package test.java;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ShowSheduleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ShowSheduleTest {
	
	@Autowired
	ShowSheduleDao dao;
	
	
	@Test
	public void retriveShedule(){
		 Date date=new Date(2017,06,29);
	
			
			System.out.println(date);
			dao.retriveShedule(date);
		
		
		
	}
	

}
