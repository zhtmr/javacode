package com.jin.Ex20;

import org.apache.hadoop.io.Text;

public class AlReportParser {
	private String year;
	private int month;
	private int cancelled;
	private int distance = 0;
	private boolean distanceAvailable = true;
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}

	public void setDistanceAvailable(boolean distanceAvailable) {
		this.distanceAvailable = distanceAvailable;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}

	public AlReportParser() {
	}

	public AlReportParser(Text txt) {
		String[] airData = txt.toString().split(",");
		year = airData[0];
		month = Integer.parseInt(airData[1]);
		cancelled = Integer.parseInt(airData[21]);

		// 항공기 출발 지연 시간 설정
		if (!"NA".equals(airData[18])) {
			distance = Integer.parseInt(airData[18]);
		} else {
			distanceAvailable = false;
		}
	}

	public String getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getCancelled() {
		return cancelled;
	}
}
