package com.pipe.vo;

public class IcView {
	private String uuid;
	private String Businname;
	private String mobnum;
	private String retrievalmodel;
	private String factory;
	private String qq;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getBusinname() {
		return Businname;
	}
	public void setBusinname(String businname) {
		Businname = businname;
	}
	public String getMobnum() {
		return mobnum;
	}
	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}
	public String getRetrievalmodel() {
		return retrievalmodel;
	}
	public void setRetrievalmodel(String retrievalmodel) {
		this.retrievalmodel = retrievalmodel;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getIcqq() {
		return qq;
	}
	public void setIcqq(String icqq) {
		this.qq = icqq;
	}
	@Override
	public String toString() {
		return "IcView [uuid=" + uuid + ", Businname=" + Businname
				+ ", mobnum=" + mobnum + ", retrievalmodel=" + retrievalmodel
				+ ", factory=" + factory + ", icqq=" + qq + "]";
	}
	
}
