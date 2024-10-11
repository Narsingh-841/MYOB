package StepDefinition;

import javax.mail.MessagingException;

import com.asis.util.BaseClass;

import XERO.ATOExtractingBASValuesPage;
import io.cucumber.java.en.*;

public class ATOExtractingBASValuesSteps {
	public ATOExtractingBASValuesPage dataValues  = new ATOExtractingBASValuesPage();


	@Given("All the filtered Quarter are visible to user")
	public void all_the_filtered_quarter_are_visible_to_user() {
	}

	@When("user click on July Quarter")
	public void user_click_on_quarter() throws InterruptedException, MessagingException {
		dataValues.clickOnJulyQuarter();
	}

	@Then("July Quarter will get open")
	public void july_quarter_will_get_open() throws MessagingException {

	}
	@Given("All the filtered Quarters are visible to user")
	public void all_the_filtered_quarters_are_visible_to_user() {
	}

	@When("user click on October Quarter")
	public void user_click_on_october_quarter() throws InterruptedException {
		dataValues.clickOnOctQuarter();
	}

	@Then("October Quarter will get open")
	public void october_quarter_will_get_open() {
	}

	@Given("All the filtered Quarter are visible to the user")
	public void all_the_filtered_quarter_are_visible_to_the_user() {
	}

	@When("user click on January Quarter")
	public void user_click_on_january_quarter() throws InterruptedException {
		dataValues.clickOnJanQuarter();
	}

	@Then("January Quarter will get open")
	public void january_quarter_will_get_open() {
	}

	@Given("All the filtered Quarters are visible to the user")
	public void all_the_filtered_quarters_are_visible_to_the_user() {
	}

	@When("user click on April Quarter")
	public void user_click_on_april_quarter() throws InterruptedException {
		dataValues.clickOnAprQuarter();
	}

	@Then("April Quarter will get open")
	public void april_quarter_will_get_open() {
	}


	
}
