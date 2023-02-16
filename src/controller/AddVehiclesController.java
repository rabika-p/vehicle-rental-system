package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.AddRecordsModel;
import object.Vehicle;
import view.AddVehiclesView;
import view.StaffMenuView;

public class AddVehiclesController implements ActionListener {
	//Model and view for AddVehiclesController
	private AddRecordsModel addRecordsModel;
	private AddVehiclesView addVehiclesView;
	
	//parameterized constructor, pass respective model and view to controller
	public AddVehiclesController(AddRecordsModel addRecordsModel, AddVehiclesView addVehiclesView) {
		this.addRecordsModel = addRecordsModel;
		this.addVehiclesView = addVehiclesView;
		
		//Add action-listeners to JButtons from addVehiclesView
		this.addVehiclesView.getJBBack().addActionListener(this);
		
		this.addVehiclesView.getJBAddCar().addActionListener(this);
		this.addVehiclesView.getJBEditCar().addActionListener(this);
		this.addVehiclesView.getJBUpdateCar().addActionListener(this);
		this.addVehiclesView.getJBDisplayCar().addActionListener(this);
		this.addVehiclesView.getJBDeleteCar().addActionListener(this);
		this.addVehiclesView.getJBSaveCar().addActionListener(this);
		
		
		this.addVehiclesView.getJBAddMB().addActionListener(this);
		this.addVehiclesView.getJBEditMB().addActionListener(this);
		this.addVehiclesView.getJBUpdateMB().addActionListener(this);
		this.addVehiclesView.getJBDisplayMB().addActionListener(this);
		this.addVehiclesView.getJBDeleteMB().addActionListener(this);
		this.addVehiclesView.getJBSaveMB().addActionListener(this);
		
		this.addVehiclesView.getJBAddLorry().addActionListener(this);
		this.addVehiclesView.getJBEditLorry().addActionListener(this);
		this.addVehiclesView.getJBUpdateLorry().addActionListener(this);
		this.addVehiclesView.getJBDisplayLorry().addActionListener(this);
		this.addVehiclesView.getJBDeleteLorry().addActionListener(this);
		this.addVehiclesView.getJBSaveLorry().addActionListener(this);
		
		//Add action-listeners to radio buttons from addVehiclesView
		this.addVehiclesView.getJRBCar().addActionListener(this);
		this.addVehiclesView.getJRBMiniBus().addActionListener(this);
		this.addVehiclesView.getJRBLorry().addActionListener(this);	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//store getters into variables that are used often
		 DefaultTableModel dTMCars = addVehiclesView.getDTMCars();
		 DefaultTableModel dTMMiniBuses = addVehiclesView.getDTMMiniBuses();
		 DefaultTableModel dTMLorries = addVehiclesView.getDTMLorries();
		 
		 JTable jTblCars = addVehiclesView.getJTblCars();
		 JTable jTblMiniBuses = addVehiclesView.getJTblMiniBuses();
		 JTable jTblLorries = addVehiclesView.getJTblLorries();
		 
		 JTextField jTId = addVehiclesView.getJTId();
		 JTextField jTMake = addVehiclesView.getJTMake();
		 JTextField jTModel = addVehiclesView.getJTModel();
		 JTextField jTRegNo = addVehiclesView.getJTRegNo();
		 JTextField jTTopSpeed = addVehiclesView.getJTTopSpeed();
		 JTextField jTHireRate = addVehiclesView.getJTHireRate();
		 JTextField jTNoDoors = addVehiclesView.getJTNoDoors();
		 JTextField jTSeating = addVehiclesView.getJTSeating();
		 JTextField jTLoading = addVehiclesView.getJTLoading();
		 
		 JRadioButton jRBHireAvailable = addVehiclesView.getJRBHireAvailable();
		 JRadioButton jRBNotAvailable = addVehiclesView.getJRBNotAvailable();
		 JRadioButton jRBPetrol = addVehiclesView.getjRBPetrol();
		 JRadioButton jRBDiesel = addVehiclesView.getjRBDiesel();
		 
		 /* Check for button presses and perform functionality based on it (display button is to be
		  * pressed first to load data from the file, to which new data can be added, edited, or 
		  deleted which is loaded into the file on pressing save to file button. */
			
		if (e.getSource()== addVehiclesView.getJBAddCar()) {
				int id = 0;
				String make = null, model = null, regNo = null, hireAvailable = null;
				double topSpeed = 0,  hireRate = 0;
				
				//to get common details to be stored for all vehicles, method returns object
				Vehicle v =  getVehicleDetails();
				
				//get all details to be stored when adding a car
				String fuelType = null;
				
				//check for selected radio button and store in string
				fuelType = addRecordsModel.extractSelectedRBText(jRBPetrol, jRBDiesel, fuelType);
				
				int noDoors = Integer.parseInt(jTNoDoors.getText());
				//get details entered in text-boxes by user
				id = v.getId();
				make = v.getMake();
				model = v.getModel();
				regNo = v.getRegNo();
				topSpeed = v.getTopSpeed();
				hireRate = v.getDailyHireRate();
				hireAvailable = v.getHireAvailable();
				
				//check for any empty inputs, display error if found.
				if (make.equals("") || model.equals("") || regNo.equals("") ) {
					JOptionPane.showMessageDialog(null, "All fields are mandatory!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);	
				}
				//check for duplicate entry of id
				else if (addRecordsModel.checkDuplicateId(dTMCars, jTId) == true){
					JOptionPane.showMessageDialog(null, "Duplicate id!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);
				}
				//if no errors found, add new car and display in the JTable
				else {
					Object [] rowCars =  {id, make, model, regNo, topSpeed, hireRate, hireAvailable,
											fuelType, noDoors};
					addRecordsModel.addVehicle(dTMCars, rowCars, "Car",
							jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate, jRBHireAvailable);
					jTNoDoors.setText(null);
					
				}	
		}
		
		if (e.getSource()== addVehiclesView.getJBDeleteCar()) {
			//to delete a row of car record
			addRecordsModel.deleteDataRow(dTMCars, jTblCars);	
		}
		
		if (e.getSource()== addVehiclesView.getJBEditCar()) {
			// check for invalid edit tries by the staff, example trying to edit more than one record at a time
			addRecordsModel.checkValidEdit(jTblCars);
			
			//can only edit one record at a time
			if (jTblCars.getSelectedRowCount() == 1) {
				//get current values of car attribute to be edited
				String id = dTMCars.getValueAt(jTblCars.getSelectedRow(), 0).toString();
				String make = dTMCars.getValueAt(jTblCars.getSelectedRow(), 1).toString();
				String model = dTMCars.getValueAt(jTblCars.getSelectedRow(), 2).toString();
				String regNo = dTMCars.getValueAt(jTblCars.getSelectedRow(), 3).toString();
				String topSpeed = dTMCars.getValueAt(jTblCars.getSelectedRow(), 4).toString();
				String hireRate = dTMCars.getValueAt(jTblCars.getSelectedRow(), 5).toString();
				String hireAvailable = dTMCars.getValueAt(jTblCars.getSelectedRow(), 6).toString();
				String fuelType =dTMCars.getValueAt(jTblCars.getSelectedRow(), 7).toString();
				String noDoors = dTMCars.getValueAt(jTblCars.getSelectedRow(), 8).toString();
				//Display update button instead of add
				addVehiclesView.getJBAddCar().setEnabled(false);
				addVehiclesView.getJBUpdateCar().setEnabled(true);
				//display vehicles details from the table to the form to be edited
				addRecordsModel.displayVDetailsForEdit(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate, 
						id, make, model, regNo, topSpeed, hireRate);
				jTNoDoors.setText(noDoors);

				addRecordsModel.changeRBOption(jRBPetrol, jRBDiesel, "Petrol", "Diesel", fuelType);
				addRecordsModel.changeRBOption(jRBHireAvailable, jRBNotAvailable, "Yes", "No", hireAvailable);
			}			
		}
		
		if (e.getSource()== addVehiclesView.getJBUpdateCar()) {
			//replace old record in the table with edited data from the JTextFields
				int editedId = Integer.parseInt(jTId.getText());
				String editedMake = jTMake.getText();
				String editedModel = jTModel.getText();
				String editedRegNo = jTRegNo.getText();
				double editedTopSpeed = Double.parseDouble(jTTopSpeed.getText());
				double editedHireRate = Double.parseDouble(jTHireRate.getText());
				String editedFuelType = null;
				
				//check for selected radio button and store in string
				editedFuelType = addRecordsModel.extractSelectedRBText(jRBPetrol, jRBDiesel, 
																		editedFuelType);
				
				int editedNoDoors =Integer.parseInt(jTNoDoors.getText());
				String editedHireAvailable = null;
				editedHireAvailable = addRecordsModel.extractSelectedRBText(jRBHireAvailable, 
															jRBNotAvailable, editedHireAvailable);
	
				addRecordsModel.displayVDataToTable(dTMCars, jTblCars, editedId, editedMake, 
						editedModel, editedRegNo, editedTopSpeed, editedHireRate, editedHireAvailable);
				dTMCars.setValueAt(editedFuelType, jTblCars.getSelectedRow(), 7);
				dTMCars.setValueAt(editedNoDoors, jTblCars.getSelectedRow(), 8);
				
				
				JOptionPane.showMessageDialog(null, "Data updated successfully!", 
						"Car updated", JOptionPane.INFORMATION_MESSAGE); 
				//reset JTextFields after successfully updating data
				addRecordsModel.resetVehicleDetails(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed,
						jTHireRate, jRBHireAvailable);
				jTNoDoors.setText(null);
				jRBPetrol.setSelected(true);
				//Display add button instead of update, make id editable for adding new record
				jTId.setEditable(true);
				addVehiclesView.getJBUpdateCar().setEnabled(false);
				addVehiclesView.getJBAddCar().setEnabled(true);
		}
		
		if (e.getSource()== addVehiclesView.getJBDisplayCar()) {
			//enable other buttons only after display is pressed (file data is loaded after pressing
			//display records which can be then added to, edited or deleted
			addVehiclesView.getJBDisplayCar().setEnabled(false);	
			
			addVehiclesView.getJBAddCar().setEnabled(true);
			addVehiclesView.getJBEditCar().setEnabled(true);
			addVehiclesView.getJBDeleteCar().setEnabled(true);
			addVehiclesView.getJBSaveCar().setEnabled(true);
			
			addRecordsModel.displayTryBlock(dTMCars, "Car");
		}
		
		if (e.getSource()== addVehiclesView.getJBSaveCar()) {
			//store data to file if save is pressed
			addRecordsModel.writeTryBlock(dTMCars, "Car");
		}
		
		if (e.getSource()== addVehiclesView.getJBAddMB()) {
				int id = 0;
				String make = null, model = null, regNo = null, hireAvailable = null;
				double topSpeed = 0,  hireRate = 0;
				
				//to get common details to be stored for all vehicles, method returns object
				Vehicle v =  getVehicleDetails();
				
				int seating = Integer.parseInt(jTSeating.getText());
				
				//get details entered in text-boxes by user
				id = v.getId();
				make = v.getMake();
				model = v.getModel();
				regNo = v.getRegNo();
				topSpeed = v.getTopSpeed();
				hireRate = v.getDailyHireRate();
				hireAvailable = v.getHireAvailable();
				//check for any empty inputs, display error if found.
				if (make.equals("") || model.equals("") || regNo.equals("") ) {
					JOptionPane.showMessageDialog(null, "All fields are mandatory!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);
				}
				//check for duplicate entry of id
				else if (addRecordsModel.checkDuplicateId(dTMMiniBuses, jTId) == true){
					JOptionPane.showMessageDialog(null, "Duplicate id!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);
				}
				//if no errors found, add new mini-bus and display in the JTable
				else {
					Object [] rowMiniBuses =  {id, make, model, regNo, topSpeed, hireRate, hireAvailable, 
											seating};
					addRecordsModel.addVehicle(dTMMiniBuses, rowMiniBuses, "Mini Bus",
							jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate, jRBHireAvailable);
					jTSeating.setText(null);
				}	
		}
		
		if (e.getSource()== addVehiclesView.getJBDeleteMB()) {
			//to delete a row of mini-bus record
			addRecordsModel.deleteDataRow(dTMMiniBuses, jTblMiniBuses);	
		}
		
		if (e.getSource()== addVehiclesView.getJBEditMB()) {	
			// check for invalid edit tries by the staff, example trying to edit more than one record at a time
			addRecordsModel.checkValidEdit(jTblMiniBuses);
				//can only edit one record at a time
			
			if (jTblMiniBuses.getSelectedRowCount() == 1) {
				//get current values of mini-bus attribute to be edited
				String id = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 0).toString();
				String make = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 1).toString();
				String model = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 2).toString();
				String regNo = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 3).toString();
				String topSpeed = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 4).toString();
				String hireRate = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 5).toString();
				String hireAvailable = dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 6).toString();
				String seating  =dTMMiniBuses.getValueAt(jTblMiniBuses.getSelectedRow(), 7).toString();
				//Display update button instead of add
				addVehiclesView.getJBAddMB().setEnabled(false);
				addVehiclesView.getJBUpdateMB().setEnabled(true);
				//display vehicles details from the table to the form to be edited
				addRecordsModel.displayVDetailsForEdit(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, 
						jTHireRate, id, make, model, regNo, topSpeed, hireRate);
				jTSeating.setText(seating);
				
