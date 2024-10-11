package MYOB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import com.asis.Excel;
import com.asis.QuaterData;
import com.asis.util.BaseClass;

public class GenrateExcel extends BaseClass {

	Double reportingVarValue;
	Double unknownVarValue ;

	String formattedUnknownVar;
	String formattedreportingVar;

	Double unknownVar ;
	Double reportingVar;

	int index ;

	public void getMYOBData() {
		ArrayList<QuaterData> xero_data = new ArrayList<>();
		QuaterData xeroObj = new QuaterData("As per the book");
		xeroObj.set_G1(Double.parseDouble(fetchCaptureA1G1B1Data.get(0)), false);
		xeroObj.set_1A(Double.parseDouble(fetchCaptureA1G1B1Data.get(1)), false);
		xeroObj.set_1B(Double.parseDouble(fetchCaptureA1G1B1Data.get(2)), false);
		xeroObj.set_W1(Double.parseDouble(fetchCaptureA1G1B1Data.get(3)), false);
		xeroObj.set_4(Double.parseDouble(fetchCaptureA1G1B1Data.get(4)), false);
		xeroObj.set_GST_Refund(xeroObj.get_1A() - xeroObj.get_1B(), false);
		xeroObj.set_ATO_Total_Refund(xeroObj.get_GST_Refund() + xeroObj.get_4() + xeroObj.get_5A() - xeroObj.get_7D(), false);
		xero_data.add(xeroObj);
		XERO_DATA.add(xero_data);

		ArrayList<QuaterData> variance_data = new ArrayList<>();
		QuaterData variance = new QuaterData("Variance");
		variance.set_G1(QuaterData.getTotal_of_year_G1() - xeroObj.get_G1(), false);
		variance.set_1A(QuaterData.getTotal_of_year_1A() - xeroObj.get_1A(), false);
		variance.set_1B(QuaterData.getTotal_of_year_1B() - xeroObj.get_1B(), false);
		variance.set_W1(QuaterData.getTotal_of_year_W1() - xeroObj.get_W1(), false);
		variance.set_4(QuaterData.getTotal_of_year_4() - xeroObj.get_4(), false);
		variance.set_GST_Refund(variance.get_1A() - variance.get_1B(), false);
		variance.set_ATO_Total_Refund(variance.get_GST_Refund() + variance.get_4() + variance.get_5A() - variance.get_7D(), false);
		variance_data.add(variance);
		XERO_DATA.add(variance_data);    

		HashMap<String, Double> hm4 = new HashMap<>();
		double juneBAS = LAST_TABLE_DATA.get(0).getOrDefault("June BAS", 0.0);
		double total = juneBAS + MYOBAgedPayableSummaryPage.PayableAmount + MYOBAgedRecieveablePage.RecievableAmounts;
		hm4.put("Total", total);
		LAST_TABLE_DATA.add(3,hm4);

		HashMap<String, Double> hm7 = new HashMap<>();
		hm7.put("Reason for Variance:", 0.0);
		while (LAST_TABLE_DATA.size() <= 6) {
			LAST_TABLE_DATA.add(new HashMap<>()); // Ensure the list has enough elements
		}
		LAST_TABLE_DATA.add(6, hm7);

		HashMap<String, Double> hm8 = new HashMap<>();
		hm8.put("Reporting variance", variance.get_GST_Refund());
		while (LAST_TABLE_DATA.size() <= 7) {
			LAST_TABLE_DATA.add(new HashMap<>()); // Ensure the list has enough elements
		}
		LAST_TABLE_DATA.add(7, hm8);

		Double total23 = LAST_TABLE_DATA.get(3).get("Total");
		Double gstAsPerBalanceSheet =  MYOBBalanceSheetPage.GST_asperBalanceSheet;
		HashMap<String, Double> hm5 = new HashMap<>();
		hm5.put("GST as per Balance sheet", MYOBBalanceSheetPage.GST_asperBalanceSheet);

		LAST_TABLE_DATA.set(4,hm5);
		HashMap<String, Double> hm6 = new HashMap<>();
		hm6.put("Total - GST as per balance sheet",  total23 - gstAsPerBalanceSheet);

		LAST_TABLE_DATA.set(5,hm6);
		reportingVarValue=LAST_TABLE_DATA.get(7).get("Reporting variance");
		formattedreportingVar = String.format("%.2f", reportingVarValue);
		reportingVar = Double.parseDouble(formattedreportingVar);
		

		// Ensure we handle null values when calculating 'Unknown variance'
		HashMap<String, Double> hm9 = new HashMap<>();
		Double totalGST = LAST_TABLE_DATA.get(5).get("Total - GST as per balance sheet");
		Double reasonForVariance = LAST_TABLE_DATA.get(6).get("Reason for Variance:");
		Double reportingVariance = LAST_TABLE_DATA.get(7).get("Reporting variance");

		if (totalGST == null) totalGST = 0.0;
		if (reasonForVariance == null) reasonForVariance = 0.0;
		if (reportingVariance == null) reportingVariance = 0.0;

		hm9.put("Unknown variance", totalGST + reasonForVariance + reportingVariance);
		while (LAST_TABLE_DATA.size() <= 8) {
			LAST_TABLE_DATA.add(new HashMap<>()); // Ensure the list has enough elements
		}
		LAST_TABLE_DATA.add(8, hm9);

		unknownVarValue = LAST_TABLE_DATA.get(8).get("Unknown variance");
		formattedUnknownVar = String.format("%.2f", unknownVarValue);
		unknownVar = Double.parseDouble(formattedUnknownVar);
		
		ArrayList<QuaterData> bas_relodged_data = new ArrayList<>();
		QuaterData bas_relodged = new QuaterData("BAS to be relodged for Period ended Jun 23");

		bas_relodged.set_G1(TEMP_JUNE_G1 - variance.get_G1(), false);
		bas_relodged.set_1A(TEMP_JUNE_A1 - variance.get_1A(), false);
		bas_relodged.set_1B(TEMP_JUNE_B1 - variance.get_1B(), false);
		bas_relodged.set_W1(TEMP_JUNE_W1 - variance.get_W1(), false);
		bas_relodged.set_4(TEMP_JUNE_4 - variance.get_4(), false);
		bas_relodged.set_GST_Refund(TEMP_JUNE_GST_Refund - variance.get_GST_Refund(), false);
		bas_relodged.set_ATO_Total_Refund(bas_relodged.get_GST_Refund() + bas_relodged.get_4() + bas_relodged.get_5A() - bas_relodged.get_7D(), false);
		bas_relodged_data.add(bas_relodged);
		XERO_DATA.add(bas_relodged_data);

				// Ensure the total and total - GST as per balance sheet are included in the final Excel
		if (LAST_TABLE_DATA.size() > 5 && LAST_TABLE_DATA.get(3).get("Total") != null) {
		}else {
			System.out.println("null");
		}
		if (LAST_TABLE_DATA.size() > 8 && LAST_TABLE_DATA.get(8).get("Unknown variance") != null) {
		}
		else {
			System.out.println("null");
		}

	}



