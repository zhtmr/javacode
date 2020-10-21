package com.jin.Ex08;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int dayOfweek;
	private int depTime;
	private int dayOfmonth;
	private int cancelled;
	final static int SUSPENSIONOFAIRLINE = -1;
	final static int NONCANCELLED = 0;
	
	public AirlineParser(Text txt) {
		String[] airdata = txt.toString().split(",");
		year = Integer.parseInt(airdata[0]);
		month = Integer.parseInt(airdata[1]);
		dayOfmonth=Integer.parseInt(airdata[2]);
		dayOfweek = Integer.parseInt(airdata[3]);
		if("na".equalsIgnoreCase(airdata[4])) depTime = SUSPENSIONOFAIRLINE;
		else depTime = Integer.parseInt(airdata[4]);
		cancelled = Integer.parseInt(airdata[21]);
		
	}

	public int getDayOfmonth() {
		return dayOfmonth;
	}

	public int getCancelled() {
		return cancelled;
	}
	public int getYear() {
		return year;
	}
	public int getDayOfweek() {
		return dayOfweek;
	}
	public int getDeptime() {
		return depTime;
	}



	public int getMonth() {
		return month;
	}

	
	
	
}
