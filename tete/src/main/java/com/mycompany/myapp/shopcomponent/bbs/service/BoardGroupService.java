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
 * @packgename com.mycompany.myapp.shopcomponent.bbs.service
 * @filename BoardGroupService.java
 * author 영수
 * version 1.0, 2016. 9. 18. 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.shopcomponent.bbs.dao.BoardGroupDAO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupVO;

@Service
public class BoardGroupService {

    private static final Logger LOG = LoggerFactory.getLogger(BoardGroupService.class);

    @Resource
    private BoardGroupDAO boardGroupDAO;

    /**
     * 게시판 그룹 리스트
     * @param boardGroupSearchVO
     * @return
     */
    public BoardGroupListVO getBoardGroupList(BoardGroupSearchVO boardGroupSearchVO) {
        LOG.debug("invoked 'getBoardGroupList' method...");

        BoardGroupListVO boardGroupListVO = new BoardGroupListVO();

        // 게시판 총갯수
        int totalCount = boardGroupDAO.getListTotalCount(boardGroupSearchVO);

        List<BoardGroupVO> boardGroupList = boardGroupDAO.getBoardGroupList(boardGroupSearchVO);

        // 게시판 그룹 리스트 정보 셋팅
        boardGroupListVO.setBoardGroupList(boardGroupList);
        boardGroupSearchVO.setTotalCount(totalCount);
        return boardGroupListVO;
    }

    /**
     * 게시판 그룹
     * @param boardGroupSearchVO
     * @return
     */
    public BoardGroupVO getBoardGroup(BoardGroupSearchVO boardGroupSearchVO) {
        LOG.debug("invoked 'getBoardGroup' method...");

        return boardGroupDAO.getBoardGroup(boardGroupSearchVO);
    }

    /**
     * 게시판 그룹 BOARD_GROUP_ID 체크
     *
     * @param boardGroupSearchVO
     * @return
     */
    public int getCheckBoardGroupId(BoardGroupSearchVO boardGroupSearchVO) {
        LOG.debug("invoked 'getCheckBoardGroupId' method...");

        return boardGroupDAO.getCheckBoardGroupId(boardGroupSearchVO);
    }

    /**
     * 게시판 그룹 등록
     * @param boardGroupVO
     * @return
     */
    public int addBoardGroup(BoardGroupVO boardGroupVO) {
        LOG.debug("invoked 'addBoardGroup' method...");

        return boardGroupDAO.insertBoardGroup(boardGroupVO);
    }

    /**
     * 게시판 그룹 수정
     * @param boardGroupVO
     * @return
     */
    public int modifyBoardGroup(BoardGroupVO boardGroupVO) {
        LOG.debug("invoked 'modifyBoardGroup' method...");

        return boardGroupDAO.updateBoardGroup(boardGroupVO);
    }

    /**
     * 게시판 그룹 상태 수정
     * @param boardGroupVO
     * @return
     */
    public int modifyBoardStatus(BoardGroupVO boardGroupVO) {
        LOG.debug("invoked 'modifyBoardStatus' method...");

        return boardGroupDAO.updateBoardStatus(boardGroupVO);
    }

    /**
     * 게시판 그룹 상태 수정 (멀티)
     * @param boardGroupVOList
     * @param updateId
     * @param updateIp
     * @return
     */
    public int modifyMultiBoardStatus(List<BoardGroupVO> boardGroupVOList, String updateId, String updateIp) {
        LOG.debug("invoked 'modifyMultiBoardStatus' method...");

        int status = Constants.RESULT_STATUS_ERROR_MESSAGE;

        for (BoardGroupVO boardGroupVO : boardGroupVOList) {
        	boardGroupVO.setUpdateId(updateId);
        	boardGroupVO.setUpdateIp(updateIp);
        	status = boardGroupDAO.updateBoardStatus(boardGroupVO);
        }

        return status;
    }

}
