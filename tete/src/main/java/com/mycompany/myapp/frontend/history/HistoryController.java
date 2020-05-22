package com.mycompany.myapp.frontend.history;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.frontend.main.MainController;
import com.mycompany.myapp.shopcomponent.history.service.HistoryService;
import com.mycompany.myapp.shopcomponent.history.vo.HistoryListVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistorySearchVO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 18. 오후 3:08:07
 * @description
 * </pre>
 */
@Controller
public class HistoryController {
	private static final Logger LOG = LoggerFactory.getLogger(HistoryController.class);

	@Resource
	private HistoryService historyService;

	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/history/historyList")
	public ModelAndView historyList(HttpServletRequest request, HttpServletResponse rsponse,Authentication authentication,HistorySearchVO historySearchVO){
		LOG.debug("historyList~~");

		Map<String, Object> model = new HashMap<String, Object>();

		HistoryListVO historyList = historyService.getHistoryList(historySearchVO);
		model.put("historyList", historyList);

		MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

		return new ModelAndView("history/historyList", model);
	}
}
