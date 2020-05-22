/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 입력 FORM VO
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

import org.springframework.web.multipart.MultipartFile;

public class MessageFormVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1429949433370016628L;

    /**
     * 게시물 번호
     */
    private String messageSeq;

    /**
     * 게시판 아이디
     */
    private String boardSeq;

    /**
     * 게시물 분류 번호
     */
    private String messageCategorySeq;

    /**
     * 게시물 분류명
     */
    private String messageCategoryName;

    /**
     * 부모 게시물 번호
     */
    private String parentMessageSeq;

    /**
     * 게시물 레벨
     */
    private String messageLevel;

    /**
     * 테그
     */
    private String tags;

    /**
     * 이전태그
     */
    private String otags;

    /**
     * 게시물 상단위치 적용 flag
     */
    private String topFlag;

    /**
     * 제목
     */
    private String title;

    /**
     * 부제목
     */
    private String subTitle;

    /**
     * 요약
     */
    private String summaryContents;

    /**
     * messageContentsTarget
     */
    private String messageContentsTarget;

    /**
     * 조회수
     */
    private int viewCount;

    /**
     *
     */
    private int replyCount;

    /**
     * 덧글수
     */
    private int commentCount;

    /**
     * 첨부파일 수
     */
    private int attachmentCount;

    /**
     * 스크랩 수
     */
    private int scrapCount;

    /**
     * 추천수
     */
    private int recommendCount;

    /**
     * 추천포인트
     */
    private int recommendPoint;

    /**
     * 게재 시작시간
     */
    private String startDate;

    /**
     * 게재 종료시간
     */
    private String endDate;

    /**
     * thumbnailUrl
     */
    private String thumbnailUrl;

    /**
     * licenseType
     */
    private String licenseType;

    /**
     * licensePoint
     */
    private int licensePoint;

    /**
     * homeUrl
     */
    private String homeUrl;

    /**
     * 0취소  1미진행 2진행 3완료 4보류
     */
    private String progressStatus;

    /**
     * sortTree
     */
    private String sortTree;

    /**
     * varFiled1
     */
    private String varFiled1;

    /**
     * varFiled2
     */
    private String varFiled2;

    /**
     * varFiled3
     */
    private String varFiled3;

    /**
     * varFiled4
     */
    private String varFiled4;

    /**
     * varFiled5
     */
    private String varFiled5;

    /**
     * varFiled6
     */
    private String varFiled6;

    /**
     * varFiled7
     */
    private String varFiled7;

    /**
     * varFiled8
     */
    private String varFiled8;

    private String varFiled9;

    private String varFiled10;

    /**
     * varFileds
     */
    private String varFileds;

    /**
     * 등록자 ID
     */
    private String createId;

    /**
     * 등록자 패스워드
     */
    private String createPwd;

    /**
     * 등록자명
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
     * 등록일
     */
    private String createDate;

    /**
     * 수정자 ID
     */
    private String updateId;

    /**
     * 수정일
     */
    private String updateDate;

    /**
     * 수정자 IP
     */
    private String updateIp;

    /**
     * 게시물 상태
     */
    private String statusType;

    /**
     * 메세지내용
     */
    private String contents;

    /**
     * 포인트 초기화
     */
    private String pointInit;

    /**
     * file
     */
    private MultipartFile file;

    /**
     * showFile1
     */
    private MultipartFile showFile1;

    /**
     * showFile2
     */
    private MultipartFile showFile2;

    /**
     * showFile3
     */
    private MultipartFile showFile3;

    /**
     * showFile4
     */
    private MultipartFile showFile4;

    /**
     * showFile5
     */
    private MultipartFile showFile5;

    /**
     * showFile6
     */
    private MultipartFile showFile6;

    /**
     * showFile7
     */
    private MultipartFile showFile7;

    /**
     * showFile8
     */
    private MultipartFile showFile8;

    /**
     * showFile9
     */
    private MultipartFile showFile9;

    /**
     * 임시 파일 저장 위치
     */
    private String[] files;

    /**
     * listReturnURL
     */
    private String listReturnURL;

    /**
     * 첨푸파일 ID
     */
    private String attachmentId;

    /**
     *
     */
    private String[] checkedIds;

    /**
     * 등록일 기준 적용
     */
    private String registerDateType;

    /**
     * 게시물 카테고리 목록
     */
    private List<MessageCategoryVO> messageCategoryList;

    /**
     * 첨부파일 목록
     */
    private List<MessageAttachmentVO> attachmentList;

    /**
     *
     */
    private String infoid;

    private int cugonetooneMaxId;

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
     * @return the parentMessageSeq
     */
    public String getParentMessageSeq() {
        return parentMessageSeq;
    }

    /**
     * @param parentMessageSeq the parentMessageSeq to set
     */
    public void setParentMessageSeq(String parentMessageSeq) {
        this.parentMessageSeq = parentMessageSeq;
    }

    /**
     * @return the messageLevel
     */
    public String getMessageLevel() {
        return messageLevel;
    }

    /**
     * @param messageLevel the messageLevel to set
     */
    public void setMessageLevel(String messageLevel) {
        this.messageLevel = messageLevel;
    }

    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return the otags
     */
    public String getOtags() {
        return otags;
    }

    /**
     * @param otags the otags to set
     */
    public void setOtags(String otags) {
        this.otags = otags;
    }

    /**
     * @return the topFlag
     */
    public String getTopFlag() {
        return topFlag;
    }

    /**
     * @param topFlag the topFlag to set
     */
    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
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
     * @return the subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param subTitle the subTitle to set
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * @return the summaryContents
     */
    public String getSummaryContents() {
        return summaryContents;
    }

    /**
     * @param summaryContents the summaryContents to set
     */
    public void setSummaryContents(String summaryContents) {
        this.summaryContents = summaryContents;
    }

    /**
     * @return the messageContentsTarget
     */
    public String getMessageContentsTarget() {
        return messageContentsTarget;
    }

    /**
     * @param messageContentsTarget the messageContentsTarget to set
     */
    public void setMessageContentsTarget(String messageContentsTarget) {
        this.messageContentsTarget = messageContentsTarget;
    }

    /**
     * @return the viewCount
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount the viewCount to set
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return the replyCount
     */
    public int getReplyCount() {
        return replyCount;
    }

    /**
     * @param replyCount the replyCount to set
     */
    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    /**
     * @return the commentCount
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount the commentCount to set
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return the attachmentCount
     */
    public int getAttachmentCount() {
        return attachmentCount;
    }

    /**
     * @param attachmentCount the attachmentCount to set
     */
    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    /**
     * @return the scrapCount
     */
    public int getScrapCount() {
        return scrapCount;
    }

    /**
     * @param scrapCount the scrapCount to set
     */
    public void setScrapCount(int scrapCount) {
        this.scrapCount = scrapCount;
    }

    /**
     * @return the recommendCount
     */
    public int getRecommendCount() {
        return recommendCount;
    }

    /**
     * @param recommendCount the recommendCount to set
     */
    public void setRecommendCount(int recommendCount) {
        this.recommendCount = recommendCount;
    }

    /**
     * @return the recommendPoint
     */
    public int getRecommendPoint() {
        return recommendPoint;
    }

    /**
     * @param recommendPoint the recommendPoint to set
     */
    public void setRecommendPoint(int recommendPoint) {
        this.recommendPoint = recommendPoint;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the thumbnailUrl
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * @param thumbnailUrl the thumbnailUrl to set
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     * @return the licenseType
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * @param licenseType the licenseType to set
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * @return the licensePoint
     */
    public int getLicensePoint() {
        return licensePoint;
    }

    /**
     * @param licensePoint the licensePoint to set
     */
    public void setLicensePoint(int licensePoint) {
        this.licensePoint = licensePoint;
    }

    /**
     * @return the homeUrl
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * @param homeUrl the homeUrl to set
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    /**
     * @return the progressStatus
     */
    public String getProgressStatus() {
        return progressStatus;
    }

    /**
     * @param progressStatus the progressStatus to set
     */
    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
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
     * @return the varFiled1
     */
    public String getVarFiled1() {
        return varFiled1;
    }

    /**
     * @param varFiled1 the varFiled1 to set
     */
    public void setVarFiled1(String varFiled1) {
        this.varFiled1 = varFiled1;
    }

    /**
     * @return the varFiled2
     */
    public String getVarFiled2() {
        return varFiled2;
    }

    /**
     * @param varFiled2 the varFiled2 to set
     */
    public void setVarFiled2(String varFiled2) {
        this.varFiled2 = varFiled2;
    }

    /**
     * @return the varFiled3
     */
    public String getVarFiled3() {
        return varFiled3;
    }

    /**
     * @param varFiled3 the varFiled3 to set
     */
    public void setVarFiled3(String varFiled3) {
        this.varFiled3 = varFiled3;
    }

    /**
     * @return the varFiled4
     */
    public String getVarFiled4() {
        return varFiled4;
    }

    /**
     * @param varFiled4 the varFiled4 to set
     */
    public void setVarFiled4(String varFiled4) {
        this.varFiled4 = varFiled4;
    }

    /**
     * @return the varFiled5
     */
    public String getVarFiled5() {
        return varFiled5;
    }

    /**
     * @param varFiled5 the varFiled5 to set
     */
    public void setVarFiled5(String varFiled5) {
        this.varFiled5 = varFiled5;
    }

    /**
     * @return the varFiled6
     */
    public String getVarFiled6() {
        return varFiled6;
    }

    /**
     * @param varFiled6 the varFiled6 to set
     */
    public void setVarFiled6(String varFiled6) {
        this.varFiled6 = varFiled6;
    }

    /**
     * @return the varFiled7
     */
    public String getVarFiled7() {
        return varFiled7;
    }

    /**
     * @param varFiled7 the varFiled7 to set
     */
    public void setVarFiled7(String varFiled7) {
        this.varFiled7 = varFiled7;
    }

    /**
     * @return the varFiled8
     */
    public String getVarFiled8() {
        return varFiled8;
    }

    /**
     * @param varFiled8 the varFiled8 to set
     */
    public void setVarFiled8(String varFiled8) {
        this.varFiled8 = varFiled8;
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
    public void createNickname(String createNickname) {
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
     * @return the contents
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the files
     */
    public String[] getFiles() {
        return files;
    }

    /**
     * @param files the files to set
     */
    public void setFiles(String[] files) {
        this.files = files;
    }

    /**
     * @return the listReturnURL
     */
    public String getListReturnURL() {
        return listReturnURL;
    }

    /**
     * @param listReturnURL the listReturnURL to set
     */
    public void setListReturnURL(String listReturnURL) {
        this.listReturnURL = listReturnURL;
    }

    /**
     * @return the attachmentId
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId the attachmentId to set
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
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

    /**
     * @return the registerDateType
     */
    public String getRegisterDateType() {
        return registerDateType;
    }

    /**
     * @param registerDateType the registerDateType to set
     */
    public void setRegisterDateType(String registerDateType) {
        this.registerDateType = registerDateType;
    }

    /**
     * @return the messageCategoryList
     */
    public List<MessageCategoryVO> getMessageCategoryList() {
        return messageCategoryList;
    }

    /**
     * @param messageCategoryList the messageCategoryList to set
     */
    public void setMessageCategoryList(List<MessageCategoryVO> messageCategoryList) {
        this.messageCategoryList = messageCategoryList;
    }

    /**
     * @return the attachmentList
     */
    public List<MessageAttachmentVO> getAttachmentList() {
        return attachmentList;
    }

    /**
     * @param attachmentList the attachmentList to set
     */
    public void setAttachmentList(List<MessageAttachmentVO> attachmentList) {
        this.attachmentList = attachmentList;
    }

    /**
     * @return the infoid
     */
    public String getInfoid() {
        return infoid;
    }

    /**
     * @param infoid the infoid to set
     */
    public void setInfoid(String infoid) {
        this.infoid = infoid;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile1() {
        return showFile1;
    }

    /**
     * @param showFile1
     */
    public void setShowFile1(MultipartFile showFile1) {
        this.showFile1 = showFile1;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile2() {
        return showFile2;
    }

    /**
     * @param showFile2
     */
    public void setShowFile2(MultipartFile showFile2) {
        this.showFile2 = showFile2;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile3() {
        return showFile3;
    }

    /**
     * @param showFile3
     */
    public void setShowFile3(MultipartFile showFile3) {
        this.showFile3 = showFile3;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile4() {
        return showFile4;
    }

    /**
     * @param showFile4
     */
    public void setShowFile4(MultipartFile showFile4) {
        this.showFile4 = showFile4;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile5() {
        return showFile5;
    }

    /**
     * @param showFile5
     */
    public void setShowFile5(MultipartFile showFile5) {
        this.showFile5 = showFile5;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile6() {
        return showFile6;
    }

    /**
     * @param showFile6
     */
    public void setShowFile6(MultipartFile showFile6) {
        this.showFile6 = showFile6;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile7() {
        return showFile7;
    }

    /**
     * @param showFile7
     */
    public void setShowFile7(MultipartFile showFile7) {
        this.showFile7 = showFile7;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile8() {
        return showFile8;
    }

    /**
     * @param showFile8
     */
    public void setShowFile8(MultipartFile showFile8) {
        this.showFile8 = showFile8;
    }

    /**
     * @return
     */
    public MultipartFile getShowFile9() {
        return showFile9;
    }

    /**
     * @param showFile9
     */
    public void setShowFile9(MultipartFile showFile9) {
        this.showFile9 = showFile9;
    }

    /**
     * @return
     */
    public String getVarFileds() {
        return varFileds;
    }

    /**
     * @param varFileds
     */
    public void setVarFileds(String varFileds) {
        this.varFileds = varFileds;
    }

    /**
     * @return
     */
    public String getPointInit() {
        return pointInit;
    }

    /**
     * @param pointInit
     */
    public void setPointInit(String pointInit) {
        this.pointInit = pointInit;
    }

	public String getVarFiled9() {
		return varFiled9;
	}

	public void setVarFiled9(String varFiled9) {
		this.varFiled9 = varFiled9;
	}

	public String getVarFiled10() {
		return varFiled10;
	}

	public void setVarFiled10(String varFiled10) {
		this.varFiled10 = varFiled10;
	}

	public int getCugonetooneMaxId() {
		return cugonetooneMaxId;
	}

	public void setCugonetooneMaxId(int cugonetooneMaxId) {
		this.cugonetooneMaxId = cugonetooneMaxId;
	}

}
