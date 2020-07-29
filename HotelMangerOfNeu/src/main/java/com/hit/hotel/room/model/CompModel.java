package com.hit.hotel.room.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Comp")
public class CompModel implements Serializable {

	private String no = null;
	private String name = null;
	private String able=null;
	private String tel = null;
	private int cost = 0;
	private String per = null;
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
	public String getAble() {
		return able;
	}
	public void setAble(String able) {
		this.able = able;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	
}
