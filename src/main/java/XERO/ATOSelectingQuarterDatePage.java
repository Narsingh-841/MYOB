package XERO;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;

import Driver_manager.DriverManager;

public class ATOSelectingQuarterDatePage extends BaseClass{
	// List of WebElements
	@FindBy(xpath = "//div[@class='ato-tab']/ul/li[2]")
	WebElement history;
	@FindBy(xpath = "//h1/span[contains(text(),'Activity statements')]")
	WebElement scrollTo;
	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	WebElement filter;
	@FindBy(xpath = "//input[@id='dp-atoo-as-from-date-002']")
	WebElement From;
	@FindBy(xpath = "//input[@id='dp-atoo-as-to-date-002']")
	WebElement To;
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	WebElement filter2;

	// Constructor
	public ATOSelectingQuarterDatePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void getPageTitle() {
	}

	public void clickHistory() {
		wait.until(ExpectedConditions.elementToBeClickable(history));
		history.click();
	}

	public void clickOnActivityStatementByScrolling() {
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
	}

	public void clickOnFilterButton() throws InterruptedException {
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", filter);
	}

	public void enterFromoDate() throws ParseException, InterruptedException {
		String StringFromDate = ATO_FROM_DATE;
		wait.until(ExpectedConditions.elementToBeClickable(From)).clear();
//		From.clear();
		Thread.sleep(1000);
		From.sendKeys(StringFromDate);
	}

	public void enterToDate() throws ParseException, InterruptedException {
		String StringToDate = ATO_TO_DATE;
		wait.until(ExpectedConditions.elementToBeClickable(To)).clear();
//		To.clear();
		To.sendKeys(StringToDate);
		Thread.sleep(2000);
	}


	public void clickOnFilterButtonAfterEnteringDate() throws InterruptedException {
		js.executeScript("arguments[0].click();", filter2);
		Thread.sleep(3000);

	}
}
