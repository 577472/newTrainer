package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dao.AddSheduleDao;
import com.cognizant.entity.TrainerDetails;
import com.cognizant.entity.TrainingShedule;

@Controller
public class ApplySheduleController {
	
	private List<TrainingShedule> list=new ArrayList<TrainingShedule>();
	@Autowired
	AddSheduleDao dao;
	@RequestMapping(value="/applyshedule",method = RequestMethod.GET)
	public String applyShedule(Model model){
		model.addAttribute("TrainingShedule", new TrainingShedule());
		model.addAttribute("trainerDetails", new TrainerDetails());
		return "addShedule";
		
	}
	
	@RequestMapping(value="/applyShedule", method = RequestMethod.POST)
		public String  initAddShedule(@ModelAttribute("TrainingShedule") @Valid TrainingShedule TrainingShedule, BindingResult result,
				Model model){
		
		TrainerDetails obj1=TrainingShedule.getTrainerDetails();
			System.out.println("detaals" +TrainingShedule.getTrainerDetails());
			System.out.println("duration"+TrainingShedule.getDuration());
			System.out.println("Date" +TrainingShedule.getStartDate());
			
			list.add(TrainingShedule);
			obj1.setList(list);
			System.out.println(obj1);
			dao.addShedule(obj1);
		
		return "success";
		
	}
	

}
