package com.pipe.vo;

import java.sql.Timestamp;

public class ViewHistory {
	private String excel_name;
	private Timestamp time;
	private String Businname;
	private String retrievalmodel;
	private String mobnum;
	private String address;
	private String factory;
	private String qq;
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getBusinname() {
		return Businname;
	}
	public void setBusinname(String businname) {
		Businname = businname;
	}
	public String getRetrievalmodel() {
		return retrievalmodel;
	}
	public void setRetrievalmodel(String retrievalmodel) {
		this.retrievalmodel = retrievalmodel;
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
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Override
	public String toString() {
		return "ViewHistory [time=" + time + ", Businname=" + Businname
				+ ", retrievalmodel=" + retrievalmodel + ", mobnum=" + mobnum
				+ ", address=" + address + ", factory=" + factory + ", qq="
				+ qq + "]";
	}
	public String getExcel_name() {
		return excel_name;
	}
	public void setExcel_name(String excel_name) {
		this.excel_name = excel_name;
	}
}
