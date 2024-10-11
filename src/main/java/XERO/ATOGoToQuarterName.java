package XERO;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class ATOGoToQuarterName extends BaseClass {

    // List of WebElements
    @FindBy(xpath = "//div[@role='menubar']//span[contains(text(),'Lodgments')]")
    WebElement lodgements;
    @FindBy(xpath = "//div[@role='menubar']//span[contains(text(),'Lodgments')]/parent::div/following-sibling::ul/li")
    List<WebElement> options;

    // Constructor
    public ATOGoToQuarterName() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickLodgments() throws InterruptedException {
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.elementToBeClickable(lodgements));
        lodgements.click();
    }

    public void checkingOptionAndClickingActivityStatements() {
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase("Activity statements")) {
                option.click();
                break;
            }
        }
    }
}
