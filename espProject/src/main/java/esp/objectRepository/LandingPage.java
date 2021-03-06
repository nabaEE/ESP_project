package esp.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class LandingPage {
	/************ Utilization *************/
	@FindBy(xpath = "//ul[@class='right hide-on-med-and-down']/li")
	private List<WebElement> landingPageValues;
	@FindBy(id = "Not_now")
	private WebElement clickNotNow;
	@FindBy(name = "Attendance")
	private WebElement attendanceWindow;
	@FindBy(id = "Not_now")
	private WebElement skipForNowButton;
	@FindBy(id = "present")
	private WebElement markAttendance;
	@FindBy(xpath = "//html//body//header//div[2]//nav//div//ul//li[2]//a//img")
	private WebElement adminIcon;
	@FindBy(xpath = "//div[@class='nav-wrapper']/ul/li[2]/a/span")
	private WebElement adminToolTip;
	@FindBy(xpath = "//ul[@id='AdminDropDowns']/li/a[text()='Configuration Setup']")
	private WebElement configurationSetupAdminValue;
	@FindBy(xpath = "//ul[@id='AdminDropDowns']/li/a")
	private List<WebElement> adminDropdownValues;
	@FindBy(xpath = "//ul[@id='AdminDropDowns']/li[4]/a")
	private WebElement newHireAdminValue;
	@FindBy(xpath = "//ul[@id='AdminDropDowns']/li/a[text()='People']")
	private WebElement peopleIcon;
	@FindBy(xpath = "//input[@id='ApprovalSearch']")
	private WebElement searchLeaveRequest;
	@FindBy(xpath = "//div[@id='approvals']/div[2]/div/li[1]/div/div/p[3]/span/span[2]/i")
	private WebElement approveRequest;
	@FindBy(xpath="//div[@id='approvals']/div[2]/div/li[1]/div/div/p[3]/span/span[3]/i")
	private WebElement rejectRequest;
	@FindBy(xpath = "//div[@class='row three-main-cards-row']/div[3]")
	private WebElement thirdPanel;
	@FindBy(xpath = "//div[@id='approvals']/div[1]/div/div/a/i")
	private WebElement moveToApprovalPage;
	@FindBy(xpath = "//div[@class='container-off']/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/a/div")
	private WebElement clickAttendanceWindow;
	@FindBy(xpath="//nav[@class='custom-navbar']/div/ul/li[3]")
	private WebElement clickHomeIcon;

	/*********** Getters Usage ************/
	public WebElement getRejectRequest() {
		return rejectRequest;
	}
	public WebElement getClickHomeIcon() {
		return clickHomeIcon;
	}
	public WebElement getMoveToApprovalPage() {
		return moveToApprovalPage;
	}

	public WebElement getThirdPanel() {
		return thirdPanel;
	}

	public WebElement getApproveRequest() {
		return approveRequest;
	}

	public WebElement getSearchLeaveRequest() {
		return searchLeaveRequest;
	}

	public WebElement getPeopleIcon() {
		return peopleIcon;
	}

	public WebElement getAttendanceWindow() {
		return attendanceWindow;
	}

	public WebElement getSkipForNowButton() {
		return skipForNowButton;
	}

	public WebElement getMarkAttendance() {
		return markAttendance;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getConfigurationSetupAdminValue() {
		return configurationSetupAdminValue;
	}

	public WebElement getNewHireAdminValue() {
		return newHireAdminValue;
	}

	public WebElement getAdminToolTip() {
		return adminToolTip;
	}

	public WebElement getClickNotNow() {
		return clickNotNow;
	}

	public WebElement getClickAttendanceWindow() {
		return clickAttendanceWindow;
	}

	/*********** Utilization *************/
	public void skipAttendance() {
		if (clickNotNow.isDisplayed()) {
			clickNotNow.click();
		} else {

		}
	}

	public void clickAdminIcon() {
		for (int i = 0; i < landingPageValues.size(); i++) {
			if (landingPageValues.get(i).equals(2)) {
				landingPageValues.get(i).click();
			}
		}

	}

	// Method to click new hire
	public void clickNewHire() {
		for (int i = 0; i < adminDropdownValues.size(); i++) {
			if (adminDropdownValues.get(i).getText().equalsIgnoreCase("New Hire")) {
				adminDropdownValues.get(i).click();
			}
		}
	}

	public void clickReports() {
		for (int i = 0; i < adminDropdownValues.size(); i++) {
			if (adminDropdownValues.get(i).getText().equalsIgnoreCase("Reports")) {
				adminDropdownValues.get(i).click();
			}
		}
	}

//Method to verify Admin tooltip
	public String getAdminTooltipText() throws InterruptedException {
		WebdriverUtils.waitForPageToLoad(BaseClass.driver);
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(adminIcon).perform();
		String tooltip = adminToolTip.getText();
		System.out.println("Tooltip message is " + tooltip);
		return tooltip;
	}

//Method to print all admin values
	public String[] printAdminValues() {
		String[] val = new String[10];
		for (int i = 0; i < adminDropdownValues.size(); i++) {
			val[i] = adminDropdownValues.get(i).getText();
			System.out.println(val[i]);
		}
		return val;

	}

//Method to click an element using java script executor
	public void clickAdmin() {
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass.driver;
		executor.executeScript("arguments[0].click();", adminIcon);
	}

//Method to click using java script
	public void clickElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass.driver;
		executor.executeScript("arguments[0].click();", element);
	}

//Method to click T&A Admin
	// Method to click new hire
	public void clickTimeAndAttendance() {
		for (int i = 0; i < adminDropdownValues.size(); i++) {
			if (adminDropdownValues.get(i).getText().equalsIgnoreCase("T&A Admin")) {
				adminDropdownValues.get(i).click();
			}
		}

	}
}