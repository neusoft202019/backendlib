package com.hit.hotel.order.service;

import java.util.List;

import com.hit.hotel.order.model.OrderType;

public interface IOrderTypeService {

    int insertOrderType(OrderType orderType);

    int deleteOrderType(int typeId);

    int updateOrderType(OrderType orderType);

    OrderType selectById(int typeId);

    List<OrderType> selectAll();
}
