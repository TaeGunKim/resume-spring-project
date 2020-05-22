/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 파일 검색 VO
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

import javax.xml.bind.annotation.XmlElement;

import com.mycompany.myapp.common.vo.SearchVO;

public class MessageAttachmentSearchVO extends SearchVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 9030968378050968617L;

    /**
     * 게시글 ID
     */
    @XmlElement(name = "messageSeq")
    private String messageSeq;

    /**
     * 게시글 위치
     */
    @XmlElement(name = "showIndex")
    private int showIndex;

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
	 * @return the showIndex
	 */
	public int getShowIndex() {
		return showIndex;
	}

	/**
	 * @param showIndex the showIndex to set
	 */
	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}



}
