package com.mycompany.myapp.shopcomponent.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.shopcomponent.menu.dao.MenuDAO;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:43:12
 * @description
 * </pre>
 */
@Service
public class MenuService {

	private static final Logger LOG  = LoggerFactory.getLogger(MenuService.class);

	@Resource
	private MenuDAO menuDAO;

	public MenuListVO getUseMenu(){

		LOG.debug("invoked 'getUseMenu' method...");

		MenuListVO menuListVO = new MenuListVO();
		List<MenuVO> menuList = menuDAO.getUseMenu();
		menuListVO.setMenuList(menuList);

		return menuListVO;
	}
}
