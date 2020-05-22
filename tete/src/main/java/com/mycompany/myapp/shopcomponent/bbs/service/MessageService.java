/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 관리
 *
 * <pre>
 * <b>History:</b>
 * Author	   Date		Description
 * ys.ko		2016.07.03  초기작성
 * </pre>
 *
 * author ys.ko
 * version 1.0, 2016.07.03 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.processor.AttachmentProcessor;
import com.mycompany.myapp.common.component.vo.AttachmentVO;
import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.common.util.PamaStringUtils;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageAddProdDAO;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageAttachmentDAO;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageDAO;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageAttachmentVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageVO;

@Service
public class MessageService {

	private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

	@Resource
	private BoardManagerService boardManagerService;

	@Resource
	private MessageDAO messageDAO;

	@Resource
	private MessageAttachmentDAO messageAttachmentDAO;

	@Resource
	private MessageAddProdDAO messageAddProdDAO;

	@Resource
	private AttachmentProcessor attachmentProcessor;

	/**
	 * 게시판 게시글 총갯수
	 * @param searchValue
	 * @return
	 */
	public int getMessageCount(String searchValue) {
		LOG.debug("invoked 'getMessageCount' method...");

		return messageDAO.getMessageCount(searchValue);
	}

	/**
	 * 게시판 게시글 목록
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageList(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageList' method...");

		MessageListVO messageListVO = new MessageListVO();


		int totalCount = messageDAO.getListTotalCount(messageSearchVO);
		List<MessageVO> messageList = messageDAO.getMessageList(messageSearchVO);
		for (MessageVO messageVO : messageList) {

		  //첨부 조회
			List<MessageAttachmentVO> messageAttachmentVOs =  messageAttachmentDAO.getMessageAttachments(String.valueOf(messageVO.getMessageSeq()));

			MessageAttachmentVO[] messageAttachmentVOShowIndex=new MessageAttachmentVO[9];

			for (MessageAttachmentVO messageAttachmentVO : messageAttachmentVOs) {

				if(messageAttachmentVO.getShowIndex()>0){
					messageAttachmentVOShowIndex[messageAttachmentVO.getShowIndex()]=messageAttachmentVO;
				}
			}

			if( messageAttachmentVOs.size() > 0){
				messageVO.setAttachmentList(messageAttachmentVOs);
				int messageAttachmentVOsSize = messageAttachmentVOs.size();
				messageVO.setLastAttachment(messageAttachmentVOs.get(messageAttachmentVOsSize-1));
				messageVO.setFirstAttachment(messageAttachmentVOs.get(0));
			}

		}

		messageListVO.setMessageList(messageList);
		messageListVO.setMessageSearchVO(messageSearchVO);
		messageListVO.getMessageSearchVO().setTotalCount(totalCount);

		int rest = totalCount%messageSearchVO.getRow()==0?0:1;
		int totalPages = totalCount==0?1:totalCount / messageSearchVO.getRow() + rest;
		messageListVO.getMessageSearchVO().setTotalPages(totalPages);

		return messageListVO;
	}
	/**
	 * 상단 공지 게시판 게시글 5개 목록
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageList5(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageList5' method...");

		MessageListVO messageListVO = new MessageListVO();

		int totalCount = messageDAO.getListTotalCount5(messageSearchVO);
		List<MessageVO> messageList;
		//일반
		messageSearchVO.setRow(5);
		messageList = messageDAO.getMessageList(messageSearchVO);


		messageListVO.setMessageList(messageList);
		messageListVO.setMessageSearchVO(messageSearchVO);
		messageListVO.getMessageSearchVO().setTotalCount(totalCount);

		/*
		int rest = totalCount%messageSearchVO.getRow()==0?0:1;
		int totalPages = totalCount==0?1:totalCount / messageSearchVO.getRow() + rest;
		messageListVO.getMessageSearchVO().setTotalPages(totalPages);
		*/

