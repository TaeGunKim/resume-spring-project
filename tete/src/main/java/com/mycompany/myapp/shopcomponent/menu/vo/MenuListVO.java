package com.mycompany.myapp.shopcomponent.menu.vo;

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
 * @date 2020. 5. 18. 오후 2:08:37
 * @description
 * </pre>
 */
@XmlRootElement(name = "menuList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4898250303513823157L;


	@XmlElement(name = "menuList")
	private List<MenuVO> menuList;

	public List<MenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}

}
