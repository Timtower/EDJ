package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DockingDeniedEvent extends Event {

	String reason, stationName, stationType;
	long marketID;
	
	public DockingDeniedEvent(String timestamp, String reason, String stationName, String stationType, long marketID) {
		super(timestamp);
		this.reason = reason;
		this.stationName = stationName;
		this.stationType = stationType;
		this.marketID = marketID;
	}

	public String getReason() {
		return reason;
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
