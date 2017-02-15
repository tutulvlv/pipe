package com.pipe.entity;

import java.sql.Timestamp;

public class SupplierExcel {
	private Integer sup_excel_id;
	private Integer cus_excel_id;
	private String sup_excel_name;
	private Integer supplier_id;
	private Timestamp quote_time;
	private String total_price;
	public Integer getSup_excel_id() {
		return sup_excel_id;
	}
	public void setSup_excel_id(Integer sup_excel_id) {
		this.sup_excel_id = sup_excel_id;
	}
	public Integer getCus_excel_id() {
		return cus_excel_id;
	}
	public void setCus_excel_id(Integer cus_excel_id) {
		this.cus_excel_id = cus_excel_id;
	}
	public String getSup_excel_name() {
		return sup_excel_name;
	}
	public void setSup_excel_name(String sup_excel_name) {
		this.sup_excel_name = sup_excel_name;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Timestamp getQuote_time() {
		return quote_time;
	}
	public void setQuote_time(Timestamp quote_time) {
		this.quote_time = quote_time;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "SupplierExcel [sup_excel_id=" + sup_excel_id
				+ ", cus_excel_id=" + cus_excel_id + ", sup_excel_name="
				+ sup_excel_name + ", supplier_id=" + supplier_id
				+ ", quote_time=" + quote_time + ", total_price=" + total_price
				+ "]";
	}
	
}