	/*
		bas_relodged.set_G1(qd_jun.get_G1() - variance.get_G1(),false);
		bas_relodged.set_1A(qd_jun.get_1A() - variance.get_1A(),false);
		bas_relodged.set_1B(qd_jun.get_1B() - variance.get_1B(),false);
		bas_relodged.set_W1(qd_jun.get_W1() - variance.get_W1(),false);
		bas_relodged.set_4(qd_jun.get_4() - variance.get_4(),false);
		bas_relodged.set_GST_Refund(qd_jun.get_GST_Refund() - variance.get_GST_Refund(),false);
		bas_relodged.set_ATO_Total_Refund(bas_relodged.get_GST_Refund() + bas_relodged.get_4() + bas_relodged.get_5A() - bas_relodged.get_7D(),false);
		bas_relodged_data.add(bas_relodged);
		XERO_DATA.add(bas_relodged_data);

	 */

	public void generateExcelAndSendEmail(String recipientEmail) {
		String[] client_data = {ATO_CLIENT_NAME, ATO_TO_DATE};
		String excelName = ATO_CLIENT_NAME+" "+ATO_TO_DATE;
		Excel obj = new Excel();
		String filePath =  "Final_data.xls"; // Assuming this is the file path where the Excel file will be generated
		obj.createFinancialSummaryExcelWithData(filePath, BaseClass.ATO_ROW_DATA, BaseClass.XERO_DATA, BaseClass.ACTIVITY_STATEMENT_DATA, client_data);

		// Then, send the Excel file as an email attachment
		String from = "toptechautomation@theoutsourcepro.com.au";
		String password = "Guf87765";
		String senderMail = from;

		// Outlook SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Creating a session object
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			// Creating a MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field
			message.setFrom(new InternetAddress(from));
			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			// Set Subject: header field
			message.setSubject("BAS Summary of "  +ATO_CLIENT_NAME);

			// Create a multipart message
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			String emailBody = "<html><body style=\"font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; font-size: 14px; line-height: 1.5; color: #333;\">"
					+ "<h2 style=\"font-weight: bold; margin-bottom: 5px;\">Financial Summary Report</h2>"
					+ "<table border=\"1\" style=\"border-collapse: collapse; margin-bottom: 10px;\">"
					+ "<tr>"
					+ "<th style=\"background-color: #d3f3ce; padding: 8px;\">Client Name</th>"
					+ "<th style=\"background-color: #d3f3ce; padding: 8px;\">Year</th>"
					+ "<th style=\"background-color: #d3f3ce; padding: 8px;\">Reporting Variance</th>"
					+ "<th style=\"background-color: #d3f3ce; padding: 8px;\">Unknown Variance</th>"
					+ "</tr>"
					+ "<tr>"
					+ "<td style=\"padding: 8px;\">" + ATO_CLIENT_NAME + "</td>"
					+ "<td style=\"padding: 8px;\">" + ATO_TO_DATE + "</td>"
					+ "<td style=\"padding: 8px; color: #ff6347;\">$" + reportingVar + "</td>"
					+ "<td style=\"padding: 8px; color: #ff6347;\">$" + unknownVar + "</td>"
					+ "</tr>"
					+ "</table>"
					+ "<p style=\"margin-bottom: 15px;\">Hello " + USERNAME + ",</p>"
					+ "<p style=\"margin-bottom: 15px;\">We are pleased to provide you with the <b>Financial Summary Report</b> for your review. This report contains essential financial data for the specified year, from " + ATO_FROM_DATE + " to " + ATO_TO_DATE + ", including reporting and unknown variances.</p>"
					+ "<p style=\"margin-bottom: 15px;\">This comprehensive report has been meticulously prepared by our team of financial experts, and we trust it will assist you in making informed decisions for your business.</p>"
					+ "<p style=\"margin-bottom: 15px;\">Please take a moment to review the attached Excel file, which contains detailed information and analysis. Should you have any questions or require further clarification on any aspect of the report, please do not hesitate to reach out to us.</p>"
					+ "<p style=\"margin-bottom: 15px;\">Your feedback is valuable to us, and we welcome any comments or suggestions you may have regarding the report or our services.</p>"
					+ "<p style=\"margin-bottom: 15px;\">Thank you for choosing TOP TECH for your financial needs. We look forward to continuing to support you in achieving your business goals.</p>"
					+ "<p style=\"font-weight: bold; margin-bottom: 5px;\">TEAM TITANS </p>"
					+ "<p style=\"font-weight: bold; margin-bottom: 5px;\">The Outsource Pro</p>"
					+ "<p style=\"margin-bottom: 5px;\">Contact Information:</p>"
					+ "<p style=\"margin-bottom: 5px;\">Email: topfinancial@theoutsourcepro.com.au</p>"
					+ "<p style=\"margin-bottom: 5px;\">Phone: +91 6283289834</p>"
					+ "<p style=\"margin-bottom: 5px;\">Website: <a href=\"https://theoutsourcepro.com.au\" style=\"color: #333;\">theoutsourcepro.com.au</a></p>"
					+ "</body></html>";



			// Set content type to HTML
			messageBodyPart.setContent(emailBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(excelName+".xls");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
		} catch (AuthenticationFailedException e) {
			System.out.println("Authentication failed. Please check your credentials and try again.");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}