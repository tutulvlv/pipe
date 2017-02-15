package com.pipe.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pipe.dao.IcDAO;
import com.pipe.service.IcService;
import com.pipe.utils.Paging;
import com.pipe.vo.IcView;
import com.pipe.vo.ViewHistory;
@Service
public class IcServiceImpl implements IcService {
	@Resource
	private IcDAO icDAO;
	@Override
	public List<IcView> getIcByModel(List<String> model) {
		return icDAO.getIcByModel(model);
	}
	@Override
	public Map getViewHistory(String currentPage) {
		if(currentPage==null){
			currentPage="1";
		}
		int total=icDAO.getTotalViewHistory();
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		Map map=new HashMap();
		map.put("start", pager.getStart());
		map.put("pageSize",pager.getPageSize());
		Map remap=new HashMap();
		remap.put("pager", pager);
		remap.put("viewHistoryList", icDAO.getViewHistory(map));
		return remap;
	}
	@Override
	public Map getSendHistory(String currentPage) {
		if(currentPage==null){
			currentPage="1";
		}
		int total=icDAO.getTotalSendHistory();
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		Map map=new HashMap();
		map.put("start", pager.getStart());
		map.put("pageSize",pager.getPageSize());
		Map remap=new HashMap();
		remap.put("pager", pager);
		remap.put("sendHistoryList", icDAO.getSendHistory(map));
		return remap;
	}
	
}
