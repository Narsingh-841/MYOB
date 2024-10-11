package StepDefinition;

import XERO.XeroGetActivityStatementValuesPage;
import io.cucumber.java.en.*;

public class XeroGetQuarterValuesSteps {

	public XeroGetActivityStatementValuesPage xeroquarterValues  = new XeroGetActivityStatementValuesPage();
	
	@Given("user is on clien Activity statement page")
	public void user_is_on_clien_activity_statement_page() {
	}

	@Then("user extract the A1 B1 G1 Values from client activity statement page")
	public void user_extract_the_a1_b1_g1_values_from_client_activity_statement_page() {
		xeroquarterValues.captureA1G1B1Data();
//		xeroquarterValues.capture4W1B1Data();
//		xeroquarterValues.generateExcel();
	}
}
