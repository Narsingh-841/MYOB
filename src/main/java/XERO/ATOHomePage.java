package XERO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asis.Excel;
import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class ATOHomePage {
	
	//list of webelements
	@FindBy(xpath = "//input[@type='search']")
    WebElement clientNameSearch;
		
	//constructor
	public ATOHomePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);       
    }
	
	//list  of all the actions on page
	
	public void enterClientName() {
		clientNameSearch.sendKeys("xyz");
	}
	
	public static void generateExcel() {
		String[] client_data = {BaseClass.clientData.get("client_name").trim(), BaseClass.clientData.get("to_date").trim()};
		Excel obj = new Excel();
		obj.createFinancialSummaryExcelWithData("Final_data.xls", BaseClass.ATO_ROW_DATA, BaseClass.XERO_DATA, BaseClass.ACTIVITY_STATEMENT_DATA,client_data);
	}

}


