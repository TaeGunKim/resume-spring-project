package com.mycompany.myapp.common.component.oauth;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.user.dao.UserDAO;
import com.mycompany.myapp.shopcomponent.user.service.UserInfoService;
import com.mycompany.myapp.shopcomponent.user.vo.UserSearchVO;
import com.mycompany.myapp.shopcomponent.user.vo.UserVO;

@Service
public class Qauth2UserDetailsService implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(Qauth2UserDetailsService.class);


    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserDAO userDAO;


    public SecurityLoginVO loadUserByUsername(String username) throws UsernameNotFoundException {

    	System.out.println("username :: " +username);
    	System.out.println("username :: " +username);
    	System.out.println("username :: " +username);
    	System.out.println("username :: " +username);


    	LOG.debug("loadUserByUsername param username : {}", username);
    	if(username == null) {
	        throw new UsernameNotFoundException("username "+username+" not found");
	    }


    	/*
    	AccountSearchVO accountSearchVO = new AccountSearchVO();
	    accountSearchVO.setUsername(username);

	    // 회원정보 조회
	    AccountVO accountInfoVO = accountDAO.getAccount(accountSearchVO);
	    */


    	UserSearchVO userSearchVO = new UserSearchVO();
    	userSearchVO.setUsername(username);

	    // 회원정보 조회
    	UserVO userVO = userDAO.getUser(userSearchVO);

	    SecurityLoginVO securityLoginVO = new SecurityLoginVO();
	    if(userVO == null) {
	    	securityLoginVO.setMessage("아이디와 비밀번호를 다시 확인하십시요");
	    	return securityLoginVO;
	    }
	    securityLoginVO.setUsername(userVO.getId());


	    LOG.debug("loadUserByUsername param userid ===================: {}", userVO.getId());
        securityLoginVO.setPassword(userVO.getPasswd());
        securityLoginVO.setRole("ROLE_USER");

        userInfoService.trxLoginCheck(securityLoginVO);
        LOG.debug("securityLoginVO memssage : {} ", securityLoginVO.getMessage());



        LOG.debug("loadUserByUsername param password : {}", securityLoginVO.getPassword());
        return securityLoginVO;

    }
}
