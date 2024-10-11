package StepDefinition;

import XERO.XEROSearchClientPage;
import io.cucumber.java.en.*;

public class XEROSearchClientSteps {
	
	XEROSearchClientPage searchpagexero = new XEROSearchClientPage();

	@Given("I am on home page of XERO")
	public void i_am_on_home_page_of_xero() {
		searchpagexero.clickOnSearchButton();
	}

	@When("I enter client name in search box of XERO")
	public void i_enter_client_name_in_search_box_of_xero() {
		searchpagexero.clickOnchnageOrganizationButton();
	}

	@When("I press enter keyword of XERO")
	public void i_press_enter_keyword_of_xero() throws InterruptedException {
		searchpagexero.writeinchnageOrganizationBox();
	}

	@Then("I should land on client home screen of XERO")
	public void i_should_land_on_client_home_screen_of_xero() throws InterruptedException {
		searchpagexero.doSearchClientName();
	}
}
