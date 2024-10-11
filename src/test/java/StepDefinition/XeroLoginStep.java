package StepDefinition;


import com.asis.util.BaseClass;

import MYOB.MYOBLoginPage;
import XERO.XeroLoginPage;
import io.cucumber.java.en.*;

public class XeroLoginStep {

	XeroLoginPage xerologinPage;
	MYOBLoginPage myobloginPage;

	@Given("User user is on Login Page")
	public void user_user_is_on_login_page() {
		BaseClass.setupDriver("Chrome");
		xerologinPage = new XeroLoginPage();
		myobloginPage = new MYOBLoginPage();
//		if()
		BaseClass.lauchSite("https://login.xero.com");
	}

	@When("user enter email")
	public void user_enter_email() {
		xerologinPage.enterUserId();
	}

	@When("user enter password")
	public void user_enter_password() {
		xerologinPage.enterPassword();
	}

	@Then("click on xero login button")
	public void click_on_xero_login_button() {
		xerologinPage.clickLoginButton();
	}
	@When("user click on another authentication method")
	public void user_click_on_another_authentication_method() {
		xerologinPage.clickAnotherAuthMethod();
	}

	@When("click on security Questions")
	public void click_on_security_questions() {
		xerologinPage.clickSecurityQsn();
	}
}
