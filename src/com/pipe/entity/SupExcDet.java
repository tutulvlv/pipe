package com.pipe.entity;

public class SupExcDet {
	private Integer sup_exc_det_id;
	private Integer sup_excel_id;
	private String factory;
	private String retrievalmodel;
	private Integer quantity;
	private String batch;
	private Double price;
	public Integer getSup_exc_det_id() {
		return sup_exc_det_id;
	}
	public void setSup_exc_det_id(Integer sup_exc_det_id) {
		this.sup_exc_det_id = sup_exc_det_id;
	}
	public Integer getSup_excel_id() {
		return sup_excel_id;
	}
	public void setSup_excel_id(Integer sup_excel_id2) {
		this.sup_excel_id = sup_excel_id2;
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
		if(quantity==0){
			quantity=null;
		}
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		if(price==0){
			price=null;
		}
		this.price = price;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	@Override
	public String toString() {
		return "SupExcDet [sup_exc_det_id=" + sup_exc_det_id
				+ ", sup_excel_id=" + sup_excel_id + ", factory=" + factory
				+ ", retrievalmode=" + retrievalmodel + ", quantity=" + quantity
				+ ", batch=" + batch + ", price=" + price + "]";
	}
	
}
