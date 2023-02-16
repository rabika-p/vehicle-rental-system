package main;
import controller.LoginGUIController;
import view.LoginGUIView;

//load the main login page for the system
public class LoginGUI {

	public static void main(String[] args) {
		LoginGUIView loginGUIView = new LoginGUIView() ;
		//pass respective login view to controller
		new LoginGUIController(loginGUIView);
	}
}
