package com.pipe.vo;

import java.sql.Timestamp;

public class SupExcDetView {
	private String factory;
	private String retrievalmodel;
	private String batch;
	private Integer quantity;
	private Double maxprice;
	private Integer sup_sum;
	private Timestamp quote_time;
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
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(Double maxprice) {
		this.maxprice = maxprice;
	}
	public Integer getSup_sum() {
		return sup_sum;
	}
	public void setSup_sum(Integer sup_sum) {
		this.sup_sum = sup_sum;
	}
	public Timestamp getQuote_time() {
		return quote_time;
	}
	public void setQuote_time(Timestamp quote_time) {
		this.quote_time = quote_time;
	}
	@Override
	public String toString() {
		return "SupExcDet [factory=" + factory + ", retrievalmodel="
				+ retrievalmodel + ", batch=" + batch + ", quantity="
				+ quantity + ", maxprice=" + maxprice + ", sup_sum=" + sup_sum
				+ ", quote_time=" + quote_time + "]";
	}
	
	
}
