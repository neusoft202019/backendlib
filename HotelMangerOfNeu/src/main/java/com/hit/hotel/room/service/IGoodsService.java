package com.hit.hotel.room.service;

import java.util.Date;
import java.util.List;

import com.hit.hotel.room.model.GoodsModel;



//物品业务接口
public interface IGoodsService {

	public int add(GoodsModel rm) throws Exception;
	public void modify(GoodsModel rm) throws Exception;
	public void delete(GoodsModel rm) throws Exception;
	
	//取得所有的物品列表
	public List<GoodsModel> getListByAll() throws Exception;
	//取得所有物品列表,分页模式
	public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得物品的个数
	public int getCountByAll() throws Exception;
	//取得物品的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据物品的no(主键)获取指定的物品对象
	public GoodsModel getByNo(int no) throws Exception;
	
	public List<GoodsModel> getListByConditionWithPageWithRoom(int rows,int page) throws Exception;
}
