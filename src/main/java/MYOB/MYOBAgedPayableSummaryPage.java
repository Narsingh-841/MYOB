package MYOB;

import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class MYOBAgedPayableSummaryPage extends BaseClass {

    @FindBy(xpath = "//div[contains(text(),'Payables reconciliation with tax')]")
    WebElement payable;

    @FindBy(xpath = "//input[@name='AS_AT_DATE']")
    WebElement toDate;

    @FindBy(xpath = "//div[@role='row' and .//span[text()='Total']]//div[3]//span")
    public WebElement total;

    @FindBy(xpath = "//div[contains(text(),'Reporting')]")
    WebElement reporting;

    @FindBy(xpath = "//span[contains(text(),'Reports')]")
    WebElement reports;

    public static double PayableAmount = 0.0;
    public static double total1 = 0.0;

    public MYOBAgedPayableSummaryPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // List of all the actions on page
    public void clickPayable() {
        try {
            wait.until(ExpectedConditions.visibilityOf(payable));
            payable.click();
        } catch (Exception e) {
            System.err.println("Failed to click Payable button: " + e.getMessage());
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
            Thread.sleep(3000); // Add sleep for manual intervention if needed
        } catch (Exception e) {
            System.err.println("Failed to enter 'To Date': " + e.getMessage());
            throw e;
        }
    }

    public void getPayableTotal() throws InterruptedException {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                // Scroll down to the bottom of the page
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(1000); // Reduced sleep time for quicker attempts

                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)); // Shorter wait time
                WebElement totalElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@role='row' and .//span[text()='Total']]//div[3]//span")
                ));

                // Wait for the total element to be visible
                wait.until(ExpectedConditions.visibilityOf(totalElement));

                // Extract the total value
                String totalPayableStr = totalElement.getText().replaceAll(",", "");
                PayableAmount = Double.parseDouble(totalPayableStr);
                System.out.println("Aged Payable Amount: " + PayableAmount);

                HashMap<String, Double> hm3 = new HashMap<>();
                hm3.put("Less: GST on Creditors", PayableAmount);
                LAST_TABLE_DATA.add(hm3);
                break; // Exit loop if successful

            } catch (org.openqa.selenium.TimeoutException e) {
                System.err.println("Element not found on attempt " + (i + 1) + ": " + e.getMessage());
                // Optionally scroll again or refresh the page
                if (i < retries - 1) {
                    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                    js.executeScript("window.scrollBy(0, 500);"); // Scroll slightly down again
                    Thread.sleep(1000); // Give time for content to load
                }
            } catch (NoSuchElementException e) {
                System.err.println("Retrying to locate the 'Total' element: Attempt " + (i + 1));
                if (i == retries - 1) throw e; // Rethrow after max retries
            } catch (NumberFormatException e) {
                System.err.println("Error parsing payable amount: " + e.getMessage());
                if (i == retries - 1) throw e; // Rethrow after max retries
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.err.println("Thread interrupted: " + e.getMessage());
            }
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
