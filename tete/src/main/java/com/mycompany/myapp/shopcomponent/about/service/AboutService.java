package com.mycompany.myapp.shopcomponent.about.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.shopcomponent.about.dao.AboutDAO;
import com.mycompany.myapp.shopcomponent.about.vo.AboutVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:46:33
 * @description
 * </pre>
 */
@Service
public class AboutService {

	private static final Logger LOG  = LoggerFactory.getLogger(AboutService.class);

	@Resource
	private AboutDAO aboutDAO;

	public AboutVO getAbout() {
		return aboutDAO.getAbout();
	}

}
