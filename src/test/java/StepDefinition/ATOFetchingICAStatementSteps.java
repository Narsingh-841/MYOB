package StepDefinition;

import java.text.ParseException;

import XERO.ATOSelectingQuarterDatePage;
import XERO.ATOfetchingICAStatement;
import io.cucumber.java.en.*;

public class ATOFetchingICAStatementSteps {

	public ATOfetchingICAStatement fetchICAStatement  = new ATOfetchingICAStatement();


	@Given("user is on client home page and want to extract ICA statement")
	public void user_is_on_client_home_page_and_want_to_extract_ica_statement() {

	}

	@When("User click on Accounts and payments")
	public void user_click_on_accounts_and_payments() throws InterruptedException {
		fetchICAStatement.clickAccountsAnsPayments();
	}

	@Then("User get menu bar")
	public void user_get_menu_bar() throws InterruptedException {
		fetchICAStatement.clickOptions();
	}

	@When("User click on Activity Statement")
	public void user_click_on_activity_statement() {
		fetchICAStatement.clickActivityStatements();
	}

	@Then("User click on filter")
	public void user_click_on_filter() throws InterruptedException {
		fetchICAStatement.clickFilter();
	}

	@Then("User clear from  date box and enter the From date as provided in excel")
	public void user_clear_from_date_box_and_enter_the_from_date_as_provided_in_excel() throws ParseException {
		fetchICAStatement.enterFromDaate();
	}

	@Then("User clear the To box and enter the To date as provided in excel")
	public void user_clear_the_to_box_and_enter_the_to_date_as_provided_in_excel() throws ParseException, InterruptedException {
		fetchICAStatement.enterToDate();
	}

	@When("User click the Submit button")
	public void user_click_the_submit_button() throws InterruptedException {
		fetchICAStatement.clickSubmitButton();
	}

	@Then("User click on PrintFriendlyVersion")
	public void user_click_on_print_friendly_version() {
		fetchICAStatement.clickPrintFriendlyVersion();
	}
	@Then("User direct to new tab")
	public void user_direct_to_new_tab() {
		fetchICAStatement.switchingTabs();
	}

	@Then("User Extract activity statement")
	public void user_extract_activity_statement() {
		fetchICAStatement.extractActivityStatement();
	}

	@Then("user close the tab")
	public void user_close_the_tab() {
		fetchICAStatement.closingTabs();
	}

}
