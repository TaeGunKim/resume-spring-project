package com.mycompany.myapp.common.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.vo.SecurityUserVO;
import com.mycompany.myapp.component.login.vo.SecurityLoginVO;



public class AuthenticationUtil {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationUtil.class);

    private static final Logger LOG_ERROR = LoggerFactory.getLogger(Constants.ERROR_LOGGER);


    public static SecurityUserVO getSecurityUser() {

        SecurityUserVO securityUserVO = new SecurityUserVO();
        try {
            SecurityLoginVO securityLoginVO = getSecurityLogin();

            BeanUtils.copyProperties(securityUserVO , securityLoginVO);
            if(StringUtils.isEmpty(securityUserVO.getPicFileName())){
                securityUserVO.setPicFileName("not");
            }

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        	LOG_ERROR.error("AuthenticationUtil.getSecurityUser : 셰션만료 :: ");
        }

        return securityUserVO;

    }

    public static SecurityLoginVO getSecurityLogin() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityLoginVO securityLoginVO = null;
//        LOG.debug("isAuthenticated => {}",authentication.isAuthenticated());
//        LOG.debug("getAuthorities => {}",authentication.getAuthorities());
//        LOG.debug("getCredentials => {}",authentication.getCredentials());
//        LOG.debug("getDetails => {}",authentication.getDetails());
//        LOG.debug("getName => {}",authentication.getName());

        if (authentication != null) {
            Object principal  = authentication.getPrincipal();
            if (principal  instanceof SecurityLoginVO) {
                securityLoginVO = (SecurityLoginVO) principal;
            }
        }


        return securityLoginVO;

    }



}
