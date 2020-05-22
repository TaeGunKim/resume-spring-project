/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 추천 VO
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

public class MessageRecommendVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3663749389220000827L;

    private int recommendSeq;
    private int messageSeq;
    private String createDate;
    private String createId;
    private String createIp;

    public int getRecommendSeq() {
        return recommendSeq;
    }
    public void setRecommendSeq(int recommendSeq) {
        this.recommendSeq = recommendSeq;
    }
    public int getMessageSeq() {
        return messageSeq;
    }
    public void setMessageSeq(int messageSeq) {
        this.messageSeq = messageSeq;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateId() {
        return createId;
    }
    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getCreateIp() {
        return createIp;
    }
    public void setRegisterIp(String createIp) {
        this.createIp = createIp;
    }

}
