package XERO;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroAgedPayableSummaryPage extends BaseClass{

	@FindBy(xpath = "//button[contains(text(),'Accounting')]")
	WebElement accountingButton;
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement reports;
	@FindBy(xpath = "//*[@class='report-row-tooltip']//descendant::span[contains(text(),'Aged Payables Summary')]")
	WebElement payable;
	@FindBy(xpath = "//button[@id='report-settings-columns-button']")
	WebElement colmSelected;
	@FindBy(xpath = "//span[contains(text(),'Outstanding GST')]")
	WebElement Outstanding_GST;
	@FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]")
	WebElement endOfMonth;
	@FindBy(xpath = "//span[contains(text(),'End of last financial year ')]")
	WebElement lastFinancialYear;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement Update;
	@FindBy(xpath = "//div[contains(text(),'Nothing to show here')]")
	public WebElement noShowDiv;
	@FindBy(xpath = "//tr//descendant::div[text()='Total']/ancestor::tr/td[9]/span/div")
	public WebElement GST2;
	public static double payableAmount = 0.0;
	public static double Total = 0.0;
	// Constructor
	public XeroAgedPayableSummaryPage() {	
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}
	//list  of all the actions on page
	public static void getPageTitle() {
	}

	public void clickAccountingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(accountingButton));
		accountingButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(reports));
		reports.click();
	}
	public void clickPayable() {
		wait.until(ExpectedConditions.elementToBeClickable(payable));
		payable.click();
	}
	public void clickColmSelected() {
		wait.until(ExpectedConditions.elementToBeClickable(colmSelected));
		colmSelected.click();
	}
	public void clickOutstanding_GST() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Outstanding_GST));
		Outstanding_GST.click();
	}
	public void clickEndOfMonth() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(endOfMonth));
		endOfMonth.click();
	}
	public void clickLastFinancialYear() {
		wait.until(ExpectedConditions.elementToBeClickable(lastFinancialYear));
		lastFinancialYear.click();
	}
	public void clickUpdate() {
		wait.until(ExpectedConditions.elementToBeClickable(Update));
		Update.click();
	}
	public void getAgedPayableValues() {
		boolean exists = false;
		try {
			exists = noShowDiv.isDisplayed();
		} catch (NoSuchElementException e) {
			exists = false; // Element is not present, hence set exists to false
		}

		double payableAmount = 0.0;
		if (exists) {
			System.out.println("No data to show: " + payableAmount);
		} else { 
			wait.until(ExpectedConditions.visibilityOf(GST2));
			String gstText = GST2.getText().replaceAll(",", "");
			try {
				payableAmount = Double.parseDouble(gstText);
			} catch (NumberFormatException e) {
				System.err.println("Error parsing GST amount: " + gstText);
			}
		}
		HashMap<String, Double> hm3 = new HashMap<>();
		hm3.put("Less: GST on Creditors", payableAmount);
		LAST_TABLE_DATA.add(hm3);

		HashMap<String, Double> hm4 = new HashMap<>();
		double juneBAS = LAST_TABLE_DATA.get(0).get("June BAS") != null ? LAST_TABLE_DATA.get(0).get("June BAS") : 0.0;
		double total = juneBAS + payableAmount + XeroAgedRecievableSummaryPage.RecievableAmount;
		hm4.put("Total", total);
		LAST_TABLE_DATA.add(hm4);
		System.out.println("Total: " + LAST_TABLE_DATA.get(1));


	}
}
