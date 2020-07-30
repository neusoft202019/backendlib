package com.hit.hotel.into.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.hotel.hr.model.EmployeeModel;
import com.hit.hotel.into.model.GuestModel;


//客户的mapper接口
@Mapper
public interface IGuestMapper {

	public void insert(GuestModel rm) throws Exception;
	public void update(GuestModel rm) throws Exception;
	public void delete(GuestModel rm) throws Exception;
	
	//取得所有的客户列表
	public List<GuestModel> selectByAll() throws Exception;
	//取得所有客户列表，分页模式 参数： start：起始位置； rows:取得记录格式， 
	public List<GuestModel> selectByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得客户的个数
	public int selectCountByAll() throws Exception;
	//根据客户的no（PK）取得指定的客户对象
	public GuestModel selectByNo(String no) throws Exception;
	//取得指定的客户，并取得其关联的房间集合
	public GuestModel selectByNoWithGoods(String no) throws Exception;
	
	//按综合条件检索员工列表，分页模式，之取关联的部门属性对象
	public List<GuestModel> selectListByConditionWithPageWithDepartment(@Param("start") int rows,@Param("rows") int page,
			@Param("lowAge") int lowAge,@Param("highAge") int highAge,
			@Param("sex") String sex,@Param("nameKey") String nameKey) ;
	

	//按综合条件检索员工个数，分页模式，之取关联的部门属性对象
	public int selectCountByCondition(@Param("lowAge") int lowAge,@Param("highAge") int highAge
			,@Param("sex") String sex,@Param("nameKey") String nameKey) ;
	
	
}
