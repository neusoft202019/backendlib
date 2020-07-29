package com.hit.hotel.room.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.hr.model.EmployeeModel;
import com.hit.hotel.room.model.GoodsModel;


//物品的mapper接口
@Mapper
public interface IGoodsMapper {

	public void insert(GoodsModel gm) throws Exception;
	public void update(GoodsModel gm) throws Exception;
	public void delete(GoodsModel gm) throws Exception;
	
	//取得所有的物品列表
	public List<GoodsModel> selectByAll() throws Exception;
	//取得所有物品列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<GoodsModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得物品的个数
	public int selectCountByAll() throws Exception;
	//根据物品的no（PK）取得指定的物品对象
	public GoodsModel selectByNo(int no) throws Exception;
	
	public List<GoodsModel> selectListByAllWithPageWithRoom(@Param("start") int start,@Param("rows") int rows) throws Exception;
}
