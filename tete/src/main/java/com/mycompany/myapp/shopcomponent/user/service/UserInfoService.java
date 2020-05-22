/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * 영수      2016. 11. 18.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.pama.app.shopcomponent.login.service
 * @filename LoginService.java
 * @author 영수
 * @version 1.0, 2016. 11. 18. 초기작성
 * @see None
 */
package com.mycompany.myapp.shopcomponent.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.component.login.vo.LoginSearchVO;
import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.user.dao.UserInfoDAO;
import com.mycompany.myapp.shopcomponent.user.vo.UserInfoVO;


@Service
public class UserInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(UserInfoService.class);

    @Resource
    private UserInfoDAO userInfoDAO;

    public SecurityLoginVO trxLoginCheck(SecurityLoginVO securityLoginVO) {

        LOG.debug("trxLoginCheck stSart ~~");

        LoginSearchVO loginSearchVO= new LoginSearchVO();
        loginSearchVO.setUsername(securityLoginVO.getUsername());

        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO = userInfoDAO.getUserInfo(loginSearchVO);

        if(userInfoVO == null) {
        	securityLoginVO.setRcode("-9");
        	securityLoginVO.setMessage("등록되지 않은 사용자 입니다.");
        }
        securityLoginVO.setRcode("1");
        securityLoginVO.setName(userInfoVO.getName());
        securityLoginVO.setMemo(userInfoVO.getMemo());
        securityLoginVO.setmTel(userInfoVO.getmTel());
        securityLoginVO.setBirthDate(userInfoVO.getBirthDate());
        securityLoginVO.setCreateDate(userInfoVO.getCreateDate());

        return securityLoginVO;
    }


}
