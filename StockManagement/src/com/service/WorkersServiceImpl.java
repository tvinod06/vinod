package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.WorkersDao;
import com.dto.WorkersFormBean;

@Service
public class WorkersServiceImpl implements WorkersService{
	
	@Autowired
	private WorkersDao workersDao;
	
	@Override
	public WorkersFormBean submitWorkersDtl(WorkersFormBean retailBean)
			throws Exception {
		Long stockMstId = workersDao.saveWorkersDtls(retailBean);
		retailBean.setWorkersMstId(stockMstId);
		return retailBean;
	}


}
