package StepDefinition;

import XERO.XeroAgedRecievableSummaryPage;
import io.cucumber.java.en.*;

public class XeroAgedRecievableSummarySteps {
	public XeroAgedRecievableSummaryPage xeroRecievableValues  = new XeroAgedRecievableSummaryPage();

	@Given("user is on client Aged Recievable summary page")
	public void user_is_on_client_aged_recievable_summary_page() {
	}

	@When("User click on accounting button")
	public void user_click_on_accounting_button() {
		xeroRecievableValues.clickOnAccountingButton();
	}

	@When("User click on aged Recievable summary button")
	public void user_click_on_aged_recievable_summary_button() {
		xeroRecievableValues.clickOnRecievable();
	}

	@When("User click on column to select the outstanding gst button")
	public void user_click_on_column_to_select_the_outstanding_gst_button() {
		xeroRecievableValues.clickOnColmSelected();
	}

	@When("User click on outstanding gst button")
	public void user_click_on_outstanding_gst_button() throws InterruptedException {
		xeroRecievableValues.clickOnOutstanding_GST();
	}

	@When("User click on end of month button")
	public void user_click_on_end_of_month_button() throws InterruptedException {
		xeroRecievableValues.clickOnEndOfMonth();
	}

	@When("User click on last financial year button")
	public void user_click_on_last_financial_year_button() {
		xeroRecievableValues.clickOnLastFinancialYear();
	}

	@When("User click on update button")
	public void user_click_on_update_button() {
		xeroRecievableValues.clickOnUpdate();
	}

	@Then("User check if the Aged Recievable summary exist then the Recievable value is mentioned on web else Zero")
	public void user_check_if_the_aged_recievable_summary_exist_then_the_recievable_value_is_mentioned_on_web_else_zero() {
		xeroRecievableValues.getAgedRecievableValues();
	}
}
