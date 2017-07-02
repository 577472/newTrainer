package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.TrainerDetails;
import com.cognizant.entity.TrainingShedule;

@Component
public class AddSheduleDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public void addShedule(TrainerDetails obj) {
		em.persist(obj);
		
	}
	
	@Transactional
	public void addShedule1(TrainingShedule trainingShedule) {
		
			em.persist(trainingShedule);
	
	}
	@Transactional
	public TrainerDetails checkTrainerIfAlreadyPresent(int trainerId) {
		
		TrainerDetails trainerDetails=em.find(TrainerDetails.class, trainerId);
		return trainerDetails;
		
	}

}
