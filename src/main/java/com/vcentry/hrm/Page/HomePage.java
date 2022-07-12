package com.vcentry.hrm.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vcentry.hrm.utils.CommonFunctions;

public class HomePage extends CommonFunctions {
 
	By homePage=By.id("welcome");
    By pim =By.id("menu_pim_viewPimModule");
    By empList =By.id("menu_pim_viewEmployeeList");
    By addEmp =By.id("btnAdd");
    By fName =By.id("firstName");
    By lName =By.id("lastName");
    By createLogin=By.id("chkLogin");
    By username =By.id("user_name");
    By password=By.id("user_password");
    By confirmPWD=By.id("re_password");
    By saveEmp=By.id("btnSave");
	By verifyEmp=By.xpath("//div[@id='profile-pic']/h1");
	By empName =By.id("empsearch_employee_name_empName");
	By searchEmp=By.id("searchBtn");
	By deleteEmp=By.id("btnDelete");
	By confirmDelete=By.id("dialogDeleteBtn");
	
	
	public void verifyHomePage () {
		Assert.assertTrue(elementDisplayed(homePage));
	}		
		public HomePage navigateToEmpList() {
			clickElement(pim);
			clickElement(empList);
			return new HomePage();
		}
	 
		public HomePage addEmp(String name1,String name2,String uName,String pwd) throws InterruptedException{
			clickElement(addEmp);
			enterText(fName, name1);
			enterText(lName, name2);
			clickCheckbox(createLogin);
			enterText(username, uName);
			enterText(password, pwd);
			enterText(confirmPWD, pwd);
			clickElement(saveEmp);
			
			return new HomePage();
		}
		
		public HomePage verifyNewEmp(String name1,String name2) throws InterruptedException{
			Thread.sleep(20000);
			String user=driver.findElement(verifyEmp).getText();  
			System.out.println(user);
			Assert.assertEquals(name1+" " +name2, user);
			return new HomePage();
		}
 public HomePage serachEmployee(String name1,String name2) throws InterruptedException{
	 clickElement(empList);
	 enterText(empName,name1+" "+name2);
	 clickElement(searchEmp);
	 Thread.sleep(5000);
	 return new HomePage();
	 
 }
	
	public HomePage deleteEmployee(String name1) {
		String checkbox="(//a[text()='"+name1+"']/parent::td/preceding-sibling::td)[1]";
		String id ="(//a[text()='"+name1+"']/parent::td/preceding-sibling::td)[2]/a";
		String empID=driver.findElement(By.xpath(id)).getText();
		clickCheckbox(By.xpath(checkbox));
		clickElement(deleteEmp);
		clickElement(confirmDelete);
		List<WebElement> empid= driver.findElements(By.xpath(id +"[text()='"+empID+" ']"));
		Assert.assertEquals(empid.size(),0);
		return new HomePage();
		
	}
	}


