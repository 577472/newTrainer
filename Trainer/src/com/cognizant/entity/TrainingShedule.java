package com.cognizant.entity;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.cognizant.entity.TrainerDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="Training_Schedule")
public class TrainingShedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer sheduleId;
	@Column
	private Date startDate;
	@Column
	private Integer Duration;
	
	@ManyToOne( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JsonManagedReference
	//@JsonIgnore
	@JoinColumn(name="trainer_Id")
	private TrainerDetails TrainerDetails;

	
	
	
	public Integer getSheduleId() {
		return sheduleId;
	}

	public void setSheduleId(Integer sheduleId) {
		this.sheduleId = sheduleId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(Integer duration) {
		Duration = duration;
	}

	public TrainerDetails getTrainerDetails() {
		return TrainerDetails;
	}

	public void setTrainerDetails(TrainerDetails trainerDetails) {
		TrainerDetails = trainerDetails;
	}

	public TrainingShedule() {
		
		// TODO Auto-generated constructor stub
	}

	public TrainingShedule( Date startDate, Integer duration,
			TrainerDetails trainerDetails) {
		super();
		//this.sheduleId = sheduleId;
		this.startDate = startDate;
		Duration = duration;
		TrainerDetails = trainerDetails;
	}

	@Override
	public String toString() {
		return "TrainingShedule [sheduleId=" + sheduleId + ", startDate=" + startDate + ", Duration=" + Duration
				+ ", TrainerDetails=" + TrainerDetails + "]";
	}
	
	

}
