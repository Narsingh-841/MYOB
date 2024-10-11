package StepDefinition;

import XERO.XeroAgedPayableSummaryPage;
import io.cucumber.java.en.*;

public class XeroAgedPayableSummarySteps {

	public XeroAgedPayableSummaryPage xeroPaybaleValues  = new XeroAgedPayableSummaryPage();

	@Given("user is on client Aged payable summary page")
	public void user_is_on_client_aged_payable_summary_page() {
	}
	@When("user click on accounting button")
	public void user_click_on_accounting_button() {
		xeroPaybaleValues.clickAccountingButton();
	}
	@When("user click on aged payable summary button")
	public void user_click_on_aged_payable_summary_button() {
		xeroPaybaleValues.clickPayable();
	}
	@When("user click on column to select the outstanding gst button")
	public void user_click_on_column_to_select_the_outstanding_gst_button() {
		xeroPaybaleValues.clickColmSelected();
	}
	@When("user click on outstanding gst button")
	public void user_click_on_outstanding_gst_button() throws InterruptedException {
		xeroPaybaleValues.clickOutstanding_GST();
	}
	@When("user click on end of month button")
	public void user_click_on_end_of_month_button() throws InterruptedException {
		xeroPaybaleValues.clickEndOfMonth();
	}
	@When("user click on last financial year button")
	public void user_click_on_last_financial_year_button() {
		xeroPaybaleValues.clickLastFinancialYear();
	}
	@When("user click on update button")
	public void user_click_on_update_button() {
		xeroPaybaleValues.clickUpdate();
	}
	@Then("user check if the Aged payable summary exist then the payable value is mentioned on web else Zero")
	public void user_check_if_the_aged_payable_summary_exist_then_the_payable_value_is_mentioned_on_web_else_zero() {
		xeroPaybaleValues.getAgedPayableValues();
	}
}
