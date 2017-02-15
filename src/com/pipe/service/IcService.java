package com.pipe.service;

import java.util.List;
import java.util.Map;

import com.pipe.vo.IcView;
import com.pipe.vo.ViewHistory;

public interface IcService {
	List<IcView> getIcByModel(List<String> model);
	Map getViewHistory(String currentPage);
	Map getSendHistory(String currentPage);
}
