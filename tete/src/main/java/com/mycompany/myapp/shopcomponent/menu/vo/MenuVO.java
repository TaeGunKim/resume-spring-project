package com.mycompany.myapp.shopcomponent.menu.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:42:56
 * @description
 * </pre>
 */
@XmlRootElement(name = "HistoryListVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuVO implements Serializable {

	private static final long serialVersionUID = -8892585942961349415L;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "url")
	private String url;

	@XmlElement(name = "tree_cd")
	private String tree_cd;

	@XmlElement(name = "useyn")
	private String useyn;

	@XmlElement(name = "memo")
	private String memo;

	@XmlElement(name = "create_id")
	private String create_id;

	@XmlElement(name = "create_date")
	private String create_date;

	@XmlElement(name = "lvl")
	private String lvl;



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTree_cd() {
		return tree_cd;
	}
	public void setTree_cd(String tree_cd) {
		this.tree_cd = tree_cd;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}




}
