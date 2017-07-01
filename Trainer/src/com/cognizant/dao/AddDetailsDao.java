package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.TrainerDetails;


@Component
public class AddDetailsDao {
	@PersistenceContext
	private EntityManager em;
	
@Transactional
	public void addDetails(TrainerDetails obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		
		
	}

	
	
}
