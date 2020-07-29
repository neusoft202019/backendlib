package com.hit.hotel.room.service;

import java.util.List;

import com.hit.hotel.room.model.CompModel;


//公司业务接口
public interface ICompService {

	public String add(CompModel cm) throws Exception;
	public void modify(CompModel cm) throws Exception;
	public void delete(CompModel cm) throws Exception;
	
	//取得所有的公司列表
	public List<CompModel> getListByAll() throws Exception;
	//取得所有公司列表,分页模式
	public List<CompModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得公司的个数
	public int getCountByAll() throws Exception;
	//取得公司的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据公司的no(主键)获取指定的公司对象
	public CompModel getByNo(String no) throws Exception;
}
