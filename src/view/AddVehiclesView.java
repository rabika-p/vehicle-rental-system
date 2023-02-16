package view;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddVehiclesView extends JFrame {
	//attributes to be stored for all vehicles
	private JLabel jLId, jLMake, jLModel, jLRegNo, jLTopSpeed, jLHireRate, jLIsHired;
	private JTextField jTId, jTMake, jTModel, jTRegNo, jTTopSpeed, jTHireRate;
	private JRadioButton jRBCar, jRBMiniBus, jRBLorry;
	private JRadioButton jRBHireAvailable, jRBNotAvailable;
	
	//attributes to be stored for all cars
	private JLabel  jLFuelType, jLNoDoors;
	private JTextField jTNoDoors;
	private JRadioButton jRBPetrol, jRBDiesel;
	
	//attributes to be stored for all mini-buses
	private JLabel  jLSeating;
	private JTextField jTSeating;
	
	//attributes to be stored for all lorries
	private JLabel  jLLoading;
	private JTextField jTLoading;
	
	//JLabels to display notes regarding button use on the GUI
	private JLabel jLNote, jLNoteOne;
	
	//JButtons with options to add, edit, display and so on for vehicles
	private JButton jBAddCar, jBSaveCar, jBEditCar, jBDeleteCar, jBUpdateCar, jBDisplayCar, jBBack;
	private JButton jBAddMB, jBSaveMB, jBEditMB, jBDeleteMB, jBUpdateMB, jBDisplayMB;
	private JButton jBAddLorry, jBSaveLorry, jBEditLorry, jBDeleteLorry, jBUpdateLorry, 
					jBDisplayLorry;
	//Button Groups (can choose only one RadioButton from a group)
	private ButtonGroup bVehicles, bFuelType, bIsHired;
	
	//DefaultTableModel and JTable to store and display data of all types of vehicles
	private JTable jTblCars, jTblMiniBuses, jTblLorries;
	private DefaultTableModel dTMCars, dTMMiniBuses, dTMLorries;
	private JScrollPane jSPCars, jSPMiniBuses, jSPLorries;
	 
	//constructor to set frame size, title, location and other properties
	public AddVehiclesView(){
		setSize(2500,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Vehicles - Admin");
		createAddView();
		setVisible(true);
		
	}
	//adds components such as JLabels, JButtons, JTextFields, JScrollPane to the window
	public void createAddView() {
		Container window = getContentPane();
		window.setLayout(null);
			
		 /*JLabels and JTextFields to get id, make, model, registration number, top-speed, hire rate,
		  * available to hire for all vehicles and to get other attributes such as fuel type for cars,
		  * seating capacity for mini-buses and so on. Also set
		  *  bounds of these components on the window */
		jLId = new JLabel("Id: ");
		jLId.setBounds(55, 60, 105, 25);
		
		jLMake = new JLabel("Make: ");
		jLMake.setBounds(55, 110, 105, 25);
		
		jLModel = new JLabel("Model: ");
		jLModel.setBounds(55, 160, 105, 25);
		
		jLRegNo = new JLabel("Registration No: ");
		jLRegNo.setBounds(55, 210, 105, 25);
		
		jLTopSpeed = new JLabel("Top Speed: ");
		jLTopSpeed.setBounds(55, 260, 105, 25);
		
		jLHireRate = new JLabel("Hire Rate: ");
		jLHireRate.setBounds(55, 310, 105, 25);
		
		jLIsHired = new JLabel("Available to hire?: ");
		jLIsHired.setBounds(55, 360, 130, 25);
		
		jLFuelType = new JLabel("Fuel Type: ");
		jLFuelType.setBounds(55, 410, 105, 25);
		
		jLSeating = new JLabel("Seating Capacity: ");
		jLSeating.setBounds(55, 410, 115, 25);
		
		jLLoading = new JLabel("Loading Capacity: ");
		jLLoading.setBounds(55, 410, 115, 25);
		
		jLSeating.setVisible(false);
		jLLoading.setVisible(false);
		
		jLNoDoors = new JLabel("No Of doors: ");
		jLNoDoors.setBounds(55, 460, 105, 25);
	
		jTId = new JTextField(10);
		jTId.setBounds(180, 60, 155, 25);
		
		jTMake = new JTextField(10);
		jTMake.setBounds(180, 110, 155, 25);
		
		jTModel = new JTextField(10);
		jTModel.setBounds(180, 160, 155, 25);
		
		jTRegNo = new JTextField(10);
		jTRegNo.setBounds(180, 210, 155, 25);
		
		jTTopSpeed = new JTextField(10);
		jTTopSpeed.setBounds(180, 260, 155, 25);
		
		jTHireRate = new JTextField(10);
		jTHireRate.setBounds(180, 310, 155, 25);
		
		jTHireRate = new JTextField(10);
		jTHireRate.setBounds(180, 310, 155, 25);
		
		jRBHireAvailable = new JRadioButton("Yes");
		jRBHireAvailable.setBounds(180, 360, 90, 25);
		jRBHireAvailable.setSelected(true);
		
		jRBNotAvailable = new JRadioButton("No");
		jRBNotAvailable.setBounds(270, 360, 90, 25);
		
		//Add radio buttons to a button group so that only one can be pressed at a time
		bIsHired = new ButtonGroup();

		bIsHired.add(jRBHireAvailable);
		bIsHired.add(jRBNotAvailable);
		
		jRBPetrol = new JRadioButton("Petrol");
		jRBPetrol.setBounds(180, 410, 90, 25);
		jRBPetrol.setSelected(true); //set default radio button selection
		
		jRBDiesel = new JRadioButton("Diesel");
		jRBDiesel.setBounds(270, 410, 90, 25);
		
		bFuelType = new ButtonGroup();

		bFuelType.add(jRBPetrol);
		bFuelType.add(jRBDiesel);
		
		jTSeating = new JTextField(10);
		jTSeating.setBounds(180, 410, 155, 25);
		
		jTLoading = new JTextField(10);
		jTLoading.setBounds(180, 410, 155, 25);
		
		jTSeating.setVisible(false);
		jTLoading.setVisible(false);

		jTNoDoors = new JTextField(10);
		jTNoDoors.setBounds(180, 460, 155, 25);
		
		//different JButtons to add, delete, edit, update, and so on for all three kinds of vehicles
		jBAddCar = new JButton("Add");
		jBAddCar.setBounds(160, 510, 75, 30);
		
		jBAddMB = new JButton("Add");
		jBAddMB.setBounds(160, 510, 75, 30);
		
		jBAddLorry = new JButton("Add");
		jBAddLorry.setBounds(160, 510, 75, 30);
		
		jBUpdateCar = new JButton("Update");
		jBUpdateCar.setBounds(260, 510, 75, 30);
		
		jBUpdateMB = new JButton("Update");
		jBUpdateMB.setBounds(260, 510, 75, 30);
		
		jBUpdateLorry = new JButton("Update");
		jBUpdateLorry.setBounds(260, 510, 75, 30);
		
		jBEditCar = new JButton("Edit");
		jBEditCar.setBounds(60, 565, 75, 30);
		
		jBEditMB = new JButton("Edit");
		jBEditMB.setBounds(60, 565, 75, 30);
		
		jBEditLorry = new JButton("Edit");
		jBEditLorry.setBounds(60, 565, 75, 30);
		
		jBDeleteCar = new JButton("Delete");
		jBDeleteCar.setBounds(160, 565, 75, 30);
		
		jBDeleteMB = new JButton("Delete");
		jBDeleteMB.setBounds(160, 565, 75, 30);
		
		jBDeleteLorry = new JButton("Delete");
		jBDeleteLorry.setBounds(160, 565, 75, 30);
		
		jBDisplayCar = new JButton("Display");
		jBDisplayCar.setBounds(260, 565, 80, 30);
		
		jBDisplayMB = new JButton("Display");
		jBDisplayMB.setBounds(260, 565, 80, 30);
		
		jBDisplayLorry = new JButton("Display");
		jBDisplayLorry.setBounds(260, 565, 80, 30);
		
		jBBack = new JButton("Back");
		jBBack.setBounds(15, 15, 75, 30);
		
		jBSaveCar = new JButton("Save To File");
		jBSaveCar.setBounds(35, 510, 110, 30);
		
		jBSaveMB = new JButton("Save To File");
		jBSaveMB.setBounds(35, 510, 110, 30);
		
		jBSaveLorry = new JButton("Save To File");
		jBSaveLorry.setBounds(35, 510, 110, 30);
		
		jLNote = new JLabel("NOTE: Press display to view all records before adding,");
		jLNote.setBounds(15, 610, 320, 15);
		
		jLNoteOne = new JLabel("editing or deleting records! "); 
		jLNoteOne.setBounds(15, 625, 320, 15);
		
		//these buttons are to be enabled only after pressing display
		jBAddCar.setEnabled(false);
		jBEditCar.setEnabled(false);
		jBDeleteCar.setEnabled(false);	
		jBSaveCar.setEnabled(false);	
		
		jBAddMB.setEnabled(false);
		jBEditMB.setEnabled(false);
		jBDeleteMB.setEnabled(false);
		jBSaveMB.setEnabled(false);
		
		jBAddLorry.setEnabled(false);
		jBEditLorry.setEnabled(false);
		jBDeleteLorry.setEnabled(false);
		jBSaveLorry.setEnabled(false);
		
		//these buttons are to be enabled only after pressing edit
		jBUpdateCar.setEnabled(false);
		jBUpdateMB.setEnabled(false);
		jBUpdateLorry.setEnabled(false);
		
		jBAddMB.setVisible(false);
		jBEditMB.setVisible(false);
		jBDisplayMB.setVisible(false);
		jBDeleteMB.setVisible(false);
		jBUpdateMB.setVisible(false);
		jBSaveMB.setVisible(false);
		
		jBAddLorry.setVisible(false);
		jBEditLorry.setVisible(false);
		jBDisplayLorry.setVisible(false);
		jBDeleteLorry.setVisible(false);
		jBUpdateLorry.setVisible(false);
		jBSaveLorry.setVisible(false);
	
		jRBCar = new JRadioButton("Car");
		jRBCar.setBounds(125, 15, 60, 30);
		jRBCar.setSelected(true);
		jRBMiniBus = new JRadioButton("Mini Bus");
		jRBMiniBus.setBounds(185, 15, 100, 30);
		jRBLorry = new JRadioButton("Lorry");
		jRBLorry.setBounds(285, 15, 70, 30);

		bVehicles = new ButtonGroup();

		bVehicles.add(jRBCar);
		bVehicles.add(jRBMiniBus);
		bVehicles.add(jRBLorry);
	
		 //Use DefaultTableModel and JTable to display data of vehicles with columns id, make, etc
		Object [] colCars = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?", "Fuel Type", "No Of Doors"};
		
		Object [] colMiniBuses = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?", "Seating Capacity"};
		
		Object [] colLorries = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?","Loading Capacity"};


		dTMCars = new DefaultTableModel(null,colCars);
		jTblCars = new JTable(dTMCars);
		
		dTMMiniBuses = new DefaultTableModel(null,colMiniBuses);
		jTblMiniBuses = new JTable(dTMMiniBuses);
		
		dTMLorries = new DefaultTableModel(null,colLorries);
		jTblLorries = new JTable(dTMLorries);

		 //Add table to JScrollPane and add the JScrollPane in specified bounds in the window
		jSPCars = new JScrollPane(jTblCars);
		jSPCars.setBounds(360, 17, 900, 603);
		
		jSPMiniBuses = new JScrollPane(jTblMiniBuses);
		jSPMiniBuses.setBounds(360, 17, 900, 603);
		
	    jSPLorries = new JScrollPane(jTblLorries);
		jSPLorries.setBounds(360, 17, 900, 603);
		
		window.add(jSPCars);
		window.add(jSPMiniBuses);
		window.add(jSPLorries);
		
		//display JScrollPane for cars by default so set visibility of other two to false
		jSPMiniBuses.setVisible(false);
		jSPLorries.setVisible(false);
		
		//add components to the window
		window.add(jLId);
		window.add(jTId);
		window.add(jLMake);
		window.add(jTMake);
		window.add(jLModel);
		window.add(jTModel);
		window.add(jLRegNo);
		window.add(jTRegNo);
		window.add(jLTopSpeed);
		window.add(jTTopSpeed);
		window.add(jLHireRate);
		window.add(jTHireRate);
		
		window.add(jLSeating);
		window.add(jTSeating);
		
		window.add(jLLoading);
		window.add(jTLoading);
		
		window.add(jLFuelType);
		window.add(jRBPetrol);
		window.add(jRBDiesel);
		
		window.add(jLNoDoors);
		window.add(jTNoDoors);
		
		window.add(jLIsHired);
		window.add(jRBHireAvailable);
		window.add(jRBNotAvailable);
		
		window.add(jBAddCar);
		window.add(jBSaveCar);
		window.add(jBEditCar);
		window.add(jBUpdateCar);
		window.add(jBDeleteCar);
		window.add(jBDisplayCar);
		
		window.add(jLNote);
		window.add(jLNoteOne);
		window.add(jBBack);
		
		window.add(jBAddMB);
		window.add(jBSaveMB);
		window.add(jBEditMB);
		window.add(jBUpdateMB);
		window.add(jBDeleteMB);
		window.add(jBDisplayMB);
		
		window.add(jBAddLorry);
		window.add(jBSaveLorry);
		window.add(jBEditLorry);
		window.add(jBUpdateLorry);
		window.add(jBDeleteLorry);
		window.add(jBDisplayLorry);
		
		window.add(jRBCar);
		window.add(jRBMiniBus);
		window.add(jRBLorry);
	}
	
	//method to be called to change JTable View when vehicle choice changes from one to
	//another 
	public void changeJTableView() {
		jSPCars.setVisible(false);
		jSPMiniBuses.setVisible(false);
		jSPLorries.setVisible(false);	
	}
	
	//method to be called to change form view when vehicle choice changes from one to 
	//another
	public void changeDefaultFormView() {
		jLFuelType.setVisible(false);
		jRBPetrol.setVisible(false);
		jRBDiesel.setVisible(false);
		jLNoDoors.setVisible(false);
		jTNoDoors.setVisible(false);	
		
		jLSeating.setVisible(false);
		jTSeating.setVisible(false);	
		
		jLLoading.setVisible(false);
		jTLoading.setVisible(false);	
	}
	
	//method to be called to change buttons when vehicle choice changes from one to 
	//another
	public void changeButtonView() {
		jBAddCar.setVisible(false);
		jBEditCar.setVisible(false);
		jBDisplayCar.setVisible(false);
		jBDeleteCar.setVisible(false);
		jBUpdateCar.setVisible(false);
		jBSaveCar.setVisible(false);
		
		jBAddMB.setVisible(false);
		jBEditMB.setVisible(false);
		jBDisplayMB.setVisible(false);
		jBDeleteMB.setVisible(false);
		jBUpdateMB.setVisible(false);
		jBSaveMB.setVisible(false);
		
		jBAddLorry.setVisible(false);
		jBEditLorry.setVisible(false);
		jBDisplayLorry.setVisible(false);
		jBDeleteLorry.setVisible(false);
		jBUpdateLorry.setVisible(false);
		jBSaveLorry.setVisible(false);
	}
	

	//method to be called when vehicle choice changes to mini-bus 
	public void miniBusView() {
		jLSeating.setVisible(true);
		jTSeating.setVisible(true);	
		
		jBAddMB.setVisible(true);
		jBEditMB.setVisible(true);
		jBDisplayMB.setVisible(true);
		jBDeleteMB.setVisible(true);
		jBSaveMB.setVisible(true);
		jBUpdateMB.setVisible(true);		
	}
	
	//method to be called when vehicle choice changes to lorry 
	public void lorryView() {
		jLLoading.setVisible(true);
		jTLoading.setVisible(true);	
		
		jBAddLorry.setVisible(true);
		jBEditLorry.setVisible(true);
		jBDisplayLorry.setVisible(true);
		jBDeleteLorry.setVisible(true);
		jBSaveLorry.setVisible(true);
		jBUpdateLorry.setVisible(true);	
	}
	
	//method to be called when vehicle choice changes to car
	public void carView() {
		jLFuelType.setVisible(true);
		jRBPetrol.setVisible(true);
		jRBDiesel.setVisible(true);
		jLNoDoors.setVisible(true);
		jTNoDoors.setVisible(true);	
		
		jBAddCar.setVisible(true);
		jBEditCar.setVisible(true);
		jBDisplayCar.setVisible(true);
		jBDeleteCar.setVisible(true);
		jBSaveCar.setVisible(true);
		jBUpdateCar.setVisible(true);
	}

	//accessors for JButtons to choose a vehicle to add/manage
	public JRadioButton getJRBCar() {
		return jRBCar;
	}
	public JRadioButton getJRBMiniBus() {
		return jRBMiniBus;
	}
	public JRadioButton getJRBLorry() {
		return jRBLorry;
	}
	
	//accessors for JTextFields for all vehicles
	public JTextField getJTId() {
		return jTId;
	}
	public JTextField getJTMake() {
		return jTMake;
	}
	public JTextField getJTModel() {
		return jTModel;
	}
	public JTextField getJTRegNo() {
		return jTRegNo;
	}
	public JTextField getJTTopSpeed() {
		return jTTopSpeed;
	}
	public JTextField getJTHireRate() {
		return jTHireRate;
	}
	//accessors for JRadioButtons for all vehicles
	public JRadioButton getJRBHireAvailable() { 
		return jRBHireAvailable;
	}
	public JRadioButton getJRBNotAvailable() { 
		return jRBNotAvailable;
	}
	
	//accessors for JRadioButtons for all cars
	public JRadioButton getjRBDiesel() {
		return jRBDiesel;
	}
	public JRadioButton getjRBPetrol() {
		return jRBPetrol;
	}
	//accessors for JTextFields for all cars
	public JTextField getJTNoDoors() {
		return jTNoDoors;
	}
	
	//accessors for JTextFields for all mini-buses
	public JTextField getJTSeating() {
		return jTSeating;
	}
	
	//accessors for JTextFields for all lorries
	public JTextField getJTLoading() {
		return jTLoading;
	}
	
	//accessors for JButtons to add/edit/delete... a car record
	public JButton getJBAddCar() {
		return jBAddCar;
	}
	public JButton getJBEditCar() {
		return jBEditCar;
	}
	public JButton getJBDeleteCar() {
		return jBDeleteCar;
	}
	public JButton getJBUpdateCar() {
		return jBUpdateCar;
	}
	public JButton getJBDisplayCar() {
		return jBDisplayCar;
	}
	public JButton getJBSaveCar() {
		return jBSaveCar;
	}
	
	//accessors for JButtons to add/edit/delete... a mini-bus record
	public JButton getJBAddMB() {
		return jBAddMB;
	}
	public JButton getJBEditMB() {
		return jBEditMB;
	}
	public JButton getJBDeleteMB() {
		return jBDeleteMB;
	}
	public JButton getJBUpdateMB() {
		return jBUpdateMB;
	}
	public JButton getJBDisplayMB() {
		return jBDisplayMB;
	}
	public JButton getJBSaveMB() {
		return jBSaveMB;
	}
	
	//accessors for JButtons to add/edit/delete... a lorry record
	public JButton getJBAddLorry() {
		return jBAddLorry;
	}
	public JButton getJBEditLorry() {
		return jBEditLorry;
	}
	public JButton getJBDeleteLorry() {
		return jBDeleteLorry;
	}
	public JButton getJBUpdateLorry() {
		return jBUpdateLorry;
	}
	public JButton getJBDisplayLorry() {
		return jBDisplayLorry;
	}
	public JButton getJBSaveLorry() {
		return jBSaveLorry;
	}
	public JButton getJBBack() {
		return jBBack;
	}
	public ButtonGroup getBVehicles() {
		return bVehicles;
	}
	
	//accessors for JTables
	public JTable getJTblCars() {
		return jTblCars;	
	}
	public JTable getJTblMiniBuses() {
		return jTblMiniBuses;	
	}
	public JTable getJTblLorries() {
		return jTblLorries;	
	}
	
	
	//accessors for table models
	public DefaultTableModel getDTMCars() {
		return dTMCars;	
	}
	public DefaultTableModel getDTMMiniBuses() {
		return dTMMiniBuses;	
	}
	public DefaultTableModel getDTMLorries() {
		return dTMLorries;	
	}
	
	//accessors for JScrollPanes
	public JScrollPane getJSPCars() {
		return jSPCars;	
	}
	public JScrollPane getJSPMiniBuses() {
		return jSPMiniBuses;	
	}
	public JScrollPane getJSPLorries() {
		return jSPLorries;	
	}
}