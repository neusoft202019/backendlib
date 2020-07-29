package com.hit.hotel.room.service;



import java.util.HashMap;
import java.util.List;

import com.hit.hotel.room.model.CheckIn;
import com.hit.hotel.room.model.Room;

public interface ICheckInService {

    int insert(CheckIn checkIn);

    Room checkIn(CheckIn checkIn);

    int delete(int checkInId);

    int update(CheckIn checkIn);

    int checkOut(String roomNumber);

    int updateByRoomNumber(String roomNumber);

    CheckIn selectById(int checkInId);

    List<CheckIn> selectAll();

}
