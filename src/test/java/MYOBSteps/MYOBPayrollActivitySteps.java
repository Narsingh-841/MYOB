package MYOBSteps;

import com.asis.util.BaseClass;

import MYOB.MYOBPayrollEmployeSummarryPage;
import io.cucumber.java.en.*;

public class MYOBPayrollActivitySteps extends BaseClass{

	public MYOBPayrollEmployeSummarryPage payroll= new MYOBPayrollEmployeSummarryPage();
	
	@Given("user is on report page")
	public void user_is_on_report_page() {
	
	}

	@When("user click on payroll activity")
	public void user_click_on_payroll_activity() {
		payroll.clickPayroll();
	}

	@Then("user enetr from date")
	public void user_enetr_from_date() throws InterruptedException {
		payroll.passFromDate();
	}

	@Then("user enter to date")
	public void user_enter_to_date() throws InterruptedException {
		payroll.passToDate();
	}

	@Then("user extract W1 and W2 value")
	public void user_extract_w1_and_w2_value() {
		payroll.extract_W1_4Values();
	}

	@When("user click on reporting")
	public void user_click_on_reporting() {
		payroll.clickReportingButton();
		payroll.clickReportsButton();
	}

}
