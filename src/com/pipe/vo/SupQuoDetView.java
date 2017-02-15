package com.pipe.vo;

import java.sql.Timestamp;

public class SupQuoDetView {
	private Double price;
	private Timestamp quote_time;
	private String new_name;
	private String per_name;
	private String sup_tel;
	private String email;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Timestamp getQuote_time() {
		return quote_time;
	}
	public void setQuote_time(Timestamp quote_time) {
		this.quote_time = quote_time;
	}
	public String getNew_name() {
		return new_name;
	}
	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public String getSup_tel() {
		return sup_tel;
	}
	public void setSup_tel(String sup_tel) {
		this.sup_tel = sup_tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SupQouteDet [price=" + price + ", quote_time=" + quote_time
				+ ", new_name=" + new_name + ", per_name=" + per_name
				+ ", sup_tel=" + sup_tel + ", email=" + email + "]";
	}
	
}
