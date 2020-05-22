/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판 VO
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

@XmlRootElement(name = "board")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -207637961268472184L;

    /**
     * 게시판코드
     */
    @XmlElement(name = "boardSeq")
    private Integer boardSeq;

    /**
     * 아이디
     */
    @XmlElement(name = "boardId")
    private String boardId;

    /**
     * 게시판 그룹 코드
     */
    @XmlElement(name = "boardGroupSeq")
    private String boardGroupSeq;

    /**
     * 게시판 그룹 명
     */
    @XmlElement(name = "boardGroupName")
    private String boardGroupName;

    /**
     * bbsContants 참조
     */
    @XmlElement(name = "boardType")
    private String boardType;

    /**
     * 제목
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * 설명
     */
    @XmlElement(name = "description")
    private String description;

    /**
     * 리스트라인수
     */
    @XmlElement(name = "listLines")
    private String listLines;

    /**
     * 관리자리스트라인수
     */
    @XmlElement(name = "listLinesAdmin")
    private String listLinesAdmin;

    /**
     * 카테고리사용여부
     */
    @XmlElement(name = "messageCategoryFlag")
    private String messageCategoryFlag;

    /**
     * 상담기능 사용여부
     */
    @XmlElement(name = "consultFlag")
    private String consultFlag;

    /**
     * 답변글사용여부
     */
    @XmlElement(name = "replyFlag")
    private String replyFlag;

    /**
     * 코멘트사용여부
     */
    @XmlElement(name = "commentFlag")
    private String commentFlag;

    /**
     * 첨부사용여부
     */
    @XmlElement(name = "attachmentFlag")
    private String attachmentFlag;

    /**
     * 첨부파일수
     */
    @XmlElement(name = "attachmentCount")
    private String attachmentCount;

    /**
     * 추천사용여부
     */
    @XmlElement(name = "recommendFlag")
    private String recommendFlag;

    /**
     * 리스트이미지사용여부
     */
    @XmlElement(name = "listImageFlag")
    private String listImageFlag;

    /**
     * 공지글 사용여부
     */
    @XmlElement(name = "topMessageFlag")
    private String topMessageFlag;

    /**
     * 유효기간 사용여부
     */
    @XmlElement(name = "expirationFlag")
    private String expirationFlag;

    /**
     * 요약사용여부
     */
    @XmlElement(name = "summaryFlag")
    private String summaryFlag;

    /**
     * 컨텐츠출력여부
     */
    @XmlElement(name = "contentsFlag")
    private String contentsFlag;

    /**
     * 태그사용여부
     */
    @XmlElement(name = "tagsFlag")
    private String tagsFlag;

    /**
     * 비밀글사용여부
     */
    @XmlElement(name = "secretFlag")
    private String secretFlag;

    /**
     * 이전글 다음글 사용여부
     */
    @XmlElement(name = "nextPrevFlag")
    private String nextPrevFlag;

    /**
     * 포인트 사용여부
     */
    @XmlElement(name = "pointUseFlag")
    private String pointUseFlag;

    /**
     * 라이센스여부(포인트 사용여부) 라이센트 획득한 사람만 가능하게 설계.
     */
    @XmlElement(name = "licenseFlag")
    private String licenseFlag;

    /**
     * listIndexNum
     */
    @XmlElement(name = "listIndexNum")
    private String listIndexNum;

    /**
     * 접근권한
     */
    @XmlElement(name = "authAccess")
    private String authAccess;

    /**
     * 리스트권한
     */
    @XmlElement(name = "authList")
    private String authList;

    /**
     * 열람권한
     */
    @XmlElement(name = "authView")
    private String authView;

    /**
     * 글작성권한
     */
    @XmlElement(name = "authWrite")
    private String authWrite;

    /**
     * 관리권한
     */
    @XmlElement(name = "authManager")
    private String authManager;

    /**
     * 등록자
     */
    @XmlElement(name = "createId")
    private String createId;

    /**
     * 등록자
     */
    @XmlElement(name = "createIp")
    private String createIp;

    /**
     * 등록일자
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
     * 보드상태 0:삭제 1:대기 2:게시 3:잠김
     */
    @XmlElement(name = "statusType")
    private String statusType;


    /**
     * @return boardSeq
     */
    public Integer getBoardSeq() {
        return boardSeq;
    }

    /**
     * @param boardSeq the boardId to set
     */
    public void setBoardSeq(Integer boardSeq) {
        this.boardSeq = boardSeq;
    }

    /**
     * @return the boardId
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * @param boardId the boardId to set
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

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
     * @return the boardGroupName
     */
    public String getBoardGroupName() {
        return boardGroupName;
    }

    /**
     * @param boardGroupName the boardGroupName to set
     */
    public void setBoardGroupName(String boardGroupName) {
        this.boardGroupName = boardGroupName;
    }

    /**
     * @return the boardType
     */
    public String getBoardType() {
        return boardType;
    }

    /**
     * @param boardType the boardType to set
     */
    public void setBoardType(String boardType) {
        this.boardType = boardType;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the listLines
     */
    public String getListLines() {
        return listLines;
    }

    /**
     * @param listLines the listLines to set
     */
    public void setListLines(String listLines) {
        this.listLines = listLines;
    }

    /**
     * @return the messageCategoryFlag
     */
    public String getMessageCategoryFlag() {
        return messageCategoryFlag;
    }

    /**
     * @param messageCategoryFlag the messageCategoryFlag to set
     */
    public void setMessageCategoryFlag(String messageCategoryFlag) {
        this.messageCategoryFlag = messageCategoryFlag;
    }

    /**
     * @return the consultFlag
     */
    public String getConsultFlag() {
        return consultFlag;
    }

    /**
     * @param consultFlag the consultFlag to set
     */
    public void setConsultFlag(String consultFlag) {
        this.consultFlag = consultFlag;
    }

    /**
     * @return the replyFlag
     */
    public String getReplyFlag() {
        return replyFlag;
    }

    /**
     * @param replyFlag the replyFlag to set
     */
    public void setReplyFlag(String replyFlag) {
        this.replyFlag = replyFlag;
    }

    /**
     * @return the commentFlag
     */
    public String getCommentFlag() {
        return commentFlag;
    }

    /**
     * @param commentFlag the commentFlag to set
     */
    public void setCommentFlag(String commentFlag) {
        this.commentFlag = commentFlag;
    }

    /**
     * @return the attachmentFlag
     */
    public String getAttachmentFlag() {
        return attachmentFlag;
    }

    /**
     * @param attachmentFlag the attachmentFlag to set
     */
    public void setAttachmentFlag(String attachmentFlag) {
        this.attachmentFlag = attachmentFlag;
    }

    /**
     * @return
     */
    public String getAttachmentCount() {
        return attachmentCount;
    }

    /**
     * @param attachmentCount
     */
    public void setAttachmentCount(String attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    /**
     * @return the recommendFlag
     */
    public String getRecommendFlag() {
        return recommendFlag;
    }

    /**
     * @param recommendFlag the recommendFlag to set
     */
    public void setRecommendFlag(String recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    /**
     * @return the listImageFlag
     */
    public String getListImageFlag() {
        return listImageFlag;
    }

    /**
     * @param listImageFlag the listImageFlag to set
     */
    public void setListImageFlag(String listImageFlag) {
        this.listImageFlag = listImageFlag;
    }

    /**
     * @return the topMessageFlag
     */
    public String getTopMessageFlag() {
        return topMessageFlag;
    }

    /**
     * @param topMessageFlag the topMessageFlag to set
     */
    public void setTopMessageFlag(String topMessageFlag) {
        this.topMessageFlag = topMessageFlag;
    }

    /**
     * @return the expirationFlag
     */
    public String getExpirationFlag() {
        return expirationFlag;
    }

    /**
     * @param expirationFlag the expirationFlag to set
     */
    public void setExpirationFlag(String expirationFlag) {
        this.expirationFlag = expirationFlag;
    }

    /**
     * @return the summaryFlag
     */
    public String getSummaryFlag() {
        return summaryFlag;
    }

    /**
     * @param summaryFlag the summaryFlag to set
     */
    public void setSummaryFlag(String summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

    /**
     * @return the contentsFlag
     */
    public String getContentsFlag() {
        return contentsFlag;
    }

    /**
     * @param contentsFlag the contentsFlag to set
     */
    public void setContentsFlag(String contentsFlag) {
        this.contentsFlag = contentsFlag;
    }

    /**
     * @return the tagsFlag
     */
    public String getTagsFlag() {
        return tagsFlag;
    }

    /**
     * @param tagsFlag the tagsFlag to set
     */
    public void setTagsFlag(String tagsFlag) {
        this.tagsFlag = tagsFlag;
    }

    /**
     * @return the secretFlag
     */
    public String getSecretFlag() {
        return secretFlag;
    }

    /**
     * @param secretFlag the secretFlag to set
     */
    public void setSecretFlag(String secretFlag) {
        this.secretFlag = secretFlag;
    }

    /**
     * @return
     */
    public String getNextPrevFlag() {
        return nextPrevFlag;
    }

    /**
     * @param nextPrevFlag
     */
    public void setNextPrevFlag(String nextPrevFlag) {
        this.nextPrevFlag = nextPrevFlag;
    }

    /**
     * @return
     */
    public String getPointUseFlag() {
        return pointUseFlag;
    }

    /**
     * @param pointUseFlag
     */
    public void setPointUseFlag(String pointUseFlag) {
        this.pointUseFlag = pointUseFlag;
    }

    /**
     * @return the listIndexNum
     */
    public String getListIndexNum() {
        return listIndexNum;
    }

    /**
     * @param listIndexNum the listIndexNum to set
     */
    public void setListIndexNum(String listIndexNum) {
        this.listIndexNum = listIndexNum;
    }

    /**
     * @return
     */
    public String getAuthAccess() {
        return authAccess;
    }

    /**
     * @param authAccess
     */
    public void setAuthAccess(String authAccess) {
        this.authAccess = authAccess;
    }

    /**
     * @return
     */
    public String getAuthList() {
        return authList;
    }

    /**
     * @param authList
     */
    public void setAuthList(String authList) {
        this.authList = authList;
    }

    /**
     * @return
     */
    public String getAuthView() {
        return authView;
    }

    /**
     * @param authView
     */
    public void setAuthView(String authView) {
        this.authView = authView;
    }

    /**
     * @return
     */
    public String getAuthWrite() {
        return authWrite;
    }

    /**
     * @param authWrite
     */
    public void setAuthWrite(String authWrite) {
        this.authWrite = authWrite;
    }

    /**
     * @return
     */
    public String getAuthManager() {
        return authManager;
    }

    /**
     * @param authManager
     */
    public void setAuthManager(String authManager) {
        this.authManager = authManager;
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

    /**
     * @return the licenseFlag
     */
    public String getLicenseFlag() {
        return licenseFlag;
    }

    /**
     * @param licenseFlag the licenseFlag to set
     */
    public void setLicenseFlag(String licenseFlag) {
        this.licenseFlag = licenseFlag;
    }

    /**
     * @return the listLinesAdmin
     */
    public String getListLinesAdmin() {
        return listLinesAdmin;
    }

    /**
     * @param listLinesAdmin the listLinesAdmin to set
     */
    public void setListLinesAdmin(String listLinesAdmin) {
        this.listLinesAdmin = listLinesAdmin;
    }

}
