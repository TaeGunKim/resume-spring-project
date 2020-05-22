package com.mycompany.myapp.shopcomponent.user.vo;

import java.io.Serializable;

public class UserVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6178350265339157102L;

	private String id;

	private String passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



}
