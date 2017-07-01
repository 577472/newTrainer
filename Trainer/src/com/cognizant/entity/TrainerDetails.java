package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TrainerDetails {
	
	@Id
	private Integer trainerId;
	
	private String Trianername;
	private String collageName;
	private String domain;
	
	@OneToMany(mappedBy="TrainerDetails" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private List<TrainingShedule> list;

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrianername() {
		return Trianername;
	}

	public void setTrianername(String trianername) {
		Trianername = trianername;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<TrainingShedule> getList() {
		return list;
	}

	public void setList(List<TrainingShedule> list) {
		this.list = list;
	}

	public TrainerDetails() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TrainerDetails [trainerId=" + trainerId + ", Trianername=" + Trianername + ", collageName="
				+ collageName + ", domain=" + domain + "]";
	}

	public TrainerDetails(Integer trainerId, String trianername, String collageName, String domain) {
		super();
		this.trainerId = trainerId;
		Trianername = trianername;
		this.collageName = collageName;
		this.domain = domain;
	}

	
	
}
