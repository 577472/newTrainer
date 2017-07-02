package com.cognizant.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ShowSheduleDao;
import com.cognizant.entity.TrainingShedule;

@Component
@Transactional
public class ShowScheduleService {

	
	@Autowired
	ShowSheduleDao showScheduleDao;

	public List<TrainingShedule> retriveShedule(Date date) {
		
		List<TrainingShedule> list=new ArrayList<TrainingShedule>();
		list=showScheduleDao.retriveShedule(date);
		
		return list;
	}
}
