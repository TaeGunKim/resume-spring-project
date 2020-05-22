/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 카테고리 관리
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

import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.shopcomponent.bbs.dao.MessageCategoryDAO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategorySearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryVO;

@Service
public class MessageCategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageCategoryService.class);

    @Resource
    private MessageCategoryDAO messageCategoryDAO;

    /**
     * 게시판 게시글의 카테고리 목록
     * @param messageCategorySearchVO
     * @return
     */
    public MessageCategoryListVO getMessageCategoryList(
            MessageCategorySearchVO messageCategorySearchVO) {

        LOG.debug("invoked 'getMessageCategoryList' method...");

        int messageCategoryTotalCount = messageCategoryDAO.getListTotalCount(messageCategorySearchVO);

        MessageCategoryListVO messageCategoryListVO = new MessageCategoryListVO();

        List<MessageCategoryVO> messageCategoryList = messageCategoryDAO.getMessageCategoryList(messageCategorySearchVO);

        messageCategoryListVO.setMessageCategoryList(messageCategoryList);
        messageCategoryListVO.setMessageCategorySearchVO(messageCategorySearchVO);
        messageCategoryListVO.getMessageCategorySearchVO().setTotalCount(messageCategoryTotalCount);

        return messageCategoryListVO;
    }

    /**
     * @param boardseq
     * @return
     */
    public List<MessageCategoryVO> getMessageCategorySelectList(MessageCategorySearchVO messageCategorySearchVO) {

        LOG.debug("invoked 'getMessageCategorySelectList' method...");

        return messageCategoryDAO.getMessageCategoryList(messageCategorySearchVO);

    }

    /**
     * 게시판 게시글의 카테고리 정보
     * @param messageCateaoryVO
     * @return
     */
    public MessageCategoryVO getMessageCategory(
            MessageCategorySearchVO messageCategorySearchVO) {

        LOG.debug("invoked 'getMessageCategory' method...");

        return messageCategoryDAO.getMessageCategory(messageCategorySearchVO);
    }

    /**
     * 게시판 게시글의 카테고리 등록
     * @param messageCategoryVO
     * @return
     */
    public int addMessageCategory(MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'addMessageCategory' method...");

        int categoryKey = messageCategoryDAO.insertMessageCategory(messageCategoryVO);

        messageCategoryVO.setMessageCategorySeq(String.valueOf(categoryKey));

        String level = ConvertUtil.getSortTree(messageCategoryVO.getSortTree(), categoryKey);
        messageCategoryVO.setMessageCategoryLevel(String.valueOf((level.length()-1) / 5)); //레벨계산
        messageCategoryVO.setSortTree(level);

        messageCategoryDAO.updateMessageCategorySortTree(messageCategoryVO);

        return categoryKey;
    }

    /**
     * 게시판 게시글의 카테고리 정보 수정
     * @param messageCategoryVO
     * @return
     */
    public int modifyMessageCategory(MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'modifyMessageCategory' method...");

        return messageCategoryDAO.updateMessageCategory(messageCategoryVO);
    }

    /**
     * 게시판 게시글의 카테고리 상태 수정
     * @param messageCategoryVO
     * @return
     */
    public int modifyMessageCategoryStatus(MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'modifyMessageCategoryStatus' method...");

        return messageCategoryDAO.updateMessageCategoryStatus(messageCategoryVO);
    }

    /**
     * 카테고리 순서 수정
     * @param messageCategoryVO
     * @return
     */
    public int modifyMessageCategorySortTree(MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'modifyMessageCategorySortTree' method...");

        return messageCategoryDAO.updateMessageCategorySortTree(messageCategoryVO);
    }

    /**
     * 게시판 게시글의 카테고리 삭제
     * @param messageCategoryVO
     * @return
     */
    public int removeMessageCategory(MessageCategoryVO messageCategoryVO) {

        LOG.debug("invoked 'getMessageCategory' method...");

        return messageCategoryDAO.deleteMessageCategory(messageCategoryVO);
    }

}
