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

import com.mycompany.myapp.shopcomponent.bbs.vo.MessageAddProdVO;

@Repository(value="MessageAddProdDAO")
public interface MessageAddProdDAO extends Serializable {


    /**
     * 파일 검색 타입 리스트
     * @param messageSeq
     * @return
     */
    public List<MessageAddProdVO> getMessageAddProd(String messageSeq);


}
