package com.hit.hotel.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.room.mapper.ICompMapper;
import com.hit.hotel.room.model.CompModel;
import com.hit.hotel.room.service.ICompService;


@Service("compServiceSM")
@Transactional  //环绕事务Advice的切入点
public class CompServiceImpl implements ICompService {

	@Autowired
	private ICompMapper compMapper=null;
	
	@Override
	public String add(CompModel cm) throws Exception {
		// TODO Auto-generated method stub
		compMapper.insert(cm);
		return cm.getNo();
	}

	@Override
	public void modify(CompModel cm) throws Exception {
		// TODO Auto-generated method stub

		compMapper.update(cm);
	}

	@Override
	public void delete(CompModel cm) throws Exception {
		// TODO Auto-generated method stub

		compMapper.delete(cm);
	}

	@Override
	public List<CompModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return compMapper.selectByAll();
	}

	@Override
	public List<CompModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return compMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return compMapper.selectCountByAll();
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
	public CompModel getByNo(String no) throws Exception {
		// TODO Auto-generated method stub
		return compMapper.selectByNo(no);
	}

}
