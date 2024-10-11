package com.asis;

import java.util.ArrayList;

public class ICA_template {
	public String activityStatement = "";
	public int activityStatementCount = 1;
	public String clinet_name = "";
	public ArrayList<ArrayList<String>> activityStatementData = new ArrayList<>();
	
	public void addRowData(ArrayList<String> rowData) {
		activityStatementData.add(rowData);
	}
	
}
