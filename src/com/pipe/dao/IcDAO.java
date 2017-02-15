package com.pipe.dao;

import java.util.List;
import java.util.Map;

import com.pipe.vo.IcView;
import com.pipe.vo.SendHistory;
import com.pipe.vo.ViewHistory;

public interface IcDAO {
	List<IcView> getIcByModel(List<String> model);
	List<ViewHistory> getViewHistory(Map map);
	int getTotalViewHistory();
	List<SendHistory> getSendHistory(Map map);
	int getTotalSendHistory();
}
