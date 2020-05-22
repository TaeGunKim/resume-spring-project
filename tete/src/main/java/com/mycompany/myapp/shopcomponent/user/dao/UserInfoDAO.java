package com.mycompany.myapp.shopcomponent.user.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.component.login.vo.LoginSearchVO;
import com.mycompany.myapp.shopcomponent.user.vo.UserInfoVO;

@Repository(value="UserInfoDAO")
public interface UserInfoDAO extends Serializable {

	public UserInfoVO getUserInfo(LoginSearchVO loginSearchVO);

}
