package object;

//MiniBus is a child class of vehicle
public class MiniBus extends Vehicle {
	private int seatCapacity;
	
	//constructir of minibus class
	public MiniBus(int id, String make, String model, String regNo, double topSpeed, double dailyHireRate, 
			String hireAvailable,int seatCapacity) {
		//refer to parent class constructor (Vehicle)
		super(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable); 
		this.seatCapacity = seatCapacity;
	}
	//accessor for attribute
	public int getSeatCapacity() {
		return seatCapacity;
	}
	//mutator for attribute
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
}