				addRecordsModel.changeRBOption(jRBHireAvailable, jRBNotAvailable, "Yes", "No",
						hireAvailable);
			}
		}
		
		if (e.getSource()== addVehiclesView.getJBUpdateMB()) {
			//replace old record in the table with edited data from the JTextFields
				int editedId = Integer.parseInt(jTId.getText());
				String editedMake = jTMake.getText();
				String editedModel = jTModel.getText();
				String editedRegNo = jTRegNo.getText();
				double editedTopSpeed = Double.parseDouble(jTTopSpeed.getText());
				double editedHireRate = Double.parseDouble(jTHireRate.getText());
	
				int editedSeating = Integer.parseInt(jTSeating.getText());
				String editedHireAvailable = null;
				editedHireAvailable = addRecordsModel.extractSelectedRBText(jRBHireAvailable, 
															jRBNotAvailable, editedHireAvailable);
	
				addRecordsModel.displayVDataToTable(dTMMiniBuses, jTblMiniBuses, editedId, editedMake, 
						editedModel, editedRegNo, editedTopSpeed, editedHireRate, editedHireAvailable);
				
				dTMMiniBuses.setValueAt(editedSeating, jTblMiniBuses.getSelectedRow(), 7);
				
				
				JOptionPane.showMessageDialog(null, "Data updated successfully!", 
						"Mini Bus updated", JOptionPane.INFORMATION_MESSAGE); 
				//reset JTextFields after successfully updating data
				addRecordsModel.resetVehicleDetails(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed,
						jTHireRate, jRBHireAvailable);
				//Display add button instead of update, make id editable for adding new record
				jTSeating.setText(null);
				jRBPetrol.setSelected(true);
				jTId.setEditable(true);
				addVehiclesView.getJBUpdateMB().setEnabled(false);
				addVehiclesView.getJBAddMB().setEnabled(true);

		}
		
		if (e.getSource()== addVehiclesView.getJBDisplayMB()) {
			//enable other buttons only after display is pressed (file data is loaded after pressing
			//display records which can be then added to, edited or deleted
			addVehiclesView.getJBDisplayMB().setEnabled(false);
	
			addVehiclesView.getJBAddMB().setEnabled(true);
			addVehiclesView.getJBEditMB().setEnabled(true);
			addVehiclesView.getJBDeleteMB().setEnabled(true);
			addVehiclesView.getJBSaveMB().setEnabled(true);			
			addRecordsModel.displayTryBlock(dTMMiniBuses, "Mini Bus");
		}
		

		if (e.getSource()== addVehiclesView.getJBSaveMB()) {
			//store data to file if save is pressed
			addRecordsModel.writeTryBlock(dTMMiniBuses, "Mini Bus");
		}
		
		if (e.getSource()== addVehiclesView.getJBAddLorry()) {
				int id = 0;
				String make = null, model = null, regNo = null, hireAvailable = null;
				double topSpeed = 0,  hireRate = 0;
				
				//to get common details to be stored for all vehicles, method returns object
				Vehicle v =  getVehicleDetails();
				
				double loading = Double.parseDouble(jTLoading.getText());
				
				//get details entered in text-boxes by user
				id = v.getId();
				make = v.getMake();
				model = v.getModel();
				regNo = v.getRegNo();
				topSpeed = v.getTopSpeed();
				hireRate = v.getDailyHireRate();
				hireAvailable = v.getHireAvailable();
				//check for any empty inputs, display error if found.
				if (make.equals("") || model.equals("") || regNo.equals("") ) {
					JOptionPane.showMessageDialog(null, "All fields are mandatory!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);
				}
				//check for duplicate entry of id
				else if (addRecordsModel.checkDuplicateId(dTMLorries, jTId) == true){
					JOptionPane.showMessageDialog(null, "Duplicate id!", "Error"
							 ,JOptionPane.ERROR_MESSAGE);
				}
				//if no errors found, add new lorry and display in the JTable
				else {
					Object [] rowLorries =  {id, make, model, regNo, topSpeed, hireRate, hireAvailable, 
											loading};
					addRecordsModel.addVehicle(dTMLorries, rowLorries, "Lorry",
							jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate, jRBHireAvailable);
					jTLoading.setText(null);
				}	
		}
		
		if (e.getSource()== addVehiclesView.getJBDeleteLorry()) {
			//to delete a row of lorry record
			addRecordsModel.deleteDataRow(dTMLorries, jTblLorries);	
		}
		
		if (e.getSource()== addVehiclesView.getJBEditLorry()) {	
			// check for invalid edit tries by the staff, example trying to edit more than one record at a time
			addRecordsModel.checkValidEdit(jTblLorries);
			//can only edit one record at a time
			if (jTblLorries.getSelectedRowCount() == 1) {
				//get current values of lorry attribute to be edited
				String id = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 0).toString();
				String make = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 1).toString();
				String model = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 2).toString();
				String regNo = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 3).toString();
				String topSpeed = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 4).toString();
				String hireRate = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 5).toString();
				String hireAvailable = dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 6).toString();
				String loading  =dTMLorries.getValueAt(jTblLorries.getSelectedRow(), 7).toString();
				//Display update button instead of add
				addVehiclesView.getJBAddLorry().setEnabled(false);
				addVehiclesView.getJBUpdateLorry().setEnabled(true);
				
				//display vehicles details from the table to the form to be edited
				addRecordsModel.displayVDetailsForEdit(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, 
						jTHireRate, id, make, model, regNo, topSpeed, hireRate);
				jTLoading.setText(loading);
				
				addRecordsModel.changeRBOption(jRBHireAvailable, jRBNotAvailable, "Yes", "No",
						hireAvailable);
			}
		}
		
		if (e.getSource()== addVehiclesView.getJBUpdateLorry()) {
			//replace old record in the table with edited data from the JTextFields
				int editedId = Integer.parseInt(jTId.getText());
				String editedMake = jTMake.getText();
				String editedModel = jTModel.getText();
				String editedRegNo = jTRegNo.getText();
				double editedTopSpeed = Double.parseDouble(jTTopSpeed.getText());
				double editedHireRate = Double.parseDouble(jTHireRate.getText());
	
				double editedLoading = Double.parseDouble(jTLoading.getText());
				String editedHireAvailable = null;
				editedHireAvailable = addRecordsModel.extractSelectedRBText(jRBHireAvailable, 
															jRBNotAvailable, editedHireAvailable);
	
				addRecordsModel.displayVDataToTable(dTMLorries, jTblLorries, editedId, editedMake, 
						editedModel, editedRegNo, editedTopSpeed, editedHireRate, editedHireAvailable);
				
				dTMLorries.setValueAt(editedLoading, jTblLorries.getSelectedRow(), 7);
				
				JOptionPane.showMessageDialog(null, "Data updated successfully!", 
						"Lorry updated", JOptionPane.INFORMATION_MESSAGE); 
				//reset JTextFields after successfully updating data
				addRecordsModel.resetVehicleDetails(jTId, jTMake, jTModel, jTRegNo, jTTopSpeed,
						jTHireRate, jRBHireAvailable);
				
				jTLoading.setText(null);
				jRBPetrol.setSelected(true);
				//Display add button instead of update, make id editable for adding new record
				jTId.setEditable(true);
				addVehiclesView.getJBUpdateLorry().setEnabled(false);
				addVehiclesView.getJBAddLorry().setEnabled(true);
		}
		
		if (e.getSource()== addVehiclesView.getJBDisplayLorry()) {
			//enable other buttons only after display is pressed (file data is loaded after pressing
			//display records which can be then added to, edited or deleted
			addVehiclesView.getJBDisplayCar().setEnabled(false);
		
			addVehiclesView.getJBAddLorry().setEnabled(true);
			addVehiclesView.getJBEditLorry().setEnabled(true);
			addVehiclesView.getJBDeleteLorry().setEnabled(true);
			addVehiclesView.getJBSaveLorry().setEnabled(true);
			
			addRecordsModel.displayTryBlock(dTMLorries, "Lorry");
		}
		
		if (e.getSource()== addVehiclesView.getJBSaveLorry()) {
			//store data to file if save is pressed
			addRecordsModel.writeTryBlock(dTMLorries, "Lorry");
		
		}
		// change view i.e. display table and buttons based on the radio button that is selected (for example, car 
		//mini-bus or lorry, hide the other views when radio buttons pressed changes
		if (addVehiclesView.getJRBCar().isSelected()) {
			addVehiclesView.changeDefaultFormView();
			addVehiclesView.changeButtonView();
			addVehiclesView.carView();
			
			addVehiclesView.changeJTableView();
			addVehiclesView.getJSPCars().setVisible(true);
		}
		
		if (addVehiclesView.getJRBMiniBus().isSelected()) {
			addVehiclesView.changeDefaultFormView();
			addVehiclesView.changeButtonView();
			addVehiclesView.miniBusView();
			
			addVehiclesView.changeJTableView();
			addVehiclesView.getJSPMiniBuses().setVisible(true);
		}
		if (addVehiclesView.getJRBLorry().isSelected()) {
			addVehiclesView.changeDefaultFormView();
			addVehiclesView.changeButtonView();
			addVehiclesView.lorryView();
			
			addVehiclesView.changeJTableView();
			addVehiclesView.getJSPLorries().setVisible(true);
		}
		if (e.getSource()== addVehiclesView.getJBBack()) {
			// display staff menu if back is pressed  
			addVehiclesView.setVisible(false);
			StaffMenuView staffMenuView = new StaffMenuView();
			new StaffMenuController(staffMenuView);
		
		}
	 }
	
	//method to getVehicle details entered by the user, to be called when new data for
	//car, mini-bus or lorry is entered
	public Vehicle getVehicleDetails() {
		Vehicle v = addRecordsModel.extractVehicleDetails(addVehiclesView.getJTId(), 
				addVehiclesView.getJTMake(), addVehiclesView.getJTModel(),
				addVehiclesView.getJTRegNo(), addVehiclesView.getJTTopSpeed(), 
				addVehiclesView.getJTHireRate(), addVehiclesView.getJRBHireAvailable(),
				addVehiclesView.getJRBNotAvailable());
		return v;
	}
		
}
