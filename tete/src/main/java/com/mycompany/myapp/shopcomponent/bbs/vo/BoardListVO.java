/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판 목록 VO
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
package com.mycompany.myapp.shopcomponent.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8719252651731386914L;

    /**
     * 게사판 리스트
     */
    @XmlElement(name = "boardList")
    private List<BoardVO> boardList;

    /**
     * 게시판 검색조건
     */
    private BoardSearchVO boardSearchVO;

    /**
     * @return the boardList
     */
    public List<BoardVO> getBoardList() {
        return boardList;
    }

    /**
     * @param boardList the boardList to set
     */
    public void setBoardList(List<BoardVO> boardList) {
        this.boardList = boardList;
    }

    /**
     * @return the boardSearchVO
     */
    public BoardSearchVO getBoardSearchVO() {
        return boardSearchVO;
    }

    /**
     * @param boardSearchVO the boardSearchVO to set
     */
    public void setBoardSearchVO(BoardSearchVO boardSearchVO) {
        this.boardSearchVO = boardSearchVO;
    }

}
