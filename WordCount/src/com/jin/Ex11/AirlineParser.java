package com.jin.Ex11;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int dayOfweek;
	private int depTime;
	private int dayOfmonth;
	private boolean cancelled;
	private String uniqueCarrier;
	private int carrierDelay;
	private String tailNum;
	private int nasDelay;
	private String cancellationCode;
	private int arrDelay;
	private int depDelay;
	private boolean diverted;
	private int flightNum;
	final static int SUSPENSIONOFAIRLINE = -1;
	final static int NONCANCELLED = 0;
	final static int NONAIRFLIGHT = 0;
	
	private int getDigitFromStr(String data, int def) {
		if("na".equalsIgnoreCase(data)) return def; // -1
		return Integer.parseInt(data);
	}
	
//	private boolean getBool(int n) {
//		return n==1?true:false;
//	}
	
	private boolean getBool(String n) {
		// 문자가 같냐
		return "1".contentEquals(n);
		// 문자와 자료형이 같냐(합동개념)
//		return "1".equals(n);
	}
	
	public AirlineParser(Text txt) {
		String[] airdata = txt.toString().split(",");
		year = Integer.parseInt(airdata[0]);
		month = Integer.parseInt(airdata[1]);
		dayOfmonth=Integer.parseInt(airdata[2]);
		dayOfweek = Integer.parseInt(airdata[3]);
		depTime = getDigitFromStr(airdata[4],SUSPENSIONOFAIRLINE);
		uniqueCarrier=airdata[8];
		flightNum=Integer.parseInt(airdata[9]);
		tailNum=airdata[10];
		depDelay=getDigitFromStr(airdata[15], SUSPENSIONOFAIRLINE);
		arrDelay=getDigitFromStr(airdata[14], SUSPENSIONOFAIRLINE);
		cancelled = getBool(airdata[21]);
		cancellationCode=airdata[22];
		diverted=getBool(airdata[23]);
		carrierDelay=getDigitFromStr(airdata[24], SUSPENSIONOFAIRLINE);
		nasDelay=getDigitFromStr(airdata[26], SUSPENSIONOFAIRLINE);
		
	}

	public int getDepDelay() {
		return depDelay;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDayOfweek() {
		return dayOfweek;
	}

	public int getDepTime() {
		return depTime;
	}

	public int getDayOfmonth() {
		return dayOfmonth;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}

	public int getCarrierDelay() {
		return carrierDelay;
	}

	public String getTailNum() {
		return tailNum;
	}

	public int getNasDelay() {
		return nasDelay;
	}

	public String getCancellationCode() {
		return cancellationCode;
	}

	public int getArrDelay() {
		return arrDelay;
	}

	public boolean isDiverted() {
		return diverted;
	}

	public int getFlightNum() {
		return flightNum;
	}

	
	

	
	
	
}
