package com.hit.hotel.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.order.model.OrderType;
import com.hit.hotel.order.service.IOrderTypeService;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.tool.ResponseTool;

import java.util.List;

@RestController
@RequestMapping(value = "/op/order-type")
public class OpOrderTypeController {
    @Autowired
    private IOrderTypeService orderTypeService;

    @RequestMapping(value = "/add")
    public Result addOrderType(String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        int re = orderTypeService.insertOrderType(orderType);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success();
    }

    @RequestMapping(value = "/delete/{typeId}")
    public Result deleteOrderType(@PathVariable Integer typeId){
        int re= orderTypeService.deleteOrderType(typeId);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success();
    }

    @RequestMapping(value = "/update")
    public Result updateOrderType(Integer typeId,String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        orderType.setTypeId(typeId);
        int re = orderTypeService.updateOrderType(orderType);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success();
    }

    @RequestMapping(value = "/{typeId}")
    public Result getById(@PathVariable Integer typeId){
        return ResponseTool.success(orderTypeService.selectById(typeId));
    }

    @RequestMapping(value = "")
    public Result getAllType(){
        return ResponseTool.success(orderTypeService.selectAll());
    }

}
