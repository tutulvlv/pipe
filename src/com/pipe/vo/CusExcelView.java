package com.pipe.vo;

import java.sql.Timestamp;

public class CusExcelView {
	private Integer cus_excel_id;
	private Integer customer_id;
	private String excel_name;
	private String customer_com;
	private Timestamp upload_time;
	private String clerkname;
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
	public String getCustomer_com() {
		return customer_com;
	}
	public void setCustomer_com(String customer_com) {
		this.customer_com = customer_com;
	}
	public Timestamp getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(Timestamp upload_time) {
		this.upload_time = upload_time;
	}
	public String getClerkname() {
		return clerkname;
	}
	public void setClerkname(String clerkname) {
		this.clerkname = clerkname;
	}
	@Override
	public String toString() {
		return "CusExcelList [cus_excel_id=" + cus_excel_id + ", customer_id="
				+ customer_id + ", excel_name=" + excel_name
				+ ", customer_com=" + customer_com + ", upload_time="
				+ upload_time + ", clerk_name=" + clerkname + "]";
	}
}
