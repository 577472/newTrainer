package com.cognizant.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.ShowSheduleDao;
import com.cognizant.entity.TrainingShedule;

@Controller
public class ViewScheduleController {
	@Autowired
	ShowSheduleDao dao;
	
	private List<TrainingShedule> trainingShedules = new ArrayList<TrainingShedule>();
	
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public String getViewSchedule(Model model) {
		return "viewSchedule";
	}

	@RequestMapping(value = "/viewSchedule1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TrainingShedule> getviewSchedule1(@RequestParam("startDate") Date date) {
		
		trainingShedules = dao.retriveShedule(date);
System.out.println(trainingShedules);
		return trainingShedules;

	}

	
	

}
