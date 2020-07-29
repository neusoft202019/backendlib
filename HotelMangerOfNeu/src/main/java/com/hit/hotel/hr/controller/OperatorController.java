package com.hit.hotel.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.enums.MsgType;
import com.hit.hotel.enums.Role;
import com.hit.hotel.hr.model.Worker;
import com.hit.hotel.hr.service.IWorkerService;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.tool.ResponseTool;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/operator")
public class OperatorController {
    @Autowired
    private IWorkerService workerService;


    @RequestMapping(method = RequestMethod.POST,value = "/delete/{workerId}")
    public Result deleteOperator(@PathVariable Integer workerId){
    	if(workerId == null) {return ResponseTool.failed("ID为空");}
        int re = workerService.delete(workerId);
        if(re!=1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("删除成功");
    }

    @RequestMapping(value = "")
    public Result getAllOperator(){
        return ResponseTool.success(workerService.selectByRole(Role.OPERATOR.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/{workerId}")
    public Result getOperator(@PathVariable Integer workerId){
    	System.out.println("here for testing");
        return ResponseTool.success(workerService.selectById(workerId));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public Result addOperator(String username,String password,String name,String gender,String phone,String email,String address){
    	
    	if(password == null) {
    		return ResponseTool.failed("密码不能为空");
    	}
    	
        Worker worker = new Worker(username,password,name,gender,phone,email,address);
        worker.setRole(Role.OPERATOR.getValue());
        int re = workerService.insert(worker);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success("添加成功");
    }


    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public Result updateOperator(int workerId,String name,String gender,String phone,String email,String address){
    	
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setName(name);
        worker.setGender(gender);
        worker.setPhone(phone);
        worker.setEmail(email);
        worker.setAddress(address);
        System.out.println("here for testing");
        int re =  workerService.updateById(worker);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success("更新成功");
    }

}
