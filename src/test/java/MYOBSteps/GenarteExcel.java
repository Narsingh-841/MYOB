package MYOBSteps;

import com.asis.util.BaseClass;

import MYOB.GenrateExcel;
import io.cucumber.java.en.*;

public class GenarteExcel {

	GenrateExcel genrateExcel = new GenrateExcel();

	@Given("User end with the process of myob")
	public void user_end_with_the_process_of_myob() {
		genrateExcel.getMYOBData();
	}

	@Then("Genrating the final excel for myob")
	public void genrating_the_final_excel_for_myob() {
		String recipientEmail = BaseClass.SENDER_TO ; // Replace with the actual recipient's email address
		genrateExcel.generateExcelAndSendEmail(recipientEmail);
	}
}
