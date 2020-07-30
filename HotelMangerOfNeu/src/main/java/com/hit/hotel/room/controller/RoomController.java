package com.hit.hotel.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.into.model.GuestModel;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.room.model.RoomModel;
import com.hit.hotel.room.service.IRoomService;

@RestController
@RequestMapping(value="/room")
@CrossOrigin(origins = {"*", "null"})
public class RoomController {

	@Autowired
	private IRoomService rs=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody RoomModel rm) throws Exception{
		rs.add(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加房间成功");
		return result;
	}
	
	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody RoomModel rm) throws Exception{
		rs.modify(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改房间成功");
		return result;
	}
	
	
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody RoomModel rm) throws Exception{
		rs.delete(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除房间成功!");
		return result;
	}
	//取得房间列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<RoomModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setCount(rs.getCountByAll());
		result.setPageCount(rs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(rs.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得房间列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<RoomModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setResult(rs.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定房间对象成功!");
		return result;
	}
	
	@GetMapping(value="/list/condition/page")
	public Result<RoomModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="10") int rows, 
			@RequestParam(required=false,defaultValue="1") int page, 
			@RequestParam(required=false,defaultValue="0") int lowPrice, 
			@RequestParam(required=false,defaultValue="0") int highPrice,
			@RequestParam(required=false,defaultValue="") String type) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setPage(page);
		result.setRows(rows);

		result.setCount(rs.getCountByCondition(lowPrice, highPrice, type));
		System.out.println("here for testing");
		result.setPageCount(rs.getPageCountByCondition(lowPrice, highPrice, type,rows));
		result.setList(rs.getListByConditionWithPageWithDepartment(rows, page,lowPrice, highPrice, type));
		result.setStatus("OK");
		result.setMessage("按条件检索物品列表成功!");
		return result;
	}
	
}
