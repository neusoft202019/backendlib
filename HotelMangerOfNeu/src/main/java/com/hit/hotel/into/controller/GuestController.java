package com.hit.hotel.into.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.hr.model.EmployeeModel;
import com.hit.hotel.into.model.GuestModel;
import com.hit.hotel.into.service.IGuestService;
import com.hit.hotel.restresult.Result;


@RestController
@RequestMapping(value="/guest")
@CrossOrigin(origins = {"*", "null"})
public class GuestController {
	
	@Autowired
	private IGuestService gs=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody GuestModel gm) throws Exception{
		gs.add(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加客户成功");
		return result;
	}
	
	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody GuestModel gm) throws Exception{
		gs.modify(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改客户成功");
		return result;
	}
	
	
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody GuestModel gm) throws Exception{
		gs.delete(gm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除客户成功!");
		return result;
	}
	//取得客户列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<GuestModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<GuestModel> result=new Result<GuestModel>();
		result.setCount(gs.getCountByAll());
		result.setPageCount(gs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(gs.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得客户列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<GuestModel> getByNo(@RequestParam(required=true) String no) throws Exception{
		Result<GuestModel> result=new Result<GuestModel>();
		result.setResult(gs.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定客户对象成功!");
		return result;
	}
	
	@GetMapping(value="/list/condition/page")
	public Result<GuestModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="10") int rows, 
			@RequestParam(required=false,defaultValue="1") int page, 
			@RequestParam(required=false,defaultValue="0") int lowAge, 
			@RequestParam(required=false,defaultValue="0") int highAge,
			@RequestParam(required=false,defaultValue="") String sex, 
			@RequestParam(required=false,defaultValue="") String nameKey) throws Exception{
		Result<GuestModel> result=new Result<GuestModel>();
		result.setPage(page);
		result.setRows(rows);
		System.out.print("here for list contain");
		result.setCount(gs.getCountByCondition(lowAge, highAge, sex, nameKey));
		result.setPageCount(gs.getPageCountByCondition(lowAge, highAge, sex, nameKey,rows));
		result.setList(gs.getListByConditionWithPageWithDepartment(rows, page,lowAge, highAge, sex, nameKey));
		result.setStatus("OK");
		result.setMessage("按条件检索客户列表成功!");
		return result;
	}

}
