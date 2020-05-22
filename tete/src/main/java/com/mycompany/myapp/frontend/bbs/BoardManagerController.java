package com.mycompany.myapp.frontend.bbs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.base.BaseController;
import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.bbs.service.BoardManagerService;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;

/**
 * 게시판 관리
 */
@Controller
@RequestMapping("/")
public class BoardManagerController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BoardManagerController.class);

    @Resource
    private BoardManagerService boardService;

    @RequestMapping(value = "bbs/boardList", method = RequestMethod.GET)
    public ModelAndView getBoardList(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardSearchVO boardSearchVO){

        LOG.debug("invoked 'getBoardList' method...");

        BoardListVO boardList = boardService.getBoardList(boardSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardList);

        return mav;
    }

    @RequestMapping(value = "bbs/boardDetail", method = RequestMethod.GET)
    public ModelAndView getBoard(BoardVO boardVO){
        LOG.debug("invoked 'getBoard' method...");

        BoardVO boardInfoVO = boardService.getBoard(boardVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardInfoVO);

        return mav;
    }

    @RequestMapping(value = "bbs/boardForm", method = RequestMethod.POST)
    public ModelAndView getBoardForm(BoardVO boardVO) {
        LOG.debug("invoked 'getBoardForm' method...");

        ArrayList<String> boardTypeList = new ArrayList<String>() ;

        boardTypeList.add(Constants.BBS_BOARD_TYPE_NOTICE);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_QNA);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_GENERAL);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_IMAGECONTENT);

        BoardVO boardInfoVO = null;
        if (boardVO.getBoardId()!=null) {
            boardInfoVO = boardService.getBoard(boardVO);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardTypeList", boardTypeList);
        mav.addObject("boardVO", boardInfoVO);

        return mav;
    }

    @RequestMapping(value = "bbs/checkBoardId", method = RequestMethod.GET)
    public ModelAndView getCheckBoardId(BoardVO boardVO){
        LOG.debug("invoked 'getCheckBoardId' method...");

        ModelAndView mav = new ModelAndView();
        mav.addObject("cnt", boardService.getCheckBoardId(boardVO));
        return mav;
    }

    @RequestMapping(value = "bbs/boardRegister", method = RequestMethod.POST)
    public ModelAndView addBoard(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardVO boardVO){
        LOG.debug("invoked 'addBoard' method...");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardVO.setCreateId(securityLoginVO.getUsername());
                boardVO.setCreateIp(ConvertUtil.getRequestIp());
                boardVO.setUpdateId(securityLoginVO.getUsername());
                boardVO.setUpdateIp(ConvertUtil.getRequestIp());
                boardVO.setStatusType(Constants.BBS_STATUS_TYPE_BBSWAIT);

                boardStatus = boardService.addBoard(boardVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardStatus", boardStatus);
        return mav;

    }

    @RequestMapping(value = "bbs/boardModify", method = RequestMethod.POST)
    public ModelAndView modifyBoard(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardVO boardVO) {
        LOG.debug("invoked 'modifyBoard' method...");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardVO.setCreateId(securityLoginVO.getUsername());
                boardVO.setCreateIp(ConvertUtil.getRequestIp());
                boardVO.setUpdateId(securityLoginVO.getUsername());
                boardVO.setUpdateIp(ConvertUtil.getRequestIp());

                boardStatus = boardService.modifyBoard(boardVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardStatus", boardStatus);
        mav.addObject("boardId",boardVO.getBoardId());

        return mav;
    }

    @RequestMapping(value = "bbs/boardRemove", method = RequestMethod.POST)
    public ModelAndView removeBoard(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardVO boardVO) {
        LOG.debug("invoked 'removeBoard' method...");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardVO.setUpdateId(securityLoginVO.getUsername());
                boardVO.setUpdateIp(ConvertUtil.getRequestIp());
                boardVO.setStatusType(Constants.BBS_STATUS_TYPE_DEL);

                boardStatus = boardService.modifyBoardStatus(boardVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardStatus", boardStatus);
        mav.addObject("boardId",boardVO.getBoardId());

        return mav;
    }

    @RequestMapping(value = "bbs/boardMultiRemove", method = RequestMethod.POST)
    public ModelAndView multiRemoveBoard(HttpServletRequest request, HttpServletResponse response, Authentication authentication, @RequestBody List<BoardVO> boardVOList) {
        LOG.debug("invoked 'multiRemoveBoard' method...");

        int boardStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardStatus = boardService.modifyMultiBoardStatus(boardVOList, securityLoginVO.getUsername(), ConvertUtil.getRequestIp());
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardStatus", boardStatus);

        return mav;
    }
}
