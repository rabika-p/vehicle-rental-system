package view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StaffMenuView extends JFrame {
	//Buttons to provide options to add vehicles, add customers, manage hire and logout
	private JButton jBAddVehicles, jBHireVehicles, jBAddCustomers, jBLogout;

	//constructor to set frame size, title, location and other properties
	public StaffMenuView() {
		 setTitle("Staff Dashboard");
		 setSize(400, 300);
		 setResizable(false);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 createStaffView();
		 setVisible(true);	
	}
	//adds components (JButtons) to the window
	private void createStaffView() {
		Container window = getContentPane();
		window.setLayout(new FlowLayout());

		jBAddVehicles = new JButton("Add Vehicles");
		jBHireVehicles = new JButton("Manage Vehicle Hire");
		jBAddCustomers = new JButton("Add Customers");
		jBLogout = new JButton("Logout");
		
		//add components to the window
		window.add(jBAddVehicles);
		window.add(jBHireVehicles);
		window.add(jBAddCustomers);
		window.add(jBLogout);
    }
	//Accessors for JButtons
	public JButton getJBAddVehicles() {
		return jBAddVehicles;	
	}
	public JButton getJBAddCustomers() {
		return jBAddCustomers;	
	}
	public JButton getJBHireVehicles() {
		return jBHireVehicles;	
	}
	public JButton getJBLogout() {
		return jBLogout;	
	}
}

