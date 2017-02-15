package com.pipe.dao;

import java.util.List;
import java.util.Map;

import com.pipe.entity.CusExcDet;
import com.pipe.entity.Customer;
import com.pipe.entity.CustomerExcel;
import com.pipe.vo.CusExcelView;

public interface CustomerDAO {
	
	int insertCustomer(Customer customer);
	
	Integer getCustomerId(Map map);
	
	int insertCusExcel(CustomerExcel customerExcel);
	
	Integer getLastId(Map map);
	
	int insertCusExcDet(CusExcDet cusExcDet);
	
	List<CusExcDet> getCusExcDetById(Integer excel_id);
	
	int getTotalCusExc();
	
	List<CusExcelView> getAllCusExcel(Map map);
	//批量插入发送记录
	int insertSend(List<Map> lm);
}
