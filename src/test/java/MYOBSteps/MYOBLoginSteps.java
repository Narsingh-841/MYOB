package MYOBSteps;

import com.asis.util.BaseClass;

import MYOB.MYOBLoginPage;
import io.cucumber.java.en.*;

public class MYOBLoginSteps extends BaseClass{

	MYOBLoginPage MYOBlogin = new MYOBLoginPage();;
	
	@Given("User user is on MYOB Login Page")
	public void user_user_is_on_myob_login_page() {
		BaseClass.setupDriver("Chrome");
		MYOBlogin = new MYOBLoginPage();
		BaseClass.lauchSite("https://app.myob.com/#/businesses");  
	}

	@When("user enter email on MYOB")
	public void user_enter_email_on_myob() {
		MYOBlogin.enterEmailAddress();
	}

	@Then("click on next button")
	public void click_on_next_button() {
		MYOBlogin.clickOnNextButton();
	}

	@Then("user enter password on MYOB")
	public void user_enter_password_on_myob() {
		MYOBlogin.enterPassword();
	}

	@Then("click on signin button")
	public void click_on_signin_button() {
		MYOBlogin.clickOnSigninButton();
		MYOBlogin.enterCode();
//		MYOBlogin.enterAuthenticationCode();
	}
}
