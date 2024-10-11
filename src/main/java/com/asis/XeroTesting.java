/**
 * 
 */
package com.asis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;
import com.asis.util.xeroexcel;

/**
 * Class for Xero Testing operations
 */
public class XeroTesting extends BaseClass{

	/**
	 * WebDriver instance
	 */

	public static HashMap<String, String> questAns;
	public static HashMap<String, String> CLIENT_XERO_DATA;
	public static ArrayList<String> fetchCaptureA1G1B1Data=new ArrayList<>();

	/**
	 * Method to get client data
	 * @return HashMap containing client data
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void getQuestAnsw() throws InterruptedException, IOException {
		questAns= xeroexcel.getQuestAnsw(XERO_LOGIN_SHEET_NAME);
		CLIENT_XERO_DATA= xeroexcel.getQuestAnsw(XERO_LOGIN_SHEET_NAME);
		

	}
	// Variables to store data
	public String A1 = null; 
	public String G1 = null; 
	public String B1 = null; 
	public double payable_amount = 0.0;
	public double recievable_amount = 0.0;
	public double GST_asperBalanceSheet = 0.0;
	public String GSTr = null;

	// Locator for security questions button
	By bySecurityQsn =By.xpath("//button[contains(text(),'Security questions')]");



	public void tempFuncXero() {
		tempData.add("Xero Testing1");
		tempData.add("Xero Testing2");
		tempData.add("Xero Testing3");
		tempData.add("Xero Testing4");
		System.out.println(tempData);
	}

	/**
	 * Method for two-factor authentication
	 */
	public void twofactorAuth() {
		//System.out.println("twofactorAuth");
		try {
			getQuestAnsw();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement anotherAuthMethod = driver.findElement(By.xpath("//button[contains(text(),\"Use another authentication method\")]"));

		anotherAuthMethod.click();		

		WebElement securityQsn = driver.findElement(bySecurityQsn);
		securityQsn.click();

		String ques1 = questAns.get("Security_qa1");
		String ans1 = questAns.get("Security_qa1_answer");
		String ques2 = questAns.get("Security_qs2");
		String ans2 = questAns.get("Security_qa2_answer");
		String ques3 = questAns.get("Security_qs3");
		String ans3 = questAns.get("Security_qa3_answer");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement firstquestion =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@class,\"auth-firstquestion\")]")));
		WebElement firstanswer =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-automationid,\"auth-firstanswer\")]/div/input")));


		WebElement secondquestion =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@class,\"auth-secondquestion\")]")));
		WebElement secondanswer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-automationid,\"auth-secondanswer\")]/div/input")));
		WebElement submitAns = driver.findElement(By.xpath("//button[@type='submit']"));		

		if(firstquestion.getText().equals(ques1)) {

			firstanswer.sendKeys(ans1);
		}
		else if(firstquestion.getText().equals(ques2)) {

			firstanswer.sendKeys(ans2);
		}
		else{
			firstanswer.sendKeys(ans3);
		}		

		if(secondquestion.getText().equals(ques1)){

			secondanswer.sendKeys(ans1);
		}
		else if(secondquestion.getText().equals(ques2)) {

			secondanswer.sendKeys(ans2);
		}
		else{
			secondanswer.sendKeys(ans3);
		}
		submitAns.click();
	}	
	private List<Map<String, String>> getQuestAnsw(String xERO_LOGIN_SHEET_NAME2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void login() {

	}
	/**
	 * Method to navigate to accounts and click
	 */
	public void gotoAccountsClick() {
		WebElement accountingButton = driver.findElement(By.xpath("//button[@data-name='navigation-menu/accounting']"));
		accountingButton.click();

		WebElement activitySatement =   driver.findElement(By.xpath("//a[contains(text(),'Activity Statement')]"));
		activitySatement.click();

	}

	/**
	 * Method to get and Set "From" and "To" dates
	 * @throws InterruptedException
	 */
	public void getAndSetFromAndTodate() throws InterruptedException, ParseException {

		DateFormat fromDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); 
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date from_date = fromDateFormat.parse(questAns.get("From date"));

			String StringFromDate = outputFormat.format(from_date);

			Date to_date = fromDateFormat.parse(questAns.get("To date"));

			String StringToDate = outputFormat.format(to_date);

			WebElement From = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fromDate']")));
			From.clear();
			From.sendKeys(StringFromDate);

			WebElement To = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateTo']")));
			To.clear();
			To.sendKeys(StringToDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		WebElement UpdateButton = driver.findElement(By.xpath("//a[@id='ext-gen27']"));
		UpdateButton.click();
	}

	/**
	 * Method to capture A1, G1, B1 data
	 */
	public void captureA1G1B1Data() {
		//		System.out.println("captureA1G1B1Data");
		G1 = driver.findElement(By.xpath("//tr//descendant::span[contains(text(),'Total sales')]/ancestor::tr/td[3]//descendant::span[1]")).getText();
		A1 = driver.findElement(By.xpath("//tr//descendant::span[contains(text(),'GST on sales')]/ancestor::tr/td[3]//descendant::span[1]")).getText();
		B1 = driver.findElement(By.xpath("//tr//descendant::span[contains(text(),'GST on purchases')]/ancestor::tr/td[3]//descendant::span[1]")).getText();

		fetchCaptureA1G1B1Data.add(G1.replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(A1.replaceAll("[,]", ""));
		fetchCaptureA1G1B1Data.add(B1.replaceAll("[,]", ""));
		
	}

	public void addDummydata() {
		HashMap<String, Double> hm1 = new HashMap<>();
		hm1.put("June BAS ", 2145.00);
		LAST_TABLE_DATA.add(hm1);

		HashMap<String, Double> hm2 = new HashMap<>();
		hm2.put("Add: GST on Debtors", 3435.00);
		LAST_TABLE_DATA.add(hm2);

		HashMap<String, Double> hm3 = new HashMap<>();
		hm3.put("Less: GST on Creditors", 456.00);
		LAST_TABLE_DATA.add(hm3);

		HashMap<String, Double> hm4 = new HashMap<>();
		hm4.put("Total", 545.00);
		LAST_TABLE_DATA.add(hm4);

		HashMap<String, Double> hm5 = new HashMap<>();
		hm5.put("GST as per Balance sheet", 789.00);
		LAST_TABLE_DATA.add(hm5);

		HashMap<String, Double> hm6 = new HashMap<>();
		hm6.put("Total - GST as per balance sheet", 567.00);
		LAST_TABLE_DATA.add(hm6);

		HashMap<String, Double> hm7 = new HashMap<>();
		hm7.put("Reason for Variance:", 0.0);
		LAST_TABLE_DATA.add(hm7);

		HashMap<String, Double> hm8 = new HashMap<>();
		hm8.put("Reporting variance", 160.00);
		LAST_TABLE_DATA.add(hm8);

		HashMap<String, Double> hm9 = new HashMap<>();
		hm9.put("Unknown variance", 0.47);
		LAST_TABLE_DATA.add(hm9);


	}

	/**
	 * Method to navigate to Aged Payable Summary
	 * @throws InterruptedException
	 */
	public void goToAgedPayableSymmary() throws InterruptedException {
		WebElement accountingButton = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		accountingButton.click();
		//div[contains(text(),'Nothing to show here')]
		WebElement payable =  driver.findElement(By.xpath("//a[contains(text(),'Aged Payables Summary')]"));
		payable.click();

		WebElement colmSelected =  driver.findElement( By.xpath("//button[@id='report-settings-columns-button']"));
		colmSelected.click();
		Thread.sleep(3000);
		WebElement Outstanding_GST =  driver.findElement( By.xpath("//span[contains(text(),'Outstanding GST')]"));
		Outstanding_GST.click();
		Thread.sleep(1000);
		WebElement endOfMonth =  driver.findElement( By.xpath("//body/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]"));
		endOfMonth.click();

		WebElement lastFinancialYear =  driver.findElement( By.xpath("//span[contains(text(),'End of last quarter')]"));
		lastFinancialYear.click();

		WebElement Update =  driver.findElement( By.xpath("//button[contains(text(),'Update')]"));
		Update.click();

		boolean exist = driver.findElements(By.xpath("//div[contains(text(),'Nothing to show here')]")).size() != 0;

		if (exist) {
			payable_amount=0.0;
			System.out.println(payable_amount);
			HashMap<String, Double> hm3 = new HashMap<>();
			hm3.put("Less: GST on Creditors", payable_amount);
			LAST_TABLE_DATA.add(hm3);
		} 
		else {	
			WebElement GST2 =  driver.findElement( By.xpath("//tr//descendant::div[text()='Total']/ancestor::tr/td[9]/span/div"));
			payable_amount =  Double.parseDouble((GST2).getText().replaceAll(",", ""));

			HashMap<String, Double> hm3 = new HashMap<>();
			hm3.put("Less: GST on Creditors", payable_amount);
			LAST_TABLE_DATA.add(hm3);

		}
		HashMap<String, Double> hm4 = new HashMap<>();
		hm4.put("Total", (LAST_TABLE_DATA.get(0).get("June BAS")+ payable_amount+recievable_amount));

		LAST_TABLE_DATA.add(hm4);
		System.out.println("total "+LAST_TABLE_DATA.get(3).get("Total"));		
	}

	/**
	 * Method to navigate to Aged Receivable Summary
	 * @throws InterruptedException
	 */
	public void goToAgedRecievableSummry() throws InterruptedException {
		WebElement accountingButton = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		accountingButton.click();

		WebElement recievable  =  driver.findElement( By.xpath("//a[contains(text(),'Aged Receivables Summary')]"));
		recievable.click();

		WebElement colSelected  =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='report-settings-columns-button']")));
		colSelected.click();
		Thread.sleep(1000);
		WebElement outstanding_gst_rec  =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-automationid='column-selection-taxamountdue--body--checkbox']")));
		outstanding_gst_rec.click();

		WebElement end_of_month  = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//body/div[4]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]")));
		end_of_month.click();

		WebElement last_financial_year  =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'End of last financial year')]")));
		last_financial_year.click();

		WebElement update  =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"report-settings\"]/div/div/div[7]/button")));
		update.click();

		boolean exist = driver.findElements(By.xpath("//div[contains(text(),'Nothing to show here')]")).size() != 0;

		if (exist) {
			recievable_amount=0.0;
			System.out.println(recievable_amount);
			HashMap<String, Double> hm2 = new HashMap<>();
			hm2.put("Add: GST on Debtors", recievable_amount);
			LAST_TABLE_DATA.add(hm2);
			System.out.println("Add: GST on Debtors");
		} 
		else {
			WebElement GST1  =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//descendant::div[text()='Total']/ancestor::tr/td[9]/span/div")));
			recievable_amount= Double.parseDouble((GST1).getText().replaceAll(",", ""));

			HashMap<String, Double> hm2 = new HashMap<>();
			hm2.put("Add: GST on Debtors", recievable_amount);
			LAST_TABLE_DATA.add(hm2);	
		}		
	}
	/**
	 * Method to navigate to Balance Sheet
	 * @throws InterruptedException
	 */
	public void balanceSheet() throws InterruptedException {
		WebElement accountingButton = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		accountingButton.click();

		WebElement balanceSheet =  driver.findElement( By.xpath("//a[contains(text(),'Balance Sheet')]"));
		balanceSheet.click();

		WebElement GST =  driver.findElement(By.xpath("//tr//descendant::div[contains(text(),'GST')]/ancestor::tr/td[2]//a"));
		GST_asperBalanceSheet= Double.parseDouble((GST).getText().replaceAll(",", ""));

		HashMap<String, Double> hm5 = new HashMap<>();
		hm5.put("GST as per Balance sheet", GST_asperBalanceSheet);
		LAST_TABLE_DATA.add(hm5);

		HashMap<String, Double> hm6 = new HashMap<>();
		hm6.put("Total - GST as per balance sheet",  (LAST_TABLE_DATA.get(3).get("Total") - LAST_TABLE_DATA.get(4).get("GST as per Balance sheet")));

		LAST_TABLE_DATA.add(hm6);
	}

	/**
	 * Method to create Excel
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void createExcel() throws FileNotFoundException, IOException {


	}
	public void GSTReconciliation() throws InterruptedException {
		ArrayList<ArrayList<String>> GST_Reconciliation_DATA = new ArrayList<>();

		// Navigate to GST Reconciliation
		WebElement accountingButton = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		accountingButton.click();

		WebElement GSTreconcil =  driver.findElement(By.xpath("//a[contains(text(),'GST Reconciliation')]"));
		GSTreconcil.click();

		// Gathering data
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='statementTable']/tbody/tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			ArrayList<String> rowData = new ArrayList<>();
			for (WebElement cell : cells) {
				rowData.add(cell.getText());
			}
			GST_Reconciliation_DATA.add(rowData);
		}

		// Print the gathered data in the specified format
		for (ArrayList<String> row : GST_Reconciliation_DATA) {
			System.out.println(String.join("\t", row));
		}

		// Writing data to Excel
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet("GST Reconciliation");
			int rowNum = 0;
			for (ArrayList<String> row : GST_Reconciliation_DATA) {
				Row excelRow = sheet.createRow(rowNum++);
				int cellNum = 0;
				for (String cellData : row) {
					excelRow.createCell(cellNum++).setCellValue(cellData);
				}
			}
			String filePath = "GST_Reconciliation.xlsx";
			try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
				workbook.write(outputStream);
			}

			System.out.println("Excel file created successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void getXeroData() {
		ArrayList<QuaterData> xero_data = new ArrayList<>();
		QuaterData xeroObj = new QuaterData("As per the book");
		xeroObj.set_G1(Double.parseDouble(fetchCaptureA1G1B1Data.get(0)),false);
		xeroObj.set_1A(Double.parseDouble(fetchCaptureA1G1B1Data.get(1)),false);
		xeroObj.set_1B(Double.parseDouble(fetchCaptureA1G1B1Data.get(2)),false);
		xeroObj.set_W1(0,false);
		xeroObj.set_4(0,false);
		xeroObj.set_GST_Refund(xeroObj.get_1A() - xeroObj.get_1B(),false);
		xeroObj.set_ATO_Total_Refund(xeroObj.get_GST_Refund() + xeroObj.get_4() + xeroObj.get_5A() - xeroObj.get_7D(),false);
		xero_data.add(xeroObj);
		XERO_DATA.add(xero_data);

		ArrayList<QuaterData> variance_data = new ArrayList<>();
		QuaterData variance = new QuaterData("Variance");
		variance.set_G1(QuaterData.getTotal_of_year_G1() - xeroObj.get_G1(),false);
		variance.set_1A(QuaterData.getTotal_of_year_1A() - xeroObj.get_1A(),false);
		variance.set_1B(QuaterData.getTotal_of_year_1B() - xeroObj.get_1B(),false);
		variance.set_W1(QuaterData.getTotal_of_year_W1() - xeroObj.get_W1(),false);
		variance.set_4(QuaterData.getTotal_of_year_4() - xeroObj.get_4(),false);
		variance.set_GST_Refund(variance.get_1A() - variance.get_1B(),false);
		variance.set_ATO_Total_Refund(variance.get_GST_Refund() + variance.get_4() + variance.get_5A() - variance.get_7D(),false);
		variance_data.add(variance);
		XERO_DATA.add(variance_data);	

		HashMap<String, Double> hm7 = new HashMap<>();
		hm7.put("Reason for Variance:", 0.0);
		LAST_TABLE_DATA.add(hm7);

		HashMap<String, Double> hm8 = new HashMap<>();
		hm8.put("Reporting variance", variance.get_GST_Refund());
		LAST_TABLE_DATA.add(hm8);

		HashMap<String, Double> hm9 = new HashMap<>();
		hm9.put("Unknown variance",	LAST_TABLE_DATA.get(5).get("Total - GST as per balance sheet")+
				LAST_TABLE_DATA.get(6).get("Reason for Variance:")+
				LAST_TABLE_DATA.get(7).get("Reporting variance"));
		LAST_TABLE_DATA.add(hm9);


		ArrayList<QuaterData> bas_relodged_data = new ArrayList<>();
		QuaterData bas_relodged = new QuaterData("BAS to be relodged for Period ended Jun 23");
		bas_relodged.set_G1(qd_jun.get_G1() - variance.get_G1(),false);
		bas_relodged.set_1A(qd_jun.get_1A() - variance.get_1A(),false);
		bas_relodged.set_1B(qd_jun.get_1B() - variance.get_1B(),false);
		bas_relodged.set_W1(qd_jun.get_W1() - variance.get_W1(),false);
		bas_relodged.set_4(qd_jun.get_4() - variance.get_4(),false);
		bas_relodged.set_GST_Refund(qd_jun.get_GST_Refund() - variance.get_GST_Refund(),false);
		bas_relodged.set_ATO_Total_Refund(bas_relodged.get_GST_Refund() + bas_relodged.get_4() + bas_relodged.get_5A() - bas_relodged.get_7D(),false);
		bas_relodged_data.add(bas_relodged);
		XERO_DATA.add(bas_relodged_data);	
	}
	/**
	 * Main method
	 * @param args
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		XeroTesting obj = new XeroTesting();
		//obj.setupDriver("Chrome");
		obj.lauchSite("https://login.xero.com");
		obj.login_xero();
		obj.twofactorAuth();
		obj.GSTReconciliation();
		//		obj.gotoAccountsClick();
		//		obj.getAndSetFromAndTodate();
		//		obj.captureA1G1B1Data();
		//		obj.getXeroData();
		//		obj.goToAgedRecievableSummry();
		//		obj.goToAgedPayableSymmary();
		//		obj.balanceSheet();
		//obj.createExcel();
	}

}
