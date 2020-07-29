package com.hit.hotel.order.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.hit.hotel.order.model.Order;

import java.util.List;

@Component
public interface OrderMapper {

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    Order selectByNameAndPhone(Order record);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Integer getOrderCount();

    List<Order> selectAll();

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllByUser(@Param("userId") Integer userId,@Param("orderStatus") Integer orderStatus);


}
