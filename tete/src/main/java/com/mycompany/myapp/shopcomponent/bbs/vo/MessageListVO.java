/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 목록 VO
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

@XmlRootElement(name = "messageList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageListVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5734876390585461964L;

    /**
     * 게시물 리스트
     */
    @XmlElement(name = "messageList")
    private List<MessageVO> messageList;

    /**
     * 게시물 상위 출력 리스트
     */
    @XmlElement(name = "messageTopList")
    private List<MessageVO> messageTopList;

    /**
     * 게시물 검색조건
     */
    private MessageSearchVO messageSearchVO;

    /**
     * @return the messageList
     */
    public List<MessageVO> getMessageList() {
        return messageList;
    }

    /**
     * @param messageList the messageList to set
     */
    public void setMessageList(List<MessageVO> messageList) {
        this.messageList = messageList;
    }

    /**
     * @return the messageTopList
     */
    public List<MessageVO> getMessageTopList() {
        return messageTopList;
    }

    /**
     * @param messageTopList the messageTopList to set
     */
    public void setMessageTopList(List<MessageVO> messageTopList) {
        this.messageTopList = messageTopList;
    }

    /**
     * @return the messageSearchVO
     */
    public MessageSearchVO getMessageSearchVO() {
        return messageSearchVO;
    }

    /**
     * @param messageSearchVO the messageSearchVO to set
     */
    public void setMessageSearchVO(MessageSearchVO messageSearchVO) {
        this.messageSearchVO = messageSearchVO;
    }

}
