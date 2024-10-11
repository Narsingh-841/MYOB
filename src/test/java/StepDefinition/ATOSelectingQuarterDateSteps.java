package StepDefinition;

import java.text.ParseException;

import XERO.ATOSelectingQuarterDatePage;
import io.cucumber.java.en.*;

public class ATOSelectingQuarterDateSteps {

	public ATOSelectingQuarterDatePage selectDate  = new ATOSelectingQuarterDatePage();
	
	@Given("Client Activity statements")
	public void client_activity_statements() {
	}

	@When("user click on History Button")
	public void user_click_on_history_button() {
		selectDate.clickHistory();
	}

	@When("User click the Filter button")
	public void user_click_the_filter_button() throws InterruptedException {
		selectDate.clickOnActivityStatementByScrolling();
		selectDate.clickOnFilterButton();
	}
	@Then("User enter the From date as provided in excel")
	public void user_enter_the_from_date_as_provided_in_excel() throws ParseException, InterruptedException {
		selectDate.enterFromoDate();
	}

	@Then("User enter the To date as provided in excel")
	public void user_enter_the_to_date_as_provided_in_excel() throws ParseException, InterruptedException {
		selectDate.enterToDate();
	}

	@Then("User click the Filter button again")
	public void user_click_the_filter_button_again() throws InterruptedException {
		selectDate.clickOnFilterButtonAfterEnteringDate();
	}
}
