/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 카테고리 검색 VO
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

@XmlRootElement(name = "messageCategorySearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategorySearchVO extends SearchVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6137639480674330800L;

    /**
     * 게시글 카테고리 ID
     */
    @XmlElement(name = "messageCategorySeq")
    private String messageCategorySeq;

    /**
     * 게시판 ID
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

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

}
