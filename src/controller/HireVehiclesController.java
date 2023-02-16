package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.HireVehiclesModel;
import view.HireVehiclesView;
import view.StaffMenuView;

public class HireVehiclesController implements ActionListener{
	//Model and view for HireVehiclesController
	HireVehiclesModel hireVehiclesModel;
	HireVehiclesView hireVehiclesView;
	//Pass respective model and view to controller
	public HireVehiclesController(	HireVehiclesModel hireVehiclesModel,
		HireVehiclesView hireVehiclesView){
		this.hireVehiclesModel = hireVehiclesModel;
		this.hireVehiclesView = hireVehiclesView;
		
		//Add action-listeners to JButtons from hireVehiclesView
		this.hireVehiclesView.getJBRequestedHire().addActionListener(this);
		this.hireVehiclesView.getJBReqReturn().addActionListener(this);
		
		this.hireVehiclesView.getJBAccept().addActionListener(this);
		this.hireVehiclesView.getJBAcReturn().addActionListener(this);
		
		this.hireVehiclesView.getJBOnLoan().addActionListener(this);
		
		this.hireVehiclesView.getJBReject().addActionListener(this);
		this.hireVehiclesView.getJBBack().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//store getters into variables that are used often
		DefaultTableModel dTMCustomers = hireVehiclesView.getDTMCustomers();
		JTable jTblCustomers = hireVehiclesView.getJTblCustomers();
		
		//if button to view hire requests by customer is pressed
		if (e.getSource() ==hireVehiclesView.getJBRequestedHire()){
			hireVehiclesView.getJBRequestedHire().setEnabled(false);
			hireVehiclesView.getJBReqReturn().setEnabled(true);
			
			hireVehiclesView.getJBAcReturn().setVisible(false);
			hireVehiclesView.getJBAccept().setVisible(true);
			hireVehiclesModel.requestHireTryBlock(dTMCustomers);	
		}
		//if button to view return requests by customer is pressed
		if (e.getSource() ==hireVehiclesView.getJBReqReturn()){
			hireVehiclesView.getJBReqReturn().setEnabled(false);
			hireVehiclesView.getJBRequestedHire().setEnabled(true);
			
			hireVehiclesView.getJBAcReturn().setVisible(true);
			hireVehiclesView.getJBAccept().setVisible(false);
			hireVehiclesModel.reqReturnTryBlock(dTMCustomers);	
		}
		//if button to accept hire request by customer is pressed
		if (e.getSource() ==hireVehiclesView.getJBAccept()){
			if (jTblCustomers.getSelectedRowCount() == 1) {
				hireVehiclesModel.acceptHire(dTMCustomers);	
				dTMCustomers.removeRow(jTblCustomers.getSelectedRow());	//remove row after staff accepts request 
			}
		}
		//if button to accept return request by customer is pressed
		if (e.getSource() ==hireVehiclesView.getJBAcReturn()){
			if (jTblCustomers.getSelectedRowCount() == 1) {
				hireVehiclesModel.acceptReturn(dTMCustomers);
				dTMCustomers.removeRow(jTblCustomers.getSelectedRow());//remove row after staff accepts request 	
			}
		}
		//if button to view list of vehicles on loan by different customers is pressed
		if (e.getSource() ==hireVehiclesView.getJBOnLoan()){
			hireVehiclesModel.hiredVehicles(dTMCustomers);	
		
		}
		//if back button is pressed
		if (e.getSource() ==hireVehiclesView.getJBBack()){
			hireVehiclesView.setVisible(false);
			StaffMenuView staffMenuView = new StaffMenuView() ;
			new StaffMenuController(staffMenuView);
		}
	}
}
