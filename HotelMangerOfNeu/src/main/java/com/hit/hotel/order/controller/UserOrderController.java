package com.hit.hotel.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.enums.MsgType;
import com.hit.hotel.enums.OrderStatus;
import com.hit.hotel.hr.model.User;
import com.hit.hotel.hr.service.IUserService;
import com.hit.hotel.order.model.Order;
import com.hit.hotel.order.service.IOrderService;
import com.hit.hotel.restresult.Result;

import com.hit.hotel.tool.ResponseTool;

import java.util.Date;
import java.util.List;

/**
 * 订单接口
 */
@RestController
@RequestMapping(value = "/user/order")
public class UserOrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IUserService userService;

    /**
     * 添加预订
     * 订单状态默认为未付款状态
     * @param orderTypeId
     * @param orderType
     * @param userId
     * @param name
     * @param phone
     * @param roomTypeId
     * @param roomType
     * @param orderDate
     * @param orderDays
     * @param orderCost
     * @return
     */
    @RequestMapping(value = "/add")
    public Result addOrder(int orderTypeId,String orderType, int userId,String name, String phone,int roomTypeId, String roomType,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate, Integer orderDays, Double orderCost){
        Order order = new Order(orderTypeId,orderType,userId,name,phone,roomTypeId,
                roomType,orderDate,orderDays, OrderStatus.UNPAID.getCode(),orderCost);
        int re = orderService.addOrder(order);
        if(re!=1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result deleteOrderByUser(int orderId){
        Order order = new Order(orderId,OrderStatus.WAS_DELETED.getCode());
        int re =  orderService.update(order);
        if(re!=1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 订单支付
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/pay")
    public Result payOrder(Integer orderId,String username,String password){
        User user = userService.selectByUsernameAndPassword(username,password);
        if(user==null) return ResponseTool.failed("密码错误");
        int re = orderService.payOrder(orderId);
        if(re!=1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/cancel")
    public Result cancelOrder(int orderId){
        int re = orderService.cancelOrder(orderId);
        if(re!=1) ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success(MsgType.SUCCESS);
    }


    /**
     * 客户查询个人所有订单（不包括被自己删除的）
     * @param userId
     * @return
     */
    @RequestMapping(value = "")
    public Result getAllByUser(Integer userId){
    	System.out.print(userId);
        return ResponseTool.success(orderService.UsersAllOrders(userId));
    }

    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/{orderId}")
    public Result getById(@PathVariable int orderId){
        return ResponseTool.success(orderService.selectById(orderId));
    }

}
