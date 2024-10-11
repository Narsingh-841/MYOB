package com.asis;

import java.util.ArrayList;

public class GST_template { 
	    public String activityStatement = "";
	    public int activityStatementCount = 1;
	    public String clientName = "";
	    public ArrayList<ArrayList<String>> GSTData = new ArrayList<>();

	    public void addRowData(ArrayList<String> rowData) {
	        GSTData.add(rowData);
	    }
}
