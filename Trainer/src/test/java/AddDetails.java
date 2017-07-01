package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.AddDetailsDao;
import com.cognizant.entity.TrainerDetails;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class AddDetails {
	


	@Autowired
	AddDetailsDao dao;
	
	@Test
	public void addDetails(){
		
		TrainerDetails obj=new TrainerDetails(1200,"ASD","roc","java");
		dao.addDetails(obj);
	}
	
	

}
