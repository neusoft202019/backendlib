package com.hit.hotel.room.mapper;


import com.hit.hotel.room.model.Room;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
@Component
public interface RoomMapper {
    Integer getCount();
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    Room selectByNumber(String roomNumber);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectByType(Integer typeId);

    List<Room> selectByStatus(Integer roomStatus);

    List<Room> selectAll();

    Room randomSelectByTypeAndStatus(@Param("typeId") Integer typeId,@Param("roomStatus") Integer roomStatus);
}
