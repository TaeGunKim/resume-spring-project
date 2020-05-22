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
@XmlRootElement(name = "HistorySearchVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistorySearchVO implements Serializable{

	private static final long serialVersionUID = 7120477360723267248L;

	@XmlElement(name = "type")
	private String type;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}






}
