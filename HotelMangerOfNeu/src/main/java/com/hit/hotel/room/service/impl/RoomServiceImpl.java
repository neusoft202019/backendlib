package com.hit.hotel.room.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.enums.RoomStatus;
import com.hit.hotel.room.mapper.RoomMapper;
import com.hit.hotel.room.model.Room;
import com.hit.hotel.room.service.IRoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public int insert(Room room) {
        return roomMapper.insertSelective(room);
    }

    @Override
    public int delete(int roomId) {
        return roomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    public int update(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public Room selectById(int roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    public Room selectByNumber(String roomNumber) {
        return roomMapper.selectByNumber(roomNumber);
    }

    @Override
    public List<Room> selectByStatus(int roomStatus) {
        return roomMapper.selectByStatus(roomStatus);
    }

    @Override
    public List<Room> selectByType(int typeId) {
        return roomMapper.selectByType(typeId);
    }

    @Override
    public List<Room> selectAll() {
        return roomMapper.selectAll();
    }

    @Override
    @Transactional
    public int orderRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId,RoomStatus.AVAILABLE.getCode());
        if (room == null) return -1;
        room.setRoomStatus(RoomStatus.ORDERED.getCode());
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    /**
     * 房间入住
     * @param typeId
     * @return
     */
    @Override
    public int inRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId,RoomStatus.AVAILABLE.getCode());
        System.out.println(room);
        room.setRoomStatus(RoomStatus.IN_USE.getCode());
        if (roomMapper.updateByPrimaryKeySelective(room) <= 0)
            return -1;
        else return room.getRoomId();
    }

    @Override
    public int outRoom(int typeId) {
        Room room = roomMapper.randomSelectByTypeAndStatus(typeId,RoomStatus.IN_USE.getCode());
        if (room == null) return -1;
        room.setRoomStatus(RoomStatus.AVAILABLE.getCode());
        return roomMapper.updateByPrimaryKeySelective(room);
    }

}
