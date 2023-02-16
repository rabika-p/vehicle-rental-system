package object;

//Car is a child class of vehicle
public class Car extends Vehicle{
	private String fuelType;
	private int noDoors;

	//constructor for car class
	public Car(int id, String make, String model, String regNo, double topSpeed, double dailyHireRate, 
			String hireAvailable, String fuelType, int noDoors) {
		//refer to parent class constructor (Vehicle)
		super(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable); 
		
		this.fuelType = fuelType;
		this.noDoors = noDoors;	
	}

	//accessors for attributes
	public String getFuelType() {
		return fuelType;
	}
	
	public int getNoDoors() {
		return noDoors;
	}
	
	//accessors for attributes
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public void setDoors(int noDoors) {
		this.noDoors = noDoors;
	}
	
}
