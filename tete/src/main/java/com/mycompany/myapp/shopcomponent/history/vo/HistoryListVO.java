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
 * @date 2020. 5. 13. 오후 4:45:54
 * @description
 * </pre>
 */
@XmlRootElement(name = "HistoryListVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryListVO implements Serializable {

	private static final long serialVersionUID = 226782309917558625L;


	private List<HistoryVO> historyList;


	public List<HistoryVO> getHistoryList() {
		return historyList;
	}


	public void setHistoryList(List<HistoryVO> historyList) {
		this.historyList = historyList;
	}

}
