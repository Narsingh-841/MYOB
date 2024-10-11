package com.asis;
import java.util.ArrayList;
import java.util.List;

public class QuaterData {
	private String quarter_name;
	private double _G1;
	private double _G3;
	private double _1A;
	private double _G10;	
	private double _G11;
	private double _1B;
	private double _GST_Refund;
	private double _W1;
	private double _4;
	private double _5A;
	private double _7D;
	private double _ATO_Total_Refund;
	private double _ATO_Reports;


	private static double total_of_year_G1 = 0.0;
	private static double total_of_year_G3 = 0.0;
	private static double total_of_year_1A = 0.0;	
	private static double total_of_year_G10 = 0.0;	
	private static double total_of_year_G11 = 0.0;
	private static double total_of_year_1B = 0.0;
	private static double total_of_year_GST_Refund = 0.0;
	private static double total_of_year_W1 = 0.0;
	private static double total_of_year_4 = 0.0;
	private static double total_of_year_5A= 0.0; 
	private static double total_of_year_7D = 0.0;
	private static double total_of_year_ATO_Total_Refund = 0.0;
	private static double total_of_year_ATO_Reports= 0.0;

	public static double getTotal_of_year_G1() {
		return total_of_year_G1;
	}


	public static double getTotal_of_year_G3() {
		return total_of_year_G3;
	}


	public static double getTotal_of_year_1A() {
		return total_of_year_1A;
	}


	public static double getTotal_of_year_G10() {
		return total_of_year_G10;
	}


	public static double getTotal_of_year_G11() {
		return total_of_year_G11;
	}


	public static double getTotal_of_year_1B() {
		return total_of_year_1B;
	}


	public static double getTotal_of_year_GST_Refund() {
		return total_of_year_GST_Refund;
	}


	public static double getTotal_of_year_W1() {
		return total_of_year_W1;
	}


	public static double getTotal_of_year_4() {
		return total_of_year_4;
	}


	public static double getTotal_of_year_5A() {
		return total_of_year_5A;
	}


	public static double getTotal_of_year_7D() {
		return total_of_year_7D;
	}


	public static double getTotal_of_year_ATO_Total_Refund() {
		return total_of_year_ATO_Total_Refund;
	}


	public static double getTotal_of_year_ATO_Reports() {
		return total_of_year_ATO_Reports;
	}


	public QuaterData(String quarter_name) {
		this.quarter_name = quarter_name;
		this._G1 = 0.0;
		this._G3 = 0.0;
		_1A = 0.0;
		this._G10 = 0.0;
		this._G11 = 0.0;
		_1B = 0.0;
		this._GST_Refund = 0.0;
		this._W1 = 0.0;
		this._4 = 0.0;
		_5A = 0.0;
		_7D = 0.0;
		this._ATO_Total_Refund = 0.0;
		this._ATO_Reports = 0.0;
	}


	public String getQuarter_name() {
		return quarter_name;
	}

	public double get_G1() {
		return _G1;
	}

	public double get_G3() {
		return _G3;
	}

	public double get_1A() {
		return _1A;
	}

	public double get_G10() {
		return _G10;
	}

	public double get_G11() {
		return _G11;
	}

	public double get_1B() {
		return _1B;
	}

	public double get_GST_Refund() {
		return _GST_Refund;
	}

	public double get_W1() {
		return _W1;
	}

	public double get_4() {
		return _4;
	}

	public double get_5A() {
		return _5A;
	}

	public double get_7D() {
		return _7D;
	}

	public double get_ATO_Total_Refund() {
		return _ATO_Total_Refund;
	}
	public double get_ATO_Reports() {
		return _ATO_Reports;
	}


	public void setQuarter_name(String quarter_name) {
		this.quarter_name = quarter_name;
	}
	public void set_G1(double _G1, boolean flag) {
		this._G1 = _G1;
		if(flag) {
			total_of_year_G1 += this._G1; 
		}		
	}

	public void set_G3(double _G3, boolean flag) {
		this._G3 = _G3;
		if(flag) {

			total_of_year_G3 += this._G3; 
		}		
	}

	public void set_1A(double _1a, boolean flag) {
		_1A = _1a;
		if(flag) {
			total_of_year_1A += this._1A;
		}	 
	}

	public void set_G10(double _G10, boolean flag) {
		this._G10 = _G10;
		if(flag) {
			total_of_year_G10 += this._G10; 
		}	
	}

	public void set_G11(double _G11, boolean flag) {
		this._G11 = _G11;
		if(flag) {
			total_of_year_G11 += this._G11; 
		}	
	}

	public void set_1B(double _1b, boolean flag) {
		_1B = _1b;
		if(flag) {
			total_of_year_1B += this._1B; 
		}	
	}

	public void set_GST_Refund(double _GST_Refund, boolean flag) {
		this._GST_Refund = _GST_Refund;
		if(flag) {
			total_of_year_GST_Refund += this._GST_Refund; 
		}	
	}
	public void set_W1(double _W1, boolean flag) {
		this._W1 = _W1;
		if(flag) {
			total_of_year_W1 += this._W1;
		}	 
	}
	public void set_4(double _4, boolean flag) {
		this._4 = _4;
		if(flag) {
			total_of_year_4 += this._4; 
		}	
	}
	public void set_5A(double _5a, boolean flag) {
		_5A = _5a;
		if(flag) {
			total_of_year_5A += this._5A; 
		}	
	}
	public void set_7D(double _7d, boolean flag) {
		_7D = _7d;
		if(flag) {
			total_of_year_7D += this._7D; 
		}	
	}
	public void set_ATO_Total_Refund(double _ATO_Total_Refund, boolean flag) {
		this._ATO_Total_Refund = _ATO_Total_Refund;
		if(flag) {
			total_of_year_ATO_Total_Refund += this._ATO_Total_Refund; 
		}	
	}
	public void set_ATO_Reports(double _ATO_Reports, boolean flag) {
		this._ATO_Reports = _ATO_Reports;
		if(flag) {
			total_of_year_ATO_Total_Refund += this._ATO_Total_Refund;
		}	
	}	

}
