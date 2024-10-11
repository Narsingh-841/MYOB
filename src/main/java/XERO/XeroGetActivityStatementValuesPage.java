package XERO;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.Excel;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroGetActivityStatementValuesPage extends BaseClass{

	@FindBy(xpath = "//tr//descendant::span[contains(text(),'Total sales')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement G1;
	@FindBy(xpath = "//tr//descendant::span[contains(text(),'GST on sales')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement A1;
	@FindBy(xpath = "//tr//descendant::span[contains(text(),'GST on purchases')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement B1;
	/*
	@FindBy(xpath = "//button[contains(text(),'Accounting')]")
	WebElement accountingButton;
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement reports;
	@FindBy(xpath = "//*[@class='report-row-tooltip']//descendant::span[contains(text(),'Payroll Employee Summary')]")
	WebElement payroll_Employee_Summary;
	@FindBy(xpath = "//button[@data-automationid='report-settings-convenience-date-dropdown-button']")
	WebElement lastQuarter;
	@FindBy(xpath = "//span[contains(text(),'Last financial year')]")
	WebElement lastFinanYear;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement update;
	@FindBy(xpath = "//div[contains(text(),'Total')]/ancestor::tr[1]//td[2]//div")
	WebElement _W1;
	@FindBy(xpath = "//div[contains(text(),'Total')]/ancestor::tr[1]//td[4]//div")
	WebElement _4;
	*/
	
	// Constructor
	public XeroGetActivityStatementValuesPage() {	
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}
	//list  of all the actions on page
	public void getPageTitle() {
	}
	public void captureA1G1B1Data() {
		fetchCaptureA1G1B1Data.add(G1.getText().replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(A1.getText().replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(B1.getText().replaceAll("[,]", ""));
	}
	/*
	public void capture4W1B1Data() {
		wait.until(ExpectedConditions.elementToBeClickable(accountingButton));
		accountingButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(reports));
		reports.click();
		wait.until(ExpectedConditions.elementToBeClickable(payroll_Employee_Summary));
		payroll_Employee_Summary.click();
		wait.until(ExpectedConditions.elementToBeClickable(lastQuarter));
		lastQuarter.click();
		wait.until(ExpectedConditions.elementToBeClickable(lastFinanYear));
		lastFinanYear.click();
		wait.until(ExpectedConditions.elementToBeClickable(update));
		update.click();
		
		fetchCaptureA1G1B1Data.add(_W1.getText().replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(_4.getText().replaceAll("[,]", ""));
	}
	*/
	
	public void generateExcel() {
		String[] client_data = {ATO_CLIENT_NAME, ATO_TO_DATE};
		Excel obj = new Excel();
		obj.createFinancialSummaryExcelWithData("Final_data.xls", BaseClass.ATO_ROW_DATA, BaseClass.XERO_DATA, BaseClass.ACTIVITY_STATEMENT_DATA,client_data);
	}
}
