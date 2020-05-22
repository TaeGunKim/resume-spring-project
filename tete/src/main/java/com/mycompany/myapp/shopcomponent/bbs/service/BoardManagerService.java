/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판 등록 및 관리
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * ys.ko        2016.07.03  초기작성
 * </pre>
 *
 * author ys.ko
 * version 1.0, 2016.07.03 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.shopcomponent.bbs.dao.BoardManagerDAO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;

@Service
public class BoardManagerService {

    private static final Logger LOG = LoggerFactory.getLogger(BoardManagerService.class);

    @Resource
    private BoardManagerDAO boardManagerDAO;

    /**
     * 게시판 리스트
     * @param boardSearchVO
     * @return
     */
    public BoardListVO getBoardList(BoardSearchVO boardSearchVO) {

        LOG.debug("invoked 'getBoardList' method...");

        BoardListVO boardListVO = new BoardListVO();

        // 게시판 정보 리스트 갯수
        int totalCount = boardManagerDAO.getListTotalCount(boardSearchVO);

        List<BoardVO> boardList = boardManagerDAO.getBoardList(boardSearchVO);

        // 게시판 리스트 정보 셋팅
        boardListVO.setBoardList(boardList);
        boardListVO.setBoardSearchVO(boardSearchVO);
        boardListVO.getBoardSearchVO().setTotalCount(totalCount);

        return boardListVO;
    }

    /**
     * 게시판 상세정보
     * @param boardSearchVO
     * @return
     */
    public BoardVO getBoard(BoardVO boardVO) {

        LOG.debug("invoked 'getBoard' method...");

        return boardManagerDAO.getBoard(boardVO);
    }

    /**
     * 게시판 상세정보
     * @param boardId
     * @return
     */
    public BoardVO getBoard(String boardId) {

        LOG.debug("invoked 'getBoard' method...");

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardId(boardId);

        return boardManagerDAO.getBoard(boardVO);
    }

    /**
     * BOARD_ID 체크
     * @param boardVO
     * @return
     */
    public int getCheckBoardId(BoardVO boardVO) {

        LOG.debug("invoked 'getCheckBoardId' method...");

        return boardManagerDAO.getCheckBoardId(boardVO);
    }

    /**
     * 게시판 정보 등록
     * @param boardVO
     * @return
     */
    public int addBoard(BoardVO boardVO) {

        LOG.debug("invoked 'addBoard' method...");

        return boardManagerDAO.insertBoard(boardVO);
    }

    /**
     * 게시판 정보 수정
     * @param boardVO
     * @return
     */
    public int modifyBoard(BoardVO boardVO) {

        LOG.debug("invoked 'modifyBoard' method...");

        return boardManagerDAO.updateBoard(boardVO);
    }

    /**
     * 게시판 상태 변경
     * @param boardVO
     * @return
     */
    public int modifyBoardStatus(BoardVO boardVO) {

        LOG.debug("invoked 'modifyBoardStatus' method...");

        return boardManagerDAO.updateBoardStatus(boardVO);
    }

    /**
     * 게시판 상태 변경 (멀티)
     * @param boardVOList
     * @param updateId
     * @param updateIp
     * @return
     */
    public int modifyMultiBoardStatus(List<BoardVO> boardVOList, String updateId, String updateIp) {
        LOG.debug("invoked 'modifyMultiBoardStatus' method...");

        int status = Constants.RESULT_STATUS_ERROR_MESSAGE;

        for (BoardVO boardVO : boardVOList) {
            boardVO.setUpdateId(updateId);
            boardVO.setUpdateIp(updateIp);
            boardVO.setStatusType(Constants.BBS_STATUS_TYPE_DEL);
            status = boardManagerDAO.updateBoardStatus(boardVO);
        }

        return status;
    }

}
