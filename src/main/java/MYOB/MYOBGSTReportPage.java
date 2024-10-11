package MYOB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class MYOBGSTReportPage extends BaseClass {

    @FindBy(xpath="//div[@data-id='GST return']//a")
    WebElement gstReturn;
    
    @FindBy(xpath="//input[@name='GST_FROM_DATE']")
    WebElement from;
    
    @FindBy(xpath="//input[@name='GST_TO_DATE']")
    WebElement to;
    
    @FindBy(xpath="//div[@title='Total sales']/following-sibling::div[@role='cell'][2]")
    WebElement G1;
    
    @FindBy(xpath="//div[contains(., 'GST on sales')]/following-sibling::div[@role='cell'][2]")
    WebElement A1;
    
    @FindBy(xpath="//div[contains(., 'GST on purchases')]/following-sibling::div[@role='cell'][2]")
    WebElement B1;

    @FindBy(xpath="//div[contains(text(),'Reporting')]")
    WebElement reporting;
    
    @FindBy(xpath="//span[contains(text(),'Reports')]")
    WebElement reports;
    
    public MYOBGSTReportPage() {    
        PageFactory.initElements(DriverManager.getDriver(), this);    
    }

    public void clickGSTReportPage() {    
        wait.until(ExpectedConditions.elementToBeClickable(gstReturn));
        gstReturn.click();
    }

    public void passFromDate() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(from));
        String StringFromDate =ATO_FROM_DATE;
        from.sendKeys(Keys.CONTROL + "a");
        from.sendKeys(Keys.DELETE);
        
        from.sendKeys(StringFromDate);
        Thread.sleep(3000);
    }

    public void passToDate() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(to));
        String StringToDate =ATO_TO_DATE;
        to.sendKeys(Keys.CONTROL + "a");
        to.sendKeys(Keys.DELETE);
        
        to.sendKeys(StringToDate);
        Thread.sleep(3000);
    }


    public void extractG1A1B1Value() {
        fetchCaptureA1G1B1Data.add(G1.getText().replaceAll("[,]", ""));        
        fetchCaptureA1G1B1Data.add(A1.getText().replaceAll("[,]", ""));
        fetchCaptureA1G1B1Data.add(B1.getText().replaceAll("[,]", ""));
    }

    public void clickReportingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reporting));
        reporting.click();
    }

    public void clickReportsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reports));
        reports.click();
    }
}
