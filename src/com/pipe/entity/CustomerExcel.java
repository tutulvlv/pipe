package com.pipe.entity;

import java.sql.Timestamp;

public class CustomerExcel {
	private Integer cus_excel_id;
	private Integer customer_id;
	private Integer clerk_id;
	private String excel_name;
	private Timestamp upload_time;
	public Integer getCus_excel_id() {
		return cus_excel_id;
	}
	public void setCus_excel_id(Integer cus_excel_id) {
		this.cus_excel_id = cus_excel_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getExcel_name() {
		return excel_name;
	}
	public void setExcel_name(String excel_name) {
		this.excel_name = excel_name;
	}
	
	public Timestamp getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(Timestamp upload_time) {
		this.upload_time = upload_time;
	}
	
	public Integer getClerk_id() {
		return clerk_id;
	}
	public void setClerk_id(Integer clerk_id) {
		this.clerk_id = clerk_id;
	}
	@Override
	public String toString() {
		return "CustomerExcel [cus_excel_id=" + cus_excel_id + ", customer_id="
				+ customer_id + ", clerk_id=" + clerk_id + ", excel_name="
				+ excel_name + ", upload_time=" + upload_time + "]";
	}
	
}
