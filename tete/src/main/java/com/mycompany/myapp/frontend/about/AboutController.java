package com.mycompany.myapp.frontend.about;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.component.base.BaseController;
import com.mycompany.myapp.shopcomponent.about.service.AboutService;
import com.mycompany.myapp.shopcomponent.about.vo.AboutVO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 18. 오후 3:08:18
 * @description
 * </pre>
 */
@Controller
public class AboutController extends BaseController{
	private static final Logger LOG = LoggerFactory.getLogger(AboutController.class);

	@Resource
	private AboutService aboutService;

	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/about/about")
	public ModelAndView about(HttpServletRequest request, HttpServletResponse rsponse,Authentication authentication, AboutVO testVO){
		LOG.debug("about~~");

		Map<String, Object> model = new HashMap<String, Object>();

		AboutVO about = aboutService.getAbout();
		model.put("about", about);

		MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

		return new ModelAndView("about/about", model);
	}
	@RequestMapping(value = "/about/aboutJobtest")
	public ModelAndView aboutJobtest(HttpServletRequest request, HttpServletResponse rsponse,Authentication authentication, AboutVO testVO){
		LOG.debug("aboutJobtest~~");

		Map<String, Object> model = new HashMap<String, Object>();

		AboutVO about = aboutService.getAbout();
		model.put("about", about);

		MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

		return new ModelAndView("about/aboutJobtest", model);
	}

	@RequestMapping(value = "/about/aboutInsert.json", method = RequestMethod.POST)
	public ModelAndView aboutInsertJson(AboutVO aboutVO) {
		System.out.println("hello world~");

		int status = 0 ;
		ModelAndView mav = new ModelAndView();


		System.out.println("name :: " + aboutVO.getName());
		System.out.println("email :: " + aboutVO.getEmail());
		System.out.println("job :: " + aboutVO.getJob());

		mav.addObject("status",status);

		return mav;
	}
}
