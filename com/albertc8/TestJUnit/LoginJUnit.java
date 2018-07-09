package com.albertc8.TestJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.albertc8.login.Login;

public class LoginJUnit {

	Login login = new Login();
	
	@Test
	public void invalidLogin() {

		assertFalse(login.ValidateLogin("",""));
		assertEquals(true, !login.getErrMesg().isEmpty());
		
		// invalid username in text box
		assertFalse(login.ValidateLogin("","123"));
		assertEquals(true, !login.getErrMesg().isEmpty());
		
		// invalid password in text box
		assertFalse(login.ValidateLogin("a",""));
		assertEquals(true, !login.getErrMesg().isEmpty());
		
		// Invalid login details
		assertFalse(login.ValidateLogin("bob", "999"));	
		assertEquals(true, !login.getErrMesg().isEmpty());
	}
	
	@Test
	public void validLogin() {
		
		// Valid login details
		assertTrue(login.ValidateLogin("achen", "123"));
		assertEquals(true, login.getErrMesg().isEmpty());

	}

}
