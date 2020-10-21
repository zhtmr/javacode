package com.jin.Ex09;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int dayOfweek;
	private int depTime;
	private int dayOfmonth;
	private int cancelled;
	private String uniqueCarrier;
	private int carrierDelay;
	final static int SUSPENSIONOFAIRLINE = -1;
	final static int NONCANCELLED = 0;
	
	private int getDigitFromStr(String data, int def) {
		if("na".equalsIgnoreCase(data)) return def;
		return Integer.parseInt(data);
	}
	
	public AirlineParser(Text txt) {
		String[] airdata = txt.toString().split(",");
		year = Integer.parseInt(airdata[0]);
		month = Integer.parseInt(airdata[1]);
		dayOfmonth=Integer.parseInt(airdata[2]);
		dayOfweek = Integer.parseInt(airdata[3]);
		depTime = getDigitFromStr(airdata[4],SUSPENSIONOFAIRLINE);
		cancelled = Integer.parseInt(airdata[21]);
		uniqueCarrier=airdata[8];
		carrierDelay=getDigitFromStr(airdata[24], SUSPENSIONOFAIRLINE);
		
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
	public int getCarrierDelay() {
		return carrierDelay;
	}
	public String getUniqueCarrier() {
		return uniqueCarrier;
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
