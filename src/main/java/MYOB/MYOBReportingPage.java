package MYOB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class MYOBReportingPage extends BaseClass {

	@FindBy(xpath="//div[contains(text(),'Reporting')]")
	WebElement reporting;
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	WebElement reports;
	
	public MYOBReportingPage(){	
		PageFactory.initElements(DriverManager.getDriver(), this);    
	}
	public void clickReportingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(reporting));
		reporting.click();
	}
	public void clickReportsButton() {
		wait.until(ExpectedConditions.elementToBeClickable(reports));
		reports.click();
	}
	
	
}
