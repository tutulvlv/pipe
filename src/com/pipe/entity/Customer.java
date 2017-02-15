package com.pipe.entity;

public class Customer {
	private Integer customer_id;
	private String customer_com;
	private String customer_name;
	private String customer_tel;
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_com() {
		return customer_com;
	}
	public void setCustomer_com(String customer_com) {
		this.customer_com = customer_com;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_com="
				+ customer_com + ", customer_name=" + customer_name
				+ ", customer_tel=" + customer_tel + "]";
	}
	
}
