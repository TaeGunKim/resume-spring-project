package com.mycompany.myapp.shopcomponent.history.vo;

import java.io.Serializable;

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
@XmlRootElement(name = "HistoryVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryVO implements Serializable{

	private static final long serialVersionUID = 7120477360723267248L;

	@XmlElement(name = "id")
	private String id;

	@XmlElement(name = "type")
	private String type;

	@XmlElement(name = "title")
	private String title;

	@XmlElement(name = "subtitle")
	private String subtitle;

	@XmlElement(name = "startdate")
	private String startdate;

	@XmlElement(name = "enddate")
	private String enddate;

	@XmlElement(name = "status")
	private String status;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "link")
	private String link;

	@XmlElement(name = "create_date")
	private String create_date;


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
