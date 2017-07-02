package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.TrainingShedule;
import com.cognizant.exception.TrainerManagementException;
import com.cognizant.service.AddSchedule;

@Controller
public class ApplySheduleController {
	
	private List<TrainingShedule> list=new ArrayList<TrainingShedule>();
	@Autowired
	AddSchedule service;
boolean flag = true;
	
	
	private static final Logger LOG = Logger.getLogger(ApplySheduleController.class);

	@RequestMapping(value="/applyshedule",method = RequestMethod.GET)
	public String applyShedule(Model model,@ModelAttribute("TrainingShedule") @Valid TrainingShedule TrainingShedule, BindingResult result){
		
		return "addShedule";
		
	}
	
	@RequestMapping(value="/applyShedule", method = RequestMethod.POST)
		public String  initAddShedule(@ModelAttribute("TrainingShedule") @Valid TrainingShedule TrainingShedule, BindingResult result,
				Model model){
		
		try{
		service.addShedule1(TrainingShedule);
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
			}
		} catch (TrainerManagementException e) {
			e.printStackTrace();
			flag = false;
			LOG.error("Validation message: "+e.getMessage());
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			
			result.rejectValue(sb1[0],"", sb1[1]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if (result.hasErrors()) {
			return "addShedule";
		}
		else
		return "success";
		
	}
	

}
