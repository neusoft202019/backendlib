package com.hit.hotel.order.service;

import org.springframework.stereotype.Service;

import com.hit.hotel.order.model.RoomType;

import java.util.List;

@Service
public interface IRoomTypeService {

    int insert(RoomType roomType);

    int delete(int typeId);

    int update(RoomType roomType);

    RoomType selectByName(String roomType);

    RoomType selectById(int typeId);

    List<RoomType> findAllType();

    int updateRest(int typeId,int num);

    int addRest(int typeId);

    int minusRest(int typeId);

    List<RoomType> findAllRestType();
}
