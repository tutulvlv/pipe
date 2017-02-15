package com.pipe.action;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pipe.entity.CusExcDet;
import com.pipe.entity.SupExcDet;
import com.pipe.entity.Supplier;
import com.pipe.entity.SupplierExcel;
import com.pipe.service.CustomerService;
import com.pipe.service.SupplierService;
import com.pipe.utils.GenerateExcel;
import com.pipe.vo.SupExcDetView;
import com.pipe.vo.SupQuoDetView;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Resource
	private CustomerService customerService;
	@Resource
	private SupplierService supplierService;

	//显示未报价的BOM表
	@RequestMapping("/showCusExcDet")
	public String showCusExcDet(HttpServletRequest request){
		String excel_id=request.getParameter("excel_id");
		String uuid=request.getParameter("uuid");
		supplierService.insertVictor(uuid);
		List<CusExcDet> cusExcDetList = customerService.getCusExcDetById(excel_id);
		request.setAttribute("cusExcDetList", cusExcDetList);
		return "quote_bom";
	}
	@RequestMapping("/quoteBom")
	@ResponseBody
	public String quoteBom(HttpServletRequest request,SupplierExcel supplierExcel,Supplier supplier){
		Integer supplierId = supplierService.getSupplierId(supplier);
		if(supplierId==null){
			supplierService.insertSupplier(supplier);
			supplierId = supplierService.getSupplierId(supplier);
		}
		String json = request.getParameter("json");
		List<SupExcDet> sed = JSONObject.parseArray(json,SupExcDet.class);
		String sup_excel_name=UUID.randomUUID()+"";
		supplierExcel.setSup_excel_name(sup_excel_name);
		supplierExcel.setSupplier_id(supplierId);
		supplierService.insertCusExcel(supplierExcel, sed);
		GenerateExcel.createExcelFile(sed,sup_excel_name);
		return "quote_success";
	}
	@RequestMapping("/showQuote")
	public String showQuote(HttpServletRequest request){
		String cus_excel_id=request.getParameter("cus_excel_id");
		String customer_com=request.getParameter("customer_com");
		String clerkname=request.getParameter("clerkname");
		List<SupExcDetView> excDetView = supplierService.getSupExcDetView(cus_excel_id);
		request.setAttribute("excDetView", excDetView);
		request.getSession().setAttribute("customer_com", customer_com);
		request.getSession().setAttribute("clerkname", clerkname);
		return "cus_key_list";
	}
	@RequestMapping("/showModelQuote")
	public String showModelQuote(HttpServletRequest request){
		String factory=request.getParameter("factory");
		String retrievalmodel=request.getParameter("retrievalmodel");
		String batch=request.getParameter("batch");
		String quantity=request.getParameter("quantity");
		List<SupQuoDetView> supQuoteDet = supplierService.getSupQuoteDetByModel(retrievalmodel);
		request.setAttribute("supQuoteDet", supQuoteDet);
		request.setAttribute("retrievalmodel", retrievalmodel);
		request.setAttribute("factory", factory);
		request.setAttribute("batch", batch);
		request.setAttribute("quantity", quantity);
		return "cus_key_price_list";
	}
}
