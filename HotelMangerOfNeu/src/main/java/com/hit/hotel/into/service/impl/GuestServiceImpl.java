package com.hit.hotel.into.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hit.hotel.hr.model.EmployeeModel;
import com.hit.hotel.into.mapper.IGuestMapper;
import com.hit.hotel.into.model.GuestModel;
import com.hit.hotel.into.service.IGuestService;

@Service("guestServiceSM")
@Transactional  //环绕事务Advice的切入点
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestMapper guestMapper=null;
	
	@Override
	public String add(GuestModel gm) throws Exception {
		// TODO Auto-generated method stub
		guestMapper.insert(gm);
		return gm.getNo();
	}

	@Override
	public void modify(GuestModel gm) throws Exception {
		// TODO Auto-generated method stub

		guestMapper.update(gm);
	}

	@Override
	public void delete(GuestModel gm) throws Exception {
		// TODO Auto-generated method stub

		guestMapper.delete(gm);
	}

	@Override
	public List<GuestModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return guestMapper.selectByAll();
	}

	@Override
	public List<GuestModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return guestMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return guestMapper.selectCountByAll();
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
	public GuestModel getByNo(String no) throws Exception {
		// TODO Auto-generated method stub
		return guestMapper.selectByNo(no);
	}



	@Override
	public int getCountByCondition(int lowAge, int highAge,String sex, String nameKey) {
		if(nameKey!=null&&nameKey.trim().length()>0) {
			nameKey="%"+nameKey+"%";
		}
		return guestMapper.selectCountByCondition(lowAge, highAge, sex, nameKey);
	}
	
	@Override
	public int getPageCountByCondition(int lowAge, int highAge,String sex, String nameKey,int rows) throws Exception {
		if(nameKey!=null&&nameKey.trim().length()>0) {
			nameKey="%"+nameKey+"%";
		}
		int count=this.getCountByCondition(lowAge, highAge,  sex, nameKey);
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
	public List<GuestModel> getListByConditionWithPageWithDepartment(int rows, int page,int lowAge, int highAge, String sex, String nameKey) {
		if(nameKey!=null&&nameKey.trim().length()>0) {
			nameKey="%"+nameKey+"%";
		}
		
		return guestMapper.selectListByConditionWithPageWithDepartment(rows*(page-1), rows, lowAge, highAge, sex, nameKey);
	}
	
	

}
