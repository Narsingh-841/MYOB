package MYOB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class MYOBSearchClientNamePage extends BaseClass{
	String client = "Carnarvon Race Club inc";
	@FindBy(xpath="//input[@id='Input_r1i0KRgfR']")
	WebElement clientName;
	@FindBy(xpath= "//div[1][@role='cell']/a")
	WebElement nextButton;
	
	public MYOBSearchClientNamePage(){	
		PageFactory.initElements(DriverManager.getDriver(), this);    
	}
	public void sendClientName() {
		wait.until(ExpectedConditions.elementToBeClickable(clientName));
//		System.out.println(client);
		clientName.click();
		clientName.sendKeys(client);
	}
	public void clickClientName() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}
}
