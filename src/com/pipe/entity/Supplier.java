package com.pipe.entity;

public class Supplier {
	private String supplier_id;
	private String old_name;
	private String new_name;
	private String per_name;
	private String sup_tel;
	private String email;
	private String credit;
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getOld_name() {
		return old_name;
	}
	public void setOld_name(String old_name) {
		this.old_name = old_name;
	}
	public String getNew_name() {
		return new_name;
	}
	public void setNew_name(String new_name) {
		this.new_name = new_name;
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
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", oldname=" + old_name
				+ ", new_name=" + new_name + ", per_name=" + per_name
				+ ", sup_tel=" + sup_tel + ", email=" + email + ", credit="
				+ credit + "]";
	}
	
}
