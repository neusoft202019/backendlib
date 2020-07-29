package com.hit.hotel.order.mapper;

import org.springframework.stereotype.Component;
import com.hit.hotel.order.model.RoomType;
import java.util.List;

@Component
public interface RoomTypeMapper {
    Integer getCount();
    int deleteByPrimaryKey(Integer typeId);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);

    List<RoomType> selectAll();

    RoomType selectByRoomType(String roomType);

    List<RoomType> selectAllWithRest();
}
