package com.hit.hotel.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.room.mapper.IRoomMapper;
import com.hit.hotel.room.model.RoomModel;
import com.hit.hotel.room.service.IRoomService;

@Service("roomServiceSM")
@Transactional  //环绕事务Advice的切入点
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomMapper roomMapper=null;
	
	@Override
	public int add(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		roomMapper.insert(rm);
		return rm.getNo();
	}

	@Override
	public void modify(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		roomMapper.update(rm);
	}

	@Override
	public void delete(RoomModel rm) throws Exception {
		// TODO Auto-generated method stub
		roomMapper.delete(rm);
	}

	@Override
	public List<RoomModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.selectByAll();
	}

	@Override
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		int count=this.getCountByAll();
		int pageCount=0;
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		
		return pageCount;
	}

	@Override
	public RoomModel getByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.selectByNo(no);
	}

}
