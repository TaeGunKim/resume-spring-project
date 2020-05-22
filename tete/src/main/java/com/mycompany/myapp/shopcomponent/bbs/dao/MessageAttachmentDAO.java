/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 첨부파일 관리 DAO
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

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageAttachmentSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageAttachmentVO;

@Repository(value="MessageAttachmentDAO")
public interface MessageAttachmentDAO extends Serializable {

    /**
     * 파일 갯수
     * @param messageAttachmentSearchVO
     * @return
     */
    public int getMessageAttachmentListTotalConut(
            MessageAttachmentSearchVO messageAttachmentSearchVO);

    /**
     * 파일 정보 리스트
     * @param messageAttachmentSearchVO
     * @return
     */
    public List<MessageAttachmentVO> getMessageAttachmentList(
            MessageAttachmentSearchVO messageAttachmentSearchVO);

    /**
     * 파일 상세 정보(게시물포함정보)
     * @param messageAttachmentSearchVO
     * @return
     */
    public int getMessageAttachmentCnt(String messageSeq);

    /**
     * 파일 상세정보
     * @param messageAttachmentSearchVO
     * @return
     */
    public MessageAttachmentVO getMessageAttachment(String attachmentId);

    /**
     * 게시물에 따른 파일 리스트
     * @param attachmentId
     * @return
     */
    public MessageAttachmentVO getMessageAttachment2(String attachmentId);

    /**
     * 파일명으로 파일정보가져오기
     * @param fileName
     * @return
     */
    public MessageAttachmentVO getMessageAttachmentFileName(String fileName);

    /**
     * 파일 정보 수정
     * @param messageAttachmentVO
     * @return
     */
    public int updateAddMessageAttachmentDownload(String fileName);

    /**
     * 파일 검색 타입 리스트
     * @param messageSeq
     * @return
     */
    public List<MessageAttachmentVO> getMessageAttachments(String messageSeq);

    /**
     * 최근 Type 파일 리스트
     * @param messageAttachmentSearchVO
     * @return
     */
    public List<MessageAttachmentVO> getMessageAttachmentTypesList(
            MessageAttachmentSearchVO messageAttachmentSearchVO);

    /**
     * 최근 파일 리스트
     * @param messageAttachmentSearchVO
     * @return
     */
    public List<MessageAttachmentVO> getMessageAttachmentLately(
            MessageAttachmentSearchVO messageAttachmentSearchVO);

    /**
     * 파일 정보 저장
     * @param messageAttachmentVO
     * @return
     */
    public int insertMessageAttachment(MessageAttachmentVO messageAttachmentVO);

    /**
     * 파일 정보 수정
     * @param messageAttachmentVO
     * @return
     */
    public int updateMessageAttachment(MessageAttachmentVO messageAttachmentVO);

    /**
     * 파일 정보 삭제(DB 완전 삭제)
     * @param attachmentId
     * @return
     */
    public int deleteMessageAttachment(String attachmentId);

    /**
     * 파일명으로 검색하여 삭제
     * @param fileName
     * @return
     */
    public int deleteNameMessageAttachment(String fileName);


    /**
     * 게시물기준으로 모든 관련 파일 삭제
     * @param messageSeq
     * @return
     */
    public int deleteMessageAttachmentMessageId(String messageSeq);

    /**
     * 파일 정보 리스트
     * @param messageAttachmentSearchVO
     * @return
     */
    public List<MessageAttachmentVO> getMessageAttachmentShowIndex(MessageAttachmentVO messageAttachmentVO);

    /**
     * 게시물 일괄 삭제 기준으로 모든 파일 삭제
     * @param messageFormVO
     * @return
     */
    public int deleteSelectMessageAttachment(MessageAttachmentVO messageAttachmentVO);

    /**
     * 파일 타입정보로 삭제
     * @param messageAttachmentVO
     * @return
     */
    public int deleteMessageAttachmentFileTypes(
            MessageAttachmentVO messageAttachmentVO);

	public int getIsMessageAttachment(MessageAttachmentVO messageAttachmentVO);

	public void deleteMessageAttachmentShowIdx(MessageAttachmentVO messageAttachmentVO);

	public void updateMessageAttachmentShowIdx(MessageAttachmentVO messageAttachmentVO);

}
