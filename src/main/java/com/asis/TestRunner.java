
/**
 * 
 */
package com.asis;

import java.io.IOException;
import java.text.ParseException;

import com.asis.util.BaseClass;

/**
 * 
 */
public class TestRunner {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws ParseException 
	 */

	public static void generateExcel() {
		String[] client_data = {BaseClass.clientData.get("client_name").trim(), BaseClass.clientData.get("to_date").trim()};
		Excel obj = new Excel();
		obj.createFinancialSummaryExcelWithData("Final_data.xls", BaseClass.ATO_ROW_DATA, BaseClass.XERO_DATA, BaseClass.ACTIVITY_STATEMENT_DATA,client_data);
	}

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		// TODO Auto-generated method stub

		ATOdata obj = new ATOdata(); 
		//obj.setupDriver();
		//obj.lauchSite("https://onlineservices.ato.gov.au/onlineservices/");

		obj.login_ato();
		obj.clientName();
		obj.goToQuarterName();
		obj.setToDateFromDate();
		obj.matchingQuarter();
		obj.gotoICAStatement();
		obj.fetchICAStatementData();		
		obj.tearDown();

	    
		XeroTesting obj2 = new XeroTesting();
//		obj2.setupDriver();
//		obj2.lauchSite("https://login.xero.com");
		obj2.login_xero();
		obj2.twofactorAuth();
		obj2.gotoAccountsClick();
		obj2.getAndSetFromAndTodate();
		obj2.captureA1G1B1Data();
		obj2.goToAgedRecievableSummry();
		obj2.goToAgedPayableSymmary();
		obj2.balanceSheet();
		obj2.getXeroData();
		obj2.tearDown();			
		generateExcel();
	    
	}

}
