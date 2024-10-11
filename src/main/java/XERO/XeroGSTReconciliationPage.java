package XERO;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroGSTReconciliationPage extends BaseClass {


	@FindBy(xpath = "//button[contains(text(),'Accounting')]")
	WebElement accountingButton;
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement reports;
	@FindBy(xpath = "//*[@class='report-row-tooltip']//descendant::span[contains(text(),'GST Reconciliation')]")
	WebElement GSTreconcil;
	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement From;
	@FindBy(xpath = "//input[@id='toDate']")
	WebElement To;
	@FindBy(xpath = "//a[@id='ext-gen26']")
	WebElement UpdateButton;
	@FindBy(xpath = "//span[contains(text(),'Export')]")
	WebElement export;
	@FindBy(xpath = "//a[@title='Export to Excel']")
	WebElement exportToExcel;
	
	// Constructor
	public XeroGSTReconciliationPage() {	
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}
	//list  of all the actions on page
	public static void getPageTitle() {
	}

	public void clickOnAccountingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(accountingButton));
		accountingButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(reports));
		reports.click();
	}
	public void clickOnGSTReconciliationButton() {
		wait.until(ExpectedConditions.elementToBeClickable(GSTreconcil));
		GSTreconcil.click();
	}
	public void clickExport() {
		String StringFromDate = XERO_FROM_DATE;
		wait.until(ExpectedConditions.elementToBeClickable(From));
		From.clear();
		From.sendKeys(StringFromDate);
	}
	public void clickOnExportToExcel() throws InterruptedException {
		String StringToDate = XERO_TO_DATE;
		wait.until(ExpectedConditions.elementToBeClickable(To));
		To.clear();
		To.sendKeys(StringToDate);
		wait.until(ExpectedConditions.elementToBeClickable(UpdateButton));
		UpdateButton.click();
		js.executeScript("arguments[0].scrollIntoView(true)", export);
		wait.until(ExpectedConditions.elementToBeClickable(export));
		export.click();
		wait.until(ExpectedConditions.elementToBeClickable(exportToExcel));
		exportToExcel.click();
		Thread.sleep(3000);
		DriverManager.getDriver().quit();
		
	}
}
