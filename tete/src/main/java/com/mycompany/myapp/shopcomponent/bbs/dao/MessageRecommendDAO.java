/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 추천 관리 DAO
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
package com.mycompany.myapp.shopcomponent.bbs.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageRecommendVO;

@Repository(value="MessageRecommendDAO")
public interface MessageRecommendDAO extends Serializable {

    /**
     * @param messageSeq
     * @param registerId
     * @return
     */
    public MessageRecommendVO getMessageRecommendRegisterId(int messageSeq, String registerId);

    /**
     * @param messageRecommendVO
     * @return
     */
    public int insertMessageRecommend(MessageRecommendVO messageRecommendVO);

}
