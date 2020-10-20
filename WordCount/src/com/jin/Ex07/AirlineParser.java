package com.jin.Ex07;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int day;
	private int depTime;
	final static int SUSPENSIONOFAIRLINE = -1;
	
	public AirlineParser(Text txt) {
		String[] airdata = txt.toString().split(",");
		year = Integer.parseInt(airdata[0]);
		month = Integer.parseInt(airdata[1]);
		day = Integer.parseInt(airdata[3]);
		if("na".equalsIgnoreCase(airdata[4])) depTime = SUSPENSIONOFAIRLINE;
		else depTime = Integer.parseInt(airdata[4]);
			
		
	}

	public int getYear() {
		return year;
	}
	public int getDay() {
		return day;
	}
	public int getDeptime() {
		return depTime;
	}



	public int getMonth() {
		return month;
	}

	
	
	
}
