package com.vcentry.hrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.vcentry.hrm.base.BaseClass;

public class CommonFunctions extends BaseClass {

	public static String getPropData(String data) {
		String propData = null;
		try{
			
		File f=new File("src/test/resources/config.properties");
		
		FileInputStream fi=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fi);
		propData=prop.getProperty(data);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return propData;
	}
	public static String currentDateandTime(){
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		LocalDateTime now=LocalDateTime.now();
		return dt.format(now);
		
	}
	public static String screenshot() {
		String destination=null;
		try{		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		destination=System.getProperty("user.dir")+"/target/screenshot_"+currentDateandTime()+".jpg";
		FileHandler.copy(src,new File(destination));
		}catch (Exception e){
			e.printStackTrace();
		}
		return destination;
		
	}
	public static boolean waitForElement(By element) {
		boolean flag=false;
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		flag =true;
		test.log(Status.PASS, element+"is visible");
		log.info(element+"is visible");
		return flag;
		
	}
	
	public static boolean clickElement(By element){
		boolean flag=false;
		if(waitForElement(element)){
			driver.findElement(element).click();
		}	
		flag=true;
		test.log(Status.PASS, element+"is clicked");
		log.info(element+"is clicked ");
		return flag;
		}
	
		
	public static boolean enterText(By element,String text){
		boolean flag=false;
		if(waitForElement(element)){
			driver.findElement(element).sendKeys(text);
			
		}
		flag=true;
		test.log(Status.PASS,text+"is entered in"+element);
		log.info(text+"is entered in"+element);
		return flag;
	}
	
	public static boolean elementDisplayed(By element){
		waitForElement(element);
		return driver.findElement(element).isDisplayed();
		
	}
	public static boolean clickCheckbox(By element){
		boolean flag=false;
		if(waitForElement(element)){
		if	(!driver.findElement(element).isSelected());
		driver.findElement(element).click();
		}else{
			
			test.log(Status.PASS, element+"checkbox is already clicked");
			log.info(element+" checkbox is clicked ");
			
			
		}
		flag=true;
		test.log(Status.PASS, element+"checkbox is clicked");
		log.info(element+"checkbox is clicked ");
		return flag;
		}
	public static String[][] getExcelData(String fileLocation,String SheetName){
		String[][] data=null;
		try{
			File f=new File (fileLocation);
			FileInputStream fi=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet(SheetName);
			int row=sh.getLastRowNum();
			data=new String[row][sh.getRow(0).getLastCellNum()];
			for (int i = 1; i <row+1; i++) {
				int col=sh.getRow(0).getLastCellNum();
				for (int j = 0; j < col; j++) {
			data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
					
				}
				
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return data;
			
		}
	}
	

