package com.pipe.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pipe.dao.SupplierDAO;
import com.pipe.entity.CusExcDet;
import com.pipe.entity.SupExcDet;
import com.pipe.entity.Supplier;
import com.pipe.entity.SupplierExcel;
import com.pipe.service.SupplierService;
import com.pipe.vo.SupExcDetView;
import com.pipe.vo.SupQuoDetView;
@Service
public class SupplierServiceImpl implements SupplierService {
	@Resource
	private SupplierDAO supplierDAO;
	@Override
	public int insertSupplier(Supplier supplier) {
		return supplierDAO.insertSupplier(supplier);
	}

	@Override
	public int insertCusExcel(SupplierExcel supplierExcel,
			List<SupExcDet> supExcDetList) {
		Timestamp ts=new Timestamp(new Date().getTime());
		supplierExcel.setQuote_time(ts);
		supplierDAO.insertSupExcel(supplierExcel);
		Map map=new HashMap();
		map.put("quote_time", ts);
		map.put("sup_excel_name", supplierExcel.getSup_excel_name());
		int sup_excel_id=supplierDAO.getLastId(map);
		for (SupExcDet supExcDet : supExcDetList) {
			supExcDet.setSup_excel_id(sup_excel_id);
			supplierDAO.insertSupExcDet(supExcDet);
		}
		return 0;
	}

	@Override
	public Integer getSupplierId(Supplier supplier) {
		Map map = new HashMap();
		map.put("per_name", supplier.getPer_name());
		map.put("sup_tel", supplier.getSup_tel());
		System.out.println(map);
		return supplierDAO.getSupplierId(supplier);
	}
	
	@Override
	public List<SupExcDetView> getSupExcDetView(String cus_excel_id) {
		return supplierDAO.getSupExcDetView(Integer.valueOf(cus_excel_id));
	}

	@Override
	public List<SupQuoDetView> getSupQuoteDetByModel(String retrievalmodel) {
		return supplierDAO.getSupQuoteDetByModel(retrievalmodel);
	}

	@Override
	public int insertVictor(String uuid) {
		return supplierDAO.insertVictor(uuid);
	}
}
