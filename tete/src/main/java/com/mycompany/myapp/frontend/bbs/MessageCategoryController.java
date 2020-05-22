package com.mycompany.myapp.frontend.bbs;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.base.BaseController;
import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.bbs.service.BoardManagerService;
import com.mycompany.myapp.shopcomponent.bbs.service.MessageCategoryService;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategorySearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryVO;

/**
 * 게시판 카테고리
 */
@Controller
@RequestMapping("/")
public class MessageCategoryController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageCategoryController.class);

    @Resource
    private MessageCategoryService messageCategoryService;

    @Resource
    private BoardManagerService boardManagerService;

    @RequestMapping(value = "bbs/messageCategoryList", method = RequestMethod.GET)
    public ModelAndView getMessageCategoryList(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageCategorySearchVO messageCategorySearchVO){

        LOG.debug("invoked 'getMessageCategoryList' method...");

        BoardSearchVO boardSearchVO = new BoardSearchVO();
        List<BoardVO> boardList = boardManagerService.getBoardList(boardSearchVO).getBoardList(); // 사용중인 게시판 가져오기

        BoardVO boardVO = boardManagerService.getBoard(messageCategorySearchVO.getBoardSeq());

        MessageCategoryListVO boardCategoryList = messageCategoryService.getMessageCategoryList(messageCategorySearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardCate", boardList);
        mav.addObject("boardVO", boardVO);
        mav.addObject("boardCategoryList", boardCategoryList);

        return mav;
    }

    @RequestMapping(value = "bbs/messageCategoryForm", method = RequestMethod.GET)
    public ModelAndView getMessageCategory(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageCategorySearchVO messageCategorySearchVO){

        LOG.debug("invoked 'getMessageCategory' method...");

        BoardSearchVO boardSearchVO = new BoardSearchVO();
        List<BoardVO> boardList = boardManagerService.getBoardList(boardSearchVO).getBoardList(); // 사용중인 게시판 가져오기

        BoardVO boardVO = boardManagerService.getBoard(messageCategorySearchVO.getBoardSeq());

        MessageCategoryVO messageCategoryInfoVO = messageCategoryService.getMessageCategory(messageCategorySearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardCate", boardList);
        mav.addObject("boardVO", boardVO);
        mav.addObject("messageCategoryVO", messageCategoryInfoVO);

        return mav;
    }

    @RequestMapping(value = "bbs/messageCategoryFormProc", method = RequestMethod.POST)
    public ModelAndView addMessageCategory(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageCategoryVO messageCategoryVO){

        LOG.debug("invoked 'addMessageCategory' method...");

        if (StringUtils.isEmpty(messageCategoryVO.getParentMessageCategorySeq())) messageCategoryVO.setParentMessageCategorySeq("0");
        if (StringUtils.isEmpty(messageCategoryVO.getMessageCategoryLevel())) messageCategoryVO.setMessageCategoryLevel("0");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageCategoryVO.setCreateId(securityLoginVO.getUsername());
                messageCategoryVO.setCreateIp(ConvertUtil.getRequestIp());
                messageCategoryVO.setUpdateId(securityLoginVO.getUsername());
                messageCategoryVO.setUpdateIp(ConvertUtil.getRequestIp());
                messageCategoryVO.setStatusType(Constants.BBS_STATUS_TYPE_OPEN);

                if(messageCategoryVO.getMessageCategorySeq() != null){//수정처리
                    boardStatus = messageCategoryService.modifyMessageCategory(messageCategoryVO);
                } else {
                    boardStatus = messageCategoryService.addMessageCategory(messageCategoryVO);
                }
            }
        }

        ModelAndView mav = new ModelAndView();

        mav.addObject("messageCategoryVO", messageCategoryVO);
        mav.addObject("boardStatus", boardStatus);

        return mav;

    }

    @RequestMapping(value = "bbs/messageCategoryRemoveProc", method = RequestMethod.POST)
    public ModelAndView removeMessageCategory(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'removeMessageCategory' method...");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageCategoryVO.setUpdateId(securityLoginVO.getUsername());
                messageCategoryVO.setUpdateIp(ConvertUtil.getRequestIp());
                messageCategoryVO.setStatusType(Constants.BBS_STATUS_TYPE_DEL);
                boardStatus = messageCategoryService.removeMessageCategory(messageCategoryVO);
            }
        }

        ModelAndView mav = new ModelAndView();

        mav.addObject("messageCategoryVO", messageCategoryVO);
        mav.addObject("boardStatus", boardStatus);

        return mav;
    }
}
