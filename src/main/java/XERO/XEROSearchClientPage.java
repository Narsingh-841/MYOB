package XERO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class XEROSearchClientPage extends BaseClass{

	@FindBy(xpath = "//button[@data-automationid='xnav-appbutton']")
	WebElement search;
	@FindBy(xpath = "//button[contains(text(),'Change organisation')]")
	WebElement chnageOrganization;
	@FindBy(xpath = "//input[@title='Search organisations']")
	WebElement searchBox;
	@FindBy(xpath = "//a[@data-menu-item-type='ORG']")
	WebElement options;
	
	public XEROSearchClientPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public void clickOnSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
	}
	public void clickOnchnageOrganizationButton() {
		wait.until(ExpectedConditions.elementToBeClickable(chnageOrganization));
		chnageOrganization.click();
	}
	public void writeinchnageOrganizationBox() throws InterruptedException {
		String client_name = ATO_CLIENT_NAME;
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		Thread.sleep(1000);
		searchBox.sendKeys(client_name);
		Thread.sleep(3000);
		if (options.getText().trim().equalsIgnoreCase(ATO_CLIENT_NAME)) {
		 options.click();
		}
	}
	public void doSearchClientName() throws InterruptedException {
	}
}
