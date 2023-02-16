package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import object.Car;
import object.Customer;
import object.Lorry;
import object.MiniBus;
import object.Vehicle;

public class AddRecordsModel {
	
	// method to get common details to be stored for all vehicles
	// returns vehicle object
	public Vehicle extractVehicleDetails(JTextField jTId, JTextField jTMake, JTextField jTModel, 
			JTextField jTRegNo,JTextField jTTopSpeed, JTextField jTHireRate, 
			JRadioButton jRBHireAvailable, JRadioButton jRBNotAvailable) {
		int id = Integer.parseInt(jTId.getText());
		String make = jTMake.getText();
		String model = jTModel.getText();
		String regNo = jTRegNo.getText();
		double topSpeed = Double.parseDouble(jTTopSpeed.getText());
		double hireRate = Double.parseDouble(jTHireRate.getText());
		String hireAvailable = null;
		if (jRBHireAvailable.isSelected()) {
			hireAvailable = jRBHireAvailable.getText();
		}
		else if (jRBNotAvailable.isSelected()) {
			hireAvailable = jRBNotAvailable.getText();
		}
		 return new Vehicle(id, make, model, regNo, topSpeed, hireRate, hireAvailable);
	}
	//to add data into the table model
	public void addVehicle(DefaultTableModel dTMVehicle, Object [] rowVehicle, String vehicle, 
			JTextField jTId, JTextField jTMake, JTextField jTModel,
			JTextField jTRegNo, JTextField jTTopSpeed, JTextField jTHireRate,
			JRadioButton jRBHireAvailable) {
		
			dTMVehicle.addRow(rowVehicle); 
		
		JOptionPane.showMessageDialog(null, "Data added successfully!", 
				vehicle + " added", JOptionPane.INFORMATION_MESSAGE);
		
		resetVehicleDetails(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate, jRBHireAvailable);
	}
	
