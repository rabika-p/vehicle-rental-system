package view;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerMenuView extends JFrame {
	private JButton jBProfile, jBOnLoan, jBCToLoan, jBMBToLoan, jBLToLoan, jBLogout, jBCHire, jBMBHire, jBLHire, jBReturn;
	//JButtons to view profile, different vehicles on loan and to loan and so on
	
	//To display list of cars, minibuses and lorries to loan
	private JTable jTblCars, jTblMiniBuses, jTblLorries;
	private DefaultTableModel dTMCars, dTMMiniBuses, dTMLorries;
	private JScrollPane jSPCars, jSPMiniBuses, jSPLorries;

	//constructor to set frame size, title, location and other properties
	public CustomerMenuView() {
		 setTitle("Customer Dashboard");
		 setSize(2500, 700);
		 setResizable(false);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 createCustomerView();
		 setVisible(true);	
	}
	
	//adds components such as JScrollPanes and JButtons to the window
	private void createCustomerView() {
		 Container window = getContentPane();
		 window.setLayout(null);	
		 
		 //Button to view customer profile
		jBProfile = new JButton("View Profile");
		jBProfile.setBounds(10, 350, 160, 35);
		
		//Button to view vehicles loaned
		jBOnLoan = new JButton("View Vehicles on Loan");
		
		jBOnLoan.setBounds(95, 280, 170, 35);
		//Buttons to view available vehicles to loan 
		jBCToLoan = new JButton("Find Cars to Loan");
		jBCToLoan.setBounds(10, 100, 160, 35);
		
		jBMBToLoan = new JButton("Find Mini-buses to Loan");
		jBMBToLoan.setBounds(95, 180, 190, 35);
		
		jBLToLoan = new JButton("Find Lorries to Loan");
		jBLToLoan.setBounds(190, 100, 160, 35);
		
		 //Button to logout
		jBLogout = new JButton("Logout");
		jBLogout.setBounds(190, 350, 160, 35);	
		
		// //Buttons to request hire of different vehicles
		jBCHire = new JButton("Request Hire");
		jBCHire.setBounds(95, 450, 160, 35);	
		
		jBMBHire = new JButton("Request Hire");
		jBMBHire.setBounds(95, 450, 160, 35);
		
		jBLHire = new JButton("Request Hire");
		jBLHire.setBounds(95, 450, 160, 35);
		
		jBReturn = new JButton("Request Return");
		jBReturn.setBounds(95, 450, 160, 35);
		
		//set buttons to hire and return vehicles to not visible
		jBCHire.setVisible(false);
		jBMBHire.setVisible(false);
		jBLHire.setVisible(false);
		jBReturn.setVisible(false);
		 
		//Use DefaultTableModel and JTable to display data of vehicles with columns id, make, etc
		Object [] colCars = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?", "Fuel Type", "No Of Doors"};
		
		Object [] colMiniBuses = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?", "Seating Capacity"};
		
		Object [] colLorries = {"Id", "Make", "Model","Reg No","Top Speed", 
				"Daily Hire Rate", "Available to Hire?","Loading Capacity"};
		
		dTMCars = new DefaultTableModel(null, colCars);
		jTblCars = new JTable(dTMCars);
		
		dTMMiniBuses = new DefaultTableModel(null,colMiniBuses);
		jTblMiniBuses = new JTable(dTMMiniBuses);
		
		dTMLorries = new DefaultTableModel(null,colLorries);
		jTblLorries = new JTable(dTMLorries);
		
		jSPCars = new JScrollPane(jTblCars);
		jSPCars.setBounds(360, 17, 900, 201);
		
		jSPMiniBuses = new JScrollPane(jTblMiniBuses);
		jSPMiniBuses.setBounds(360, 217, 900, 201);
		
	    jSPLorries = new JScrollPane(jTblLorries);
		jSPLorries.setBounds(360, 417, 900, 201);
		
		window.add(jSPCars);
		window.add(jSPMiniBuses);
		window.add(jSPLorries);
		
		jSPCars.setVisible(false);
		jSPMiniBuses.setVisible(false);
		jSPLorries.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 17, 850, 603);
		
		//add components to the window
		window.add(jBProfile);
		window.add(jBOnLoan);
		window.add(jBCToLoan);
		window.add(jBMBToLoan);
		window.add(jBLToLoan);
		window.add(jBLogout);
		window.add(jBCHire);
		window.add(jBMBHire);
		window.add(jBLHire);
		window.add(jBReturn);
    }
	//Accessors for JButtons
	public JButton getJBProfile() {
		return jBProfile;	
	}
	public JButton getJBOnLoan() {
		return jBOnLoan;	
	}
	public JButton getJBCToLoan() {
		return jBCToLoan;	
	}
	public JButton getJBMBToLoan() {
		return jBMBToLoan;	
	}
	public JButton getJBLToLoan() {
		return jBLToLoan;	
	}
	public JButton getJBCHire() {
		return jBCHire;	
	}
	public JButton getJBMBHire() {
		return jBMBHire;	
	}
	public JButton getJBLHire() {
		return jBLHire;	
	}
	public JButton getJBReturn() {
		return jBReturn;	
	}
	
	public JButton getJBLogout() {
		return jBLogout;	
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
