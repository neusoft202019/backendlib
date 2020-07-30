package com.hit.hotel.room.service;

import java.util.List;

import com.hit.hotel.room.model.RoomModel;
//客房业务接口
public interface IRoomService {

	public int add(RoomModel rm) throws Exception;
	public void modify(RoomModel rm) throws Exception;
	public void delete(RoomModel rm) throws Exception;
	
	//取得所有的客房列表
	public List<RoomModel> getListByAll() throws Exception;
	//取得所有客房列表,分页模式
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得客房的个数
	public int getCountByAll() throws Exception;
	//取得客房的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据客房的no(主键)获取指定的客房对象
	public RoomModel getByNo(int no) throws Exception;
	public int getCountByCondition(int lowPrice, int highPrice, String type);
	public int getPageCountByCondition(int lowPrice, int highPrice, String type, int rows);
	public List<RoomModel> getListByConditionWithPageWithDepartment(int rows, int page, int lowPrice, int highPrice,
			String type);
}
