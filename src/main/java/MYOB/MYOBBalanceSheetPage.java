package MYOB;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.Excel;
import com.asis.QuaterData;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class MYOBBalanceSheetPage extends BaseClass {

	@FindBy(xpath = "//div[contains(text(),'Balance sheet')]")
	WebElement balanceSheet;
	@FindBy(xpath = "//input[@name='BALANCE_DATE']")
	WebElement toDate;
	@FindBy(xpath = "(//button[@data-flx-comp='Button' and @type='button']//span)[19]")
	WebElement gstCollected;

	@FindBy(xpath = "(//button[@data-flx-comp='Button' and @type='button']//span)[21]") 
	WebElement gstPaid;

	@FindBy(xpath = "(//button[@data-flx-comp='Button' and @type='button']//span)[33]")
	WebElement gstAdjustmentActual;

	@FindBy(xpath = "(//button[@data-flx-comp='Button' and @type='button']//span)[34]")
	WebElement gstAdjustmentLastYear;

	@FindBy(xpath = "//div[contains(text(),'Reporting')]")
	WebElement reporting;
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	WebElement reports;

	// Static variables to store values
	Double reportingVarValue;
	Double unknownVarValue ;

	String formattedUnknownVar;
	String formattedreportingVar;

	Double unknownVar ;
	Double reportingVar;
	public static double gstColl=0.0;
	public static double gstPai=0.0;
	public static double gstAdjustmentAactu=0.0;
	public static double gstAdjustmentlast=0.0;
	public static double finalGst = 0.0;
	public static double GST_asperBalanceSheet = 0.0;


	public MYOBBalanceSheetPage() {    
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}

	// List of all the actions on page
	public void clickBalanceSheet() {
		wait.until(ExpectedConditions.visibilityOf(balanceSheet));
		balanceSheet.click();
	}

	public void passToDate() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(toDate));
		String StringToDate = ATO_TO_DATE;
		toDate.sendKeys(Keys.CONTROL + "a");
		toDate.sendKeys(Keys.DELETE);

		toDate.sendKeys(StringToDate);
		Thread.sleep(3000);
	}

	public void getTextGst() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", gstCollected); // Scroll to the 'total' element
	    wait.until(ExpectedConditions.visibilityOf(gstCollected));
	    String gstCollStr = gstCollected.getText().replaceAll(",", "").replaceAll("[()]", "");
	    gstColl = gstCollStr.startsWith("(") ? -Double.parseDouble(gstCollStr) : Double.parseDouble(gstCollStr);

        js.executeScript("arguments[0].scrollIntoView(true);", gstPaid); // Scroll to the 'total' element
	    wait.until(ExpectedConditions.visibilityOf(gstPaid));
	    String gstPaiStr = gstPaid.getText().replaceAll(",", "").replaceAll("[()]", "");
	    gstPai = gstPaiStr.startsWith("(") ? -Double.parseDouble(gstPaiStr) : Double.parseDouble(gstPaiStr);

        js.executeScript("arguments[0].scrollIntoView(true);", gstAdjustmentActual); // Scroll to the 'total' element
	    wait.until(ExpectedConditions.visibilityOf(gstAdjustmentActual));
	    String gstAdjustmentAactuStr = gstAdjustmentActual.getText().replaceAll(",", "").replaceAll("[()]", "");
	    gstAdjustmentAactu = gstAdjustmentAactuStr.startsWith("(") ? -Double.parseDouble(gstAdjustmentAactuStr) : Double.parseDouble(gstAdjustmentAactuStr);

        js.executeScript("arguments[0].scrollIntoView(true);", gstAdjustmentLastYear); // Scroll to the 'total' element
	    wait.until(ExpectedConditions.visibilityOf(gstAdjustmentLastYear));
	    String gstAdjustmentlastStr = gstAdjustmentLastYear.getText().replaceAll(",", "").replaceAll("[()]", "");
	    gstAdjustmentlast = gstAdjustmentlastStr.startsWith("(") ? -Double.parseDouble(gstAdjustmentlastStr) : Double.parseDouble(gstAdjustmentlastStr);

	    if (gstAdjustmentlast == gstAdjustmentAactu) {
	        finalGst = gstColl - gstPai;
	    } else {
	        finalGst = (gstColl - gstPai) + gstAdjustmentAactu;
	    }
	    GST_asperBalanceSheet = finalGst;

	    while (LAST_TABLE_DATA.size() < 6) {
	        LAST_TABLE_DATA.add(new HashMap<>());
	    }

	    HashMap<String, Double> hm5 = new HashMap<>();
		hm5.put("GST as per Balance sheet", GST_asperBalanceSheet);
		LAST_TABLE_DATA.set(4,hm5);
	}

	public void clickReportingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(reporting));
		reporting.click();
	}

	public void clickReportsButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(reports));
		reports.click();
		Thread.sleep(3000);
		DriverManager.getDriver().quit();
	}
}