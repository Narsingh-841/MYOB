package MYOB;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class MYOBAgedRecieveablePage extends BaseClass {

    @FindBy(xpath = "//div[contains(text(),'Receivables reconciliation with tax')]")
    WebElement receivable;

    @FindBy(xpath = "//input[@name='AS_AT_DATE']")
    WebElement toDate;

    @FindBy(xpath = "//div[@role='row' and .//span[text()='Total']]//div[3]//span")
    WebElement total;

    @FindBy(xpath = "//div[contains(text(),'Reporting')]")
    WebElement reporting;

    @FindBy(xpath = "//span[contains(text(),'Reports')]")
    WebElement reports;

    public static double RecievableAmounts = 0.0;

    public MYOBAgedRecieveablePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickReceivableButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(receivable));
            receivable.click();
        } catch (Exception e) {
            System.err.println("Failed to click Receivable button: " + e.getMessage());
            throw e;
        }
    }

    public void passToDate() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toDate));
            String StringToDate = ATO_TO_DATE;
            toDate.sendKeys(Keys.CONTROL + "a");
            toDate.sendKeys(Keys.DELETE);
            toDate.sendKeys(StringToDate);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("Failed to enter 'To Date': " + e.getMessage());
            throw e;
        }
    }

    public void receivableAmount() {
        try {
            int maxScrolls = 3; // Number of scrolls to perform
            boolean found = false; // Flag to indicate if the element is found
            
            for (int scrollAttempts = 0; scrollAttempts < maxScrolls; scrollAttempts++) {
                // Scroll down
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("window.scrollBy(0, 500);"); // Increased scroll distance
                
                // Check for the 'total' element after scrolling
                if (!DriverManager.getDriver().findElements(By.xpath("//div[@role='row' and .//span[text()='Total']]//div[3]//span")).isEmpty()) {
                    // Element found, scroll into view
                    WebElement totalElement = DriverManager.getDriver().findElement(By.xpath("//div[@role='row' and .//span[text()='Total']]//div[3]//span"));
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", totalElement);
                    
                    // Wait for visibility and extract the text
                    wait.until(ExpectedConditions.visibilityOf(totalElement));
                    String totalAmount = totalElement.getText().replaceAll(",", "");
                    RecievableAmounts = Double.parseDouble(totalAmount);
                    System.out.println("Aged Receivable Amount: " + RecievableAmounts);

                    // Add to the table data
                    HashMap<String, Double> hm2 = new HashMap<>();
                    hm2.put("Add: GST on Debtors", RecievableAmounts);
                    LAST_TABLE_DATA.add(hm2);
                    found = true; // Element found
                    break; // Exit loop
                }
            }
            
            if (!found) {
                throw new RuntimeException("Aged Receivable Amount could not be found after scrolling.");
            }
            
        } catch (Exception e) {
            System.err.println("Error extracting Aged Receivable amount: " + e.getMessage());
            throw e;
        }
    }



    public void clickReportingButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(reporting));
            reporting.click();
        } catch (Exception e) {
            System.err.println("Failed to click Reporting button: " + e.getMessage());
            throw e;
        }
    }

    public void clickReportsButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(reports));
            reports.click();
        } catch (Exception e) {
            System.err.println("Failed to click Reports button: " + e.getMessage());
            throw e;
        }
    }
}
