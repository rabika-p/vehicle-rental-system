package view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CustomerLoginView extends JFrame {
	private JLabel jLUsername, jLPsw;  //JLabels to match JTextFields for user-name and password
	private JTextField jTUsername; //JTextField for user-name input
	private JPasswordField jPFPsw;  //JPasswordField for password input
	private JButton jBLogIn, jBBack; //JButtons to login and go back to main menu
	
	//constructor to set frame size, title, location and other properties
	public CustomerLoginView() {
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Customer Login");
		createCustomerLogin();
		setVisible(true);
	}
	
	//adds components such as JLabels, JTextField, JPasswordFields, and JButtons to the window
	private void createCustomerLogin() {
		Container window = getContentPane();
		window.setLayout(null); //set layout to null
		
		//set bounds, title, size for components 
		
		//JLabel and JTextField to get user-name of customer
		jLUsername = new JLabel("Enter username:");
		jLUsername.setBounds(55, 60, 105, 25);
		
		jTUsername = new JTextField(10);
		jTUsername.setBounds(180, 60, 155, 25);
		
		//JLabel and JPasswordField to get password of customer
		jLPsw = new JLabel("Enter password:");
		jLPsw.setBounds(55, 110, 105, 25);
		
		jPFPsw = new JPasswordField(10);
		jPFPsw.setBounds(180, 110, 155, 25);
		
		//JButtons to login or go back 
		jBLogIn = new JButton("Log In");
		jBLogIn.setBounds(160, 160, 75, 30);
		
		jBBack = new JButton("Back");
		jBBack.setBounds(15, 15, 75, 30);
		
		//add components to the window
		window.add(jLUsername);
		window.add(jTUsername);
		window.add(jLPsw);
		window.add(jPFPsw);
		window.add(jBLogIn);
		window.add(jBBack);

		getJTUsername();
		getJTPsw();
		getJBLogin();
		getJBBack();
		
	}
	//Accessors for JButtons and JTextFields
	public JTextField getJTUsername() {
		return jTUsername;
	}
	public JPasswordField getJTPsw() {
		return jPFPsw;
	}
	public JButton getJBLogin() {
		return jBLogIn;	
	}
	public JButton getJBBack() {
		return jBBack;	
		
	}

}
