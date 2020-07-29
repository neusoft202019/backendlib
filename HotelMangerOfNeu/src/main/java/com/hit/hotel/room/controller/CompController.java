package com.hit.hotel.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.room.model.CompModel;
import com.hit.hotel.room.service.ICompService;

@RestController
@RequestMapping(value="/comp")
@CrossOrigin(origins = {"*", "null"})
public class CompController {

	@Autowired
	private ICompService cs=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody CompModel cm) throws Exception{
		cs.add(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加公司成功");
		return result;
	}
	
	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody CompModel cm) throws Exception{
		cs.modify(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改公司成功");
		return result;
	}
	
	
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody CompModel cm) throws Exception{
		cs.delete(cm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除公司成功!");
		return result;
	}
	//取得公司列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<CompModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<CompModel> result=new Result<CompModel>();
		result.setCount(cs.getCountByAll());
		result.setPageCount(cs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(cs.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得公司列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<CompModel> getByNo(@RequestParam(required=true) String no) throws Exception{
		Result<CompModel> result=new Result<CompModel>();
		result.setResult(cs.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定公司对象成功!");
		return result;
	}
}
