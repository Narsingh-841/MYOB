package MYOBSteps;

import MYOB.MYOBAgedRecieveablePage;
import io.cucumber.java.en.*;

public class MYOBAgedReceivableSteps {

	public MYOBAgedRecieveablePage agedReceivable = new MYOBAgedRecieveablePage();
	
	@Given("user is on the report page")
	public void user_is_on_the_report_page() {
	
	}

	@When("user click on Receivables reconciliation with tax report")
	public void user_click_on_receivables_reconciliation_with_tax_report() throws InterruptedException {
		agedReceivable.clickReceivableButton();
	}

	@Then("user enter the to date")
	public void user_enter_the_to_date() throws InterruptedException {
		agedReceivable.passToDate();
	}

	@Then("user extract aged receivable value")
	public void user_extract_aged_receivable_value() throws InterruptedException {
		agedReceivable.receivableAmount();
	}

	@When("user click on the reporting")
	public void user_click_on_the_reporting() {
		agedReceivable.clickReportingButton();
		agedReceivable.clickReportsButton();
	}
}
