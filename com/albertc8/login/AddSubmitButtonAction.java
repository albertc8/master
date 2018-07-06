package com.albertc8.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubmitButtonAction implements ActionListener {
		
	private Login login;
	private LoginView loginView;
	private String textUsername;
	private String textPassword;
	
	public AddSubmitButtonAction(Login login, LoginView loginView, String textUsername, String textPassword) {
		this.login = login;
		this.loginView = loginView;
		this.textUsername = textUsername;
		this.textPassword = textPassword;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		login.ValidateLogin(textUsername, textPassword);
		
	}
	
}
