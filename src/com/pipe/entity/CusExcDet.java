package com.pipe.entity;

public class CusExcDet {
	private Integer cus_exc_det_id;
	private Integer cus_excel_id;
	private String ic_name;
	private String factory;
	private String retrievalmodel;
	private Integer quantity;
	private String batch;
	public Integer getCus_exc_det_id() {
		return cus_exc_det_id;
	}
	public void setCus_exc_det_id(Integer cus_exc_det_id) {
		this.cus_exc_det_id = cus_exc_det_id;
	}
	public Integer getCus_excel_id() {
		return cus_excel_id;
	}
	public void setCus_excel_id(Integer cus_excel_id) {
		this.cus_excel_id = cus_excel_id;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getRetrievalmodel() {
		return retrievalmodel;
	}
	public void setRetrievalmodel(String retrievalmodel) {
		this.retrievalmodel = retrievalmodel;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getIc_name() {
		return ic_name;
	}
	public void setIc_name(String ic_name) {
		this.ic_name = ic_name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	@Override
	public String toString() {
		return "CusExcDet [cus_exc_det_id=" + cus_exc_det_id
				+ ", cus_excel_id=" + cus_excel_id + ", ic_name=" + ic_name
				+ ", factory=" + factory + ", retrievalmodel=" + retrievalmodel
				+ ", quantity=" + quantity + ", batch=" + batch + "]";
	}
	
}