		return messageListVO;
	}


	/**
	 * 게시판 게시글의 전체 목록
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageAllList(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageAllList' method...");

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageAllList(messageSearchVO));

		return messageListVO;
	}


	/**
	 * 게시판 게시글의 검색된 목록
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageSearchList(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageSearchList' method...");

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageList(messageSearchVO));

		return messageListVO;
	}

	/**
	 * @param boardId
	 * @param row
	 * @return
	 */
	public List<MessageVO> getMessageMainList(String boardId, int row) {

		LOG.debug("invoked 'getMessageMainList' method...");

		BoardVO boardVO = boardManagerService.getBoard(boardId);

		return messageDAO.getMessageMainList(String.valueOf(boardVO.getBoardSeq()), row);

	}

	/**
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageBestList(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageBestList' method...");

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageBestList(messageSearchVO));

		return messageListVO;

	}

	/**
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageLevelList(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageLevelList' method...");

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageLevelList(messageSearchVO));

		return messageListVO;

	}


	/**
	 * @param messageSearchVO
	 * @return
	 */
	public List<MessageVO> getRandomMessages(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getRandomMessage' method...");

		BoardVO boardVO = boardManagerService.getBoard(messageSearchVO.getBoardId());
		messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

		return messageDAO.getRandomMessages(messageSearchVO);
	}


	/**
	 * @param messageSearchVO
	 * @return
	 * @throws ParseException
	 */
	public MessageVO getMessageOne(MessageSearchVO messageSearchVO) throws ParseException {

		LOG.debug("invoked 'getMessage' method...");

		return getMessageOne(messageSearchVO.getBoardSeq(), messageSearchVO.getMessageSeq());
	}
	public MessageVO getMessageReplyOne(MessageSearchVO messageSearchVO) throws ParseException {

		LOG.debug("invoked 'getMessageReply' method...");
		LOG.debug(messageSearchVO.getBoardSeq());
		LOG.debug(messageSearchVO.getParentMessageSeq());

		return getMessageReplyOne(messageSearchVO.getBoardSeq(), messageSearchVO.getParentMessageSeq());
	}

	/**
	 * 관리자/사용자 같은거 사용함
	 * @param messageId
	 * @return
	 * @throws ParseException
	 */
	public MessageVO getMessageOne(String boardseq, String messageId) throws ParseException {

		LOG.debug("invoked 'getMessage' method...");

		if (messageId != null) {

			MessageVO messageVO = messageDAO.getMessageOne(boardseq, messageId);


			String varFileds = messageVO.getVarFileds();

			//첨부 조회
			List<MessageAttachmentVO> messageAttachmentVOs =  messageAttachmentDAO.getMessageAttachments(messageId);

			MessageAttachmentVO[] messageAttachmentVOShowIndex=new MessageAttachmentVO[9];

			for (MessageAttachmentVO messageAttachmentVO : messageAttachmentVOs) {

				if(messageAttachmentVO.getShowIndex()>0){
					messageAttachmentVOShowIndex[messageAttachmentVO.getShowIndex()]=messageAttachmentVO;
				}
			}

			if( messageAttachmentVOs.size() > 0){
				messageVO.setAttachmentList(messageAttachmentVOs);
				int messageAttachmentVOsSize = messageAttachmentVOs.size();
				messageVO.setLastAttachment(messageAttachmentVOs.get(messageAttachmentVOsSize-1));
				messageVO.setFirstAttachment(messageAttachmentVOs.get(0));
			}
			return messageVO;

		} else {
			return null;
		}
	}
	public MessageVO getMessageReplyOne(String boardseq, String messageId) throws ParseException {

		LOG.debug("invoked 'getMessage' method...");

		if (messageId != null) {

			MessageVO messageVO = messageDAO.getMessageReplyOne(boardseq, messageId);

			if(messageVO != null){

				String varFileds = messageVO.getVarFileds();
				//첨부 조회
				List<MessageAttachmentVO> messageAttachmentVOs =  messageAttachmentDAO.getMessageAttachments(messageId);
				MessageAttachmentVO[] messageAttachmentVOShowIndex=new MessageAttachmentVO[9];

				for (MessageAttachmentVO messageAttachmentVO : messageAttachmentVOs) {
					if(messageAttachmentVO.getShowIndex()>0){
						messageAttachmentVOShowIndex[messageAttachmentVO.getShowIndex()]=messageAttachmentVO;
					}
				}

				if( messageAttachmentVOs.size() > 0){
					messageVO.setAttachmentList(messageAttachmentVOs);
					int messageAttachmentVOsSize = messageAttachmentVOs.size();
					messageVO.setLastAttachment(messageAttachmentVOs.get(messageAttachmentVOsSize-1));
					messageVO.setFirstAttachment(messageAttachmentVOs.get(0));
				}
				return messageVO;

			} else {
				return null;
			}
		}else{
			return null;
		}
	}

	/**
	 * 관리자/사용자 같은거 사용함
	 * @param messageId
	 * @return
	 */
	public MessageVO getMessageOne2(String messageId) {

		LOG.debug("invoked 'getMessage' method...");

		if (messageId != null) {

			MessageVO messageVO = messageDAO.getMessageOne2(Integer.parseInt(messageId));

			return messageVO;

		} else {
			return null;
		}
	}


	/**
	 * 게시판 게시글의 이전 글
	 * @param messageSearchVO
	 * @return
	 */
	public MessageVO getMessageViewPrev(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageViewPrev' method...");

		if (messageSearchVO.getMessageSeq() != null) {
			MessageVO messageVO = messageDAO.getMessageViewPrev(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}


	/**
	 * 게시판 게시글의 다음 글
	 * @param messageSearchVO
	 * @return
	 */
	public MessageVO getMessageViewNext(MessageSearchVO messageSearchVO) {

		LOG.debug("invoked 'getMessageViewNext' method...");

		if (messageSearchVO.getMessageSeq() != null) {
			MessageVO messageVO = messageDAO.getMessageViewNext(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}

	/**
	 * 이전글
	 * @param messageSearchVO
	 * @return
	 */
	public MessageVO getMessagePrev(MessageSearchVO messageSearchVO) {
		LOG.debug("invoked 'getMessagePrev' method...");

		if (messageSearchVO.getMessageSeq() != null) {
			MessageVO messageVO = messageDAO.getMessagePrev(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}

	/**
	 * 다음글
	 * @param messageSearchVO
	 * @return
	 */
	public MessageVO getMessageNext(MessageSearchVO messageSearchVO) {
		LOG.debug("invoked 'getMessageNext' method...");

		if (messageSearchVO.getMessageSeq() != null) {
			MessageVO messageVO = messageDAO.getMessageNext(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}

	/**
	 * 사용자 후기 별점수
	 * @param messageSearchVO
	 * @return
	 */
	public int getRecommendScore(MessageSearchVO messageSearchVO) {
		LOG.debug("invoked 'getRecommendScore' method...");

		int recommendScore = 0;
		int recommendTotalCount = messageDAO.getRecommendTotalCount(messageSearchVO);
		int recommendTotalSum = messageDAO.getRecommendTotalSum(messageSearchVO);
//		recommendScore = Math.round(recommendTotalSum / (recommendTotalCount * 5));

		if(recommendTotalCount == 0 && recommendTotalSum == 0){
			recommendScore = 0;
		}else{
			recommendScore = Math.round(recommendTotalSum / recommendTotalCount);
		}

		return recommendScore;
	}

	/**
	 * 게시판 게시글 등록
	 * @param messageFormVO
	 * @return
	 */
	public int addMessage(MessageFormVO messageFormVO) {

		LOG.debug("invoked 'addMessage' method...");

		//요약정보
		if (PamaStringUtils.isEmpty(messageFormVO.getSummaryContents())) {


			String contents = "";

			if(PamaStringUtils.isNotEmpty(messageFormVO.getContents())){//contents Param없을경우 대비
				contents = PamaStringUtils.removeTag(messageFormVO.getContents());
			}

			if (contents.length() > 500) {
				messageFormVO.setSummaryContents(StringUtils.substring(contents, 0, 500));
			} else {
				messageFormVO.setSummaryContents(contents);
			}
		}

		// 게시여부
		if (messageFormVO.getStatusType()==null || "".equals(messageFormVO.getStatusType())){
			messageFormVO.setStatusType(Constants.CONTENTS_STATUS_WAIT); // 대기
		}

		int insertMessageSuccess = messageDAO.insertMessage(messageFormVO);

		if (insertMessageSuccess != 0) {

			String sortTree = ConvertUtil.getSortTree(messageFormVO.getSortTree(), Integer.valueOf(messageFormVO.getMessageSeq()));

			messageFormVO.setMessageLevel(String.valueOf((sortTree.length()-1) / 5)); //레벨계산
			messageFormVO.setSortTree(sortTree);

			// 정렬 코드 저장
			messageDAO.updateMessageSortTree(messageFormVO);
			// 내용을 저장
			messageDAO.insertMessageContents(messageFormVO);

			// 첨부파일 저장
			if  (messageFormVO.getAttachmentList() != null) {
				for (MessageAttachmentVO messageAttachmentVO : messageFormVO.getAttachmentList()) {
					messageAttachmentVO.setMessageSeq(String.valueOf(messageFormVO.getMessageSeq()));
					messageAttachmentDAO.insertMessageAttachment(messageAttachmentVO);
				}
			}

			if (!PamaStringUtils.isEmpty(messageFormVO.getParentMessageSeq()) && !"0".equals(messageFormVO.getParentMessageSeq())) {
				messageDAO.updateMessageAddReplyCount(messageFormVO); // 답변수 증가
			}
		}
		return Integer.valueOf(messageFormVO.getMessageSeq());
	}


	/**
	 * 게시판 게시글 수정
	 * @param messageVO
	 * @return
	 */
	public int modifyMessage(MessageVO messageVO) {

		LOG.debug("invoked 'modifyMessage' method...");

		int messageCount = 0;

		if (PamaStringUtils.isEmpty(messageVO.getSummaryContents())) {
			if(PamaStringUtils.isNotEmpty(messageVO.getContents())){

				String contents = PamaStringUtils.removeTag(messageVO.getContents());
				if (contents.length() > 500) {
					messageVO.setSummaryContents(StringUtils.substring(contents, 0, 500));
				} else {
					messageVO.setSummaryContents(contents);
				}
			}
		}
		// 게시여부
		if (PamaStringUtils.equals(messageVO.getStatusType(), Constants.CONTENTS_STATUS_WAIT)
				|| PamaStringUtils.equals(messageVO.getStatusType(), Constants.CONTENTS_STATUS_ON)
				){

		}else{
			messageVO.setStatusType(null);
		}

		messageCount = messageDAO.updateMessage(messageVO);

		if (messageCount != 0) {
			messageDAO.updateMessageContents(messageVO);

			if (messageVO.getAttachmentList()!=null) {
				for (MessageAttachmentVO messageAttachmentVO : messageVO.getAttachmentList()) {

					if(messageAttachmentVO.getShowIndex() > 0){

						//편의상 잘못올라간 showindex가 중복이 될 경우에는 삭제한다.
						List<MessageAttachmentVO> messageAttachmentVOs = messageAttachmentDAO.getMessageAttachmentShowIndex(messageAttachmentVO);

						for (MessageAttachmentVO messageAttachmentVO2 : messageAttachmentVOs) {
							messageAttachmentDAO.deleteMessageAttachment(messageAttachmentVO2.getAttachmentId());

							try {
								attachmentProcessor.removeFile(Constants.SERVICE_ID_BBS, messageAttachmentVO2.getFileName());
							} catch (IOException e) { LOG.error("[FILE Delete Error] " + e.getMessage()); }
						}

					}
					messageAttachmentVO.setMessageSeq(String.valueOf(messageVO.getMessageSeq()));
					int status = messageAttachmentDAO.getIsMessageAttachment(messageAttachmentVO);
					if(status > 0) {
						messageAttachmentDAO.updateMessageAttachmentShowIdx(messageAttachmentVO);
						messageAttachmentDAO.insertMessageAttachment(messageAttachmentVO);
					}else {
						messageAttachmentDAO.insertMessageAttachment(messageAttachmentVO);
					}

				}
			}
		}

		return messageCount;
	}


	/**
	 * @param messageFormVO
	 * @return
	 */
	public int modifyMessageAddViewCount(MessageFormVO messageFormVO) {

		LOG.debug("invoked 'modifyMessageAddViewCount' method...");

		return messageDAO.updateMessageAddViewCount(messageFormVO);
	}

	/**
	 * @param messageVO
	 * @return
	 */
	public int modifyVarFiled1(MessageVO messageVO) {

		LOG.debug("invoked 'modifyVarFiled1' method...");

		return messageDAO.updateVarFiled1(messageVO);
	}


	/**
	 * @param messageVO
	 * @return
	 */
	public int modifyMessageStatus(MessageVO messageVO) {

		LOG.debug("invoked 'modifyMessageStatus' method...");

		return messageDAO.updateMessageRemove(messageVO);
	}


	/**
	 * @param messageVO
	 * @return
	 */
	public int modifyMessageTags(MessageVO messageVO) {

		LOG.debug("invoked 'modifyMessageTags' method...");

		return messageDAO.updateMessageTagsRemove(messageVO);
	}


	/**
	 * @param messageVO
	 * @return
	 */
	public int removeMessage(MessageVO messageVO) {

		LOG.debug("invoked 'removeMessage' method...");
		int status = 0;
		return messageDAO.updateMessageRemove(messageVO);
	}


	/**
	 * @param messageVO
	 * @return
	 */
	public int removeAllMessage(MessageVO messageVO) {

		LOG.debug("invoked 'removeAllMessage' method...");

		int messageCount = 0;

		messageCount = messageAttachmentDAO.deleteMessageAttachmentMessageId(String.valueOf(messageVO.getMessageSeq()));
		messageCount = messageDAO.deleteMessageContents(String.valueOf(messageVO.getMessageSeq()));
		messageCount = messageDAO.deleteMessage(String.valueOf(messageVO.getMessageSeq()));

		return messageCount;
	}


	/**
	 * @param messageFormVO
	 * @return
	 */
	public int removeSelectMessage(MessageFormVO messageFormVO) {

		LOG.debug("invoked 'removeSelectMessage' method...");

		int messageCount = 0;

		MessageAttachmentVO messageAttachmentVO = new MessageAttachmentVO();

		messageCount = messageAttachmentDAO.deleteSelectMessageAttachment(messageAttachmentVO);

		messageCount = messageDAO.deleteSelectMessageContents(messageFormVO);

		messageCount = messageDAO.deleteSelectMessage(messageFormVO);

		return messageCount;
	}


	/**
	 * @param fileName
	 * @return
	 */
	public int removeMessageAttachment(String fileName) {

		LOG.debug("invoked 'removeMessageAttachment' method...");

		int messageCount = 0;
		messageCount = messageAttachmentDAO.deleteNameMessageAttachment(fileName);

		return messageCount;
	}


	/**
	 * @param attachmentVO
	 * @param boardseq
	 * @return
	 */
	public MessageAttachmentVO getMessageAttachmentoVO(AttachmentVO attachmentVO, String boardseq) {

		LOG.debug("invoked 'getMessageAttachmentoVO' method...");

		MessageAttachmentVO messageAttachmentVO = new MessageAttachmentVO();
		messageAttachmentVO.setBoardSeq(boardseq);
		messageAttachmentVO.setDisplayName(attachmentVO.getOriginalFilename());
		messageAttachmentVO.setFileName(attachmentVO.getFileName());
		messageAttachmentVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
		messageAttachmentVO.setFilePath(attachmentVO.getFilePath());
		messageAttachmentVO.setContentType(attachmentVO.getContentType());
		if (attachmentVO.getContentType().indexOf("image") >= 0) {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
			messageAttachmentVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
			messageAttachmentVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
		} else {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
		}

		return messageAttachmentVO;
	}

	/**
	 * @param attachmentVO
	 * @param boardseq
	 * @param showIndex
	 * @return
	 */
	public MessageAttachmentVO getShowIndexMessageAttachmentoVO(AttachmentVO attachmentVO, String boardseq, int showIndex) {

		LOG.debug("invoked 'getShowIndexMessageAttachmentoVO' method...");

		MessageAttachmentVO messageAttachmentVO = new MessageAttachmentVO();
		messageAttachmentVO.setBoardSeq(boardseq);
		messageAttachmentVO.setDisplayName(attachmentVO.getOriginalFilename());
		messageAttachmentVO.setFileName(attachmentVO.getFileName());
		messageAttachmentVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
		messageAttachmentVO.setFilePath(attachmentVO.getFilePath());
		messageAttachmentVO.setContentType(attachmentVO.getContentType());
		messageAttachmentVO.setShowIndex(showIndex);
		if (attachmentVO.getContentType().indexOf("image") >= 0) {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
			messageAttachmentVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
			messageAttachmentVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
		} else {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
		}

		return messageAttachmentVO;
	}


	/**
	 * @param boardseq
	 * @param fileName
	 * @return
	 */
	public MessageVO getMessageLicenseAttachment(int boardseq, String fileName) {

		LOG.debug("invoked 'getMessage' method...");

		MessageAttachmentVO messageAttachmentVO = messageAttachmentDAO.getMessageAttachmentFileName(fileName);
		String messageSeq = messageAttachmentVO.getMessageSeq();
		MessageVO messageVO = messageDAO.getMessageOne(String.valueOf(boardseq), messageSeq);
		messageVO.setDownloadAttachment(messageAttachmentVO);

		return messageVO;
	}


	/**
	 * @param boardseq
	 * @param fileName
	 * @return
	 */
	public MessageVO addMessageAttachmentDownload(int boardseq, String fileName) {

		LOG.debug("invoked 'getMessage' method...");

		MessageAttachmentVO messageAttachmentVO = messageAttachmentDAO.getMessageAttachmentFileName(fileName);
		String messageSeq = messageAttachmentVO.getMessageSeq();
		MessageVO messageVO = messageDAO.getMessageOne(String.valueOf(boardseq), messageSeq);
		messageVO.setDownloadAttachment(messageAttachmentVO);

		return messageVO;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public int modifyMessageAttachmentDownload(String fileName) {

		LOG.debug("invoked 'getMessage' method...");

		int resultCnt = messageAttachmentDAO.updateAddMessageAttachmentDownload(fileName);

		return resultCnt;
	}

	public MessageListVO getMessageListRecent4() {
		MessageListVO messageListVO = new MessageListVO();
		List<MessageVO> messageListRecent4 = messageDAO.getMessageListRecent4();
		messageListVO.setMessageList(messageListRecent4);
		return messageListVO;
	}

	public MessageListVO getMessageSubTitleCnt() {
		MessageListVO messageListVO = new MessageListVO();
		List<MessageVO> messageSubTitleCnt = messageDAO.getMessageSubTitleCnt();
		messageListVO.setMessageList(messageSubTitleCnt);
		return messageListVO;
	}

}
