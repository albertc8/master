package com.albertc8.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AddSubmitButtonAction implements ActionListener {
		
	private Login login;
	private LoginView loginView;
	
	public AddSubmitButtonAction(Login login, LoginView loginView) {
		this.login = login;
		this.loginView = loginView;		
	}
	
	public void actionPerformed(ActionEvent e) {		
		if (!login.ValidateLogin(loginView.getUsername(), loginView.getPassword())) {
			
			JOptionPane.showMessageDialog(null, 
					login.getErrMesg(), 
	                "ERROR", 
	                JOptionPane.WARNING_MESSAGE);
		} else {
			// Successfully logged in
			loginView.updateView();
		}
		
		
	}
	
}
