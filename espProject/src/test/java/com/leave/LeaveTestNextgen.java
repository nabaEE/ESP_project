package com.leave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.FileUtils;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.ApprovalPage;
import esp.objectRepository.AttendancePage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.LeaveFormPage;
import esp.objectRepository.TimeAndAttendancePage;

public class LeaveTestNextgen extends BaseClass {
	static FileUtils fil = new FileUtils();

	// 1. Apply OD for the first half then check the attendance string
	@Test(priority = 1)
	public static void halfDayAbsent_HalfDayOD() throws Exception {
		log.info("-----------halfDayAbsent_HalfDayOD :Test Started------------");
		System.out.println("-----------halfDayAbsent_HalfDayOD :Test Started------------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Maximize the leave form
		lfp.getMaximizeLeaveForm().click();
		// Click on OD page
		lfp.selectOutDoorDutyOnLeaveForm();
		// Click on leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		// select reason for OD
		lfp.selectODLeaveReason();
		Date date1 = new Date("21-Sept-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Pick second half start session
		lfp.getClickStartSession().click();
		lfp.pickFirstHalfStartSession();
		// Click end session and pick session2
		lfp.getClickEndSession().click();
		lfp.pickFirstHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsODform().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		// Click on HomeIcon
		lfp.getClickHomeIcon().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("-----------halfDayAbsent_HalfDayOD :Test Ended------------");
		System.out.println("-----------halfDayAbsent_HalfDayOD :Test Ended------------");
	}

	// 2. Apply OD for the second half and check the attendance string
	@Test(priority = 2)
	public static void halfDayOD_HalfDayOD() throws Exception {
		log.info("-----------halfDayOD_HalfDayOD :Test Started------------");
		System.out.println("-----------halfDayOD_HalfDayOD :Test Started------------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Maximize the leave form
		lfp.getMaximizeLeaveForm().click();
		// Click on OD page
		lfp.selectOutDoorDutyOnLeaveForm();
		// Click on leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		// select reason for OD
		lfp.selectODLeaveReason();
		Date date1 = new Date("21-Sept-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Pick second half start session
		lfp.getClickStartSession().click();
		lfp.pickSecondHalfStartSession();
		// Click end session and pick session2
		lfp.getClickEndSession().click();
		lfp.pickSecondHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsODform().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		// Click on HomeIcon
		lfp.getClickHomeIcon().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("-----------halfDayOD_HalfDayOD :Test Ended------------");
		System.out.println("-----------halfDayOD_HalfDayOD :Test Ended------------");
	}

//3. Cancel the half day OD then verify the attendance
	@Test(priority = 3)
	public static void cancelHalfDayODAndVerifyAttendance() {
		log.info("---------------cancelHalfDayWFHAndVerifyAttendance :-Test Started----------------");
		// Call the langing page then click on T&A Admin
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		lp.clickAdmin();
		// Click on T&A admin
		lp.clickTimeAndAttendance();
		// Put some wait to wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the time and attendance page
		TimeAndAttendancePage tap = PageFactory.initElements(driver, TimeAndAttendancePage.class);
		// Click on Leave List by employee section
		tap.clickLeaveListByEmployee();
		// Enter the employee id/name
		tap.getSearchEmployeeInLeaveListByEmployee().sendKeys("Ravi v");
		// Click on the searched employee and handle stale if it throws
		WebdriverUtils.handleStale(tap.getClickEmpInEmpLeaveListByEmp());
		// Click on the check box
		tap.getSelectLeave1ToCancel().click();
		// Click on submit
		WebdriverUtils.waitForElementPresent(driver, tap.getClickSubmitToCancel());
		tap.getClickSubmitToCancel().click();
		// Click on home icon
		lp.getClickHomeIcon().click();
		// Wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on attendance
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		lp.getClickAttendanceWindow().click();
		// Call the attendance page
		AttendancePage ap = PageFactory.initElements(driver, AttendancePage.class);
		// Get the attendance method to capture the string
		System.out.println("List of Attendance strings after cancellation");
		log.info("List of Attendance strings after cancellation");
		log.info("----------------------");
		ap.getAttendanceString();
		// Close the attendance window
		ap.getCloseAttendanceWindow().click();
		// Assert.assertTrue(ap.getAttendanceString().contains("18--D"));
		System.out.println("Leave has been successfully cancelled");
		log.info("-----------cancelHalfDayWFHAndVerifyAttendance :-Test Ended-----------");
	}

	// 4. Select the drop down and ensure all the leave types applicable for the
	// customer is available
	@Test()
	public static void clickAndVerifyLeaveTypes() throws Exception {
		log.info("------------clickAndVerifyLeaveTypes : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Declare the expected leave types
		List<String> expValues = fil.getLeaveExcelData("Nextgen", 1, 0);
		log.info("Expected leave types are :" + expValues);
		// Capture the actual leave types from the UI
		List<String> actualValues = lfp.printleaveTypeValues();
		log.info("Actual leave types are:" + actualValues);
		log.info("-Verify the leave types--");
		// Close the leave form
		lfp.getcloseLeaveForm().click();
		Assert.assertEquals(actualValues, expValues);
		log.info("Leave Types are matching with expected types" + actualValues);
		log.info("------------clickAndVerifyLeaveTypes : Test Ended-------------");
	}

	// 5. View leave balances and verify it
	@Test()
	public static void viewLeaveBalanceAndVerify() {
		log.info("------------viewLeaveBalanceAndVerify : Test Started---------");
		// Call the Leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Capture the actual leave balances
		List<String> actualLeaveBalances = lfp.printLeaveBalances();
		// Close the leave form table
		lfp.getcloseLeaveForm().click();
		log.info("-Verify the leave balance is displayed--");
		Assert.assertTrue(lfp.getLeaveBalanceTable().isDisplayed());
		log.info("The leave balances are :" + actualLeaveBalances);
		log.info("------------viewLeaveBalanceAndVerify : Test Ended-----------");
	}

	// 6. Select the drop down and select on the leave types
	@Test()
	public static void pickTheLeaveTypeAndVerify() {
		log.info("------------pickTheLeaveTypeAndVerify : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Select the leave type
		WebdriverUtils.waitForElementPresent(driver, lfp.getPickRandomLeaveType());
		lfp.getPickRandomLeaveType().click();
		String pickedLeaveType = lfp.getPickRandomLeaveType().getText();
		WebdriverUtils.waitForPageToLoad(driver);
		// Close the leave form
		lfp.getcloseLeaveForm().click();
		log.info("Verify if the leave type has selected");
		Assert.assertTrue(lfp.getPickRandomLeaveType().isDisplayed());
		log.info("Leave type is selected :" + pickedLeaveType);
		log.info("------------pickTheLeaveTypeAndVerify : Test Ended-----------");
	}

	// 7. Click on Submit button without selecting Leave Type then verify the error
	// message
	@Test()
	public static void verifyLeaveTypeMandatory() {
		log.info("------------verifyLeaveTypeMandatory : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		String expErrorMessage = "Leave Type cannot be empty";
		// Click on Submit
		lfp.getSubmitButton().click();
		String actualErrorMessage = lfp.getLeaveTypeBlankError().getText();
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Verify the error message");
		Assert.assertEquals(actualErrorMessage, expErrorMessage);
		log.info("Leave type is mandatory and the error message is :" + actualErrorMessage);
		log.info("------------verifyLeaveTypeMandatory : Test Ended-----------");
	}
	// 8. Select the drop down and ensure all the leave reasons applicable for the
		// customer is available
		@Test()
		public void verifyLeaveReasonsForLeaveType() throws Exception {
			log.info("------------verifyLeaveReasonsForLeaveType : Test Started-----------");
			// Call the landing page
			LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
			// Click on leave icon
			lfp.getClickLeaveForm().click();
			List<String> expLeaveReasons = fl.getLeaveExcelData("Bluestone", 1, 1);
			log.info("Expected Leave Reasons are : " + expLeaveReasons.toString());
			ArrayList<String> actualLeaveReasons = lfp.leaveReasonsForLeaveType();
			log.info(actualLeaveReasons);
			// Close the leave form window
			lfp.getcloseLeaveForm().click();
			// Validate the leave reasons
			log.info("-Validate the leave reasons-");
			Assert.assertEquals(actualLeaveReasons, expLeaveReasons);
			log.info("Actual Leave Reasons are matching with expected one");
			log.info("Actual leave reasons are :" + actualLeaveReasons);
			log.info("------------verifyLeaveReasonsForLeaveType : Test Ended-----------");
		}
	//9. Verify the leave reason mandatory
		@Test()
		public static void verifyLeaveReasonMandatory() {
			log.info("------------verifyLeaveReasonMandatory : Test Started-----------");
			// Call the landing page
			LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
			// Click on leave icon
			lfp.getClickLeaveForm().click();
			lfp.getClickLeaveTypeDropdown().click();
			String expErrorMessage = "Leave Reason cannot be empty";
			// Click on Submit
			lfp.getSubmitButton().click();
			String actualErrorMessage = lfp.getLeaveReasonBlankError().getText();
			// Close the leave form window
			lfp.getcloseLeaveForm().click();
			log.info("Verify the error message");
			Assert.assertEquals(actualErrorMessage, expErrorMessage);
			log.info("Leave reason is mandatory and the error message is :" + actualErrorMessage);
			log.info("------------verifyLeaveReasonMandatory : Test Ended-----------");
		}
		
}
