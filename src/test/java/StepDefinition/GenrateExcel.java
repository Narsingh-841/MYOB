package StepDefinition;

import com.asis.util.BaseClass;

import XERO.GenratingExcelPage;
import io.cucumber.java.en.*;

public class GenrateExcel {
	GenratingExcelPage genratingExcel = new GenratingExcelPage();
	
	@Given("User end with the process")
	public void user_end_with_the_process() {
		genratingExcel.getXeroData();
	}

	@Then("Genrating the final excel")
	public void genrating_the_final_excel() {
		String recipientEmail = BaseClass.SENDER_TO ; // Replace with the actual recipient's email address
		genratingExcel.generateExcelAndSendEmail(recipientEmail);
	}
}
