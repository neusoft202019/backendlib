package com.hit.hotel.room.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Room")
public class RoomModel implements Serializable {

	private int no = 0;
	private String code = null;
	private String type=null;
	private int price = 0;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
