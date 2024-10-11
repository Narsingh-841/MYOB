package StepDefinition;

import XERO.XeroGSTReconciliationPage;
import io.cucumber.java.en.*;

public class XeroGSTReconciliationSteps {

	public XeroGSTReconciliationPage fetchGSTStatement  = new XeroGSTReconciliationPage();
	@Given("User is on Balance Sheet page of client")
	public void user_is_on_balance_sheet_page_of_client() {
	}

	@When("user click on the Accounting Button")
	public void user_click_on_the_accounting_button() {
		fetchGSTStatement.clickOnAccountingButton();
	}

	@When("User click the GST Reconciliation Button")
	public void user_click_the_gst_reconciliation_button() {
		fetchGSTStatement.clickOnGSTReconciliationButton();
	}

	@Then("User click on export Drop down Button")
	public void user_click_on_export_drop_down_button() {
		fetchGSTStatement.clickExport();
	}

	@Then("User click on excel option")
	public void user_click_on_excel_option() throws InterruptedException {
		fetchGSTStatement.clickOnExportToExcel();
	}
}
