/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 덧글 입력 Form VO
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

public class MessageCommentFormVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4068440412812765201L;

    /**
     * 덧글 ID
     */
    private String commentSeq;

    /**
     * 게시글 ID
     */
    private String messageSeq;

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String comments;

    /**
     * returnUrl
     */
    private String returnUrl;

    /**
     * 등록자 ID
     */
    private String createId;

    /**
     * 등록자 비밀번호
     */
    private String createPwd;

    /**
     * 등록자 명
     */
    private String createName;

    /**
     * 등록자 닉네임
     */
    private String createNickname;

    /**
     * 등록자 이메일
     */
    private String createEmail;

    /**
     * 등록자 IP
     */
    private String createIp;

    /**
     * 순서
     */
    private String sortTree;

    /**
     * 덧글 상태
     */
    private String statusType;

    /**
     * 선택 덧글 ID
     */
    private String[] checkedIds;

    /**
     * @return the commentSeq
     */
    public String getCommentSeq() {
        return commentSeq;
    }
    /**
     * @param commentSeq the commentSeq to set
     */
    public void setCommentSeq(String commentSeq) {
        this.commentSeq = commentSeq;
    }
    /**
     * @return the messageSeq
     */
    public String getMessageSeq() {
        return messageSeq;
    }
    /**
     * @param messageSeq the messageSeq to set
     */
    public void setMessageSeq(String messageSeq) {
        this.messageSeq = messageSeq;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }
    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    /**
     * @return the returnUrl
     */
    public String getReturnUrl() {
        return returnUrl;
    }
    /**
     * @param returnUrl the returnUrl to set
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
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
     * @return the createPwd
     */
    public String getCreatePwd() {
        return createPwd;
    }
    /**
     * @param createPwd the createPwd to set
     */
    public void setCreatePwd(String createPwd) {
        this.createPwd = createPwd;
    }
    /**
     * @return the createName
     */
    public String getCreateName() {
        return createName;
    }
    /**
     * @param createName the createName to set
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    /**
     * @return the createNickname
     */
    public String getCreateNickname() {
        return createNickname;
    }
    /**
     * @param createNickname the createNickname to set
     */
    public void setCreateNickname(String createNickname) {
        this.createNickname = createNickname;
    }
    /**
     * @return the createEmail
     */
    public String getCreateEmail() {
        return createEmail;
    }
    /**
     * @param createEmail the createEmail to set
     */
    public void setCreateEmail(String createEmail) {
        this.createEmail = createEmail;
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
    /**
     * @return the checkedIds
     */
    public String[] getCheckedIds() {
        return checkedIds;
    }
    /**
     * @param checkedIds the checkedIds to set
     */
    public void setCheckedIds(String[] checkedIds) {
        this.checkedIds = checkedIds;
    }

}
