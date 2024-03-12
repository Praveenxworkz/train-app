package com.xworkz.train.dto;

public class TrainDTO {

	private String trainName ;
	private String trainSpeed;
	private String trainColor;
	private int noOfCompartments;
	private int noOfWheels;
	private String trainType ;
	
	
	public TrainDTO() {
		System.out.println("DTO is created");
	}


	public TrainDTO(String trainName, String trainSpeed, String trainColor, int noOfCompartments, int noOfWheels,
			String trainType) {
		super();
		this.trainName = trainName;
		this.trainSpeed = trainSpeed;
		this.trainColor = trainColor;
		this.noOfCompartments = noOfCompartments;
		this.noOfWheels = noOfWheels;
		this.trainType = trainType;
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
		return "TrainDTO [trainName=" + trainName + ", trainSpeed=" + trainSpeed + ", trainColor=" + trainColor
				+ ", noOfCompartments=" + noOfCompartments + ", noOfWheels=" + noOfWheels + ", trainType=" + trainType
				+ "]";
	}
	
	
	
	
}
