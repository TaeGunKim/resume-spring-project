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
 * @packgename com.mycompany.myapp.shopcomponent.bbs.vo
 * @filename BoardGroupListVO.java
 * author 영수
 * version 1.0, 2016. 9. 18. 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boardGroupList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardGroupListVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7538481231961972341L;

    /**
     * 게사판 그룹 리스트
     */
    @XmlElement(name = "boardGroupList")
    private List<BoardGroupVO> boardGroupList;

    /**
     * @return
     */
    public List<BoardGroupVO> getBoardGroupList() {
        return boardGroupList;
    }

    /**
     * @param boardGroupList
     */
    public void setBoardGroupList(List<BoardGroupVO> boardGroupList) {
        this.boardGroupList = boardGroupList;
    }

}
