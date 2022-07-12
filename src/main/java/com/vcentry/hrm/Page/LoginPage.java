package com.vcentry.hrm.Page;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import com.vcentry.hrm.base.BaseClass;
import com.vcentry.hrm.utils.CommonFunctions;

public class LoginPage  extends CommonFunctions{
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginButton = By.id("btnLogin");
	By loginError = By .id("spanMessage");
	
	public LoginPage  enterUsername(String uName) throws InterruptedException {
		enterText(username, uName);
		return new LoginPage();
	}
	public LoginPage  enterPassword(String pwd) throws InterruptedException{
		enterText(password,pwd);
	return new LoginPage();

}
 public LoginPage clickLogin(){
	 clickElement(loginButton);
	 return new LoginPage();
 }
 public LoginPage verifyLoginError(){
	 Assert.assertTrue(elementDisplayed(loginError));
	return new LoginPage();
 }
}
