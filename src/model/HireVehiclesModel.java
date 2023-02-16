package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import object.Car;
import object.Customer;
import object.Lorry;
import object.MiniBus;
import object.Vehicle;

public class HireVehiclesModel {
	public void requestHireTryBlock(DefaultTableModel dTMCustomers) {
			try {
				dTMCustomers.setRowCount(0); //remove existing rows in the table (if any to prevent duplication)
				requestedHireDisplay(dTMCustomers);
			} 
		    catch (Exception ex) {
				ex.printStackTrace();
			}
	}
	
	public void requestedHireDisplay(DefaultTableModel dTMCustomers) {
		try {

			FileInputStream fis = new FileInputStream("requestHire.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cObj = null, aCObj = null;
			Object object = null, aObject = null;

			String make = null , model = null , regNo = null;
			while ((object = ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
					
					if (object instanceof Car) {
						make = ((Car) object).getMake();
						model = ((Car) object).getModel();
						regNo = ((Car) object).getRegNo();
					}
					else if (object instanceof MiniBus) {
						make = ((MiniBus) object).getMake();
						model = ((MiniBus) object).getModel();
						regNo = ((MiniBus) object).getRegNo();
					}
					else if (object instanceof Lorry) {
						make = ((Lorry) object).getMake();
						model = ((Lorry) object).getModel();
						regNo = ((Lorry) object).getRegNo();	
					}
					Object [] rowCustomers =  {cObj.getId(),cObj.getName(), cObj.getPhone(), make, model, regNo};
					dTMCustomers.addRow(rowCustomers); 
			}
			ois.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reqReturnTryBlock(DefaultTableModel dTMCustomers) {
		try {
			dTMCustomers.setRowCount(0); //remove existing rows in the table (if any to prevent duplication)
			reqReturnDisplay(dTMCustomers);
		} 
	    catch (Exception ex) {
			ex.printStackTrace();
		}
}
	
	public void reqReturnDisplay(DefaultTableModel dTMCustomers) {
		try {
			FileInputStream fis = new FileInputStream("requestReturn.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cObj = null;
			Object object = null;

			String make = null , model = null , regNo = null;
			while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
				if (object instanceof Car) {
					make = ((Car) object).getMake();
					model = ((Car) object).getModel();
					regNo = ((Car) object).getRegNo();
				}
				else if (object instanceof MiniBus) {
					make = ((MiniBus) object).getMake();
					model = ((MiniBus) object).getModel();
					regNo = ((MiniBus) object).getRegNo();
				}
				else if (object instanceof Lorry) {
					make = ((Lorry) object).getMake();
					model = ((Lorry) object).getModel();
					regNo = ((Lorry) object).getRegNo();	
				}
				Object [] rowCustomers =  {cObj.getId(),cObj.getName(), cObj.getPhone(), make, model, regNo};
				dTMCustomers.addRow(rowCustomers); 
			}
			
			ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	//remove selected row from file, add vehicle type and customer to acceptHire file
	public void acceptHire(DefaultTableModel dTModel) {
		int id = 0;
		String name = null, phone = null;
		Car car = null;
		MiniBus minibus = null;
		Lorry lorry = null;
		Customer customer = null;
		String objType = null;  //to get what object to write
		for (int i = 0; i < dTModel.getRowCount(); i++) {
			id = (int) dTModel.getValueAt(i, 0); //to store the customer id
			name = (String) dTModel.getValueAt(i, 1); //to store the customer name
			phone = (String) dTModel.getValueAt(i, 2); //to store the customer phone number
		}
		try {
			FileInputStream fis = new FileInputStream("requestHire.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = null;
			Customer cObj = null;
			
			while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
				if (object instanceof Car) {
					if (id == ((Car) object).getId()) {
						car = new Car(((Car) object).getId(),((Car) object).getMake(),((Car) object).getModel(), 
								((Car) object).getRegNo(), ((Car) object).getTopSpeed(), ((Car) object).getDailyHireRate(),
								((Car) object).getHireAvailable(), ((Car) object).getFuelType(), ((Car) object).getNoDoors());
						objType = "Car";
					}
				}
				else if (object instanceof MiniBus) {
					if (id == ((MiniBus) object).getId()) {
						minibus = new MiniBus(((MiniBus) object).getId(),((MiniBus) object).getMake(),((MiniBus) object).getModel(), 
								((MiniBus) object).getRegNo(), ((MiniBus) object).getTopSpeed(), ((MiniBus) object).getDailyHireRate(),
								((MiniBus) object).getHireAvailable(), ((MiniBus) object).getSeatCapacity());
						objType = "Mini Bus";
						
					}
				}
				else if (object instanceof Lorry) {
					if (id == ((Lorry) object).getId()) {
						lorry = new Lorry(((Lorry) object).getId(),((Lorry) object).getMake(),((Lorry) object).getModel(), 
								((Lorry) object).getRegNo(), ((Lorry) object).getTopSpeed(), ((Lorry) object).getDailyHireRate(),
								((Lorry) object).getHireAvailable(), ((Lorry) object).getLoadCapacity());
						objType = "Lorry";
						
					}
					
				}
				customer = new Customer (id, name, null, phone, null, null, null);
				
			
		}
		ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		
		try {
			FileOutputStream fos = new FileOutputStream("acceptHire.dat", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos) {
	
				protected void writeStreamHeader() {
					 	try {
							reset();
							
						} catch (IOException e) {
						
							e.printStackTrace();
						}
				 }
			};
//			FileOutputStream fos = new FileOutputStream("acceptHire.dat");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if (objType.equals("Car")) {
				oos.writeObject(car);
			}
			else if (objType.equals("Mini Bus")) {
				oos.writeObject(minibus);
			}
			else if (objType.equals("Lorry")) {
				oos.writeObject(lorry);
			}
			
			oos.writeObject(customer);
			
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
		try {
		FileInputStream fis = new FileInputStream("acceptHire.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Customer cObj = null;
		Object object = null;
		
		while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
			if (object instanceof Car) {
				System.out.println(cObj.getId() + " " + cObj.getName()  + " " + ((Car) object).getMake() +   " " +
						((Car) object).getModel() +  " " + ((Car) object).getRegNo());
			}
			else if (object instanceof MiniBus) {
				System.out.println(cObj.getId() +  " " + cObj.getName() +   " " + ((MiniBus) object).getMake() +  " " +
						((MiniBus) object).getModel() +  " " + ((MiniBus) object).getRegNo());
			}
			else if (object instanceof Lorry) {
				System.out.println(cObj.getId() +  " " + cObj.getName() +  " " + ((Lorry) object).getMake() +  " " +
						((Lorry) object).getModel() +  " " + ((Lorry) object).getRegNo());
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
	}
	
	//remove selected row from file, add vehicle type and customer to acceptHire file
	public void acceptReturn(DefaultTableModel dTModel) {
		int id = 0;
		String name = null;
		Car car = null;
		MiniBus minibus = null;
		Lorry lorry = null;
		Customer customer = null;
		String objType = null;  //to get what object to write
		for (int i = 0; i < dTModel.getRowCount(); i++) {
			id = (int) dTModel.getValueAt(i, 0); //to store the customer id
			name = (String) dTModel.getValueAt(i, 1); //to store the customer name
		}
		try {
			FileInputStream fis = new FileInputStream("requestReturn.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = null;
			Customer cObj = null;
			
			while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
				if (object instanceof Car) {
					if (id == ((Car) object).getId()) {
						car = new Car(((Car) object).getId(),((Car) object).getMake(),((Car) object).getModel(), 
								((Car) object).getRegNo(), ((Car) object).getTopSpeed(), ((Car) object).getDailyHireRate(),
								((Car) object).getHireAvailable(), ((Car) object).getFuelType(), ((Car) object).getNoDoors());
						objType = "Car";
					}
				}
				else if (object instanceof MiniBus) {
					if (id == ((MiniBus) object).getId()) {
						minibus = new MiniBus(((MiniBus) object).getId(),((MiniBus) object).getMake(),((MiniBus) object).getModel(), 
								((MiniBus) object).getRegNo(), ((MiniBus) object).getTopSpeed(), ((MiniBus) object).getDailyHireRate(),
								((MiniBus) object).getHireAvailable(), ((MiniBus) object).getSeatCapacity());
						objType = "Mini Bus";
					}
				
				}
				else if (object instanceof Lorry) {
					if (id == ((Lorry) object).getId()) {
						lorry = new Lorry(((Lorry) object).getId(),((Lorry) object).getMake(),((Lorry) object).getModel(), 
								((Lorry) object).getRegNo(), ((Lorry) object).getTopSpeed(), ((Lorry) object).getDailyHireRate(),
								((Lorry) object).getHireAvailable(), ((Lorry) object).getLoadCapacity());
						objType = "Lorry";
					}
					
				}
				customer = new Customer (id, name, null, null, null, null, null);
			
		}
		ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		
	try {
		
			FileOutputStream fos = new FileOutputStream("acceptReturn.dat", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos) {
	
				protected void writeStreamHeader() {
					 	try {
							reset();
							
						} catch (IOException e) {
						
							e.printStackTrace();
						}
				 }
			};
//		FileOutputStream fos = new FileOutputStream("acceptReturn.dat");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		if (objType.equals("Car")) {
			oos.writeObject(car);
		}
		else if (objType.equals("Mini Bus")) {
			oos.writeObject(minibus);
		}
		else if (objType.equals("Lorry")) {
			oos.writeObject(lorry);
		}
		
		oos.writeObject(customer);
		
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
		try {
		FileInputStream fis = new FileInputStream("acceptReturn.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Customer cObj = null;
		Object object = null;
		
		while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
			if (object instanceof Car) {
				System.out.println(cObj.getId() + " " + cObj.getName()  + " " + ((Car) object).getMake() +   " " +
						((Car) object).getModel() +  " " + ((Car) object).getRegNo());
			}
			else if (object instanceof MiniBus) {
				System.out.println(cObj.getId() +  " " + cObj.getName() +   " " + ((MiniBus) object).getMake() +  " " +
						((MiniBus) object).getModel() +  " " + ((MiniBus) object).getRegNo());
			}
			else if (object instanceof Lorry) {
				System.out.println(cObj.getId() +  " " + cObj.getName() +  " " + ((Lorry) object).getMake() +  " " +
						((Lorry) object).getModel() +  " " + ((Lorry) object).getRegNo());
			}
		}
		ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
		
	public void hiredVehicles(DefaultTableModel dTMCustomers) {
		try {
			dTMCustomers.setRowCount(0); //remove existing rows in the table (if any to prevent duplication)
			hiredVehiclesDisplay(dTMCustomers);
		} 
	    catch (Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	public void hiredVehiclesDisplay(DefaultTableModel dTMCustomers) {
		try {
			FileInputStream fis = new FileInputStream("acceptHire.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cObj = null;
			Object object = null;

			String make = null , model = null , regNo = null;
			while ((object =ois.readObject())!=null && (cObj=(Customer)ois.readObject())!=null){
				if (object instanceof Car) {
					make = ((Car) object).getMake();
					model = ((Car) object).getModel();
					regNo = ((Car) object).getRegNo();
				}
				else if (object instanceof MiniBus) {
					make = ((MiniBus) object).getMake();
					model = ((MiniBus) object).getModel();
					regNo = ((MiniBus) object).getRegNo();
				}
				else if (object instanceof Lorry) {
					make = ((Lorry) object).getMake();
					model = ((Lorry) object).getModel();
					regNo = ((Lorry) object).getRegNo();	
				}
				Object [] rowCustomers =  {cObj.getId(),cObj.getName(), cObj.getPhone(), make, model, regNo};
				dTMCustomers.addRow(rowCustomers); 
			}
			
			ois.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (EOFException e) {
			System.out.println("EOF reached");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}