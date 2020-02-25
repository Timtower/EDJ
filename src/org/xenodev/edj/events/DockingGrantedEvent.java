package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DockingGrantedEvent extends Event {
	
	String stationName, stationType;
	long marketID;
	int landingPad;
	
	public DockingGrantedEvent(String timestamp, String stationName, String stationType, long marketID, int landingPad) {
		super(timestamp);
		this.stationName = stationName;
		this.stationType = stationType;
		this.marketID = marketID;
		this.landingPad = landingPad;
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

	public int getLandingPad() {
		return landingPad;
	}

}
