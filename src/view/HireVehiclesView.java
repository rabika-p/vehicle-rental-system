package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HireVehiclesView extends JFrame {
	//Buttons to view vehicles on loan, requested hires, returns and accept, reject these requests 
	private JButton jBRequestedHire, jBReqReturn, jBOnLoan, jBAccept, jBAcReturn, jBReject, jBBack;
	
	private JTable jTblCustomers;
	private DefaultTableModel dTMCustomers;
	
	//constructor to set frame size, title, location and other properties
	public HireVehiclesView() {
		 setTitle("Hire out Vehicles - Admin ");
		 setSize(2500, 700);
		 setResizable(false);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 createHireVehiclesView();
		 setVisible(true);	
	}
	//adds components such as JScrollPanes and JButtons to the window
	private void createHireVehiclesView() {
		 Container window = getContentPane();
		 window.setLayout(null);

		 jBRequestedHire = new JButton("View Requested Hires");
		 jBRequestedHire.setBounds(50, 140, 180, 35);
		 
		 jBReqReturn = new JButton("View Requested Returns");
		 jBReqReturn.setBounds(50, 200, 180, 35);
		
		 jBOnLoan = new JButton("View Vehicles on Loan");
		 jBOnLoan.setBounds(50, 260, 180, 35);
		 
		 jBAccept = new JButton("Accept Hire");
		 jBAccept.setBounds(75, 350, 160, 35);	
		 
		 jBAcReturn = new JButton("Accept Return");
		 jBAcReturn.setBounds(75, 350, 160, 35);
		
		 jBReject = new JButton("Reject Hire");
		 jBReject.setBounds(75, 350, 160, 35);
		 
		 jBBack = new JButton("Back");
		 jBBack.setBounds(15, 15, 75, 30);
		 
		 //Use DefaultTableModel and JTable to display data of customers with columns id, name, etc
		 Object [] colCustomers = {"Id", "Name", "Phone", "Make", "Model", "Reg No"};
	
		 dTMCustomers = new DefaultTableModel(null,colCustomers);
		
		 jTblCustomers = new JTable(dTMCustomers);
		
		 JScrollPane scrollPane = new JScrollPane(jTblCustomers);
		 scrollPane.setBounds(280, 17, 1000, 603);
		 window.add(scrollPane);
		 //add components to the window
		 window.add(jBRequestedHire);
		 window.add(jBAccept);
		 window.add(jBAcReturn);
		 window.add(jBReject);
		 window.add(jBBack);
		 window.add(jBReqReturn);
		 window.add(jBOnLoan); 
   }
	
	//accessors for JButtons 
	public JButton getJBRequestedHire() {
		return jBRequestedHire;
	}
	public JButton getJBReqReturn() {
		return jBReqReturn;
	}
	public JButton getJBAccept() {
		return jBAccept;
	}
	public JButton getJBAcReturn() {
		return jBAcReturn;
	}
	public JButton getJBReject() {
		return jBReject;
	}
	public JButton getJBOnLoan() {
		return 	jBOnLoan;
	}

	public JButton getJBBack() {
		return jBBack;
	}
	//accessor for DefaultTableModel
	public DefaultTableModel getDTMCustomers() {
		return dTMCustomers;
	}
	//accessor for JTable
	public JTable getJTblCustomers() {
		return jTblCustomers;
	}
	

}
