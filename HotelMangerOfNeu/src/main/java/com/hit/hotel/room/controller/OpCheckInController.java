package com.hit.hotel.room.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.restresult.Result;
import com.hit.hotel.room.model.CheckIn;
import com.hit.hotel.room.service.ICheckInService;
import com.hit.hotel.tool.ResponseTool;

@RestController
@RequestMapping(value = "/op/check-in")
public class OpCheckInController {

    @Autowired
    private ICheckInService checkInService;

    @RequestMapping(value = "/in")
    public Result addCheckIn(int orderId, int peoCount, String persons, String ids){
        CheckIn checkIn = new CheckIn();
        checkIn.setOrderId(orderId);
        checkIn.setPeoCount(peoCount);
        checkIn.setPersons(persons);
        checkIn.setIds(ids);
        return ResponseTool.success(checkInService.checkIn(checkIn));
    }

    @RequestMapping(value = "/out")
    public Result checkOut(String roomNumber) {
        if(checkInService.checkOut(roomNumber)<0)
            return ResponseTool.failed("退房失败");
        return ResponseTool.success("退房成功");
    }


    @RequestMapping(value = "/delete")
    public Result deleteCheckIn(int checkId){
        if(checkInService.delete(checkId)!=1)
            return ResponseTool.failed("删除失败");
        return ResponseTool.success("删除成功");
    }

    @RequestMapping(value = "/update")
    public Result update(int checkId,String roomNumber){
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInId(checkId);
        checkIn.setRoomNumber(roomNumber);
        if(checkInService.update(checkIn)!=1)
            return ResponseTool.failed("更新失败");
        return ResponseTool.success("更新成功");
    }



    @RequestMapping(value = "/{checkId}")
    public Result getById(@PathVariable int checkId){
        return ResponseTool.success(checkInService.selectById(checkId));
    }

    @RequestMapping(value = "")
    public Result getAll(){
        return ResponseTool.success(checkInService.selectAll());
    }

}
