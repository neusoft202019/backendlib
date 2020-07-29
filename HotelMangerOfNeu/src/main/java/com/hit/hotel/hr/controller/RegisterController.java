package com.hit.hotel.hr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.enums.Role;
import com.hit.hotel.hr.model.User;
import com.hit.hotel.hr.model.Worker;
import com.hit.hotel.hr.service.IUserService;
import com.hit.hotel.hr.service.IWorkerService;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.tool.ResponseTool;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    IUserService userService;
    @Autowired
    IWorkerService workerService;

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public Result userRegister(String username,String password,String name,String gender,String phone,String email,String address,String idcard){
    	if(password == null) {
    		return ResponseTool.failed("密码不能为空！！！");
    	}
    	
    	if(username == null) {
    		return ResponseTool.failed("姓名不能为空！！！");
    	}
    	
    	if(idcard == null) {
    		return ResponseTool.failed("身份证件为空不能为空！！！");
    	}
    	
    	
        User user = new User(username,password,name,gender,phone,email,address,idcard);
        int result = userService.insertUser(user);
        if(result==1){
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/admin")
    public Result adminRegister(String username, String password, String name, String gender, String phone, String email, String address){
    	
    	
    	if(password == null) {
    		return ResponseTool.failed("密码不能为空！！！");
    	}
    	
    	if(username == null) {
    		return ResponseTool.failed("姓名不能为空！！！");
    	}

        Worker worker = new Worker(username,password,name,gender,phone,email,address);
        worker.setRole(Role.ADMIN.getValue());
        int result = workerService.insert(worker);
        if(result==1){
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/operator")
    public Result operatorRegister(String username,String password,String name,String gender,String phone,String email,String address){
    	
    	if(password == null) {
    		return ResponseTool.failed("密码不能为空！！！");
    	}
    	
    	if(username == null) {
    		return ResponseTool.failed("姓名不能为空！！！");
    	}
    	
    	
        Worker worker = new Worker(username,password,name,gender,phone,email,address);
        worker.setRole(Role.OPERATOR.getValue());
        int result = workerService.insert(worker);
        if(result==1){
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

}
