package com.mycompany.myapp.common.component.vo;

import java.io.Serializable;

public class AttachmentVO implements Serializable {

    /**
     * serial Version UID
     */
    private static final long serialVersionUID = 2546728470112176578L;

    /**
     * 원본 파일이름
     */
    protected String originalFilename;

    /**
     * 저장된 파일이름
     */
    protected String fileName;

    /**
     * 저장된 파일패스
     */
    protected String filePath;

    /**
     * 컨텐츠타입
     */
    protected String contentType;

    /**
     * 저장된 파일사이즈
     */
    protected long fileSize;

    /**
     * 이미지일경우에 너비
     */
    protected int imageWidth;

    /**
     * 이미지일경우에 높이
     */
    protected int imageHeight;

    protected String extension;

    /**
     * @return the originalFilename
     */
    public String getOriginalFilename() {
        return originalFilename;
    }

    /**
     * @param originalFilename the originalFilename to set
     */
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
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
     * @return the fileSize
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the imageWidth
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * @param imageWidth the imageWidth to set
     */
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * @return the imageHeight
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * @param imageHeight the imageHeight to set
     */
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /* (non-Javadoc)
    * see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AttachmentVO [originalFilename=" + originalFilename + ", fileName=" + fileName + ", filePath="
                + filePath + ", contentType=" + contentType + ", fileSize=" + fileSize + ", imageWidth=" + imageWidth
                + ", imageHeight=" + imageHeight + ", extension=" + extension + "]";
    }


}
