package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingRequestedEvent extends Event {
	
	String stationmName, stationType;
	long marketID;
	
	public DockingRequestedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationmName = json.getString("StationName");
		this.stationType = json.getString("StationType");
		this.marketID = json.getLong("MarketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStationmName() {
		return stationmName;
	}

	public void setStationmName(String stationmName) {
		this.stationmName = stationmName;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public long getMarketID() {
		return marketID;
	}

	public void setMarketID(long marketID) {
		this.marketID = marketID;
	}

}