	//method to empty fields and reset RadioButton choices once a vehicle has been added
	public void resetVehicleDetails(JTextField jTId, JTextField jTMake, JTextField jTModel,
			JTextField jTRegNo, JTextField jTTopSpeed, JTextField jTHireRate,
			JRadioButton jRBHireAvailable) {
		jTId.setText(null);
		jTMake.setText(null);
		jTModel.setText(null);
		jTRegNo.setText(null);
		jTTopSpeed.setText(null);
		jTHireRate.setText(null);
		jRBHireAvailable.setSelected(true);
	}
	//to display details for edit
	public void displayVDetailsForEdit(JTextField jTId, JTextField jTMake, JTextField jTModel,
			JTextField jTRegNo, JTextField jTTopSpeed, JTextField jTHireRate, 
			String id, String make, String model, String regNo, String topSpeed,String hireRate) {
		jTId.setText(id);
		jTId.setEditable(false);
		jTMake.setText(make);
		jTModel.setText(model);
		jTRegNo.setText(regNo);
		jTTopSpeed.setText(topSpeed);
		jTHireRate.setText(hireRate);
	}
	//to check for valid delete
	public void deleteDataRow(DefaultTableModel dTModel, JTable jTable) {
		if (jTable.getSelectedRowCount() == 1) {
			dTModel.removeRow(jTable.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Deleted Successfully!", "Delete"
					 ,JOptionPane.INFORMATION_MESSAGE);
		}
		else if (jTable.getSelectedRowCount() == 0) { 
			JOptionPane.showMessageDialog(null, "Select a row to delete!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
		}
		else if  (jTable.getSelectedRowCount() > 1)  {
			JOptionPane.showMessageDialog(null, "Select one row at a time to delete!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Could not be deleted, Try again!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
		}	
	}
	//to check for valid edit
	public void checkValidEdit(JTable jTable) {
		if (jTable.getSelectedRowCount() < 1) { 
			JOptionPane.showMessageDialog(null, "Select a row to update!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
		}
		else if (jTable.getSelectedRowCount() > 1)  {
			JOptionPane.showMessageDialog(null, "Select one row at a time to update!", "Error"
					 ,JOptionPane.ERROR_MESSAGE);
		}

	}
	//for displaying data to table
	public void displayVDataToTable(DefaultTableModel dTMVehicle, JTable jTblVehicle, int editedId,
			String editedMake, String editedModel, String editedRegNo, double editedTopSpeed,
			double editedHireRate, String editedHireAvailable) {
		dTMVehicle.setValueAt(editedId, jTblVehicle.getSelectedRow(), 0);
		dTMVehicle.setValueAt(editedMake, jTblVehicle.getSelectedRow(), 1);
		dTMVehicle.setValueAt(editedModel, jTblVehicle.getSelectedRow(), 2);
		dTMVehicle.setValueAt(editedRegNo, jTblVehicle.getSelectedRow(), 3);
		dTMVehicle.setValueAt(editedTopSpeed, jTblVehicle.getSelectedRow(), 4);
		dTMVehicle.setValueAt(editedHireRate, jTblVehicle.getSelectedRow(), 5);
		dTMVehicle.setValueAt(editedHireAvailable, jTblVehicle.getSelectedRow(), 6);
	}
	//to extract the text from the option that a user has chosen among two radio buttons
	public String extractSelectedRBText(JRadioButton jRBOne, JRadioButton jRBTwo, String toSet) {
		if (jRBOne.isSelected()) {
			toSet = jRBOne.getText();
		}
		else if (jRBTwo.isSelected()) {
			toSet = jRBTwo.getText();
		}
		return toSet;
	}
	
	//to extract the text from the option that a user has chosen among two radio buttons, updating
	public String changeRBOption(JRadioButton jRBOne, JRadioButton jRBTwo, String toCompareOne, 
			String toCompareTwo,String toSet ) {
		if (toSet.equals(toCompareOne)) {
			jRBOne.setSelected(true);
		}
		else if (toSet.equals(toCompareTwo)) {
			jRBTwo.setSelected(true);
		}
	return toSet;
	}
	//try block for writing data to file
	public void writeTryBlock(DefaultTableModel dTModel, String obj) {
		try {
			writeFile(dTModel, obj);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	//try block for displaying data from file
	public void displayTryBlock(DefaultTableModel dTModel, String obj) {
		try {
			displayData(dTModel, obj);
		} 
	    catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	//write data from table to file based on the object
	private void writeFile(DefaultTableModel dTModel, String obj) throws Exception {
		 for (int i = 0; i < dTModel.getRowCount(); i++) {
			 int id, noDoors, seating;
	         String make, model, regNo, hireAvailable, fuelType, name, address, phone, email, username, password;
	         double topSpeed, hireRate, loading;
	            
             id = noDoors = seating = 0;
	         make = model = regNo = hireAvailable = fuelType = name = address = phone = email = username = 
	        		password = null;
	         topSpeed = hireRate = loading = 0;

	         if (obj.equals("Car")) {
	        	 id = (int) dTModel.getValueAt(i, 0);
	        	 make = (String) dTModel.getValueAt(i, 1);
	        	 model = (String) dTModel.getValueAt(i, 2);
				 regNo = (String) dTModel.getValueAt(i, 3);
				 topSpeed = (double) dTModel.getValueAt(i, 4);
				 hireRate = (double) dTModel.getValueAt(i, 5);
				 hireAvailable = (String) dTModel.getValueAt(i, 6);	
				 fuelType = (String) dTModel.getValueAt(i, 7);
				 noDoors = (int) dTModel.getValueAt(i, 8);       
	         }
	         
	         else if (obj.equals("Mini Bus")) {
				id = (int) dTModel.getValueAt(i, 0);
				make = (String) dTModel.getValueAt(i, 1);
				model = (String) dTModel.getValueAt(i, 2);
				regNo = (String) dTModel.getValueAt(i, 3);
				topSpeed = (double) dTModel.getValueAt(i, 4);
				hireRate = (double) dTModel.getValueAt(i, 5);
				hireAvailable = (String) dTModel.getValueAt(i, 6);	
				seating = (int) dTModel.getValueAt(i, 7);
	        }
	         
	         else if (obj.equals("Lorry")) {
				id = (int) dTModel.getValueAt(i, 0);
				make = (String) dTModel.getValueAt(i, 1);
				model = (String) dTModel.getValueAt(i, 2);
				regNo = (String) dTModel.getValueAt(i, 3);
				topSpeed = (double) dTModel.getValueAt(i, 4);
				hireRate = (double) dTModel.getValueAt(i, 5);
				hireAvailable = (String) dTModel.getValueAt(i, 6);	
				loading = (double) dTModel.getValueAt(i, 7);
			}
	         
	        else if (obj.equals("Customer")) {
	        	id = (int) dTModel.getValueAt(i, 0);
  	            name = (String) dTModel.getValueAt(i, 1);
  	            address = (String) dTModel.getValueAt(i, 2);
  	            phone = (String) dTModel.getValueAt(i, 3);
  	            email = (String) dTModel.getValueAt(i, 4);
  	            username = (String) dTModel.getValueAt(i, 5);
  	            password = (String) dTModel.getValueAt(i, 6);
	        }
	         
	        try {
	        	FileOutputStream fos = null;
            	Car car = null;
            	MiniBus miniBus = null;
            	Lorry lorry = null;
            	Customer customer = null;
	            if (obj.equals("Car")) {
		             car = new Car(id, make, model, regNo, topSpeed, hireRate, hireAvailable, fuelType, 
		            		 noDoors);
		             fos = new FileOutputStream("cars.dat", true);
		             //fos = new FileOutputStream("cars.dat");
	            }
	            else if (obj.equals("Mini Bus")) {
		             miniBus = new MiniBus(id, make, model, regNo, topSpeed, hireRate, hireAvailable,seating);
		             fos = new FileOutputStream("minibuses.dat", true);
		             //fos = new FileOutputStream("minibuses.dat");
		         }
	            else if (obj.equals("Lorry")) {
		             lorry = new Lorry(id, make, model, regNo, topSpeed, hireRate, hireAvailable, loading);
		             fos = new FileOutputStream("lorries.dat", true);
		             //fos = new FileOutputStream("lorries.dat");
		         }
	            else if (obj.equals("Customer")) {
		             customer = new Customer(id, name, address, phone, email, username, password);
		             fos = new FileOutputStream("customers.dat", true);
		             //fos = new FileOutputStream("customers.dat");
		         }
				ObjectOutputStream oos = new ObjectOutputStream(fos){
					protected void writeStreamHeader() {
						 	try {
								reset();
								
							} catch (IOException e) {
							
								e.printStackTrace();
							}
					 }
				};
				if (obj.equals("Car")) {
					oos.writeObject(car);
				 }
				else if (obj.equals("Mini Bus")) {
					oos.writeObject(miniBus);
				}
				else if (obj.equals("Lorry")) {
					oos.writeObject(lorry);
				 }
				else if (obj.equals("Customer")) {
					oos.writeObject(customer);
				 }
				oos.close();
				fos.close();
				
				if (obj.equals("Car")) {	
					FileInputStream fis = new FileInputStream("cars.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Car carObj = null;
					while ((carObj = (Car)ois.readObject())!=null){
						System.out.println("Id: " + carObj.getId() + " Make: " + carObj.getMake() +
								" Model: " + carObj.getModel() + " Reg No: " + carObj.getRegNo() +
								" Top Speed: " + carObj.getTopSpeed() +
								" Daily Hire Rate: " + carObj.getDailyHireRate() +
								" Available to hire? : " + carObj.getHireAvailable() +
								" Fuel Type: " + carObj.getFuelType() + " No Of Doors: " + carObj.getNoDoors()
								);
					}
					ois.close();
					fis.close();
				}
				else if (obj.equals("Mini Bus")) {
					FileInputStream fis = new FileInputStream("minibuses.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					MiniBus mBObj = null;
					while ((mBObj = (MiniBus)ois.readObject())!=null){
						System.out.println("Id: " + mBObj.getId() + " Make: " + mBObj.getMake() +
								" Model: " + mBObj.getModel() + " Reg No: " + mBObj.getRegNo() +
								" Top Speed: " + mBObj.getTopSpeed() +
								" Daily Hire Rate: " + mBObj.getDailyHireRate() +
								" Available to hire? : " + mBObj.getHireAvailable() +
								" Seating Capacity: " + mBObj.getSeatCapacity());
					}
					ois.close();
					fis.close();
					
				}
				else if (obj.equals("Lorry")) {
					FileInputStream fis = new FileInputStream("lorries.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Lorry lObj = null;
					while ((lObj = (Lorry)ois.readObject())!=null){
						System.out.println("Id: " + lObj.getId() + " Make: " + lObj.getMake() +
								" Model: " + lObj.getModel() + " Reg No: " + lObj.getRegNo() +
								" Top Speed: " + lObj.getTopSpeed() +
								" Daily Hire Rate: " + lObj.getDailyHireRate() +
								" Available to hire? : " + lObj.getHireAvailable() +
								" Loading Capacity: " + lObj.getLoadCapacity());
					}
					ois.close();
					fis.close();
					
				}
				else if (obj.equals("Customer")) {
					FileInputStream fis = new FileInputStream("customers.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Customer cObj= null;
					while ((cObj = (Customer)ois.readObject())!=null){
						System.out.println("Id: " + cObj.getId() +
								" Name: " + cObj.getName() + " Address: " + cObj.getAddress() +
								" Phone: " + cObj.getPhone() + " Email: " + cObj.getEmail() +
								" Username: " + cObj.getUsername() + " Password: " + cObj.getAddress()
								);
					}
					ois.close();
					fis.close();
					
				}		
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
	}
	
	//method to empty fields once customer data has been added/ updated
		public void resetCustomerDetails(JTextField jTId, JTextField jTCName, JTextField jTAddress,
				JTextField jTPhone, JTextField jTEmail, JTextField jTUsername, JTextField jTPassword) {
			jTId.setText(null);
			jTCName.setText(null);
			jTAddress.setText(null);
			jTPhone.setText(null);
			jTEmail.setText(null);
			jTUsername.setText(null);
			jTPassword.setText(null);
		}
		
		//to display data into the table based on the object passed
		public void displayData(DefaultTableModel dTModel, String obj) throws Exception {
			try {
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				//if obj is Car
				if (obj.equals("Car")) {
					fis = new FileInputStream("cars.dat");
					ois = new ObjectInputStream(fis);
					Car cObj = null;
					while ((cObj = (Car)ois.readObject())!=null){
						//get car attributes
						int id = cObj.getId();
						String make = cObj.getMake();
						String model = cObj.getModel();
						String regNo = cObj.getRegNo();
						double topSpeed = cObj.getTopSpeed();
						double hireRate = cObj.getDailyHireRate();
						String availableHire = cObj.getHireAvailable();
						String fuelType = cObj.getFuelType();
						int noDOors = cObj.getNoDoors();
						//add to table model
						Object [] rowCars =  {id, make, model, regNo, topSpeed, hireRate,
								availableHire, fuelType, noDOors};
						dTModel.addRow(rowCars);
					}
					ois.close();
					fis.close();
			   }
				//if object is Mini-bus
				else if (obj.equals("Mini Bus")) {
					fis = new FileInputStream("minibuses.dat");
					ois = new ObjectInputStream(fis);
					MiniBus mObj = null;
					while ((mObj = (MiniBus)ois.readObject())!=null){
						//get mini bus attributes
						int id = mObj.getId();
						String make = mObj.getMake();
						String model = mObj.getModel();
						String regNo = mObj.getRegNo();
						double topSpeed = mObj.getTopSpeed();
						double hireRate = mObj.getDailyHireRate();
						String availableHire = mObj.getHireAvailable();
						int seating = mObj.getSeatCapacity();
						// add to table model
						Object [] rowMiniBuses =  {id, make, model, regNo, topSpeed, hireRate,
								availableHire, seating};
						dTModel.addRow(rowMiniBuses);
					}
					ois.close();
					fis.close();
			    } 
				//if object is lorry
			   else if (obj.equals("Lorry")) {
					fis = new FileInputStream("lorries.dat");
					ois = new ObjectInputStream(fis);
					Lorry lObj = null;
					while ((lObj= (Lorry)ois.readObject())!=null){
						//get lorry attributes
						int id = lObj.getId();
						String make = lObj.getMake();
						String model = lObj.getModel();
						String regNo = lObj.getRegNo();
						double topSpeed = lObj.getTopSpeed();
						double hireRate = lObj.getDailyHireRate();
						String availableHire = lObj.getHireAvailable();
						double loading = lObj.getLoadCapacity();
						// add to table model
						Object [] rowLorries =  {id, make, model, regNo, topSpeed, hireRate,
								availableHire, loading};
						dTModel.addRow(rowLorries);
					}
					ois.close();
					fis.close();
			  }
				//if object is customer
			   else if (obj.equals("Customer")) {
					fis = new FileInputStream("customers.dat");
					ois = new ObjectInputStream(fis);
					Customer cObj = null;
					while ((cObj= (Customer)ois.readObject())!=null){
						//get customer attributes
						int id = cObj.getId();
						String name = cObj.getName();
						String address = cObj.getAddress();
						String phone = cObj.getPhone();
						String email = cObj.getEmail();
						String username = cObj.getUsername();
						String password = cObj.getPassword();
						//add to table model
						Object [] rowCustomers =  {id, name, address, phone, email, username,
								password};
						dTModel.addRow(rowCustomers); 
					}
					ois.close();
					fis.close();
			  }
			
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
			
			try {
				if (obj.equals("Car")) {
					FileOutputStream fos = new FileOutputStream("cars.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.close();
					fos.close();
				}
				else if (obj.equals("Mini Bus")) {
					FileOutputStream fos = new FileOutputStream("minibuses.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.close();
					fos.close();
				}
				else if (obj.equals("Lorry")) {
					FileOutputStream fos = new FileOutputStream("lorries.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.close();
					fos.close();
				}
				else if (obj.equals("Customer")) {
					FileOutputStream fos = new FileOutputStream("customers.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.close();
					fos.close();
				}
					 
			} 
			catch (FileNotFoundException e) {
				System.out.println("File Not Found!");
			}
			catch (EOFException e) {
				System.out.println("EOF reached");
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		}
	//check for duplicate id entries
	public boolean checkDuplicateId(DefaultTableModel dTModel, JTextField jTId) {
		boolean found = false;
		 for (int i = 0; i < dTModel.getRowCount(); i++) {
			 int id;
	        	 id = (int) dTModel.getValueAt(i, 0); 
	        	 if (Integer.parseInt(jTId.getText()) == id) {
	        			found = true;
	        	 }
	         }
		 return found;
	         
		 } 
	}
	