package StepDefinition;

import com.asis.util.BaseClass;
import XERO.ATOClientNameSearchPage;
import XERO.ATOGoToQuarterName;
import XERO.SelectTOPIdPage;
import io.cucumber.java.en.*;

public class ATOSearchClientNameStep extends BaseClass {
    private ATOClientNameSearchPage clientSearchPage = new ATOClientNameSearchPage();
    private SelectTOPIdPage selectTOP = new SelectTOPIdPage();
    private ATOGoToQuarterName quarterNamePage;

    public static String taxation = TAXATION; // Ensure TAXATION is defined elsewhere

    @Given("I am on home page")
    public void i_am_on_home_page() {
        // Navigate to the home page logic goes here
    }

    @When("I enter client name in search box")
    public void i_enter_client_name_in_search_box() throws InterruptedException {
        if (taxation.equalsIgnoreCase("taxation")) {
            // Pass the actual client name here as needed
            clientSearchPage.enterClientName(ATO_CLIENT_NAME);
        } else {
            selectTOP.clickOnTOPButton();
        }
    }

    @When("I press enter keyword")
    public void i_press_enter_keyword() throws InterruptedException {
        if (taxation.equalsIgnoreCase("taxation")) {
            clientSearchPage.doSearchClientName();
        } else {
            selectTOP.clickOnNextButton();
        }
    }

    @Then("I should land on client home screen")
    public void i_should_land_on_client_home_screen() {
        // Validation logic to confirm landing on client home screen
    }

    @When("I go to Lodgments")
    public void i_go_to_lodgments() throws InterruptedException {
        quarterNamePage = new ATOGoToQuarterName();
        quarterNamePage.clickLodgments();
    }

    @And("Select Activity statements")
    public void select_activity_statements() {
        quarterNamePage.checkingOptionAndClickingActivityStatements();
    }
}
