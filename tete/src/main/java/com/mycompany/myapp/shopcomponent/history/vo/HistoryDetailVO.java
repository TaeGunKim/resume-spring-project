package com.mycompany.myapp.shopcomponent.history.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:43:33
 * @description
 * </pre>
 */
@XmlRootElement(name = "HistoryDetailVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryDetailVO implements Serializable{

	private static final long serialVersionUID = 7120477360723267248L;

	@XmlElement(name = "id")
	private String id;

	@XmlElement(name = "history_id")
	private String history_id;

	@XmlElement(name = "company")
	private String company;

	@XmlElement(name = "orderer")
	private String orderer;

	@XmlElement(name = "project_nm")
	private String project_nm;

	@XmlElement(name = "site_nm")
	private String site_nm;

	@XmlElement(name = "site_img_1")
	private String site_img_1;

	@XmlElement(name = "site_img_2")
	private String site_img_2;

	@XmlElement(name = "site_img_3")
	private String site_img_3;

	@XmlElement(name = "site_img_4")
	private String site_img_4;

	@XmlElement(name = "startdate")
	private String startdate;

	@XmlElement(name = "enddate")
	private String enddate;

	@XmlElement(name = "status")
	private String status;

	@XmlElement(name = "worker_cnt")
	private String worker_cnt;

	@XmlElement(name = "language")
	private String language;

	@XmlElement(name = "tool")
	private String tool;

	@XmlElement(name = "part")
	private String part;

	@XmlElement(name = "create_date")
	private String create_date;

	@XmlElement(name = "update_date")
	private String update_date;

	@XmlElement(name = "del_yn")
	private String del_yn;

	private List<HistorySiteVO> historySiteList;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHistory_id() {
		return history_id;
	}
	public void setHistory_id(String history_id) {
		this.history_id = history_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getProject_nm() {
		return project_nm;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public String getSite_nm() {
		return site_nm;
	}
	public void setSite_nm(String site_nm) {
		this.site_nm = site_nm;
	}
	public String getSite_img_1() {
		return site_img_1;
	}
	public void setSite_img_1(String site_img_1) {
		this.site_img_1 = site_img_1;
	}
	public String getSite_img_2() {
		return site_img_2;
	}
	public void setSite_img_2(String site_img_2) {
		this.site_img_2 = site_img_2;
	}
	public String getSite_img_3() {
		return site_img_3;
	}
	public void setSite_img_3(String site_img_3) {
		this.site_img_3 = site_img_3;
	}
	public String getSite_img_4() {
		return site_img_4;
	}
	public void setSite_img_4(String site_img_4) {
		this.site_img_4 = site_img_4;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWorker_cnt() {
		return worker_cnt;
	}
	public void setWorker_cnt(String worker_cnt) {
		this.worker_cnt = worker_cnt;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public List<HistorySiteVO> getHistorySiteList() {
		return historySiteList;
	}
	public void setHistorySiteList(List<HistorySiteVO> historySiteList) {
		this.historySiteList = historySiteList;
	}



}
