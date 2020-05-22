package com.mycompany.myapp.shopcomponent.about.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.about.vo.AboutVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:46:39
 * @description
 * </pre>
 */
@Repository(value="AboutDAO")
public interface AboutDAO extends Serializable {

	AboutVO getAbout();

}
