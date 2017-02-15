package com.pipe.iccraw.entity;

/**
 * name    		 姓名
 * telPhone     手机号码
 * ic.net.cn  每一个商家对应的手机号 和 联系人  实体类
 * @author viakiba
 *
 */
public class Contacts {
	private String name;//姓名
	private String telPhone;//手机号码
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	@Override
	public String toString() {
		return "Contacts [name=" + name + ", telPhone=" + telPhone + "]";
	}
}