package com.jin.Ex20;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int week;
	private int depTime;
	private int day;
	private boolean cancelled;
	private int carrierDelay;
	private String uiqueCarrier;
	private String tailNum;
	private String cancellationcode;
	private boolean diverted;
	private int arrDelay;
	private int depDelay;
	private int distance;
	private boolean distanceAvailable;
	
	private int actualElapsedTime;
	private int CRSElapsedTime;

	final static int SUSPENSIONOFAIRLINE=-1;
	final static int NONCANCELLED=0;
	final static int NONAIRFLIGHT=0;
	//shift+alt+s , r -> alt+g -> alt+r
	/*
	 * 들어온 값이 1이면 true
	 * 거짓이면 false를 반환
	 */
	private boolean getBool(int n) {
		return n==1?true:false;
	}
	
	private boolean getBool(String n) {
		return "1".contentEquals(n);
		//문자가 같냐
		//return "1".contentEquals(n)==true?true:false;
		//문자와 자료형이 같냐
		//return "1".equals(n)?true:false;
	}
	private int getDigitFromStr(String data, int def) {
		if("NA".equals(data))	return def;
		return Integer.parseInt( data );
	}
	public AirlineParser() {} 
	public AirlineParser(Text txt) {
		String [] airdata = txt.toString().split(",");
		year =Integer.parseInt( airdata[0] );
		month =Integer.parseInt( airdata[1] );
		day =Integer.parseInt( airdata[2] );
		week =Integer.parseInt( airdata[3] );
		depTime =getDigitFromStr(airdata[4],SUSPENSIONOFAIRLINE);
		uiqueCarrier = airdata[8];
		actualElapsedTime = getDigitFromStr(airdata[11], SUSPENSIONOFAIRLINE);
		CRSElapsedTime = getDigitFromStr(airdata[12], SUSPENSIONOFAIRLINE);

		arrDelay =getDigitFromStr(airdata[14],SUSPENSIONOFAIRLINE);
		depDelay =getDigitFromStr(airdata[15],SUSPENSIONOFAIRLINE);
		distance =getDigitFromStr(airdata[18],SUSPENSIONOFAIRLINE);
		carrierDelay =getDigitFromStr(airdata[24],SUSPENSIONOFAIRLINE);
//		cancelled =getBool(Integer.parseInt( airdata[21] ));
		
		cancelled =getBool(airdata[21]);
		tailNum = airdata[10];
		cancellationcode = airdata[22];
		diverted =getBool(airdata[23]);
		
		if(!"na".equalsIgnoreCase(airdata[18])) {
			distance = Integer.parseInt(airdata[18]);
			distanceAvailable =true;
		}else
			distanceAvailable = false;
		
	}
	
	
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setDistanceAvailable(boolean distanceAvailable) {
		this.distanceAvailable = distanceAvailable;
	}

	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}

	int getActualElapsedTime() {
		return actualElapsedTime;
	}

	int getCRSElapsedTime() {
		return CRSElapsedTime;
	}

	int getDistance() {
		return distance;
	}

	int getArrDelay() {
		return arrDelay;
	}

	int getDepDelay() {
		return depDelay;
	}

	static int getNonairflight() {
		return NONAIRFLIGHT;
	}

	boolean isCancelled() {
		return cancelled;
	}

	String getTailNum() {
		return tailNum;
	}

	String getCancellationcode() {
		return cancellationcode;
	}

	boolean isDiverted() {
		return diverted;
	}

	int getCarrierDelay() {
		return carrierDelay;
	}
	String getUiqueCarrier() {
		return uiqueCarrier;
	}
	static int getNoncancelled() {
		return NONCANCELLED;
	}
	int getDay() {
		return day;
	}

	public int getDepTime() {
		return depTime;
	}
	public static int getSuspensionofairline() {
		return SUSPENSIONOFAIRLINE;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getWeek() {
		return week;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setUiqueCarrier(String uiqueCarrier) {
		this.uiqueCarrier = uiqueCarrier;
	}

	public void setTailNum(String tailNum) {
		this.tailNum = tailNum;
	}
	
	
	
}








