package com.vcentry.hml.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.hrm.base.BaseClass;
import com.vcentry.hrm.utils.CommonFunctions;

public class LoginTest extends CommonFunctions {

	@Test(priority =2)
	public void loginWithValidCredentials() throws InterruptedException{
	login.enterUsername(getPropData("username")).enterPassword(getPropData("password")).clickLogin();
	home.verifyHomePage();
	}	
	

	@Test(priority =1,dataProvider ="invalidCredentials",enabled=false)
	public void loginWithInValidCredentials(String uName,String pwd) throws InterruptedException {
	login.enterUsername(uName).enterPassword(pwd).clickLogin().verifyLoginError();
	
}
	@DataProvider(name ="invalidCredentials")
	public Object[][]loginData(){
		return getExcelData("src/test/resources/DataSheet.xlsx","login");
		
	}
}