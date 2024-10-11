package XERO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

import java.time.Duration;

public class ATOClientNameSearchPage extends BaseClass {

    // List of WebElements
    @FindBy(xpath = "//input[@type='search']")
    WebElement clientNameSearch;

    @FindBy(xpath = "//ul[contains(@class, 'error')]/li[contains(text(), 'No matches found')]")
    WebElement noMatches;

    // Constructor
    public ATOClientNameSearchPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Method to enter client name
    public void enterClientName(String clientName) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // Wait for the input to be present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='search']")));

        // Wait for the input to be visible
        wait.until(ExpectedConditions.visibilityOf(clientNameSearch));

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(clientNameSearch));

        // Clear the input if necessary
        clientNameSearch.clear();

        // Enter the client name using sendKeys (Replacing JavaScript code)
        clientNameSearch.sendKeys(clientName);
    }

    // Method to search for the client name
    public void doSearchClientName() throws InterruptedException {
        Thread.sleep(3000); // Consider using proper waits instead of Thread.sleep
        clientNameSearch.sendKeys(Keys.ENTER);

        // Check if no matches found
        if (isNoMatchesDisplayed()) {
            System.out.println("No matches found for the entered client name.");
            // Handle this case (e.g., quit driver or log an error)
        }
    }

    // Method to check if "No matches found" message is displayed
    public boolean isNoMatchesDisplayed() {
        try {
            return noMatches.isDisplayed();
        } catch (Exception e) {
            return false; // Element not found means no matches are displayed
        }
    }

    // Optional: Method to get page title (not implemented)
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
