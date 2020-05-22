package com.mycompany.myapp.frontend.skills;

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

import com.mycompany.myapp.frontend.about.AboutController;
import com.mycompany.myapp.shopcomponent.about.vo.AboutVO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 18. 오후 3:10:13
 * @description
 * </pre>
 */
@Controller
public class SkillsController {
	private static final Logger LOG = LoggerFactory.getLogger(SkillsController.class);

	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/skills/skills")
	public ModelAndView skills(HttpServletRequest request, HttpServletResponse rsponse,Authentication authentication){
		LOG.debug("skills~~");

		Map<String, Object> model = new HashMap<String, Object>();


		MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

		return new ModelAndView("skills/skills", model);
	}
}
