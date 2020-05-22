package com.mycompany.myapp.frontend.main;

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

import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;


@Controller
public class MainController {
	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@Resource
	private MenuService menuService;


	@RequestMapping(value = "/main")
	public ModelAndView mainhome(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		LOG.debug("mainhome~~");

		Map<String, Object> model = new HashMap<String, Object>();

		MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

		return new ModelAndView("main/main", model);

	}
}
