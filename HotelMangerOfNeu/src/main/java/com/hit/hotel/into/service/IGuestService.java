package com.hit.hotel.into.service;

import java.util.Date;
import java.util.List;

import com.hit.hotel.hr.model.EmployeeModel;
import com.hit.hotel.into.model.GuestModel;

//客户业务接口
public interface IGuestService {

	public String add(GuestModel rm) throws Exception;
	public void modify(GuestModel rm) throws Exception;
	public void delete(GuestModel rm) throws Exception;
	
	//取得所有的客户列表
	public List<GuestModel> getListByAll() throws Exception;
	//取得所有客户列表,分页模式
	public List<GuestModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得客户的个数
	public int getCountByAll() throws Exception;
	//取得客户的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据客户的no(主键)获取指定的客户对象
	public GuestModel getByNo(String no) throws Exception;
	//根据条件查询page数目
	public int getPageCountByCondition(int lowAge, int highAge,String sex, String nameKey,int rows) throws Exception;
	//根据条件查询总数目
	public int getCountByCondition(int lowAge, int highAge, String sex, String nameKey);
	//根据条件查询List
	public List<GuestModel> getListByConditionWithPageWithDepartment(int rows, int page, int lowAge, int highAge, String sex, String nameKey);
		
	
	
}
