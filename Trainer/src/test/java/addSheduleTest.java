package test.java;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.AddSheduleDao;
import com.cognizant.entity.TrainerDetails;
import com.cognizant.entity.TrainingShedule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class addSheduleTest {

	
	
	@Autowired
	AddSheduleDao dao;
	private List<TrainingShedule> list=new ArrayList<TrainingShedule>();
	
	@Test
	public void addShedule(){
		TrainerDetails obj=new TrainerDetails(1200,"ASD","roc","java");
		
		
	      Date date=new Date(2017,06,29);
			System.out.println(date);
			TrainingShedule obj1=new TrainingShedule(date,45678,obj);
			list.add(obj1);
			obj.setList(list);
			
			dao.addShedule(obj);
		
		
	
	    
	    
		
		
		
		
		
	}
	
}
