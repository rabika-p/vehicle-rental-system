package object;

//Lorry is a child class of vehicle
public class Lorry extends Vehicle {
	private double loadCapacity;
	
	//constructor for lorry class
	public Lorry(int id, String make, String model, String regNo, double topSpeed, double dailyHireRate, 
			String hireAvailable, double loadCapacity) {
		//refer to parent class constructor (Vehicle)
		super(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable); 
		
		this.loadCapacity = loadCapacity;	
	}
	//accessor for attribute
	public double getLoadCapacity() {
		return loadCapacity;
	}
	//mutator for attribute
	public void setLoadCapacity(double loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
}
