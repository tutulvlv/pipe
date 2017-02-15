package com.pipe.vo;

import java.sql.Timestamp;

public class SendHistory {
	private String excel_name;
	private Timestamp upload_time;
	private String businname;
	private String mobnum;
	private String address;
	private String qq;
	public Timestamp getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(Timestamp upload_time) {
		this.upload_time = upload_time;
	}
	public String getBusinname() {
		return businname;
	}
	public void setBusinname(String businname) {
		this.businname = businname;
	}
	public String getMobnum() {
		return mobnum;
	}
	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getExcel_name() {
		return excel_name;
	}
	public void setExcel_name(String excel_name) {
		this.excel_name = excel_name;
	}

}
