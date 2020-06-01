package com.mycompany.myapp.shopcomponent.history.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.shopcomponent.history.dao.HistoryDAO;
import com.mycompany.myapp.shopcomponent.history.vo.HistoryDetailVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistoryListVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistorySearchVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistorySiteVO;
import com.mycompany.myapp.shopcomponent.history.vo.HistoryVO;
import com.mycompany.myapp.shopcomponent.menu.dao.MenuDAO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 13. 오후 4:46:00
 * @description
 * </pre>
 */
@Service
public class HistoryService {

	private static final Logger LOG  = LoggerFactory.getLogger(HistoryService.class);

	@Resource
	private HistoryDAO historyDAO;

	public HistoryListVO getHistoryList(HistorySearchVO historySearchVO) {

		LOG.debug("invoked 'getHistoryList' method...");

		if(historySearchVO.getType() == null) {
			historySearchVO.setType("C");
		}

		HistoryListVO historyListVO = new HistoryListVO();
		List<HistoryVO> historyList = historyDAO.getHistoryList(historySearchVO);
		historyListVO.setHistoryList(historyList);

		return historyListVO;
	}

	public HistoryListVO getHistoryDetailList(HistoryVO historyVO) {

		LOG.debug("invoked 'getHistoryDetailList' method...");

		if(historyVO.getId() == null || "".equals(historyVO.getId())) {
			return null;
		}
		HistoryListVO historyDetailListVO = new HistoryListVO();

		List<HistoryDetailVO> historyDetailList = historyDAO.getHistoryDetailList(historyVO);

		for(int i=0; i<historyDetailList.size();i++) {
			HistorySiteVO historySiteVO = new HistorySiteVO();

			System.out.println("id :: " +historyDetailList.get(i).getId());
			System.out.println("history_id :: " +historyDetailList.get(i).getHistory_id());

			historySiteVO.setDetail_id(historyDetailList.get(i).getId());
			historySiteVO.setHistory_id(historyDetailList.get(i).getHistory_id());
			List<HistorySiteVO> historySiteList = historyDAO.getHistorySiteList(historySiteVO);
			historyDetailList.get(i).setHistorySiteList(historySiteList);
		}
		historyDetailListVO.setHistoryDetailList(historyDetailList);

		return historyDetailListVO;
	}

	public HistoryVO getHistory(HistoryVO historyVO) {

		LOG.debug("invoked 'getHistory' method...");

		return  historyDAO.getHistory(historyVO);
	}

}
