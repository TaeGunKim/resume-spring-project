package com.mycompany.myapp.shopcomponent.history.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.shopcomponent.history.vo.HistorySearchVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistoryVO;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:46:05
 * @description
 * </pre>
 */
@Repository(value="HistoryDAO")
public interface HistoryDAO extends Serializable {

	List<HistoryVO> getHistoryList(HistorySearchVO historySearchVO);

}
