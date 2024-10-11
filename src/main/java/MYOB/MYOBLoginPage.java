package MYOB;

import javax.swing.JOptionPane;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class MYOBLoginPage extends BaseClass{

	@FindBy(xpath="//input[@id='username']")
	WebElement emailAddress;
	@FindBy(xpath= "//button[contains(text(),'Next')]")
	WebElement nextButton;
	@FindBy(xpath= "//input[@id='password']")
	WebElement password;
	@FindBy(xpath= "//button[contains(text(),'Sign in')]")
	WebElement signin;
	@FindBy(xpath= "//input[@id='code']")
	WebElement authenti;
	@FindBy(xpath= "//span[@aria-label='Error']")
	WebElement error;
	//span[@aria-label='Error']
	@FindBy(xpath= "//button[contains(text(),'Continue')]")
	WebElement continueButton;
	//button[contains(text(),'Continue')]

	public MYOBLoginPage(){	
		PageFactory.initElements(DriverManager.getDriver(), this);    
	}
	public void enterEmailAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
		String email = XERO_USER_NAME;
		System.out.println(emailAddress);
		emailAddress.sendKeys(email);
	}
	public void clickOnNextButton() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}
	public void enterPassword() {
		wait.until(ExpectedConditions.elementToBeClickable(password));
		String passwordValue =XERO_PASSWORD;
		password.sendKeys(passwordValue);
	}
	public void clickOnSigninButton() {
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
	}
	
	public void enterCode() {
		wait.until(ExpectedConditions.elementToBeClickable(authenti));
		String code =MYOBCODE;
		authenti.sendKeys(code);
		authenti.sendKeys(Keys.ENTER);    
//		authenti.sendKeys(ENTER);
//		continueButton.click();
	}
	/*
	  public void enterAuthenticationCode() {
	        String authenticationCode = JOptionPane.showInputDialog("Enter your Authentication code:");
	        if (authenticationCode == null || authenticationCode.trim().isEmpty()) {
	            System.out.println("Authentication code is required");
	            return;
	        }
	        wait.until(ExpectedConditions.elementToBeClickable(authenti));
	        authenti.sendKeys(authenticationCode);
	        continueButton.click();
	    }
	    */
}
