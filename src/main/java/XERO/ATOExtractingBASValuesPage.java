
package XERO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asis.QuaterData;
import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class ATOExtractingBASValuesPage extends BaseClass {

	// List of WebElements
	@FindBy(xpath = "//h2/span[contains(text(),'Business activity statement summary')]")
	WebElement scrollTo;

	@FindBy(xpath = "//button[text()='Print-friendly version']")
	WebElement printFriendlyVersion;

	@FindBy(xpath = "//td[text()='1A']/parent::tr/td[4]")
	WebElement _1A;

	@FindBy(xpath = "//td[text()='1B']/parent::tr/td[5]")
	WebElement _1B;

	@FindBy(xpath = "//td[text()='G1']/parent::tr/td[3]")
	WebElement _G1;

	@FindBy(xpath = "//td[text()='W1']/parent::tr/td[3]")
	WebElement _W1;

	@FindBy(xpath = "//td[text()='4']/parent::tr/td[4]")
	WebElement _4;
	
	@FindBy(xpath = "//div//a[@class='print-link']")
	WebElement print;

	@FindBy(xpath = "//button[@class='ato-button btn btn-default btnHalf']")
	WebElement back;

	// Constructor
	public ATOExtractingBASValuesPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	// list of all the actions on page
	public static void getPageTitle() {
//		return DriverManager.getDriver().getTitle();
	}

	public void clickOnJulyQuarter() throws InterruptedException {
		String jul_quater = ATO_JULY_QUARTER;
		if (!jul_quater.isBlank()) {
			getQquaterData(jul_quater);
			HashMap<String, Double> data = goToStatementDetail();

			ArrayList<QuaterData> last_jun_quater_data_row = new ArrayList<>();

			last_jun_quater_data_row.add(qd_lastJune);
			ATO_ROW_DATA.add(last_jun_quater_data_row);

			ArrayList<QuaterData> jul_quater_data_row = new ArrayList<>();

			jul_quater_data_row.add(qd_jul);
			ATO_ROW_DATA.add(jul_quater_data_row);

			ArrayList<QuaterData> aug_quater_data_row = new ArrayList<>();

			aug_quater_data_row.add(qd_aug);
			ATO_ROW_DATA.add(aug_quater_data_row);

			ArrayList<QuaterData> sept_quater_data_row = new ArrayList<>();

			qd_sept.set_G1(data.get("G1"), true);
			qd_sept.set_1A(data.get("1A"), true);
			qd_sept.set_1B(data.get("1B"), true);
			qd_sept.set_W1(data.get("W1"), true);
			qd_sept.set_4(data.get("4"), true);
			qd_sept.set_GST_Refund(qd_sept.get_1A() - qd_sept.get_1B(), true);
			qd_sept.set_ATO_Total_Refund((qd_sept.get_GST_Refund() + qd_sept.get_4() + qd_sept.get_5A() - qd_sept.get_7D()), true);
			sept_quater_data_row.add(qd_sept);
			ATO_ROW_DATA.add(sept_quater_data_row);
		}
	}
	public void clickOnOctQuarter() throws InterruptedException {
		String oct_quarter = ATO_OCT_QUARTER;
		if(!oct_quarter.isBlank()) {
			getQquaterData(oct_quarter);
			HashMap<String,Double> data = goToStatementDetail();

			ArrayList<QuaterData> oct_quater_data_row = new ArrayList<>();

			oct_quater_data_row.add(qd_oct);
			ATO_ROW_DATA.add(oct_quater_data_row);


			ArrayList<QuaterData> nov_quater_data_row = new ArrayList<>();

			nov_quater_data_row.add(qd_nov);
			ATO_ROW_DATA.add(nov_quater_data_row);

			ArrayList<QuaterData> dec_quater_data_row = new ArrayList<>();

			qd_dec.set_G1(data.get("G1"),true);
			qd_dec.set_1A(data.get("1A"),true);
			qd_dec.set_1B(data.get("1B"),true);
			qd_dec.set_W1(data.get("W1"),true);
			qd_dec.set_4(data.get("4"),true);
			qd_dec.set_GST_Refund(qd_dec.get_1A() - qd_dec.get_1B(),true);
			qd_dec.set_ATO_Total_Refund(qd_dec.get_GST_Refund() + qd_dec.get_4() + qd_dec.get_5A() - qd_dec.get_7D(),true);
			dec_quater_data_row.add(qd_dec);
			ATO_ROW_DATA.add(dec_quater_data_row);
		}
	}
	public void clickOnJanQuarter() throws InterruptedException {
		String jan_quarter = ATO_JAN_QUARTER;
		if(!jan_quarter.isBlank()) {
			getQquaterData(jan_quarter);
			HashMap<String,Double> data = goToStatementDetail();

			ArrayList<QuaterData> jan_quater_data_row = new ArrayList<>();

			jan_quater_data_row.add(qd_jan);
			ATO_ROW_DATA.add(jan_quater_data_row);


			ArrayList<QuaterData> feb_quater_data_row = new ArrayList<>();

			feb_quater_data_row.add(qd_feb);
			ATO_ROW_DATA.add(feb_quater_data_row);

			ArrayList<QuaterData> mar_quater_data_row = new ArrayList<>();

			qd_mar.set_G1(data.get("G1"),true);
			qd_mar.set_1A(data.get("1A"),true);
			qd_mar.set_1B(data.get("1B"),true);
			qd_mar.set_W1(data.get("W1"),true);
			qd_mar.set_4(data.get("4"),true);
			qd_mar.set_GST_Refund(qd_mar.get_1A() - qd_mar.get_1B(),true);
			qd_mar.set_ATO_Total_Refund(qd_mar.get_GST_Refund() + qd_mar.get_4() + qd_mar.get_5A() - qd_mar.get_7D(),true);
			mar_quater_data_row.add(qd_mar);
			ATO_ROW_DATA.add(mar_quater_data_row);
		}
	}
	public void clickOnAprQuarter() throws InterruptedException {
		String apr_quarter = ATO_APR_QUARTER;
		if(!apr_quarter.isBlank()) {
			getQquaterData(apr_quarter);
			HashMap<String,Double> data = goToStatementDetail();

			ArrayList<QuaterData> apr_quater_data_row = new ArrayList<>();

			apr_quater_data_row.add(qd_apr);
			ATO_ROW_DATA.add(apr_quater_data_row);

			ArrayList<QuaterData> may_quater_data_row = new ArrayList<>();

			may_quater_data_row.add(qd_may);
			ATO_ROW_DATA.add(may_quater_data_row);

			ArrayList<QuaterData> jun_quater_data_row = new ArrayList<>();

			qd_jun.set_G1(data.get("G1"),true);
			qd_jun.set_1A(data.get("1A"),true);
			qd_jun.set_1B(data.get("1B"),true);
			qd_jun.set_W1(data.get("W1"),true);
			qd_jun.set_4(data.get("4"),true);
			qd_jun.set_GST_Refund(qd_jun.get_1A() - qd_jun.get_1B(),true);
			qd_jun.set_ATO_Total_Refund(qd_jun.get_GST_Refund() + qd_jun.get_4() + qd_jun.get_5A() - qd_jun.get_7D(),true);
			jun_quater_data_row.add(qd_jun);
			ATO_ROW_DATA.add(jun_quater_data_row);
			TEMP_JUNE_G1 = qd_jun.get_G1();
			TEMP_JUNE_A1 = qd_jun.get_1A();
			TEMP_JUNE_B1 = qd_jun.get_1B();
			TEMP_JUNE_W1 = qd_jun.get_W1();
			TEMP_JUNE_4 = qd_jun.get_4();
			TEMP_JUNE_GST_Refund = qd_jun.get_GST_Refund();
			
			
			HashMap<String, Double> hm1 = new HashMap<>();
			hm1.put("June BAS", qd_jun.get_GST_Refund());
			LAST_TABLE_DATA.add(hm1);
		}
	}

	/**
	 * Method to get quarter data
	 *
	 * @param quater_statement_name
	 * @throws InterruptedException
	 */
	public void getQquaterData(String quater_statement_name) throws InterruptedException {
		WebDriver driver = DriverManager.getDriver();
		Thread.sleep(2000);
		List<WebElement> statements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'" + quater_statement_name + "')]")));
		if (statements.size() > 1) {
			for (WebElement ele : statements) {
				WebElement revision = ele.findElement(By.xpath(".//ancestor::div[@class='table-data-text']//span[contains(text(),'Revision')]"));
				if (revision.isDisplayed()) {
					System.out.println("Visible");
					ele.click();
					break;
				}
			}
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", statements.get(0).findElement(By.xpath(".//parent::a")));
		}
	}

	public HashMap<String, Double> goToStatementDetail() throws InterruptedException {
		HashMap<String, Double> data = new HashMap<>();
		Thread.sleep(1000);
		scrollDownToGetBASStatement();
		clickOnPrintFriendlyVersion();
		switchingTabs();
		extracting_Values(data);
		closingSwitchedWindow();
		clickBackButton();
		return data;
	}

	public void scrollDownToGetBASStatement() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
	}

	public void clickOnPrintFriendlyVersion() throws InterruptedException {
		//printFriendlyVersion.click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",printFriendlyVersion);
	}

	public void switchingTabs() {
		ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabs.get(1));
	}

	public void extracting_Values(HashMap<String, Double> data) {
		String value1 = _1A.getText().replaceAll("[$,]", "");
		data.put("1A", Double.parseDouble(value1));
		String value2 = _1B.getText().replaceAll("[$,]", "");
		data.put("1B", Double.parseDouble(value2));
		String value3 = _G1.getText().replaceAll("[$,]", "");
		data.put("G1", Double.parseDouble(value3));
		String value4 = _W1.getText().replaceAll("[$,]", "");
		data.put("W1", Double.parseDouble(value4));
		String value5 = _4.getText().replaceAll("[$,]", "");
		data.put("4", Double.parseDouble(value5));
	}

	public void closingSwitchedWindow() {
		ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
		if (tabs.size() > 1) {
			DriverManager.getDriver().switchTo().window(tabs.get(1)).close();
			DriverManager.getDriver().switchTo().window(tabs.get(0));
		} else {
			throw new IllegalStateException("Unable to switch tabs: No additional tab/window found.");
		}
	}

	public void clickBackButton() {
		wait.until(ExpectedConditions.elementToBeClickable(back));
		back.click();
	}
}
