/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * 영수        2016. 10. 2.   초기작성
 * </pre>
 *
 * @title
 * @packgename com.mycompany.myapp.common.vo
 * @filename SecurityUserVO.java
 * author 영수
 * version 1.0, 2016. 10. 2. 초기작성
* see None
 */
package com.mycompany.myapp.common.vo;

import java.io.Serializable;

public class SecurityUserVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6415777555951972388L;

    /**
     * username
     */
    private String username;


    /**
     * Erp 연동 MCode
     */
    private String erpMcode;

    /**
     * 유저명
     */
    private String userNm;


    /**
     * 권한코드 : A : 연합회관리자,  H : 연합회직원, C : 법인, S : 매장직원
     */
    private String userClsCd;

    /**
     * 매장코드
     */
    private String shopCd;

    /**
     * 매장명
     */
    private String shopNm;

    /**
     * 그룹명
     */
    private String groupCd;

    /**
     * 사진
     */
    private String picFileName;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the erpMcode
	 */
	public String getErpMcode() {
		return erpMcode;
	}

	/**
	 * @param erpMcode the erpMcode to set
	 */
	public void setErpMcode(String erpMcode) {
		this.erpMcode = erpMcode;
	}

	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}

	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	/**
	 * @return the userClsCd
	 */
	public String getUserClsCd() {
		return userClsCd;
	}

	/**
	 * @param userClsCd the userClsCd to set
	 */
	public void setUserClsCd(String userClsCd) {
		this.userClsCd = userClsCd;
	}

	/**
	 * @return the shopCd
	 */
	public String getShopCd() {
		return shopCd;
	}

	/**
	 * @param shopCd the shopCd to set
	 */
	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	/**
	 * @return the shopNm
	 */
	public String getShopNm() {
		return shopNm;
	}

	/**
	 * @param shopNm the shopNm to set
	 */
	public void setShopNm(String shopNm) {
		this.shopNm = shopNm;
	}

	/**
	 * @return the groupCd
	 */
	public String getGroupCd() {
		return groupCd;
	}

	/**
	 * @param groupCd the groupCd to set
	 */
	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	/**
	 * @return the picFileName
	 */
	public String getPicFileName() {
		return picFileName;
	}

	/**
	 * @param picFileName the picFileName to set
	 */
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

}
