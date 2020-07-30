package com.hit.hotel.into.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.into.model.GuestModel;
import com.hit.hotel.into.model.IntableModel;
import com.hit.hotel.into.service.IIntableService;
import com.hit.hotel.restresult.Result;


@RestController
@RequestMapping(value="/intable")
@CrossOrigin(origins = {"*", "null"})
public class IntableController {

	@Autowired
	private IIntableService is=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody IntableModel im) throws Exception{
		is.add(im);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加入住单成功");
		return result;
	}
	
	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody IntableModel im) throws Exception{
		is.modify(im);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改入住单成功");
		return result;
	}
	
	
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody IntableModel im) throws Exception{
		is.delete(im);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除入住单成功!");
		return result;
	}
	//取得物品列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<IntableModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="10") int rows, 
			@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<IntableModel> result=new Result<IntableModel>();
		result.setPage(page);
		result.setRows(rows);
		result.setCount(is.getCountByAll());
		result.setPageCount(is.getPageCountByAll(rows));
		result.setList(is.getListByConditionWithPageWithGuest(rows, page));
		result.setStatus("OK");
		result.setMessage("按条件检索入住单列表成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<IntableModel> getByCode(@RequestParam(required=true) String code) throws Exception{
		Result<IntableModel> result=new Result<IntableModel>();
		result.setResult(is.getByCode(code));
		
		result.setStatus("OK");
		result.setMessage("取得指定入住单对象成功!");
		return result;
	}
	
	@GetMapping(value="/list/condition/page")
	public Result<IntableModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="10") int rows, 
			@RequestParam(required=false,defaultValue="1") int page, 
			@RequestParam(required=false,defaultValue="0") int lowAge, 
			@RequestParam(required=false,defaultValue="0") int highAge,
			@RequestParam(required=false,defaultValue="0") int roomNo, 
			@RequestParam(required=false,defaultValue="") String nameKey) throws Exception{
		Result<IntableModel> result=new Result<IntableModel>();
		result.setPage(page);
		result.setRows(rows);
		System.out.print("here for list contain");
		result.setCount(is.getCountByCondition(lowAge, highAge, roomNo, nameKey));
		result.setPageCount(is.getPageCountByCondition(lowAge, highAge, roomNo, nameKey,rows));
		result.setList(is.getListByConditionWithPageWithDepartment(rows, page,lowAge, highAge, roomNo, nameKey));
		result.setStatus("OK");
		result.setMessage("按条件检索入住列表成功!");
		return result;
	}
	
}
