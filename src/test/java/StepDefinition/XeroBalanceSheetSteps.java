package StepDefinition;

import XERO.XeroBalanceSheetPage;
import io.cucumber.java.en.*;

public class XeroBalanceSheetSteps {
	public XeroBalanceSheetPage xeroBalanceSheetValues  = new XeroBalanceSheetPage();
	
	@Given("User is on client Aged Recievable summary page")
	public void user_is_on_client_aged_recievable_summary_page() {
	}

	@When("User click on the accounting button")
	public void user_click_on_the_accounting_button() {
		xeroBalanceSheetValues.clickOnAccountingButton();
	}

	@When("user click on Balance Sheet button")
	public void user_click_on_balance_sheet_button() {
		xeroBalanceSheetValues.clickOnBalanceSheetButton();
	}

	@Then("user extract the GST value from balance sheet page")
	public void user_extract_the_gst_value_from_balance_sheet_page() {
		xeroBalanceSheetValues.fetchingGST();
	}
}
