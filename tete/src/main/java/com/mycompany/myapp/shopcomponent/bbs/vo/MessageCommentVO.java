/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 덧글  VO
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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageCategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCommentVO implements Serializable {

    /**
     * Serializable
     */
    private static final long serialVersionUID = 5057449163715693992L;

    private String commentSeq;
    private String messageSeq;
    private String title;
    private String comments;
    private String statusType;
    private String createId;
    private String createPwd;
    private String createName;
    private String createNickname;
    private String createEmail;
    private String createIp;
    private String createDate;
    private String sortTree;
    private String recommendCount;

    public String getCommentSeq() {
        return commentSeq;
    }
    public void setCommentSeq(String commentSeq) {
        this.commentSeq = commentSeq;
    }
    public String getMessageSeq() {
        return messageSeq;
    }
    public void setMessageSeq(String messageSeq) {
        this.messageSeq = messageSeq;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getStatusType() {
        return statusType;
    }
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }
    public String getCreateId() {
        return createId;
    }
    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getCreatePwd() {
        return createPwd;
    }
    public void setCreatePwd(String createPwd) {
        this.createPwd = createPwd;
    }
    public String getCreateName() {
        return createName;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getCreateNickname() {
        return createNickname;
    }
    public void setCreateNickname(String createNickname) {
        this.createNickname = createNickname;
    }
    public String getCreateEmail() {
        return createEmail;
    }
    public void setCreateEmail(String createEmail) {
        this.createEmail = createEmail;
    }
    public String getCreateIp() {
        return createIp;
    }
    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
     * @return the recommendCount
     */
    public String getRecommendCount() {
        return recommendCount;
    }
    /**
     * @param recommendCount the recommendCount to set
     */
    public void setRecommendCount(String recommendCount) {
        this.recommendCount = recommendCount;
    }

}
