/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시판의 게시물 카테고리 관리 DAO
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

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategorySearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryVO;

@Repository(value="MessageCategoryDAO")
public interface MessageCategoryDAO extends Serializable {

    /**
     * 게시판별로 사용 총 카테고리 수
     * @param messageCategorySearchVO
     * @return
     */
    public int getListTotalCount(MessageCategorySearchVO messageCategorySearchVO);

    /**
     * 게시판별로 사용 카테고리 목록
     * @param boardSeq
     * @return
     */
    public List<MessageCategoryVO> getMessageCategoryList(MessageCategorySearchVO messageCategorySearchVO);

    /**
     * 카테고리 정보
     * @param messageCategorySeq
     * @return
     */
    public MessageCategoryVO getMessageCategory(MessageCategorySearchVO messageCategorySearchVO);

    /**
     * 카테고리 등록
     * @param messageCategoryVO
     * @return
     */
    public int insertMessageCategory(MessageCategoryVO messageCategoryVO);

    /**
     * 카테고리 수정
     * @param messageCategoryVO
     * @return
     */
    public int updateMessageCategory(MessageCategoryVO messageCategoryVO);


    /**
     * 카테고리 상태 변경
     * @param messageCategoryVO
     * @return
     */
    public int updateMessageCategoryStatus(MessageCategoryVO messageCategoryVO);

    /**
     * 카테고리 순서 수정
     * @param messageCategoryVO
     * @return
     */
    public int updateMessageCategorySortTree(MessageCategoryVO messageCategoryVO);

    /**
     * 카테고리 삭제
     * @param messageCategorySeq
     * @return
     */
    public int deleteMessageCategory(MessageCategoryVO messageCategoryVO);

}
