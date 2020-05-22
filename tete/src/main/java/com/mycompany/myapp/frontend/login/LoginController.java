package com.mycompany.myapp.frontend.login;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;
import com.mycompany.myapp.shopcomponent.user.service.UserInfoService;

import jxl.read.biff.PasswordException;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private UserInfoService loginService;

	@Resource
	private MenuService menuService;


    @RequestMapping(value = "/login/loginForm")
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws Exception {

    	LOG.debug("loginForm.do ~~");
    	Map<String, Object> model = new HashMap<String, Object>();

    	MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

        return new ModelAndView("login/loginForm", model);

	}

    @RequestMapping(value = "/login/loginFaile")
    public ModelAndView loginFaile(HttpServletRequest request, HttpServletResponse response, Authentication authentication, SecurityLoginVO securityLoginVO) throws Exception {

    	LOG.debug("loginFaile.do ~~");
    	Map<String, Object> model = new HashMap<String, Object>();

    	MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

        return new ModelAndView("login/loginFaile", model);

	}

    @RequestMapping(value = "/login/loginOk")
    public ModelAndView loginOk(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws Exception {
        LOG.debug("loginOk.do ~~");

        Map<String, Object> model = new HashMap<String, Object>();

        MenuListVO menuList = menuService.getUseMenu();
		model.put("menuList", menuList);

        return new ModelAndView("login/loginOk", model);
    }

}
