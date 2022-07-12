package com.vcentry.hrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.dockerjava.api.model.Driver;
import com.vcentry.hrm.Page.HomePage;
import com.vcentry.hrm.Page.LoginPage;
import com.vcentry.hrm.utils.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public LoginPage login;
public HomePage home;

public static ExtentReports extent = new ExtentReports();
public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
public static ExtentTest test;
public static Logger log=LogManager.getLogger(BaseClass.class);


public void openbrowser(String browser){
	if(browser.equalsIgnoreCase("chrome")){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}else if (browser.equalsIgnoreCase("edge")){
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
  driver.manage().window().maximize();
}
@BeforeSuite
public void beforeSuite(){
	extent.attachReporter(spark);
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("MyReport");
	openbrowser(CommonFunctions.getPropData("browser"));
	driver.get(CommonFunctions.getPropData("url"));
}
@BeforeClass
public void beforeTest(){
	login=new LoginPage();
	home=new HomePage();
	
}


@AfterSuite
public void afterSuite(){
	driver.close();
	
			
}
}
