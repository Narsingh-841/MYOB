package MYOB;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class MYOBPayrollEmployeSummarryPage extends BaseClass {

	@FindBy(xpath="//div[contains(text(),'Payroll activity')]")
	WebElement payroll;

	@FindBy(xpath="//input[@name='FROM_DATE']")
	WebElement fromDate;

	@FindBy(xpath="//input[@name='TO_DATE']")
	WebElement toDate;

	@FindBy(xpath="//div[@role='row' and .//span[text()='Grand total']]//div[2]//span")
	WebElement _W1;

	@FindBy(xpath="//div[@role='row' and .//span[text()='Grand total']]//div[4]//span")
	WebElement _4;

	@FindBy(xpath="//div[contains(text(),'Reporting')]")
	WebElement reporting;

	@FindBy(xpath="//span[contains(text(),'Reports')]")
	WebElement reports;

	public MYOBPayrollEmployeSummarryPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void clickPayroll() {
		wait.until(ExpectedConditions.elementToBeClickable(payroll));
		payroll.click();
	}

	public void passFromDate() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fromDate));

		// Send a sequence of backspace or delete keys to clear the field
		fromDate.sendKeys(Keys.CONTROL + "a");
		fromDate.sendKeys(Keys.DELETE);

		fromDate.sendKeys("01/07/2022");
		Thread.sleep(3000);
	}

	public void passToDate() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(toDate));
		String StringToDate =ATO_TO_DATE;
		toDate.sendKeys(Keys.CONTROL + "a");
		toDate.sendKeys(Keys.DELETE);

		toDate.sendKeys(StringToDate);
		Thread.sleep(3000);
	}

	public void extract_W1_4Values() {
		fetchCaptureA1G1B1Data.add(_W1.getText().replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(_4.getText().replaceAll("[,]", ""));
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
