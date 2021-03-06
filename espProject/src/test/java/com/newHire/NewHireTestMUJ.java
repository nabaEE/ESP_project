package com.newHire;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.FileUtils;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.CompensationPage;
import esp.objectRepository.HireSummaryPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.NewHirePage;

public class NewHireTestMUJ extends BaseClass {
	@Test(groups = "Smoke")
	public static void submitNewHireFormAndValidate() throws Throwable {
		log.debug("---------submit New Hire Form and validate all mandatory fields are selected----------");
		FileUtils fil = new FileUtils();
		// driver.findElement(By.id("Not_now")).click();
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click add new button
		WebdriverUtils.waitForElementPresent(driver, nhp.getClickAddNewButton());
		nhp.getClickAddNewButton().click();
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys(fil.getExcelData("MUJ", 1, 0));
		// Enter last name
		nhp.getLastNameEditbox().sendKeys(fil.getExcelData("MUJ", 1, 1));
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("MUJ", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("MUJ", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("MUJ", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("0001118");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("prakash.sinha");
		// Click email domain
		nhp.getEmailDomainDropdown().click();
		// Select the domain type
		nhp.getPickEmailDomain().click();
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Stop page refresh
		// BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		// Enter three letters in the Department editbox and pick one department
		/*
		 * try { nhp.getDepartmentEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectDepartment(); //nhp.getPickDepartment().click(); }
		 * catch(StaleElementReferenceException e) { nhp.getPickDepartment().click(); }
		 */
		nhp.getDepartmentEditbox().sendKeys("dep");
		nhp.chooseDepartment();
		// Enter three letters in the role editbox
		/*
		 * try { nhp.getRoleEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectRole(); } catch(StaleElementReferenceException e) {
		 * //nhp.selectRole(); nhp.selectRole(); }
		 */
		WebdriverUtils.waitForElementPresent(driver, nhp.getRoleEditbox());
		nhp.getRoleEditbox().sendKeys("tea");
		Thread.sleep(1000);
		// nhp.getPickRole().click();
		nhp.chooseRole();
		// Enter three letters and select Designation
		/*
		 * try { nhp.getDesignationEditbox().sendKeys("Sal"); Thread.sleep(2000);
		 * nhp.getPickDesignation().click(); } catch(StaleElementReferenceException e) {
		 * nhp.getPickDesignation().click(); }
		 */
		nhp.getDesignationEditbox().sendKeys("man");
		Thread.sleep(1000);
		nhp.getPickDesignation().click();
		// Enter three letters and select reporting hiring manager
		/*
		 * try { nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
		 * Thread.sleep(2000); nhp.getPickReportingHiringManager().click(); }
		 * catch(StaleElementReferenceException e) {
		 * WebdriverUtils.waitForElementPresent(driver,
		 * nhp.getPickReportingHiringManager());
		 * nhp.getPickReportingHiringManager().click(); }
		 */
		// Click on grade dropdown
		nhp.getGradeDropdown().click();
		// Select the teaching grade
		nhp.selectGrade();
		nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
		Thread.sleep(1000);
		nhp.getPickReportingHiringManager().click();
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		WebdriverUtils.waitForElementPresent(driver, nhp.getSaveAndContinueButtonMUJ());
		nhp.getSaveAndContinueButtonMUJ().click();
		// Call the compensation page and click on skip button
		CompensationPage cmp = PageFactory.initElements(driver, CompensationPage.class);
		// Click hire summary
		WebdriverUtils.waitForElementPresent(BaseClass.driver, cmp.getClickHireSummaryMUJ());
		cmp.getClickHireSummaryMUJ().click();
		// Call the Hire Summary page
		HireSummaryPage hs = PageFactory.initElements(driver, HireSummaryPage.class);
		hs.getclickPersonalData().click();
		// Click on save and continue button on new hire page to validate all the
		// mandatory fields
		nhp.getSaveAndContinueButtonMUJ().click();
		// click hire summary
		cmp.getClickHireSummaryMUJ().click();
		// Capture the Hire summary page title to validate
		String hireSummaryTitle = hs.gethireSummaryPageTitle().getText();
		// Validate the page title
		Assert.assertTrue(hireSummaryTitle.contains("Hire Summary for"));
		System.out.println("All new hire mandatory fields has been verified successfully");
		System.out.println("The page title is :--" + hireSummaryTitle);
		log.info("The page title is :--" + hireSummaryTitle);
	}

}
