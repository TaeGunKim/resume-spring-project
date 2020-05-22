package com.mycompany.myapp.shopcomponent.about.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:46:14
 * @description
 * </pre>
 */
@XmlRootElement(name = "about")
@XmlAccessorType(XmlAccessType.FIELD)
public class AboutVO implements Serializable{

	private static final long serialVersionUID = -6256031428316996121L;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "job")
	private String job;

	@XmlElement(name = "intro")
	private String intro;

	@XmlElement(name = "birth")
	private String birth;

	@XmlElement(name = "mtel")
	private String mtel;

	@XmlElement(name = "email")
	private String email;

	@XmlElement(name = "residence")
	private String residence;

	@XmlElement(name = "sns1")
	private String sns1;

	@XmlElement(name = "sns2")
	private String sns2;

	@XmlElement(name = "about")
	private String about;

	@XmlElement(name = "create_id")
	private String create_id;

	@XmlElement(name = "create_date")
	private String create_date;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getSns1() {
		return sns1;
	}
	public void setSns1(String sns1) {
		this.sns1 = sns1;
	}
	public String getSns2() {
		return sns2;
	}
	public void setSns2(String sns2) {
		this.sns2 = sns2;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
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



}
