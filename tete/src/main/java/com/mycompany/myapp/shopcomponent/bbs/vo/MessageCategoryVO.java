/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 카테고리 정보 VO
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageCategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategoryVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1981397964487979151L;

    /**
     * 카테고리 코드
     */
    @XmlElement(name = "messageCategorySeq")
    private String messageCategorySeq;

    /**
     * 게시판 코드
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

    /**
     * 계층 최상위 게시판 코드
     */
    @XmlElement(name = "parentMessageCategorySeq")
    private String parentMessageCategorySeq;

    /**
     * 카테고리(분류)명
     */
    @XmlElement(name = "messageCategoryName")
    private String messageCategoryName;

    /**
     * 카테고리 순서
     */
    @XmlElement(name = "sortTree")
    private String sortTree;

    /**
     * 카테고리 level
     */
    @XmlElement(name = "messageCategoryLevel")
    private String messageCategoryLevel;

    /**
     * 등록자 ID
     */
    @XmlElement(name = "createId")
    private String createId;

    /**
     * 등록자 IP
     */
    @XmlElement(name = "createIp")
    private String createIp;

    /**
     * 등록일
     */
    @XmlElement(name = "createDate")
    private String createDate;

    /**
     * 수정자 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정자 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 카테고리 상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * @return the messageCategorySeq
     */
    public String getMessageCategorySeq() {
        return messageCategorySeq;
    }

    /**
     * @param messageCategorySeq the messageCategorySeq to set
     */
    public void setMessageCategorySeq(String messageCategorySeq) {
        this.messageCategorySeq = messageCategorySeq;
    }

    /**
     * @return the boardSeq
     */
    public String getBoardSeq() {
        return boardSeq;
    }

    /**
     * @param boardSeq the boardSeq to set
     */
    public void setBoardSeq(String boardSeq) {
        this.boardSeq = boardSeq;
    }

    /**
     * @return the parentMessageCategorySeq
     */
    public String getParentMessageCategorySeq() {
        return parentMessageCategorySeq;
    }

    /**
     * @param parentMessageCategorySeq the parentMessageCategorySeq to set
     */
    public void setParentMessageCategorySeq(String parentMessageCategorySeq) {
        this.parentMessageCategorySeq = parentMessageCategorySeq;
    }

    /**
     * @return the messageCategoryName
     */
    public String getMessageCategoryName() {
        return messageCategoryName;
    }

    /**
     * @param messageCategoryName the messageCategoryName to set
     */
    public void setMessageCategoryName(String messageCategoryName) {
        this.messageCategoryName = messageCategoryName;
    }

    /**
     * @return the sortTree
     */
    public String getSortTree() {
        return sortTree;
    }

    /**
     * @param sortTree the sortTree to set
     */
    public void setSortTree(String sortTree) {
        this.sortTree = sortTree;
    }

    /**
     * @return the messageCategoryLevel
     */
    public String getMessageCategoryLevel() {
        return messageCategoryLevel;
    }

    /**
     * @param messageCategoryLevel the messageCategoryLevel to set
     */
    public void setMessageCategoryLevel(String messageCategoryLevel) {
        this.messageCategoryLevel = messageCategoryLevel;
    }

    /**
     * @return the createId
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * @param createId the createId to set
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * @return the createIp
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * @param createIp the createIp to set
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the updateId
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId the updateId to set
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * @return the updateIp
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * @param updateIp the updateIp to set
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    /**
     * @return the updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the statusType
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

}
