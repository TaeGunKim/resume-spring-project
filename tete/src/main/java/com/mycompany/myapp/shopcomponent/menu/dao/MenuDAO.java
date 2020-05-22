package com.mycompany.myapp.shopcomponent.menu.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.menu.vo.MenuVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:43:18
 * @description
 * </pre>
 */
@Repository(value="MenuDAO")
public interface MenuDAO extends Serializable {

	public List<MenuVO> getUseMenu();

}
