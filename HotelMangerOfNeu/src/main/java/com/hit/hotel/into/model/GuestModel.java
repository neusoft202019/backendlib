package com.hit.hotel.into.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Guest")
public class GuestModel implements Serializable {

	private String no = null;
	private String name = null;
	private int age=0;
	private String sex=null;
	private int account = 0;
	private String local=null;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
}
