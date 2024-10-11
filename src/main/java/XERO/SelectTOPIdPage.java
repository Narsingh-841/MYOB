package XERO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class SelectTOPIdPage extends BaseClass{

	@FindBy(xpath="//span[contains(text(),'THE OUTSOURCE PRO PTY LTD')]")
	WebElement TOP;
	@FindBy(xpath="//button[@id='atoo-of-atobutton-005']")
	WebElement next;
	
	public SelectTOPIdPage(){	
		PageFactory.initElements(DriverManager.getDriver(), this);       
	}

	public void clickOnTOPButton() {
		wait.until(ExpectedConditions.elementToBeClickable(TOP));
		TOP.click();
	}

	public void clickOnNextButton() {
		wait.until(ExpectedConditions.elementToBeClickable(next));
		next.click();
	}
}
