package com.hit.hotel.tool;

import java.util.HashMap;
import java.util.List;

import com.hit.hotel.enums.MsgType;
import com.hit.hotel.hr.model.Worker;
import com.hit.hotel.order.model.Order;
import com.hit.hotel.restresult.Result;

public class ResponseTool {

	public static Result failed(String string) {
		Result result = new Result();
		result.setMessage(string);
		result.setStatus("400");
		return result;
	}

	public static Result success(int intResult) {
		Result result = new Result();
		result.setIntResult(intResult);
		result.setMessage("返回一个Integer");
		return result;
	}

	public static Result success(HashMap<String, String> map) {
		Result result = new Result();
		result.setResult(map);
		result.setMessage("返回一个hashMap");
		return result;
	}



	public static Result success(Order selectById) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Result failed(MsgType failed) {
		Result result = new Result();
		result.setMessage(failed.getMessage());
		result.setStatus(failed.getCode().toString());
		return result;
	}

	public static Result success(MsgType success) {
		Result result = new Result();
		result.setMessage(success.getMessage());
		result.setStatus(success.getCode().toString());
		return result;
	}

	public static Result success(String string) {
		Result result = new Result();
		result.setMessage(string);
		result.setStatus("200");
		return result;
	}

	public static <T> Result success(T selectById) {
		Result result = new Result();
		result.setResult(selectById);
		result.setMessage("返回单个结果");
		return result;
	}

	public static Result failed() {
		
		return ResponseTool.failed(MsgType.FAILED);
	}

	public static <T> Result success(List<T> list) {
		
		Result result = new Result();
		result.setResult(list);
		result.setMessage("返回一个list");
		return result;
	}

	public static Result success() {
		return ResponseTool.failed(MsgType.SUCCESS);
	}
	

}
