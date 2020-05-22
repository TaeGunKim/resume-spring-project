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

@XmlRootElement(name = "messageAddProd")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageAddProdVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4051290195095555890L;

    /**
     * 게시판 아이디
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

    /**
     * 게시물 번호
     */
    @XmlElement(name = "messageSeq")
    private Integer messageSeq;

    /**
     * 게시물 분류 번호
     */
    @XmlElement(name = "gcode")
    private String gcode;


	public String getGcode() {
		return gcode;
	}


	public void setGcode(String gcode) {
		this.gcode = gcode;
	}


	public Integer getMessageSeq() {
		return messageSeq;
	}


	public void setMessageSeq(Integer messageSeq) {
		this.messageSeq = messageSeq;
	}


	public String getBoardSeq() {
		return boardSeq;
	}


	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
}
