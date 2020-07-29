package com.hit.hotel.room.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.enums.OrderStatus;
import com.hit.hotel.enums.RoomStatus;
import com.hit.hotel.order.model.Order;
import com.hit.hotel.order.model.RoomType;
import com.hit.hotel.order.service.IOrderService;
import com.hit.hotel.order.service.IRoomTypeService;
import com.hit.hotel.room.mapper.CheckInMapper;
import com.hit.hotel.room.model.CheckIn;
import com.hit.hotel.room.model.Room;
import com.hit.hotel.room.service.ICheckInService;
import com.hit.hotel.room.service.IRoomService;

import java.util.HashMap;
import java.util.List;

@Service
public class CheckInServiceImpl implements ICheckInService {
    @Autowired
    private CheckInMapper checkInMapper;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IRoomTypeService roomTypeService;
    @Autowired
    private IRoomService roomService;

    @Override
    public int insert(CheckIn checkIn) {
        return checkInMapper.insert(checkIn);
    }

    /**
     * 入住登记
     * @param checkIn
     * 1.获取订单
     * 2.获取房间类型
     * 3.获取房间
     * @return
     */
    @Override
    @Transactional
    public Room checkIn(CheckIn checkIn) {
        Order order = orderService.selectById(checkIn.getOrderId());
        RoomType rt = roomTypeService.selectById(order.getRoomTypeId());
        Room r = roomService.selectById(roomService.inRoom(order.getRoomTypeId()));
        checkIn.setRoomId(r.getRoomId());
        checkIn.setRoomNumber(r.getRoomNumber());
        roomTypeService.updateRest(rt.getTypeId(),-1);
        order.setOrderStatus(OrderStatus.CHECK_IN.getCode());
        orderService.update(order);
        checkInMapper.insert(checkIn);
        return r;
    }

    /**
     * 退房登记
     * 1.获取房间
     * 2.获取房型
     * 3.获取checkIn
     * @param roomNumber
     * @return
     */
    @Override
    public int checkOut(String  roomNumber){
        Room r = roomService.selectByNumber(roomNumber);
        RoomType ty = roomTypeService.selectById(r.getTypeId());
        CheckIn checkIn = checkInMapper.selectLatestByRoomNumber(roomNumber);
        r.setRoomStatus(RoomStatus.AVAILABLE.getCode());
        if(roomService.update(r) <=0 )return -3;
        if (roomTypeService.updateRest(ty.getTypeId(),1)<=0)return -2;
        return checkInMapper.checkOut(checkIn.getCheckInId());
    }

    @Override
    public int delete(int checkInId) {
        return checkInMapper.deleteByPrimaryKey(checkInId);
    }

    @Override
    public int update(CheckIn checkIn) {
        return checkInMapper.updateByPrimaryKeySelective(checkIn);
    }



    @Override
    public int updateByRoomNumber(String roomNumber) {
        return checkInMapper.updateByRoomNumber(roomNumber);
    }

    @Override
    public CheckIn selectById(int checkInId) {
        return checkInMapper.selectByPrimaryKey(checkInId);
    }

    @Override
    public List<CheckIn> selectAll() {
        return checkInMapper.selectAll();
    }
}
