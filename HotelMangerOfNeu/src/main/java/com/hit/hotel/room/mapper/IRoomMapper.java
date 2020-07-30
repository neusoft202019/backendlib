package com.hit.hotel.room.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.room.model.RoomModel;

//房间的mapper接口
@Mapper
public interface IRoomMapper {

	public void insert(RoomModel rm) throws Exception;
	public void update(RoomModel rm) throws Exception;
	public void delete(RoomModel rm) throws Exception;
	
	//取得所有的房间列表
	public List<RoomModel> selectByAll() throws Exception;
	//取得所有房间列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<RoomModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得房间的个数
	public int selectCountByAll() throws Exception;
	//根据房间的no（PK）取得指定的房间对象
	public RoomModel selectByNo(int no) throws Exception;
	//取得指定的房间，并取得其关联的物品集合
	public RoomModel selectByNoWithGoods(int no) throws Exception;
	public List<RoomModel> selectListByConditionWithPageWithDepartment(@Param("start")  int i, @Param("rows") int rows, @Param("lowPrice")int lowPrice, 
			@Param("highPrice")int highPrice,@Param("type")String type);
	
	public int selectCountByCondition( @Param("lowPrice")int lowPrice, 
			@Param("highPrice")int highPrice,@Param("type")String types);
}
