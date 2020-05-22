/**
l * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 파일 정보 VO
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

@XmlRootElement(name = "messageAttachment")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageAttachmentVO implements Serializable {

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8541479529233534344L;

    @XmlElement(name = "attachmentSeq")
    private String attachmentSeq;

    /**
     * 첨부파일 ID
     */
    @XmlElement(name = "attachmentId")
    private String attachmentId;

    /**
     * 게시글 ID
     */
    @XmlElement(name = "messageSeq")
    private String messageSeq;

    /**
     * 첨부파일 종류
     */
    @XmlElement(name = "fileType")
    private String fileType;

    /**
     * 첨부파일 contentType
     */
    @XmlElement(name = "contentType")
    private String contentType;

    /**
     * 서버저장 파일명
     */
    @XmlElement(name = "fileName")
    private String fileName;

    /**
     * 사용자 노출 파일명
     */
    @XmlElement(name = "displayName")
    private String displayName;

    /**
     * 파일 위치
     */
    @XmlElement(name = "filePath")
    private String filePath;

    /**
     * 파일 용량
     */
    @XmlElement(name = "fileSize")
    private String fileSize;

    /**
     * 파일 다운로드 수
     */
    @XmlElement(name = "downloadCount")
    private String downloadCount;

    /**
     * 파일 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 이미지 Width
     */
    @XmlElement(name = "imageWidth")
    private String imageWidth;

    /**
     * 이미지 Height
     */
    @XmlElement(name = "imageHeight")
    private String imageHeight;

    /**
     * 파일 확장명
     */
    @XmlElement(name = "fileExt")
    private String fileExt;

    /**
     * showIndex
     */
    @XmlElement(name = "showIndex")
    private int showIndex;

    /**
     *
     */
    @XmlElement(name = "registerAfterHour")
    private String registerAfterHour;//등록후 지난시간

    /**
     *
     */
    @XmlElement(name = "updateAfterdHour")
    private String updateAfterdHour;//수정후 지난시간

    /**
     *
     */
    @XmlElement(name = "title")
    private String title;

    /**
     *
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

    /**
     *
     */
    @XmlElement(name = "messageCategorySeq")
    private String messageCategorySeq;

	/**
     * @return the attachmentSeq
     */
    public String getAttachmentSeq() {
        return attachmentSeq;
    }

    /**
     * @param attachmentSeq the attachmentSeq to set
     */
    public void setAttachmentSeq(String attachmentSeq) {
        this.attachmentSeq = attachmentSeq;
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
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the downloadCount
	 */
	public String getDownloadCount() {
		return downloadCount;
	}

	/**
	 * @param downloadCount the downloadCount to set
	 */
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}

	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the imageWidth
	 */
	public String getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public String getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the fileExt
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @param fileExt the fileExt to set
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
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
	 * @return the updateAfterdHour
	 */
	public String getUpdateAfterdHour() {
		return updateAfterdHour;
	}

	/**
	 * @param updateAfterdHour the updateAfterdHour to set
	 */
	public void setUpdateAfterdHour(String updateAfterdHour) {
		this.updateAfterdHour = updateAfterdHour;
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

	public int getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}

	/* (non-Javadoc)
	* see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageAttachmentVO [attachmentId=" + attachmentId + ", messageSeq=" + messageSeq + ", fileType="
				+ fileType + ", contentType=" + contentType + ", fileName=" + fileName + ", displayName=" + displayName
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", downloadCount=" + downloadCount
				+ ", registerDate=" + registerDate + ", imageWidth=" + imageWidth + ", imageHeight=" + imageHeight
				+ ", fileExt=" + fileExt + ", showIndex=" + showIndex + ", registerAfterHour=" + registerAfterHour
				+ ", updateAfterdHour=" + updateAfterdHour + ", title=" + title + ", boardSeq=" + boardSeq
				+ ", messageCategorySeq=" + messageCategorySeq + "]";
	}

}
