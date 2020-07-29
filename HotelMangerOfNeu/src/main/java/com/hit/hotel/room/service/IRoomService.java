package com.hit.hotel.room.service;

import java.util.List;
import com.hit.hotel.room.model.Room;


public interface IRoomService {
    int insert(Room room);
    int delete(int roomId);
    int update(Room room);
    Room selectById(int roomId);
    Room selectByNumber(String roomNumber);
    List<Room> selectByStatus(int roomStatus);
    List<Room> selectByType(int typeId);
    List<Room> selectAll();

    int orderRoom(int typeId);
    int inRoom(int typeId);
    int outRoom(int typeId);
}
