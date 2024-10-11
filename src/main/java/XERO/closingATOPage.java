package XERO;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class closingATOPage extends BaseClass{

	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	List<WebElement> tableTr;

	//constructor
	public closingATOPage(){  
	}

	//list  of all the actions on page
	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	public void closingTabs() {
	}
	
	public void closeBrowser() {
		DriverManager.getDriver().quit();
	}
}
