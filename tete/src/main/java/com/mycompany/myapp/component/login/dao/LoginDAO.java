package com.mycompany.myapp.component.login.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.component.login.vo.LoginSearchVO;
import com.mycompany.myapp.component.login.vo.LoginVO;

@Repository(value="LoginDAO")
public interface LoginDAO extends Serializable {

	public LoginVO getUser(LoginSearchVO loginSearchVO);

}
