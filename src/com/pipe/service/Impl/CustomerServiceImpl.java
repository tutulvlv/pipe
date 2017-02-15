package com.pipe.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pipe.dao.CustomerDAO;
import com.pipe.entity.CusExcDet;
import com.pipe.entity.Customer;
import com.pipe.entity.CustomerExcel;
import com.pipe.service.CustomerService;
import com.pipe.utils.Paging;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Resource
	private CustomerDAO customerDAO;

	@Override
	public int insertCustomer(Customer customer) {
		return customerDAO.insertCustomer(customer);
	}

	@Override
	public int insertCusExcel(CustomerExcel customerExcel,List<CusExcDet> cusExcDetList) {
		Timestamp ts=new Timestamp(new Date().getTime());
		customerExcel.setUpload_time(ts);
		System.out.println(customerExcel);
		customerDAO.insertCusExcel(customerExcel);
		Map map=new HashMap();
		map.put("upload_time", ts);
		map.put("excel_name", customerExcel.getExcel_name());
		int cus_excel_id=customerDAO.getLastId(map);
		for (CusExcDet cusExcDet : cusExcDetList) {
			cusExcDet.setCus_excel_id(cus_excel_id);
			customerDAO.insertCusExcDet(cusExcDet);
		}
		return cus_excel_id;
	}

	@Override
	public List<CusExcDet> getCusExcDetById(String excel_id) {
		return customerDAO.getCusExcDetById(Integer.valueOf(excel_id));
	}

	@Override
	public Integer getCustomerId(Customer customer) {
		Map map=new HashMap();
		map.put("customer_name", customer.getCustomer_name());
		map.put("customer_tel", customer.getCustomer_tel());
		return customerDAO.getCustomerId(map);
	}
	
	@Override
	public Map getAllCusExcel(String currentPage) {
		if(currentPage==null){
			currentPage="1";
		}
		int total=customerDAO.getTotalCusExc();
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		Map map=new HashMap();
		map.put("start", (Integer.valueOf(currentPage)-1)*pager.getPageSize());
		map.put("pageSize", pager.getPageSize());
		Map remap=new HashMap();
		remap.put("pager", pager);
		remap.put("cusExcList", customerDAO.getAllCusExcel(map));
		return remap;
	}

	@Override
	public int insertSend(List<Map> lm) {
		return customerDAO.insertSend(lm);
	}
}
