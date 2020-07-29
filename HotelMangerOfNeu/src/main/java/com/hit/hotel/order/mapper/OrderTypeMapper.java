package com.hit.hotel.order.mapper;
import org.springframework.stereotype.Component;

import com.hit.hotel.order.model.OrderType;

import java.util.List;


@Component
public interface OrderTypeMapper {
    Integer getCount();
    int deleteByPrimaryKey(Integer typeId);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);

    List<OrderType> selectAll();


}