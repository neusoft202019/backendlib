package com.hit.hotel.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.into.model.GuestModel;
import com.hit.hotel.room.mapper.IGoodsMapper;
import com.hit.hotel.room.model.GoodsModel;
import com.hit.hotel.room.service.IGoodsService;

@Service("goodsServiceSM")
@Transactional  //环绕事务Advice的切入点
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsMapper goodsMapper=null;
	
	@Override
	public int add(GoodsModel gm) throws Exception {
		// TODO Auto-generated method stub
		goodsMapper.insert(gm);
		return gm.getNo();
	}

	@Override
	public void modify(GoodsModel gm) throws Exception {
		// TODO Auto-generated method stub
		goodsMapper.update(gm);

	}

	@Override
	public void delete(GoodsModel gm) throws Exception {
		// TODO Auto-generated method stub
		goodsMapper.delete(gm);

	}

	@Override
	public List<GoodsModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return goodsMapper.selectByAll();
	}

	@Override
	public List<GoodsModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return goodsMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return goodsMapper.selectCountByAll();
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
	public GoodsModel getByNo(int no) throws Exception {
		return goodsMapper.selectByNo(no);
	}

	@Override
	public List<GoodsModel> getListByConditionWithPageWithRoom(int rows, int page) throws Exception {
		return goodsMapper.selectListByAllWithPageWithRoom(rows*(page-1), rows);
	}

	@Override
	public int getCountByCondition(int lowPrice, int highPrice, int roomNo) {
		
		return goodsMapper.selectCountByCondition(lowPrice, highPrice, roomNo);
	}

	@Override
	public List<GoodsModel> getListByConditionWithPageWithDepartment(int rows, int page, int lowPrice, int highPrice,
			int roomNo) {
		return goodsMapper.selectListByConditionWithPageWithDepartment(rows*(page-1), rows, lowPrice, highPrice, roomNo);
	}

	@Override
	public int getPageCountByCondition(int lowPrice, int highPrice, int roomNo, int rows) {
		
		int count=this.getCountByCondition(lowPrice, highPrice,  roomNo);
		int pageCount=0;
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	
	

}
