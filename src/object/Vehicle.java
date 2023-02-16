package object;

import java.io.Serializable;

public class Vehicle implements Serializable{
	private int id;
	private String make, model, regNo, hireAvailable;
	private double topSpeed, dailyHireRate;
	
	//constructor of vehicle class
	public Vehicle(int id, String make, String model, String regNo, double topSpeed, double dailyHireRate, 
			String hireAvailable) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.topSpeed = topSpeed;
		this.dailyHireRate = dailyHireRate;
		this.hireAvailable = hireAvailable;
	}
	
	//accessors for attributes
	public int getId() {
		return id;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}

	public String getRegNo() {
		return regNo;
	}

	public double getTopSpeed() {
		return topSpeed;
	}
	
	public double getDailyHireRate() {
		return dailyHireRate;
	}
	public String getHireAvailable() {
		return hireAvailable;
	}
	
	//mutators for attributes
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public void setDailyHireRate(double dailyHireRate) {
		this.dailyHireRate = dailyHireRate;
	}
	public void setHireAvailable(String hireAvailable) {
		this.hireAvailable = hireAvailable;
	}
	//return details variable with all attributes related to a vehicle
	@Override
	public String toString() {
		String details = "Id: " + id + " Make: " + make + " Model: " + model + 
				" Reg No: " + regNo + " Top Speed: " + topSpeed + " Daily Hire Rate: " 
				+ dailyHireRate + " Hire Available?: " + hireAvailable;
		return details;
	}
	
}