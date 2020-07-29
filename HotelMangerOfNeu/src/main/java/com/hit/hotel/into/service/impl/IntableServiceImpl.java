package com.hit.hotel.into.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.into.mapper.IIntableMapper;
import com.hit.hotel.into.model.IntableModel;
import com.hit.hotel.into.service.IIntableService;


@Service("intableServiceSM")
@Transactional  //环绕事务Advice的切入点
public class IntableServiceImpl implements IIntableService {

	
	@Autowired
	private IIntableMapper intableMapper=null;
	
	@Override
	public String add(IntableModel im) throws Exception {
		// TODO Auto-generated method stub
		intableMapper.insert(im);
		return im.getCode();
	}

	@Override
	public void modify(IntableModel im) throws Exception {
		// TODO Auto-generated method stub

		intableMapper.update(im);
	}

	@Override
	public void delete(IntableModel im) throws Exception {
		// TODO Auto-generated method stub

		intableMapper.delete(im);
	}

	@Override
	public List<IntableModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return intableMapper.selectByAll();
	}

	@Override
	public List<IntableModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return intableMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return intableMapper.selectCountByAll();
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
	public IntableModel getByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return intableMapper.selectByCode(code);
	}

	@Override
	public List<IntableModel> getListByConditionWithPageWithGuest(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return intableMapper.selectListByAllWithPageWithGuest(rows*(page-1), rows);
	}

}
