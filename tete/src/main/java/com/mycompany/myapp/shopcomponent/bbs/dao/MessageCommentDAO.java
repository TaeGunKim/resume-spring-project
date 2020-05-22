/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 덧글 관리 DAO
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
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentVO;

@Repository(value="MessageCommentDAO")
public interface MessageCommentDAO extends Serializable {

    /**
     * 게시물의 덧글 총 갯수
     * @param messageCommentSearchVO
     * @return
     */
    public int getListTotalCount(MessageCommentSearchVO messageCommentSearchVO);

    /**
     * @param messageCommentSearchVO
     * @return
     */
    public int getMessageCommentRegisterIdCount(MessageCommentSearchVO messageCommentSearchVO);

    /**
     * 게시물의 덧글 목록
     * @param messageCommentSearchVO
     * @return
     */
    public List<MessageCommentVO> getMessageCommentList(MessageCommentSearchVO messageCommentSearchVO);

    /**
     * @param messageCommentSearchVO
     * @return
     */
    public List<MessageCommentVO> getMessageCommentEventList(MessageCommentSearchVO messageCommentSearchVO);

    /**
     * 게시물의 덧글 등록
     * @param messageCommentFormVO
     * @return
     */
    public int insertMessageComment(MessageCommentFormVO messageCommentFormVO);

    /**
     * 게시물의 덧글 순서 변경
     * @param messageCommentFormVO
     * @return
     */
    public int updateMessageCommentSortTree(MessageCommentFormVO messageCommentFormVO);

    /**
     * @param messageCommentFormVO
     * @return
     */
    public List<MessageCommentVO> getMessageCommentEventList(MessageCommentFormVO messageCommentFormVO);

    /**
     * @param messageCommentFormVO
     * @return
     */
    public int updateMessageCommentRecommendCount(MessageCommentFormVO messageCommentFormVO);

    /**
     * @param messageCommentFormVO
     * @return
     */
    public int deleteComment(MessageCommentFormVO messageCommentFormVO);

    /**
     * @param messageCommentFormVO
     * @return
     */
    public int deleteSelectComment(MessageCommentFormVO messageCommentFormVO);

}
