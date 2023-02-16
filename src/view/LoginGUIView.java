package view;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginGUIView extends JFrame {
	private JLabel JLTitle; //JLabel to prompt user to press on an option
	
	//JButtons to login as staff, customer or exit the program
	private JButton jBStaff, jBCus, jBExit; 

	//constructor to set frame size, title, location and other properties
	public LoginGUIView(){
		setSize(400,300); //
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		createLoginView();
		setVisible(true);	
	}

	//adds components such as JLabel and JButtons to the window
	private void createLoginView() {
		Container window = getContentPane();
		window.setLayout(new FlowLayout()); //set to flow layout
		
		JLTitle = new JLabel("Select Option"); 
		jBStaff = new JButton("Staff"); //JButton to login as staff
		jBCus = new JButton("Customer"); //JButton to login as a customer
		jBExit = (new JButton("Exit")); //JButton to exit 
	
		//add components to the window
		window.add(JLTitle);
		window.add(jBStaff);
		window.add(jBCus);
		window.add(jBExit);
		
		//call accessor and mutator methods
		getJBStaff();
		getJBCus();
		getJBExit();
		
		setJBStaff(jBStaff);
		setJBCus(jBCus);
		setJBExit(jBExit);
}
	//Accessors for JButtons
	public JButton getJBStaff() {
		return jBStaff;
	}
	
	public JButton getJBCus() {
		return jBCus;	
	}
	
	public JButton getJBExit() {
		return jBExit;	
	}
	
	//Mutators for JButtons
	public void setJBStaff(JButton jBStaff) {
		this.jBStaff= jBStaff ;
	}
	public void setJBCus(JButton jBCus) {
		this.jBCus= jBCus ;
	}
	public void setJBExit(JButton jBExit) {
		this.jBExit = jBExit ;
	}
	public void setjBExit(JButton jBExit) {
		this.jBExit = jBExit;
	}
}