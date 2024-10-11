package StepDefinition;


import XERO.XeroSecurityQuestionPage;
import io.cucumber.java.en.*;

public class XeroSecurityQuestionSteps {

    XeroSecurityQuestionPage securityQuestion = new XeroSecurityQuestionPage();

	@Given("User wants to enter security ans")
	public void user_wants_to_enter_security_ans() {
		System.out.println("at securityquestion");
	}

	@When("user enter security question ans")
	public void user_enter_security_question_ans() {
		securityQuestion.answerSecurityQuestions();
	}
	@Then("user subit the Answer")
	public void user_subit_the_answer() {
		securityQuestion.clickSubmitButton();
	}
}
