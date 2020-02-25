package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class UndockedEvent extends Event {
	
	String stationName, stationType;
	long marketID;
	
	public UndockedEvent(String timestamp, String stationName, String stationType, long marketID) {
		super(timestamp);
		this.stationName = stationName;
		this.stationType = stationType;
		this.marketID = marketID;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public long getMarketID() {
		return marketID;
	}

}
