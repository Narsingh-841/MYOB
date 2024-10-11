package StepDefinition;

import XERO.ATOExtractingBASValuesPage;
import XERO.closingATOPage;
import io.cucumber.java.en.*;

public class closingAtoSteps {

	public closingATOPage extractValues  = new closingATOPage();

	
	@Given("User done with the ATO data")
	public void user_done_with_the_ATO_data() {		
	}

	@When("User close the browser")
	public void user_close_the_browser() {
		extractValues.closeBrowser();
	}
}
