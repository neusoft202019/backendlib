package com.hit.hotel.room.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.room.model.CompModel;


//公司的mapper接口
@Mapper
public interface ICompMapper {

	public void insert(CompModel rm) throws Exception;
	public void update(CompModel rm) throws Exception;
	public void delete(CompModel rm) throws Exception;
	
	//取得所有的公司列表
	public List<CompModel> selectByAll() throws Exception;
	//取得所有公司列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<CompModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得公司的个数
	public int selectCountByAll() throws Exception;
	//根据公司的no（PK）取得指定的公司对象
	public CompModel selectByNo(String no) throws Exception;
	//取得指定的公司，并取得其关联的物品集合
	public CompModel selectByNoWithGoods(String no) throws Exception;
}
