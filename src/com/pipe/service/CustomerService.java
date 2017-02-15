package com.pipe.service;

import java.util.List;
import java.util.Map;

import com.pipe.entity.CusExcDet;
import com.pipe.entity.Customer;
import com.pipe.entity.CustomerExcel;

public interface CustomerService {
	int insertCustomer(Customer customer);
	
	Integer getCustomerId(Customer customer);
	
	int insertCusExcel(CustomerExcel customerExcel,List<CusExcDet> cusExcDetList);
	
	List<CusExcDet> getCusExcDetById(String excel_id);

	Map getAllCusExcel(String currentPage);
	//批量插入发送记录
	int insertSend(List<Map> lm);
}
