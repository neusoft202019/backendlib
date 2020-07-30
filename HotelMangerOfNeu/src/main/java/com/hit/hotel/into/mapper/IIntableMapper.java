package com.hit.hotel.into.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.into.model.IntableModel;


//入住单的mapper接口
@Mapper
public interface IIntableMapper {

	public void insert(IntableModel gm) throws Exception;
	public void update(IntableModel gm) throws Exception;
	public void delete(IntableModel gm) throws Exception;
	
	//取得所有的入住单列表
	public List<IntableModel> selectByAll() throws Exception;
	//取得所有入住单列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<IntableModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得入住单的个数
	public int selectCountByAll() throws Exception;
	//根据入住单的no（PK）取得指定的入住单对象
	public IntableModel selectByCode(String code) throws Exception;
	
	public List<IntableModel> selectListByAllWithPageWithGuest(@Param("start") int start,@Param("rows") int rows) throws Exception;
	public int selectCountByCondition(@Param("lowPrice") int lowPrice, @Param("highPrice") int highPrice,@Param("roomNo") int roomNo, @Param("nameKey") String nameKey);
	public List<IntableModel> selectListByConditionWithPageWithDepartment(@Param("start") int i, @Param("rows")int rows, @Param("lowPrice")  int lowPrice,
			@Param("highPrice") int highPrice,@Param("roomNo")int roomNo, @Param("nameKey")String nameKey);

}
