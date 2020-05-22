/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판 등록 및 관리 DAO
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
package com.mycompany.myapp.shopcomponent.bbs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.bbs.vo.BoardSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;

@Repository(value="BoardManagerDAO")
public interface BoardManagerDAO extends Serializable {

    /**
     * 게시판 총갯수
     * @param boardSearchVO
     * @return
     */
    public int getListTotalCount(BoardSearchVO boardSearchVO);

    /**
     * 게시판 목록
     * @param boardSearchVO
     * @return
     */
    public List<BoardVO> getBoardList(BoardSearchVO boardSearchVO);

    /**
     * 게시판 내용
     * @param boardVO
     * @return
     */
    public BoardVO getBoard(BoardVO boardVO);

    /**
     * BOARD_ID 체크
     * @param boardVO
     * @return
     */
    public int getCheckBoardId(BoardVO boardVO);

    /**
     * 게시판 추가
     * @param boardVO
     * @return
     */
    public int insertBoard(BoardVO boardVO);

    /**
     * 게시판 수정
     * @param boardVO
     * @return
     */
    public int updateBoard(BoardVO boardVO);

    /**
     * 게시판 수정
     * @param boardVO
     * @return
     */
    public int updateBoardStatus(BoardVO boardVO);

}
