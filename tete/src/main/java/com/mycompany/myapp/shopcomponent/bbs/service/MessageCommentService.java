/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 덧글 관리
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
package com.mycompany.myapp.shopcomponent.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.common.util.AuthenticationUtil;
import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.common.vo.SecurityUserVO;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageCommentDAO;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageDAO;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageRecommendDAO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageRecommendVO;

@Service
public class MessageCommentService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageCommentService.class);

    @Resource
    private MessageCommentDAO messageCommentDAO;

    @Resource
    private MessageDAO messageDAO;

    @Resource
    private MessageRecommendDAO messageRecommendDAO;

    /**
     * 게시판 게시글의 덧글 목록
     * @param messageCommentSearchVO
     * @return
     */
    public MessageCommentListVO getMessageCommentList(MessageCommentSearchVO messageCommentSearchVO) {

        LOG.debug("invoked 'getMessageCommentList' method...");

        int totalCount = messageCommentDAO.getListTotalCount(messageCommentSearchVO);
        List<MessageCommentVO> messageCommentList = messageCommentDAO.getMessageCommentList(messageCommentSearchVO);

        MessageCommentListVO messageCommentListVO = new MessageCommentListVO();

        messageCommentListVO.setMessageCommentList(messageCommentList);
        messageCommentListVO.setMessageCommentSearchVO(messageCommentSearchVO);
        messageCommentListVO.getMessageCommentSearchVO().setTotalCount(totalCount);

        return messageCommentListVO;

    }

    /**
     * @param messageCommentSearchVO
     * @return
     */
    public int getMessageCommentRegisterIdCount(MessageCommentSearchVO messageCommentSearchVO) {

        LOG.debug("invoked 'getMessageCommentRegisterIdCount' method...");

        int totalCount = messageCommentDAO.getMessageCommentRegisterIdCount(messageCommentSearchVO);

        return totalCount;

    }

    /**
     * @param messageCommentSearchVO
     * @return
     */
    public MessageCommentListVO getMessageCommentEventList(MessageCommentSearchVO messageCommentSearchVO) {

        LOG.debug("invoked 'getMessageCommentList' method...");

        List<MessageCommentVO> messageCommentList = messageCommentDAO.getMessageCommentEventList(messageCommentSearchVO);

        MessageCommentListVO messageCommentListVO = new MessageCommentListVO();

        messageCommentListVO.setMessageCommentList(messageCommentList);
        messageCommentListVO.setMessageCommentSearchVO(messageCommentSearchVO);

        return messageCommentListVO;

    }

    /**
     * 게시판 게시글의 덧글 등록
     * @param messageCommentFormVO
     * @return
     */
    public int insertMessageComment(MessageCommentFormVO messageCommentFormVO) {

        LOG.debug("invoked 'insertMessageComment' method...");

        messageCommentFormVO.setCreateId(messageCommentFormVO.getCreateName());
        messageCommentFormVO.setCreateIp(ConvertUtil.getRequestIp());

        int row = 0;

        row += messageCommentDAO.insertMessageComment(messageCommentFormVO);

        if( row > 0 ){
            String sortTree = ConvertUtil.getSortTree(messageCommentFormVO.getSortTree(), Integer.valueOf(messageCommentFormVO.getCommentSeq()));

            messageCommentFormVO.setSortTree(sortTree);
            messageCommentDAO.updateMessageCommentSortTree(messageCommentFormVO);

        }

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageSeq(messageCommentFormVO.getMessageSeq());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);

        return row;
    }

    /**
     * @param messageCommentFormVO
     * @return
     */
    public int updateMessageCommentRecommendCount(MessageCommentFormVO messageCommentFormVO) {

        LOG.debug("invoked 'insertMessageComment' method...");

        int row = 0;

        MessageRecommendVO messageRecommendVO = messageRecommendDAO.getMessageRecommendRegisterId( Integer.parseInt( messageCommentFormVO.getMessageSeq() ) , messageCommentFormVO.getCreateId());
        if( messageRecommendVO==null ){
            messageRecommendVO = new MessageRecommendVO();
            messageRecommendVO.setMessageSeq(Integer.parseInt(messageCommentFormVO.getMessageSeq()));
            messageRecommendVO.setCreateId(messageCommentFormVO.getCreateId());
            row += messageRecommendDAO.insertMessageRecommend(messageRecommendVO);
            row += messageCommentDAO.updateMessageCommentRecommendCount(messageCommentFormVO);
        }else{
            row = -2;
        }


        return row;
    }

    /**
     * 게시판 게시글의 삭제
     * @param messageCommentFormVO
     * @return
     */
    public int deleteComment(MessageCommentFormVO messageCommentFormVO) {

        LOG.debug("invoked 'deleteComment' method...");

        int row = 0;
        row += messageCommentDAO.deleteComment(messageCommentFormVO);

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageSeq(messageCommentFormVO.getMessageSeq());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);
        return row;
    }

    /**
     * 게시판 게시글의 선택된 덧글 삭제
     * @param messageCommentFormVO
     * @return
     */
    public int deleteSelectComment(MessageCommentFormVO messageCommentFormVO) {

        LOG.debug("invoked 'deleteSelectComment' method...");

        int row = 0;
        row += messageCommentDAO.deleteSelectComment(messageCommentFormVO);

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageSeq(messageCommentFormVO.getMessageSeq());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);
        return row;
    }

}
