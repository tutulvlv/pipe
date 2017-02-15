package com.pipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pipe.entity.SupExcDet;
import com.pipe.entity.Supplier;
import com.pipe.entity.SupplierExcel;
import com.pipe.vo.SupExcDetView;
import com.pipe.vo.SupQuoDetView;


public interface SupplierDAO {
	int insertSupplier(Supplier supplier);
	
	Integer getSupplierId(Supplier supplier);
	
	int insertSupExcel(SupplierExcel supplierExcel);
	
	Integer getLastId(Map map);
	
	int insertSupExcDet(SupExcDet supExcDet);
	
	List<SupExcDetView> getSupExcDetView(Integer cus_excel_id);
	
	List<SupQuoDetView> getSupQuoteDetByModel(String retrievalmodel);
	
	int insertVictor(String uuid);
}
