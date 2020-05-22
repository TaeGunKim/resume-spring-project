/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * 영수        2016. 9. 18.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.mycompany.myapp.backend.bbs
 * @filename BoardGroupController.java
 * author 영수
 * version 1.0, 2016. 9. 18. 초기작성
* see None
 */
package com.mycompany.myapp.frontend.bbs;

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
import com.mycompany.myapp.shopcomponent.bbs.service.BoardGroupService;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupVO;

/**
 * 게시판 그룹관리
 */
@Controller
@RequestMapping("/")
public class BoardGroupController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BoardGroupController.class);

    @Resource
    private BoardGroupService boardGroupService;

    @RequestMapping(value = "bbs/boardGroupList", method = RequestMethod.GET)
    public ModelAndView getBoardGroupList(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardGroupSearchVO boardGroupSearchVO){

        LOG.debug("invoked 'getBoardGroupList' method...");

        BoardGroupListVO boardGroupList = boardGroupService.getBoardGroupList(boardGroupSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupList", boardGroupList);

        return mav;

    }

    @RequestMapping(value = "bbs/boardGroupDetail", method = RequestMethod.GET)
    public ModelAndView getBoardGroup(BoardGroupSearchVO boardGroupSearchVO){
        LOG.debug("invoked 'getBoardGroup' method...");

        BoardGroupVO boardGroupInfoVO = boardGroupService.getBoardGroup(boardGroupSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupVO", boardGroupInfoVO);

        return mav;
    }

    @RequestMapping(value = "bbs/boardGroupCheckGroupId", method = RequestMethod.GET)
    public ModelAndView getCheckBoardGroupId(BoardGroupSearchVO boardGroupSearchVO){
        LOG.debug("invoked 'getCheckBoardGroupId' method...");

        ModelAndView mav = new ModelAndView();
        mav.addObject("cnt", boardGroupService.getCheckBoardGroupId(boardGroupSearchVO));

        return mav;
    }

    @RequestMapping(value = "bbs/boardGroupRegister", method = RequestMethod.POST)
    public ModelAndView addBoardGroup(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardGroupVO boardGroupVO){
        LOG.debug("invoked 'addBoardGroup' method...");

        int boardGroupStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardGroupVO.setCreateId(securityLoginVO.getUsername());
                boardGroupVO.setCreateIp(ConvertUtil.getRequestIp());
                boardGroupVO.setUpdateId(securityLoginVO.getUsername());
                boardGroupVO.setUpdateIp(ConvertUtil.getRequestIp());
                boardGroupVO.setStatusType(Constants.BBS_STATUS_TYPE_OPEN);

                boardGroupStatus = boardGroupService.addBoardGroup(boardGroupVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupStatus", boardGroupStatus);
        return mav;
    }

    @RequestMapping(value = "bbs/boardGroupModify", method = RequestMethod.POST)
    public ModelAndView modifyBoardGroup(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardGroupVO boardGroupVO) {
        LOG.debug("invoked 'modifyBoardGroup' method...");

        int boardGroupStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardGroupVO.setCreateId(securityLoginVO.getUsername());
                boardGroupVO.setCreateIp(ConvertUtil.getRequestIp());
                boardGroupVO.setUpdateId(securityLoginVO.getUsername());
                boardGroupVO.setUpdateIp(ConvertUtil.getRequestIp());

                boardGroupStatus = boardGroupService.modifyBoardGroup(boardGroupVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupStatus", boardGroupStatus);
        mav.addObject("boardGroupId",boardGroupVO.getBoardGroupId());

        return mav;
    }

    @RequestMapping(value = "bbs/boardGroupRemove", method = RequestMethod.POST)
    public ModelAndView removeBoardGroup(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardGroupVO boardGroupVO) {
        LOG.debug("invoked 'removeBoardGroup' method...");

        int boardGroupStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardGroupVO.setCreateId(securityLoginVO.getUsername());
                boardGroupVO.setCreateIp(ConvertUtil.getRequestIp());
                boardGroupVO.setUpdateId(securityLoginVO.getUsername());
                boardGroupVO.setUpdateIp(ConvertUtil.getRequestIp());
                boardGroupVO.setStatusType(Constants.BBS_STATUS_TYPE_DEL);

                boardGroupStatus = boardGroupService.modifyBoardStatus(boardGroupVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupStatus", boardGroupStatus);
        mav.addObject("boardGroupId",boardGroupVO.getBoardGroupId());

        return mav;
    }

    @RequestMapping(value = "bbs/boardGroupMultiRemove", method = RequestMethod.POST)
    public ModelAndView removeMultiBoardGroup(HttpServletRequest request, HttpServletResponse response, Authentication authentication, @RequestBody List<BoardGroupVO> boardGroupVOList) {
        LOG.debug("invoked 'removeMultiBoardGroup' method...");

        int boardGroupStatus = Constants.RESULT_STATUS_ERROR_MESSAGE;

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
                boardGroupStatus = boardGroupService.modifyMultiBoardStatus(boardGroupVOList, securityLoginVO.getUsername(), ConvertUtil.getRequestIp());
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardGroupStatus", boardGroupStatus);

        return mav;
    }

}
