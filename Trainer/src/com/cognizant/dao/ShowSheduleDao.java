package com.cognizant.dao;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.TrainingShedule;

@Component
public class ShowSheduleDao {

	@PersistenceContext
	private EntityManager em;
	@Transactional
	
	
	public List<TrainingShedule> retriveShedule(Date d) {
		// TODO Auto-generated method stub
		 java.sql.Date sqlDate;
		 java.util.Date javaDate=null;
		 if (d != null) 
			 javaDate = new Date(d.getTime());
	        
			Calendar cal = Calendar.getInstance();
		     
		        cal.setTime(javaDate);
		        cal.add(Calendar.DATE, 7);
		        java.util.Date utilDate = cal.getTime();
		       sqlDate = new java.sql.Date(utilDate.getTime());
		       System.out.println(sqlDate);
		Query query = em.createQuery("  from TrainingShedule t where t.startDate between :startDate  and :endDate");
		System.out.println(d);
		query.setParameter("startDate", d);
		query.setParameter("endDate", sqlDate);
		List<TrainingShedule> results = query.getResultList();
		System.out.println(results);
		
		 return results;
	}
	
}

