package com.mycompany.myapp.shopcomponent.user.vo;

import java.io.Serializable;

public class UserSearchVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6178350265339157102L;

	private String username;

	private String passwd;

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
