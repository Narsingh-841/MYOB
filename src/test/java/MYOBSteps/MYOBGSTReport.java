package MYOBSteps;

import MYOB.MYOBGSTReportPage;
import io.cucumber.java.en.*;

public class MYOBGSTReport {

	MYOBGSTReportPage gstReports = new MYOBGSTReportPage();
	
	@Given("User is on reports page")
	public void user_is_on_reports_page() {
		
	}

	@When("user click on  gst return button")
	public void user_click_on_gst_return_button() {
		gstReports.clickGSTReportPage();
	}

	@Then("User enter from and to date")
	public void user_enter_from_and_to_date() throws InterruptedException {
		gstReports.passFromDate();
		gstReports.passToDate();
	}

	@Then("User extract A1 B1 and G1")
	public void user_extract_a1_b1_and_g1() {
		gstReports.extractG1A1B1Value();
	}

	@Then("User click on reporting and reports button")
	public void user_click_on_reporting_and_reports_button() {
		gstReports.clickReportingButton();
		gstReports.clickReportsButton();
	}
}
