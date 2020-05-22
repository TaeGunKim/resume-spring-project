package com.mycompany.myapp.shopcomponent.user.vo;

import java.io.Serializable;

public class UserInfoVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6178350265339157102L;

	private String id;

	private String name;

	private String mTel;

	private String memo;

	private String birthDate;

	private String createDate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}






}
