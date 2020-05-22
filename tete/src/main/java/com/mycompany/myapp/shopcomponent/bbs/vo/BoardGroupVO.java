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
 * @filename BoardGroupVO.java
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

@XmlRootElement(name = "boardGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardGroupVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6262837220341632644L;

    /**
     * 게시판 그룹 코드
     */
    @XmlElement(name = "boardGroupSeq")
    private Integer boardGroupSeq;

    /**
     * 게시판 그룹 아이디
     */
    @XmlElement(name = "boardGroupId")
    private String boardGroupId;

    /**
     * 게시판 그룹명
     */
    @XmlElement(name = "boardGroupName")
    private String boardGroupName;

    /**
     * 게시판 수
     */
    @XmlElement(name = "boardCount")
    private String boardCount;

    /**
     * 등록일
     */
    @XmlElement(name = "createDate")
    private String createDate;

    /**
     * 등록자
     */
    @XmlElement(name = "createId")
    private String createId;

    /**
     * 등록자 IP
     */
    @XmlElement(name = "createIp")
    private String createIp;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정자
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정자 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 보드상태 0:삭제 1:등록
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * @return
     */
    public Integer getBoardGroupSeq() {
        return boardGroupSeq;
    }

    /**
     * @param boardGroupSeq
     */
    public void setBoardGroupSeq(Integer boardGroupSeq) {
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
    public String getBoardCount() {
        return boardCount;
    }

    /**
     * @param boardCount
     */
    public void setBoardCount(String boardCount) {
        this.boardCount = boardCount;
    }

    /**
     * @return
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * @param createId
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * @return
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * @param createIp
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    /**
     * @return
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * @return
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * @param updateIp
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
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
