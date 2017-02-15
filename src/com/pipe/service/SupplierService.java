package com.pipe.service;

import java.util.List;

import com.pipe.entity.SupExcDet;
import com.pipe.entity.Supplier;
import com.pipe.entity.SupplierExcel;
import com.pipe.vo.SupExcDetView;
import com.pipe.vo.SupQuoDetView;


public interface SupplierService {
	int insertSupplier(Supplier supplier);
	
	Integer getSupplierId(Supplier supplier);
	
	int insertCusExcel(SupplierExcel supplierExcel,List<SupExcDet> supExcDetList);

	List<SupExcDetView> getSupExcDetView(String cus_excel_id);
	
	List<SupQuoDetView> getSupQuoteDetByModel(String retrievalmodel);
	
	int insertVictor(String uuid);
}
