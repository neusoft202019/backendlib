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
import com.hit.hotel.room.model.GoodsModel;
import com.hit.hotel.room.service.IGoodsService;

@RestController
@RequestMapping(value="/goods")
@CrossOrigin(origins = {"*", "null"})
public class GoodsController {

	@Autowired
	private IGoodsService gs=null;
	
	@PostMapping(value="/add")
	public Result<String> add(@RequestBody GoodsModel rm) throws Exception{
		gs.add(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加物品成功");
		return result;
	}
	
	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody GoodsModel rm) throws Exception{
		gs.modify(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改物品成功");
		return result;
	}
	
	
	@PostMapping(value="/delete")
	public Result<String> delete(@RequestBody GoodsModel rm) throws Exception{
		gs.delete(rm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除物品成功!");
		return result;
	}
	//取得物品列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<GoodsModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<GoodsModel> result=new Result<GoodsModel>();
		result.setCount(gs.getCountByAll());
		result.setPageCount(gs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(gs.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得物品列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<GoodsModel> getByNo(@RequestParam(required=true) int no) throws Exception{
		Result<GoodsModel> result=new Result<GoodsModel>();
		result.setResult(gs.getByNo(no));
		
		result.setStatus("OK");
		result.setMessage("取得指定物品对象成功!");
		return result;
	}
}
