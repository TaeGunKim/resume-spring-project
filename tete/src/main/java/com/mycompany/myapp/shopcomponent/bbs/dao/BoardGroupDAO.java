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
 * @packgename com.mycompany.myapp.shopcomponent.bbs.dao
 * @filename BoardGroupDAO.java
 * author 영수
 * version 1.0, 2016. 9. 18. 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardGroupVO;

@Repository(value="BoardGroupDAO")
public interface BoardGroupDAO extends Serializable {

    /**
     * 게시판 그룹 총갯수
     * @param boardGroupSearchVO
     * @return
     */
    public int getListTotalCount(BoardGroupSearchVO boardGroupSearchVO);

    /**
     * 게시판 그룹 리스트
     * @param boardGroupSearchVO
     * @return
     */
    public List<BoardGroupVO> getBoardGroupList(BoardGroupSearchVO boardGroupSearchVO);

    /**
     * 게시판 그룹
     * @param boardGroupSearchVO
     * @return
     */
    public BoardGroupVO getBoardGroup(BoardGroupSearchVO boardGroupSearchVO);

    /**
     * 게시판 그룹 BOARD_GROUP_ID 체크
     *
     * @param boardGroupSearchVO
     * @return
     */
    public int getCheckBoardGroupId(BoardGroupSearchVO boardGroupSearchVO);

    /**
     * 게시판 그룹 등록
     * @param boardGroupVO
     * @return
     */
    public int insertBoardGroup(BoardGroupVO boardGroupVO);

    /**
     * 게시판 그룹 수정
     * @param boardGroupVO
     * @return
     */
    public int updateBoardGroup(BoardGroupVO boardGroupVO);

    /**
     * 게시판 그룹 상태 수정
     * @param boardGroupVO
     * @return
     */
    public int updateBoardStatus(BoardGroupVO boardGroupVO);

}
