package com.jin.Ex05;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	
	public AirlineParser(Text txt) {
		String[] airdata = txt.toString().split(",");
		year = Integer.parseInt(airdata[0]);
		month = Integer.parseInt(airdata[1]);
	}

	public int getYear() {
		return year;
	}



	public int getMonth() {
		return month;
	}

	
	
	
}
