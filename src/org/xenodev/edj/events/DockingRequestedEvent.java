package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DockingRequestedEvent extends Event {
	
	String stationmName, stationType;
	long marketID;
	
	public DockingRequestedEvent(String timestamp, String stationmName, String stationType, long marketID) {
		super(timestamp);
		this.stationmName = stationmName;
		this.stationType = stationType;
		this.marketID = marketID;
	}

	public String getStationmName() {
		return stationmName;
	}

	public String getStationType() {
		return stationType;
	}

	public long getMarketID() {
		return marketID;
	}

}
