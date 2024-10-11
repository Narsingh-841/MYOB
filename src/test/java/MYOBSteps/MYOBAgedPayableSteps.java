package MYOBSteps;

import MYOB.MYOBAgedPayableSummaryPage;
import io.cucumber.java.en.*;

public class MYOBAgedPayableSteps {

    public MYOBAgedPayableSummaryPage agedPayable = new MYOBAgedPayableSummaryPage();

    @Given("User is on report page")
    public void user_is_on_report_page() {
    }

    @When("user click on Payable reconciliation with tax report")
    public void user_click_on_payable_reconciliation_with_tax_report() throws InterruptedException {
        agedPayable.clickPayable();
    }

    @Then("User enter the to date")
    public void user_enter_the_to_date() throws InterruptedException {
        agedPayable.passToDate();
    }

    @Then("user extract aged Payable value")
    public void user_extract_aged_payable_value() throws InterruptedException {
        agedPayable.getPayableTotal();
    }

    @When("user click on the reporting button")
    public void user_click_on_the_reporting_button() throws InterruptedException {
        agedPayable.clickReportingButton();
        agedPayable.clickReportsButton();
    }
}
