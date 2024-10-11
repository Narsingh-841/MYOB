package XERO;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroSecurityQuestionPage extends BaseClass{

	@FindBy(xpath = "//label[contains(@class,\"auth-firstquestion\")]")
	WebElement firstquestion;
	@FindBy(xpath = "//div[contains(@data-automationid,\"auth-firstanswer\")]/div/input")
	WebElement firstanswer;
	@FindBy(xpath = "//label[contains(@class,\"auth-secondquestion\")]")
	WebElement secondquestion;
	@FindBy(xpath = "//div[contains(@data-automationid,\"auth-secondanswer\")]/div/input")
	WebElement secondanswer;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitAns;

	// Constructor
	public XeroSecurityQuestionPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public void getPageTitle() {
	}
	public void answerSecurityQuestions() {
		String ques1 = XERO_SECURITY_QUEST1;
		String ans1 = XERO_SECURITY_ANS1;
		String ques2 = XERO_SECURITY_QUEST2;
		String ans2 = XERO_SECURITY_ANS2;
		String ques3 = XERO_SECURITY_QUEST3;
		String ans3 = XERO_SECURITY_ANS3;
		
		if(firstquestion.getText().equals(ques1)) {
			wait.until(ExpectedConditions.elementToBeClickable(firstanswer));
			firstanswer.sendKeys(ans1);
		}
		else if(firstquestion.getText().equals(ques2)) {
			wait.until(ExpectedConditions.elementToBeClickable(firstanswer));
			firstanswer.sendKeys(ans2);
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(firstanswer));
			firstanswer.sendKeys(ans3);
		}

		if(secondquestion.getText().equals(ques1)) {
			wait.until(ExpectedConditions.elementToBeClickable(secondanswer));
			secondanswer.sendKeys(ans1);
		}
		else if(secondquestion.getText().equals(ques2)) {
			wait.until(ExpectedConditions.elementToBeClickable(secondanswer));
			secondanswer.sendKeys(ans2);
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(secondanswer));
			secondanswer.sendKeys(ans3);
		}
	}
	public void clickSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitAns));
		submitAns.click();
	}
}
