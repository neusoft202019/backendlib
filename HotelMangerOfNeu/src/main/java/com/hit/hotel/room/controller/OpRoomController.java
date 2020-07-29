package com.hit.hotel.room.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.hotel.order.model.RoomType;
import com.hit.hotel.order.service.IRoomTypeService;
import com.hit.hotel.restresult.Result;
import com.hit.hotel.room.model.Room;
import com.hit.hotel.room.service.IRoomService;
import com.hit.hotel.tool.ResponseTool;
@RestController
@RequestMapping(value = "/op/room")
public class OpRoomController {

    @Autowired
    private IRoomService roomService;
    @Autowired
    private IRoomTypeService roomTypeService;

    @RequestMapping(value = "/add")
    public Result addRoom(String roomNumber, Integer typeId, String roomType, double roomPrice, double roomDiscount, int roomStatus, String remark){
        if(roomService.selectByNumber(roomNumber)!=null) return ResponseTool.failed("房间号码重复");
        Room room = new Room(roomNumber,typeId,roomType,roomPrice,roomDiscount,roomStatus,remark);
        RoomType rt = new RoomType();
        if (roomService.insert(room) == 1){
            rt.setTypeId(typeId);
            rt.setRest(roomTypeService.selectById(typeId).getRest() + 1);
            if(roomTypeService.update(rt)!=1) return ResponseTool.failed("添加失败");
        }else return ResponseTool.failed("添加失败");
        return ResponseTool.success("添加成功");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/delete/{roomId}")
    public Result deleteRoom(@PathVariable Integer roomId){
        if(roomService.delete(roomId)!=1) return ResponseTool.failed("删除失败");
        return ResponseTool.success("删除成功");
    }

    @RequestMapping(value = "/update")
    public Result updateRoom(Integer roomId,String roomNumber,Integer typeId,
                          String roomType,double roomPrice,double roomDiscount,int roomStatus,String remark){
        Room room = new Room(roomNumber,typeId,roomType,roomPrice,roomDiscount,roomStatus,remark);
        room.setRoomId(roomId);
        if(roomService.update(room)!=1) return ResponseTool.failed("更新失败");
        return ResponseTool.success("更新成功");
    }

    @RequestMapping(value = "/{id}")
    public Result getById(@PathVariable Integer id){
        return ResponseTool.success(roomService.selectById(id));
    }

    @RequestMapping(value = "/type/{typeId}")
    public Result getByType(@PathVariable Integer typeId){
        return ResponseTool.success(roomService.selectByType(typeId));
    }

    @RequestMapping(value = "/status/{statusId}")
    public Result getByStatus(@PathVariable Integer statusId){
        return ResponseTool.success(roomService.selectByStatus(statusId));
    }

    @RequestMapping(value = "")
    public Result getAll(){
        return ResponseTool.success(roomService.selectAll());
    }

}
