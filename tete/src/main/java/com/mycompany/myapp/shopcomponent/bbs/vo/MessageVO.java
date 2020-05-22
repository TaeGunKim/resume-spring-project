/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 VO
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

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4051290195095555890L;

    /**
     * 게시물 번호
     */
    @XmlElement(name = "messageSeq")
    private Integer messageSeq;

    /**
     * 게시판 아이디
     */
    @XmlElement(name = "boardId")
    private String boardId;

    /**
     * 게시판 아이디
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

    /**
     * 게시물 분류 번호
     */
    @XmlElement(name = "messageCategorySeq")
    private String messageCategorySeq;

    /**
     * 게시물 분류명
     */
    @XmlElement(name = "messageCategoryName")
    private String messageCategoryName;

    /**
     * 부모 게시물 번호
     */
    @XmlElement(name = "parentMessageSeq")
    private String parentMessageSeq;

    /**
     * 게시물 레벨
     */
    @XmlElement(name = "messageLevel")
    private String messageLevel;

    /**
     * 태그
     */
    @XmlElement(name = "tags")
    private String tags;

    /**
     * 공지사항 1:공지, 2:일반
     */
    @XmlElement(name = "topFlag")
    private String topFlag;

    /**
     * 제목
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * 부제목
     */
    @XmlElement(name = "subTitle")
    private String subTitle;

    @XmlElement(name = "subTitleCnt")
    private String subTitleCnt;

    /**
     * 요약내용
     */
    @XmlElement(name = "summaryContents")
    private String summaryContents;

    /**
     * 조회수
     */
    @XmlElement(name = "viewCount")
    private Integer viewCount;

    /**
     * 리플수
     */
    @XmlElement(name = "replyCount")
    private Integer replyCount;

    /**
     * 커멘트수
     */
    @XmlElement(name = "commentCount")
    private Integer commentCount;

    /**
     * 첨부파일수
     */
    @XmlElement(name = "attachmentCount")
    private Integer attachmentCount;

    /**
     * 스크랩수
     */
    @XmlElement(name = "scrapCount")
    private Integer scrapCount;

    /**
     * 추천수
     */
    @XmlElement(name = "recommendCount")
    private Integer recommendCount;

    /**
     * 추천점수
     */
    @XmlElement(name = "recommendPoint")
    private Integer recommendPoint;

    /**
     * 썹네일 URL
     */
    @XmlElement(name = "thumbnailUrl")
    private String thumbnailUrl;

    /**
     * 홈페이지 URL
     */
    @XmlElement(name = "homeUrl")
    private String homeUrl;

    /**
     * 시작일자
     */
    @XmlElement(name = "startDate")
    private String startDate;

    /**
     * 종료일자
     */
    @XmlElement(name = "endDate")
    private String endDate;

    /**
     * 0취소  1미진행 2진행 3완료 4보류
     */
    @XmlElement(name = "progressStatus")
    private String progressStatus;

    /**
     * sortTree
     */
    @XmlElement(name = "sortTree")
    private String sortTree;

    /**
     * licenseType
     */
    @XmlElement(name = "licenseType")
    private String licenseType;

    /**
     * licensePoint
     */
    @XmlElement(name = "licensePoint")
    private int licensePoint;

    /**
     * varFiled1
     */
    @XmlElement(name = "varFiled1")
    private String varFiled1;

    /**
     * varFiled2
     */
    @XmlElement(name = "varFiled2")
    private String varFiled2;

    /**
     * varFiled3
     */
    @XmlElement(name = "varFiled3")
    private String varFiled3;

    /**
     * varFiled4
     */
    @XmlElement(name = "varFiled4")
    private String varFiled4;

    /**
     * varFiled5
     */
    @XmlElement(name = "varFiled5")
    private String varFiled5;

    /**
     * varFiled6
     */
    @XmlElement(name = "varFiled6")
    private String varFiled6;

    /**
     * varFiled7
     */
    @XmlElement(name = "varFiled7")
    private String varFiled7;

    /**
     * varFiled8
     */
    @XmlElement(name = "varFiled8")
    private String varFiled8;

    @XmlElement(name = "varFiled9")
    private String varFiled9;

    @XmlElement(name = "varFiled10")
    private String varFiled10;

    /**
     * varFileds
     */
    @XmlElement(name = "varFileds")
    private String varFileds;

    @XmlElement(name = "imgList")
    private String imgList;

    /**
     * 등록자 ID
     */
    @XmlElement(name = "createId")
    private String createId;

    /**
     * 등록자 패스워드(비회원)
     */
    @XmlElement(name = "createPwd")
    private String createPwd;

    /**
     * 등록자명 (비회원)
     */
    @XmlElement(name = "createName")
    private String createName;

    /**
     * 등록자닉네임
     */
    @XmlElement(name = "createNickname")
    private String createNickname;

    /**
     * 등록자 이메일 (비회원)
     */
    @XmlElement(name = "createEmail")
    private String createEmail;

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

    @XmlElement(name = "createDateDiff")
    private String createDateDiff;

    /**
     * 수정자 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정자 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 게시물 상태  0:삭제 1:대기 2:게재
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * 등록후 지난시간
     */
    @XmlElement(name = "registerAfterHour")
    private String registerAfterHour;

    /**
     * 수정후 지난시간
     */
    @XmlElement(name = "updateAfterHour")
    private String updateAfterHour;

    /**
     * 리스트이미지정보
     */
    @XmlElement(name = "listImgInfo")
    private String listImgInfo;

    /**
     * 리스트이미지정보 Path
     */
    @XmlElement(name = "listImgPath")
    private String listImgPath;

    /**
     * 리스트파일정보
     */
    @XmlElement(name = "listAttachInfo")
    private String listAttachInfo;

    /**
     * 메세지내용
     */
    @XmlElement(name = "contents")
    private String contents;

    /**
     * newFlag
     */
    @XmlElement(name = "newFlag")
    private String newFlag;

    /**
     * messageConId
     */
    @XmlElement(name = "messageConId")
    private Integer messageConId;

    /**
     * showFile1
     */
    @XmlElement(name = "showFile1")
    private String showFile1;

    /**
     * showFile2
     */
    @XmlElement(name = "showFile2")
    private String showFile2;

    @XmlElement(name = "mbSosok")
    private String mbSosok;

    /**
     * attachmentList
     */
    private List<MessageAttachmentVO> attachmentList;

    private List<MessageAddProdVO> addProdList;

    /**
     * 마지막 첨부파일
     */
    private MessageAttachmentVO lastAttachment;

    /**
     * 처음 첨부파일
     */
    private MessageAttachmentVO firstAttachment;

    /**
     * 처음 첨부파일
     */
    private MessageAttachmentVO downloadAttachment;

    /**
     * @return the messageSeq
     */
    public Integer getMessageSeq() {
        return messageSeq;
    }

    /**
     * @param messageSeq the messageSeq to set
     */
    public void setMessageSeq(Integer messageSeq) {
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
     * @return the viewCount
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount the viewCount to set
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return the replyCount
     */
    public Integer getReplyCount() {
        return replyCount;
    }

    /**
     * @param replyCount the replyCount to set
     */
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    /**
     * @return the commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount the commentCount to set
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return the attachmentCount
     */
    public Integer getAttachmentCount() {
        return attachmentCount;
    }

    /**
     * @param attachmentCount the attachmentCount to set
     */
    public void setAttachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    /**
     * @return the scrapCount
     */
    public Integer getScrapCount() {
        return scrapCount;
    }

    /**
     * @param scrapCount the scrapCount to set
     */
    public void setScrapCount(Integer scrapCount) {
        this.scrapCount = scrapCount;
    }

    /**
     * @return the recommendCount
     */
    public Integer getRecommendCount() {
        return recommendCount;
    }

    /**
     * @param recommendCount the recommendCount to set
     */
    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    /**
     * @return the recommendPoint
     */
    public Integer getRecommendPoint() {
        return recommendPoint;
    }

    /**
     * @param recommendPoint the recommendPoint to set
     */
    public void setRecommendPoint(Integer recommendPoint) {
        this.recommendPoint = recommendPoint;
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
     * @return the registerAfterHour
     */
    public String getRegisterAfterHour() {
        return registerAfterHour;
    }

    /**
     * @param registerAfterHour the registerAfterHour to set
     */
    public void setRegisterAfterHour(String registerAfterHour) {
        this.registerAfterHour = registerAfterHour;
    }

    /**
     * @return the updateAfterHour
     */
    public String getUpdateAfterHour() {
        return updateAfterHour;
    }

    /**
     * @param updateAfterHour the updateAfterHour to set
     */
    public void setUpdateAfterHour(String updateAfterHour) {
        this.updateAfterHour = updateAfterHour;
    }

    /**
     * @return the listImgInfo
     */
    public String getListImgInfo() {
        return listImgInfo;
    }

    /**
     * @param listImgInfo the listImgInfo to set
     */
    public void setListImgInfo(String listImgInfo) {
        this.listImgInfo = listImgInfo;
    }

    /**
     * @return the listImgPath
     */
    public String getListImgPath() {
        return listImgPath;
    }

    /**
     * @param listImgPath the listImgPath to set
     */
    public void setListImgPath(String listImgPath) {
        this.listImgPath = listImgPath;
    }

    /**
     * @return the listAttachInfo
     */
    public String getListAttachInfo() {
        return listAttachInfo;
    }

    /**
     * @param listAttachInfo the listAttachInfo to set
     */
    public void setListAttachInfo(String listAttachInfo) {
        this.listAttachInfo = listAttachInfo;
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
     * @return the newFlag
     */
    public String getNewFlag() {
        return newFlag;
    }

    /**
     * @param newFlag the newFlag to set
     */
    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    /**
     * @return the messageConId
     */
    public Integer getMessageConId() {
        return messageConId;
    }

    /**
     * @param messageConId the messageConId to set
     */
    public void setMessageConId(Integer messageConId) {
        this.messageConId = messageConId;
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
     * @return the lastAttachment
     */
    public MessageAttachmentVO getLastAttachment() {
        return lastAttachment;
    }

    /**
     * @param lastAttachment the lastAttachment to set
     */
    public void setLastAttachment(MessageAttachmentVO lastAttachment) {
        this.lastAttachment = lastAttachment;
    }

    /**
     * @return the firstAttachment
     */
    public MessageAttachmentVO getFirstAttachment() {
        return firstAttachment;
    }

    /**
     * @param firstAttachment the firstAttachment to set
     */
    public void setFirstAttachment(MessageAttachmentVO firstAttachment) {
        this.firstAttachment = firstAttachment;
    }

    /**
     * @return the downloadAttachment
     */
    public MessageAttachmentVO getDownloadAttachment() {
        return downloadAttachment;
    }

    /**
     * @param downloadAttachment the downloadAttachment to set
     */
    public void setDownloadAttachment(MessageAttachmentVO downloadAttachment) {
        this.downloadAttachment = downloadAttachment;
    }

    /**
     * @return the showFile1
     */
    public String getShowFile1() {
        return showFile1;
    }

    /**
     * @param showFile1 the showFile1 to set
     */
    public void setShowFile1(String showFile1) {
        this.showFile1 = showFile1;
    }

    /**
     * @return the showFile2
     */
    public String getShowFile2() {
        return showFile2;
    }

    /**
     * @param showFile2 the showFile2 to set
     */
    public void setShowFile2(String showFile2) {
        this.showFile2 = showFile2;
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

    public String getVarFileds() {
        return varFileds;
    }

    public void setVarFileds(String varFileds) {
        this.varFileds = varFileds;
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

	public List<MessageAddProdVO> getAddProdList() {
		return addProdList;
	}

	public void setAddProdList(List<MessageAddProdVO> addProdList) {
		this.addProdList = addProdList;
	}

	public String getImgList() {
		return imgList;
	}

	public void setImgList(String imgList) {
		this.imgList = imgList;
	}

	public String getMbSosok() {
		return mbSosok;
	}

	public void setMbSosok(String mbSosok) {
		this.mbSosok = mbSosok;
	}

	public String getCreateDateDiff() {
		return createDateDiff;
	}

	public void setCreateDateDiff(String createDateDiff) {
		this.createDateDiff = createDateDiff;
	}

	public String getSubTitleCnt() {
		return subTitleCnt;
	}

	public void setSubTitleCnt(String subTitleCnt) {
		this.subTitleCnt = subTitleCnt;
	}

}
