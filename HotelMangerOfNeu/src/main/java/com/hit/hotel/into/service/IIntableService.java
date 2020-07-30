package com.hit.hotel.into.service;

import java.util.List;

import com.hit.hotel.into.model.IntableModel;


//入住单业务接口
public interface IIntableService {

	public String add(IntableModel im) throws Exception;
	public void modify(IntableModel im) throws Exception;
	public void delete(IntableModel im) throws Exception;
	
	//取得所有的入住单列表
	public List<IntableModel> getListByAll() throws Exception;
	//取得所有入住单列表,分页模式
	public List<IntableModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得入住单的个数
	public int getCountByAll() throws Exception;
	//取得入住单的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据入住单的no(主键)获取指定的入住单对象
	public IntableModel getByCode(String code) throws Exception;
	
	public List<IntableModel> getListByConditionWithPageWithGuest(int rows,int page) throws Exception;
	public int getCountByCondition(int lowAge, int highAge, int roomNo, String nameKey);
	public int getPageCountByCondition(int lowAge, int highAge, int roomNo, String nameKey, int rows);
	public List<IntableModel> getListByConditionWithPageWithDepartment(int rows, int page, int lowAge, int highAge,
			int roomNo, String nameKey);


}
