package MYOBSteps;

import com.asis.util.BaseClass;

import MYOB.MYOBReportingPage;
import io.cucumber.java.en.*;

public class MYOBReportsStep extends BaseClass{

	MYOBReportingPage reports = new MYOBReportingPage();
	
	@Given("User is on Home page")
	public void user_is_on_home_page() {
		
	}

	@When("User click on reporting button")
	public void user_click_on_reporting_button() {
		reports.clickReportingButton();
	}

	@Then("click on reports button")
	public void click_on_reports_button() {
		reports.clickReportsButton();
	}
}
