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
 * @filename BoardGroupSearchVO.java
 * author 영수
 * version 1.0, 2016. 9. 18. 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.myapp.common.vo.SearchVO;

@XmlRootElement(name = "boardGroupSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardGroupSearchVO extends SearchVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1799877145651978130L;

    /**
     * 게시판 그룹 코드
     */
    @XmlElement(name = "boardGroupSeq")
    private String boardGroupSeq;

    /**
     * 게시판 그룹 아이디
     */
    @XmlElement(name = "boardGroupId")
    private String boardGroupId;

    /**
     * 게시판 그룹 명
     */
    @XmlElement(name = "boardGroupName")
    private String boardGroupName;

    /**
     * 게시판 그룹 상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * @return
     */
    public String getBoardGroupSeq() {
        return boardGroupSeq;
    }

    /**
     * @param boardGroupSeq
     */
    public void setBoardGroupSeq(String boardGroupSeq) {
        this.boardGroupSeq = boardGroupSeq;
    }

    /**
     * @return
     */
    public String getBoardGroupId() {
        return boardGroupId;
    }

    /**
     * @param boardGroupId
     */
    public void setBoardGroupId(String boardGroupId) {
        this.boardGroupId = boardGroupId;
    }

    /**
     * @return
     */
    public String getBoardGroupName() {
        return boardGroupName;
    }

    /**
     * @param boardGroupName
     */
    public void setBoardGroupName(String boardGroupName) {
        this.boardGroupName = boardGroupName;
    }

    /**
     * @return
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

}
