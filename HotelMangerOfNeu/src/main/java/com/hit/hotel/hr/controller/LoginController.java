package com.hit.hotel.hr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.hr.model.User;
import com.hit.hotel.hr.model.Worker;
import com.hit.hotel.hr.service.IUserService;
import com.hit.hotel.hr.service.IWorkerService;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.tool.ResponseTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IWorkerService workerService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result userLogin(String username, String password,
                                        HttpServletRequest request) {
    	
        if(StringUtils.isEmpty(username)){
            return ResponseTool.failed("用户名不能为空");
        }else if(StringUtils.isEmpty(password)) {
            return ResponseTool.failed("密码不能为空");
        }
        User user = userService.selectByUsernameAndPassword(username,password);
        if(user==null){
            return ResponseTool.failed("用户名或密码不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getUserId());
        session.setAttribute("username",user.getUsername());
        HashMap map = new HashMap<>();
        map.put("sessionId",session.getId());
        map.put("userId",user.getUserId());
        return ResponseTool.success(map);
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public Result workerLogin(String username, String password,
                                HttpServletRequest request){
        if(StringUtils.isEmpty(username)){
            return ResponseTool.failed("用户名不能为空");
        }else if(StringUtils.isEmpty(password)) {
            return ResponseTool.failed("密码不能为空");
        }
        Worker worker = workerService.login(username,password);
        if(worker==null){
            return ResponseTool.failed("用户名或密码不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId",worker.getWorkerId());
        session.setAttribute("role",worker.getRole());
        HashMap<String, String> map = new HashMap<>();
        map.put("sessionId",session.getId());
        map.put("role",worker.getRole());
        return ResponseTool.success(map);
    }

}
