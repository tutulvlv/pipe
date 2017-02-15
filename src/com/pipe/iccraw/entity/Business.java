package com.pipe.iccraw.entity;

import java.util.List;

/**
 * Businname     					商家名称
 * memberlevel     					会员等级
 * retrievalmodel     				检索型号
 * Memberyears     					会员年限
 * private List<Contacts> contacts  联系人
 * private List<Qq> qq    			 联系人
 * mobnum     						手机号
 * address     						地址
 * pagesize                         页数
 * ic.net.cn  用于封装检索的商家信息
 * @author 666
 *
 */
public class Business {
	private String Businname;//商家名称
	private String memberlevel;//会员等级
	private String retrievalmodel;//检索型号
	private String factory;//检索型号
	private String Memberyears;//会员年限
	private List<Contacts> contacts;//联系人
	private List<Qq> qq;//联系人
	private String mobnum;//手机号
	private String address;//地址
	private String pagesize;//地址

	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public List<Qq> getQq() {
		return qq;
	}
	public void setQq(List<Qq> qq) {
		this.qq = qq;
	}
	public String getBusinname() {
		return Businname;
	}
	public void setBusinname(String businname) {
		Businname = businname;
	}
	public String getMemberlevel() {
		return memberlevel;
	}
	public void setMemberlevel(String memberlevel) {
		this.memberlevel = memberlevel;
	}
	public String getRetrievalmodel() {
		return retrievalmodel;
	}
	public void setRetrievalmodel(String retrievalmodel) {
		this.retrievalmodel = retrievalmodel;
	}
	public String getMemberyears() {
		return Memberyears;
	}
	public void setMemberyears(String memberyears) {
		Memberyears = memberyears;
	}
	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
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
	@Override
	public String toString() {
		return "Business [Businname=" + Businname + ", memberlevel="
				+ memberlevel + ", retrievalmodel=" + retrievalmodel
				+ ", factory=" + factory + ", Memberyears=" + Memberyears
				+ ", contacts=" + contacts + ", qq=" + qq + ", mobnum="
				+ mobnum + ", address=" + address + ", pagesize=" + pagesize
				+ "]"+"\n";
	}
}
