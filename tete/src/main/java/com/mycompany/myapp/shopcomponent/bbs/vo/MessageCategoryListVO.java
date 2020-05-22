/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 카테고리 목록 VO
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

@XmlRootElement(name = "messageCategoryList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategoryListVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -387515520998966782L;

    /**
     * 게사판 리스트
     */
    @XmlElement(name = "messageCategoryList")
    private List<MessageCategoryVO> messageCategoryList;

    /**
     * 게시판 카테고리 검색 조건
     */
    private MessageCategorySearchVO messageCategorySearchVO;

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
     * @return the messageCategorySearchVO
     */
    public MessageCategorySearchVO getMessageCategorySearchVO() {
        return messageCategorySearchVO;
    }

    /**
     * @param messageCategorySearchVO the messageCategorySearchVO to set
     */
    public void setMessageCategorySearchVO(
            MessageCategorySearchVO messageCategorySearchVO) {
        this.messageCategorySearchVO = messageCategorySearchVO;
    }


}
