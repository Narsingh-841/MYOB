package XERO;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.asis.util.BaseClass;

public class GenerateEmail extends BaseClass {
	

    public void sendEmail(String recipientEmail) {
        String filePath = "Final_data.xls";
        String excelName = ATO_CLIENT_NAME + "_Financial_Summary_Report";

        Double unknownVar = 0.0; // Assuming these are defined elsewhere
        Double reportingVar = 0.0; // Assuming these are defined elsewhere

		String from = "toptechautomation@theoutsourcepro.com.au";
        String password = "Guf87765";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("BAS Summary of " + ATO_CLIENT_NAME);

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
                + "<p style=\"margin-bottom: 15px;\">Thank you for choosing AccountTECH for your financial needs. We look forward to continuing to support you in achieving your business goals.</p>"
                + "<p style=\"font-weight: bold; margin-bottom: 5px;\">InsightFinTECH </p>"
                + "<p style=\"font-weight: bold; margin-bottom: 5px;\">The Outsource Pro</p>"
                + "<p style=\"margin-bottom: 5px;\">Contact Information:</p>"
                + "<p style=\"margin-bottom: 5px;\">Email: topfinancial@theoutsourcepro.com.au</p>"
                + "<p style=\"margin-bottom: 5px;\">Phone: +91 6283289834</p>"
                + "<p style=\"margin-bottom: 5px;\">Website: <a href=\"https://theoutsourcepro.com.au\" style=\"color: #333;\">theoutsourcepro.com.au</a></p>"
                + "</body></html>";

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(emailBody, "text/html");
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(excelName + ".xls");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email with attachment sent successfully to " + recipientEmail);
        } catch (AuthenticationFailedException e) {
            System.out.println("Authentication failed. Please check your credentials and try again.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GenerateEmail obj = new GenerateEmail();
        obj.sendEmail("asis.kaur@theoutsourcepro.com.au");

    }
}
