package com.mycompany.myapp.shopcomponent.user.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.component.login.vo.LoginSearchVO;
import com.mycompany.myapp.component.login.vo.LoginVO;
import com.mycompany.myapp.shopcomponent.user.vo.UserSearchVO;
import com.mycompany.myapp.shopcomponent.user.vo.UserVO;

@Repository(value="UserDAO")
public interface UserDAO extends Serializable {

	public UserVO getUser(UserSearchVO userSearchVO);

}
