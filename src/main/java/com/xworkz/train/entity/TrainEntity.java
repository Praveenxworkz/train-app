package com.xworkz.train.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "train")
@NamedQuery(name = "TrainEntity.findTrainEntityByTrainName" , query = "from TrainEntity where trainName =: TrAiNnAmE")
@NamedQuery(name = "TrainEntity.getListOfTrainEntity" , query = "from TrainEntity")
@NamedQuery(name = "TrainEntity.deleteByName" , query = "delete from TrainEntity where trainName =: DeleteName")
@NamedQuery(name = "TrainEntity.updateTrainEntityByTrainName" , query = "update TrainEntity set trainName =: TRAINNAME, trainSpeed =: TRAINSPEED, traincolor =: TRAINCOLOR , noOfCompartments =: NOOFCOMPARTMENTS, noOfWheels =: NOOFWHEELS, trainType =: TRAINTYPE  where trainName =: t")
public class TrainEntity {

	@GenericGenerator(name = "x", strategy = "increment")
    @GeneratedValue(generator = "x")
	@Id
	@Column(name = "train_id")
	private int trainId ;
	@Column(name = "train_name")
	private String trainName;
	@Column(name = "train_speed")
	private String trainSpeed;
	@Column(name = "traincolor")
	private String trainColor;
	@Column(name = "compartments")
	private int noOfCompartments;
	@Column(name = "wheels")
	private int noOfWheels;
	@Column(name = "type")
	private String trainType ;
	
	public TrainEntity() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public TrainEntity( String trainName, String trainSpeed, String trainColor, int noOfCompartments,
			int noOfWheels, String trainType) {
		this.trainName = trainName;
		this.trainSpeed = trainSpeed;
		this.trainColor = trainColor;
		this.noOfCompartments = noOfCompartments;
		this.noOfWheels = noOfWheels;
		this.trainType = trainType;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainSpeed() {
		return trainSpeed;
	}

	public void setTrainSpeed(String trainSpeed) {
		this.trainSpeed = trainSpeed;
	}

    public String getTrainColor() {
		return trainColor;
	}

	public void setTrainColor(String trainColor) {
		this.trainColor = trainColor;
	}

	public int getNoOfCompartments() {
		return noOfCompartments;
	}

	public void setNoOfCompartments(int noOfCompartments) {
		this.noOfCompartments = noOfCompartments;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	@Override
	public String toString() {
		return "TrainEntity [trainId=" + trainId + ", trainName=" + trainName + ", trainSpeed=" + trainSpeed
				+ ", trainColor=" + trainColor + ", noOfCompartments=" + noOfCompartments + ", noOfWheels=" + noOfWheels
				+ ", trainType=" + trainType + "]";
	}
	
	        
}
