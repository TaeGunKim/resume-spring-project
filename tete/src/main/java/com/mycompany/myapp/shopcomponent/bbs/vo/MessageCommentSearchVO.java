/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 덧글 검색 조건 VO
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
import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.myapp.common.vo.SearchVO;

@XmlRootElement(name = "MessageCommentSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCommentSearchVO extends SearchVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8895072704615113533L;

    private String commentSeq;
    private String messageSeq;
    private String createId;
    private String createPwd;
    private String createName;
    private String title;

    /**
     * @return the commentSeq
     */
    public String getCommentSeq() {
        return commentSeq;
    }
    /**
     * @param commentSeq the commentSeq to set
     */
    public void setCommentSeq(String commentSeq) {
        this.commentSeq = commentSeq;
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

}
