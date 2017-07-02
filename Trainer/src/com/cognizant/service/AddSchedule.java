package com.cognizant.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.AddSheduleDao;
import com.cognizant.entity.TrainerDetails;
import com.cognizant.entity.TrainingShedule;
import com.cognizant.exception.TrainerManagementException;
@Component
@Transactional
public class AddSchedule {

	@Autowired
	AddSheduleDao dao;
	public void addShedule1(TrainingShedule trainingShedule) {
		String trainerName=trainingShedule.getTrainerDetails().getTrianername();
		char[] chars=trainerName.toCharArray();
		int count=0;
		for(char c:chars)
		{
			if(!Character.isLetter(c)) {
	        	count++;    	
	        }
	    }
	    if(count>=1)
	{
		throw new TrainerManagementException("TrainerDetails.Trianername:Trainer name should contain only alphabets and space.");
	}
	    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis()); 
		Date inputDate=(Date) trainingShedule.getStartDate();
		
		int id=trainingShedule.getTrainerDetails().getTrainerId();
		System.out.println(id);
		TrainerDetails trainerDetails=dao.checkTrainerIfAlreadyPresent(id);
		if(trainerDetails!=null)
		{
			if(inputDate.after(currentDate) || inputDate.compareTo(currentDate)==0){
			trainingShedule.setTrainerDetails(trainerDetails);
			List<TrainingShedule> trainingSheduleList=new ArrayList<TrainingShedule>();
			trainingSheduleList.add(trainingShedule);
			trainerDetails.setList(trainingSheduleList);
			System.out.println("if null"+trainerDetails);
			}
			else
				throw new TrainerManagementException("startDate:Invalid Date Please Enter Date ");
		}
		else
		{
			if(inputDate.after(currentDate) || inputDate.compareTo(currentDate)==0){
			dao.addShedule1(trainingShedule);}
			else
				throw new TrainerManagementException("startDate:Ivalid Date");
		}
		}
		
		
	}


