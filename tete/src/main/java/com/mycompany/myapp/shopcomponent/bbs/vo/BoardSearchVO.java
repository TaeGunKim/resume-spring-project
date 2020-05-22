/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판 검색 VO
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

import com.mycompany.myapp.common.vo.SearchVO;

@XmlRootElement(name = "boardSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardSearchVO extends SearchVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7554477992643047582L;

    /**
     * 게시판 제목
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * 아이디
     */
    @XmlElement(name = "boardId")
    private String boardId;

    /**
     * 게시판게재
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * lastIndex
     */
    @XmlElement(name = "lastIndex")
    private int lastIndex;

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
     * @return the lastIndex
     */
    public int getLastIndex() {
        return lastIndex;
    }

    /**
     * @param lastIndex the lastIndex to set
     */
    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

}
