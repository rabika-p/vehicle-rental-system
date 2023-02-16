package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import object.Car;
import object.Customer;
import object.Lorry;
import object.MiniBus;

public class MainModel {

	public static String cUsername, cPassword;

	/*validateLogin method that takes user-name and password of staff, checks if credentials are 
	 valid and returns 1 if it is a valid login and 0 if invalid  */

	public int validateLogin(String username, String password) {
		//valid login if username and password is admin
		if (username.equals("admin") && password.equals("admin")) {
			JOptionPane.showMessageDialog(null, "Logged in successfully!", "Welcome", 
					JOptionPane.INFORMATION_MESSAGE);
			return 1;
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Invalid Credentials, Try again!", "Log in Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
	}
	
	/*validateCLogin method that takes user-name and password of customer, checks if credentials are 
	 valid and returns 1 if it is a valid login and 0 if invalid  */
	public int validateCLogin(String username, String password) {
		int i = 0;
		String  uname, psw;
		uname = psw = null;
		try {
			FileInputStream fis = new FileInputStream("customers.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cObj = null;
		
			while ((cObj= (Customer)ois.readObject())!=null){ 
				uname = cObj.getUsername();
				psw = cObj.getPassword();

				if (uname.equals(username) && psw.equals(password)) {
					cUsername = username;
					i = 1;
				}
				
			}
			ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return i;		
	}
	
	// to print customer profile
	public void customerRecords() {
//		if (cUsername.equals(uname)) {
			int id = customerFile().getId();
			String name = customerFile().getName();
			String address = customerFile().getAddress();
			String email = customerFile().getEmail();
			String phone = customerFile().getPhone();
			String uname = customerFile().getUsername();
			String psw = customerFile().getPassword();
			JOptionPane.showMessageDialog(null, "Customer Id: "+ id + "\n\nCustomer Name: "+ name  + 
					"\n\nCustomer Address: "+ address  + "\n\nEmail: "+ email  + "\n\nPhone Number: "+ phone
					 + "\n\nCustomer Username: "+ uname  + "\n\nCustomer Password: "+ psw  , 
					"Your Profile", 
					JOptionPane.INFORMATION_MESSAGE);
		//}	
	}
	
	//get all details of the customer that is currently logged in
	public Customer customerFile() {
		int id = 0;
		String name, address, phone, email, username, password;
		name = address = phone = email = username = password = null;
		try {
			FileInputStream fis = new FileInputStream("customers.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cObj = null;
		
			while ((cObj= (Customer)ois.readObject())!=null){
				
				if (cUsername.equals(cObj.getUsername())) {
					 id = cObj.getId();
					 name = cObj.getName();
					 address = cObj.getAddress();
					 phone = cObj.getPhone();
					 email = cObj.getEmail();
					 username = cObj.getUsername();
					 password = cObj.getPassword();		
				}	
		}
			ois.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new Customer(id, name, address, phone, email, username, password);
		}
	
	//to get attributes of car from car file
	public Car carFile(int vId) {
		int id = 0, noDoors = 0;
		String make, model, regNo, hireAvailable, fuelType;
		double topSpeed = 0.0, dailyHireRate = 0.0;
		make = model = regNo = hireAvailable = fuelType =  null;
		try {
			FileInputStream fis = new FileInputStream("cars.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Car cObj = null;
		
			while ((cObj= (Car)ois.readObject())!=null){
				if (vId == (cObj.getId())) {
					id = cObj.getId();
					make = cObj.getMake();
					model = cObj.getModel();
					regNo = cObj.getRegNo();
					topSpeed = cObj.getTopSpeed();
					dailyHireRate = cObj.getDailyHireRate();
					hireAvailable = cObj.getHireAvailable();
					
					fuelType = cObj.getFuelType();
					noDoors = cObj.getNoDoors();
				}
			}
			ois.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new Car(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, fuelType, noDoors);
			
		}
	//to get attributes of mini-bus from mini-bus file
	public MiniBus miniBusFile(int vId) {
		int id = 0, seatingCapacity = 0;
		String make, model, regNo, hireAvailable;
		double topSpeed = 0.0, dailyHireRate = 0.0;
		make = model = regNo = hireAvailable  =  null;
		try {
			FileInputStream fis = new FileInputStream("minibuses.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			MiniBus mObj = null;
		
			while ((mObj= (MiniBus)ois.readObject())!=null){
				if (vId == (mObj.getId())) {
					id = mObj.getId();
					make = mObj.getMake();
					model = mObj.getModel();
					regNo = mObj.getRegNo();
					topSpeed = mObj.getTopSpeed();
					dailyHireRate = mObj.getDailyHireRate();
					hireAvailable = mObj.getHireAvailable();
					
					seatingCapacity = mObj.getSeatCapacity();
				}
			}
			ois.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new MiniBus(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, seatingCapacity);
			
		}
	//to get attributes of lorry from lorry file
	public Lorry lorryFile(int vId) {
		int id = 0;
		double  loadingCapacity = 0;
		String make, model, regNo, hireAvailable;
		double topSpeed = 0.0, dailyHireRate = 0.0;
		make = model = regNo = hireAvailable  =  null;
		try {
			FileInputStream fis = new FileInputStream("lorries.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Lorry lObj = null;
		
			while ((lObj= (Lorry)ois.readObject())!=null){
				if (vId == lObj.getId()) {
					id = lObj.getId();
					make = lObj.getMake();
					model = lObj.getModel();
					regNo = lObj.getRegNo();
					topSpeed = lObj.getTopSpeed();
					dailyHireRate = lObj.getDailyHireRate();
					hireAvailable = lObj.getHireAvailable();
					
					loadingCapacity = lObj.getLoadCapacity();
				}
			}
			ois.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new Lorry(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, loadingCapacity);
			
		}
	
	public void vehiclesToHire(DefaultTableModel dTModel, String obj) {
		try {
			dTModel.setRowCount(0);  //remove existing rows in the table (if any to prevent duplication)
			displayVehiclesToHire(dTModel, obj);
		} 
	    catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void displayVehiclesToHire(DefaultTableModel dTModel, String obj) throws Exception {
			try {
				FileInputStream fis = null;
				ObjectInputStream ois = null;

				if (obj.equals("Car")) {
					fis = new FileInputStream("cars.dat");
					ois = new ObjectInputStream(fis);
					Car cObj = null;
					while ((cObj = (Car)ois.readObject())!=null){
						String availableHire = cObj.getHireAvailable();
							if (availableHire.equals("Yes")) {
								int id = cObj.getId();
								String make = cObj.getMake();
								String model = cObj.getModel();
								String regNo = cObj.getRegNo();
								double topSpeed = cObj.getTopSpeed();
								double hireRate = cObj.getDailyHireRate();
								
								String fuelType = cObj.getFuelType();
								int noDOors = cObj.getNoDoors();
								
								Object [] rowCars =  {id, make, model, regNo, topSpeed, hireRate,
										availableHire, fuelType, noDOors};
								dTModel.addRow(rowCars);
						}
					}
					ois.close();
					fis.close();
			   }
				else if (obj.equals("Mini Bus")) {
					fis = new FileInputStream("minibuses.dat");
					ois = new ObjectInputStream(fis);
					MiniBus mObj = null;
					while ((mObj = (MiniBus)ois.readObject())!=null){
						String availableHire = mObj.getHireAvailable();
						if (availableHire.equals("Yes")) {
							int id = mObj.getId();
							String make = mObj.getMake();
							String model = mObj.getModel();
							String regNo = mObj.getRegNo();
							double topSpeed = mObj.getTopSpeed();
							double hireRate = mObj.getDailyHireRate();
							int seating = mObj.getSeatCapacity();
							
							Object [] rowMiniBuses =  {id, make, model, regNo, topSpeed, hireRate,
									availableHire, seating};
							dTModel.addRow(rowMiniBuses);
						}
					}
					ois.close();
					fis.close();
			    } 
			   else if (obj.equals("Lorry")) {
					fis = new FileInputStream("lorries.dat");
					ois = new ObjectInputStream(fis);
					Lorry lObj = null;
					
					while ((lObj= (Lorry)ois.readObject())!=null){

						String availableHire = lObj.getHireAvailable();
						if (availableHire.equals("Yes")) {
						
							int id = lObj.getId();
							String make = lObj.getMake();
							String model = lObj.getModel();
							String regNo = lObj.getRegNo();
							double topSpeed = lObj.getTopSpeed();
							double hireRate = lObj.getDailyHireRate();
							double loading = lObj.getLoadCapacity();
							
							Object [] rowLorries =  {id, make, model, regNo, topSpeed, hireRate,
									availableHire, loading};
							dTModel.addRow(rowLorries);

						}
					}
					ois.close();
					fis.close();
			  }
			}
			catch (FileNotFoundException e) {
				System.out.println("file not found");
			}
			catch (EOFException e) {
				System.out.println("EOF reached");
			}
			catch (ClassNotFoundException e) {
				System.out.println("class not found");
			}
			catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public void vehiclesOnHire(DefaultTableModel dTModel, String objType) {
		try {
			dTModel.setRowCount(0); //remove existing rows in the table (if any to prevent duplication)
			displayVehiclesOnHire(dTModel, objType);
		} 
	    catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void displayVehiclesOnHire(DefaultTableModel dTModel, String objType) throws Exception {
			try {
				FileInputStream fis = new FileInputStream("acceptHire.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				int customerId = customerFile().getId();
		
				Customer cusObj = null;
				Object object = null;
				
				int id;
				String make, model, regNo, availableHire;
				double topSpeed, hireRate;
				
				while ((object =ois.readObject())!=null && (cusObj=(Customer)ois.readObject())!=null){
					if (customerId ==  cusObj.getId()) { //display vehicles on loan of the current customer that is logged in
						
						if (object instanceof Car) {
							if (objType.equals("Car")) {
								id = ((Car) object).getId();
								make = ((Car) object).getMake();
								model = ((Car) object).getModel();
								regNo = ((Car) object).getRegNo();
								topSpeed = ((Car) object).getTopSpeed();
								hireRate = ((Car) object).getDailyHireRate();
								availableHire = ((Car) object).getHireAvailable();
								
								String fuelType = ((Car) object).getFuelType();
								int noDOors = ((Car) object).getNoDoors();
								
								Object [] rowCars =  {id, make, model, regNo, topSpeed, hireRate,
										availableHire, fuelType, noDOors};
								dTModel.addRow(rowCars);	
							}
						}
						else if (object instanceof MiniBus) {
							if (objType.equals("Mini Bus")) {
								id = ((MiniBus) object).getId();
								make = ((MiniBus) object).getMake();
								model = ((MiniBus) object).getModel();
								regNo = ((MiniBus) object).getRegNo();
								topSpeed = ((MiniBus) object).getTopSpeed();
								hireRate = ((MiniBus) object).getDailyHireRate();
								availableHire = ((MiniBus) object).getHireAvailable();
								int seating = ((MiniBus) object).getSeatCapacity();
								
								Object [] rowMiniBuses =  {id, make, model, regNo, topSpeed, hireRate,
										availableHire, seating};
								dTModel.addRow(rowMiniBuses);
							}
							
						}
						else if (object instanceof Lorry) {
							if (objType.equals("Lorry")) {
								id = ((Lorry) object).getId();
								make = ((Lorry) object).getMake();
								model = ((Lorry) object).getModel();
								regNo = ((Lorry) object).getRegNo();
								topSpeed = ((Lorry) object).getTopSpeed();
								hireRate = ((Lorry) object).getDailyHireRate();
								availableHire = ((Lorry) object).getHireAvailable();
								double loading = ((Lorry) object).getLoadCapacity();
								
								Object [] rowLorries =  {id, make, model, regNo, topSpeed, hireRate,
										availableHire, loading};
								dTModel.addRow(rowLorries);	
						}
					}
				}
				}
					
					ois.close();

			}
			catch (FileNotFoundException e) {
				System.out.println("file not found");
			}
			catch (EOFException e) {
				System.out.println("EOF reached");
			}
			catch (ClassNotFoundException e) {
				System.out.println("class not found");
			}
			catch (IOException e) {
				e.printStackTrace();
		}
	}

	//request to return a vehicle  
	public void requestReturnV(int vId, String obj) {
		int id;
		String make, model, regNo, hireAvailable;
		double topSpeed, dailyHireRate;
	
		Car carList = null;
		MiniBus minibusList = null;
		Lorry lorryList = null;
		
		int cId = customerFile().getId();
		String name = customerFile().getName();
		String address = customerFile().getAddress();
		String email = customerFile().getEmail();
		String phone = customerFile().getPhone();
		String uname = customerFile().getUsername();
		String psw = customerFile().getPassword();
			if (obj.equals("Car")) {
				id = carFile(vId).getId();
				make = carFile(vId).getMake();
				model = carFile(vId).getModel();
				regNo = carFile(vId).getRegNo();
				topSpeed = carFile(vId).getTopSpeed();
				dailyHireRate = carFile(vId).getDailyHireRate();
				hireAvailable = carFile(vId).getHireAvailable();
				
				int noDoors = carFile(vId).getNoDoors();
				String fuelType = carFile(vId).getFuelType();
				carList = new Car(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, fuelType, noDoors);
						
			}
			
			else if(obj.equals("Mini Bus")){
				id = miniBusFile(vId).getId();
					make = miniBusFile(vId).getMake();
					model = miniBusFile(vId).getModel();
					regNo = miniBusFile(vId).getRegNo();
					topSpeed = miniBusFile(vId).getTopSpeed();
					dailyHireRate = miniBusFile(vId).getDailyHireRate();
					hireAvailable = miniBusFile(vId).getHireAvailable();
					
					int seatingCapacity = miniBusFile(vId).getSeatCapacity();
					minibusList = new MiniBus(cId, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, seatingCapacity);
			}
			else if(obj.equals("Lorry")){
				id = lorryFile(vId).getId();
				make = lorryFile(vId).getMake();
				model = lorryFile(vId).getModel();
				regNo = lorryFile(vId).getRegNo();
				topSpeed = lorryFile(vId).getTopSpeed();
				dailyHireRate = lorryFile(vId).getDailyHireRate();
				hireAvailable = lorryFile(vId).getHireAvailable();
				
				double loadingCapacity = lorryFile(vId).getLoadCapacity();
				lorryList = new Lorry(cId, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, loadingCapacity);	
		}

			Customer cList = new Customer(cId, name, address, phone, email, uname, psw);
			try {
			FileOutputStream fos = new FileOutputStream("requestReturn.dat", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos) {
	
				protected void writeStreamHeader() {
					 	try {
							reset();
							
						} catch (IOException e) {
						
							e.printStackTrace();
						}
				 }
			};
//				FileOutputStream fos = new FileOutputStream("requestReturn.dat");
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
				if (obj.equals("Car")) {
					oos.writeObject(carList);
				}
				else if (obj.equals("Mini Bus")) {
					oos.writeObject(minibusList);
				}
				else if (obj.equals("Lorry")) {
					oos.writeObject(lorryList);
				}
				oos.writeObject(cList);
				
			oos.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (EOFException e) {
				System.out.println("EOF reached");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	public void vehicleWishList(int vId, String obj) {
		int id;
		String make, model, regNo, hireAvailable;
		double topSpeed, dailyHireRate;
	
		Car carList = null;
		MiniBus minibusList = null;
		Lorry lorryList = null;
		
		int cId = customerFile().getId();
		String name = customerFile().getName();
		String address = customerFile().getAddress();
		String email = customerFile().getEmail();
		String phone = customerFile().getPhone();
		String uname = customerFile().getUsername();
		String psw = customerFile().getPassword();
			if (obj.equals("Car")) {
				id = carFile(vId).getId();
				make = carFile(vId).getMake();
				model = carFile(vId).getModel();
				regNo = carFile(vId).getRegNo();
				topSpeed = carFile(vId).getTopSpeed();
				dailyHireRate = carFile(vId).getDailyHireRate();
				hireAvailable = carFile(vId).getHireAvailable();
				
				int noDoors = carFile(vId).getNoDoors();
				String fuelType = carFile(vId).getFuelType();
				carList = new Car(id, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, fuelType, noDoors);	
			}
						
			
			else if(obj.equals("Mini Bus")){
				id = miniBusFile(vId).getId();
				make = miniBusFile(vId).getMake();
				model = miniBusFile(vId).getModel();
				regNo = miniBusFile(vId).getRegNo();
				topSpeed = miniBusFile(vId).getTopSpeed();
				dailyHireRate = miniBusFile(vId).getDailyHireRate();
				hireAvailable = miniBusFile(vId).getHireAvailable();
				
				int seatingCapacity = miniBusFile(vId).getSeatCapacity();
				minibusList = new MiniBus(cId, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, seatingCapacity);

			}
			else if(obj.equals("Lorry")){
				id = lorryFile(vId).getId();
				make = lorryFile(vId).getMake();
				model = lorryFile(vId).getModel();
				regNo = lorryFile(vId).getRegNo();
				topSpeed = lorryFile(vId).getTopSpeed();
				dailyHireRate = lorryFile(vId).getDailyHireRate();
				hireAvailable = lorryFile(vId).getHireAvailable();
				
				double loadingCapacity = lorryFile(vId).getLoadCapacity();
				lorryList = new Lorry(cId, make, model, regNo, topSpeed, dailyHireRate, hireAvailable, loadingCapacity);	
		}

			Customer cList = new Customer(cId, name, address, phone, email, uname, psw);
			try {
			FileOutputStream fos = new FileOutputStream("requestHire.dat", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos) {
	
				protected void writeStreamHeader() {
					 	try {
							reset();
							
						} catch (IOException e) {
						
							e.printStackTrace();
						}
				 }
			};
//				FileOutputStream fos = new FileOutputStream("requestHire.dat");
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
				if (obj.equals("Car")) {
					oos.writeObject(carList);
				}
				else if (obj.equals("Mini Bus")) {
					oos.writeObject(minibusList);
				}
				else if (obj.equals("Lorry")) {
					oos.writeObject(lorryList);
				}
				oos.writeObject(cList);
				
			oos.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (EOFException e) {
				System.out.println("EOF reached");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}
