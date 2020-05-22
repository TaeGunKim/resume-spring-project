/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 덧글 목록 VO
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

@XmlRootElement(name = "MessageCommentList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCommentListVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3636303992314098739L;

    @XmlElement(name = "messageCommentList")
    private List<MessageCommentVO> messageCommentList;

    private MessageCommentSearchVO messageCommentSearchVO;

    /**
     * @return the messageCommentList
     */
    public List<MessageCommentVO> getMessageCommentList() {
        return messageCommentList;
    }

    /**
     * @param messageCommentList the messageCommentList to set
     */
    public void setMessageCommentList(List<MessageCommentVO> messageCommentList) {
        this.messageCommentList = messageCommentList;
    }

    /**
     * @return the messageCommentSearchVO
     */
    public MessageCommentSearchVO getMessageCommentSearchVO() {
        return messageCommentSearchVO;
    }

    /**
     * @param messageCommentSearchVO the messageCommentSearchVO to set
     */
    public void setMessageCommentSearchVO(MessageCommentSearchVO messageCommentSearchVO) {
        this.messageCommentSearchVO = messageCommentSearchVO;
    }

}
