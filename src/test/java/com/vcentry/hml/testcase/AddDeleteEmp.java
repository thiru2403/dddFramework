package com.vcentry.hml.testcase;

import org.testng.annotations.Test;

import com.vcentry.hrm.utils.CommonFunctions;

public class AddDeleteEmp extends CommonFunctions {

	@Test(priority=3)
	public void addEmp() throws InterruptedException {
		home.navigateToEmpList()
		.addEmp("Rocky", "bhai", "rockeybhjai", "test@1234").verifyNewEmp("Rocky", "bhai");
	}
	@Test(priority=4)
	public void deleteEmp() throws InterruptedException {
		home.serachEmployee("Rocky", "Bhai")
		.deleteEmployee("Rocky");
	}
}
