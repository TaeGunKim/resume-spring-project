/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 관리 DAO
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

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageVO;

@Repository(value="MessageDAO")
public interface MessageDAO extends Serializable {

    /**
     * 메세지 목록에 대한 전체게시물갯수
     * @param messageSearchVO
     * @return
     */
    public int getListTotalCount(MessageSearchVO messageSearchVO);

    public int getListTotalCountTest(MessageSearchVO messageSearchVO);

    public int getListTotalCount5(MessageSearchVO messageSearchVO);

    /**
     * 메세지 목록 조회
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageList(MessageSearchVO messageSearchVO);

    /**
     * 메세지 TOP 목록 조회
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageTopList(MessageSearchVO messageSearchVO);

    /**
     * @param searchValue
     * @return
     */
    public int getMessageCount(String searchValue);

    /**
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageAllList(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageBestList(MessageSearchVO messageSearchVO);

    /**
     * @param boardSeq
     * @param row
     * @return
     */
    public List<MessageVO> getMessageMainList(String boardSeq, int row);

    /**
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageLevelList(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getMessageReplyList(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public List<MessageVO> getRandomMessages(MessageSearchVO messageSearchVO);

    /**
     * @param messageSeq
     * @return
     */
    public MessageVO getMessageOne2(Integer messageSeq);

    /**
     * @param boardSeq
     * @param messageSeq
     * @return
     */
    public MessageVO getMessageOne(String boardSeq, String messageSeq);

    public MessageVO getMessageReplyOne(String boardSeq, String messageSeq);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessageView(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessageViewPrev(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessageViewNext(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessagePrev(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessageNext(MessageSearchVO messageSearchVO);

    /**
     * @param messageSearchVO
     * @return
     */
    public MessageVO getMessageContents(MessageSearchVO messageSearchVO);

    /**
     * 사용후기 별점수 등록 갯수
     * @param messageSearchVO
     * @return
     */
    public int getRecommendTotalCount(MessageSearchVO messageSearchVO);

    /**
     * 사용후기 별점수 합계
     * @param messageSearchVO
     * @return
     */
    public int getRecommendTotalSum(MessageSearchVO messageSearchVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int insertMessage(MessageFormVO messageFormVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int insertMessageContents(MessageFormVO messageFormVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateMessage(MessageVO messageVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int updateMessageSortTree(MessageFormVO messageFormVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateMessageContents(MessageVO messageVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateMessageProgressStatus(MessageVO messageVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int updateMessageAddViewCount(MessageFormVO messageFormVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int updateMessageAddReplyCount(MessageFormVO messageFormVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int updateMessageAddCommentCount(MessageFormVO messageFormVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateVarFiled1(MessageVO messageVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateMessageRemove(MessageVO messageVO);

    /**
     * @param messageVO
     * @return
     */
    public int updateMessageTagsRemove(MessageVO messageVO);

    /**
     * @param messageSeq
     * @return
     */
    public int deleteMessage(String messageSeq);

    /**
     * @param messageSeq
     * @return
     */
    public int deleteMessageContents(String messageSeq);

    /**
     * @param messageFormVO
     * @return
     */
    public int deleteSelectMessage(MessageFormVO messageFormVO);

    /**
     * @param messageFormVO
     * @return
     */
    public int deleteSelectMessageContents(MessageFormVO messageFormVO);

	public List<MessageVO> getMessageList5(MessageSearchVO messageSearchVO);

	public List<MessageVO> getMessageListRecent4();

	public List<MessageVO> getMessageSubTitleCnt();
}
