package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingRequestedEvent extends Event {
	
	String stationmName, stationType;
	Long marketID;
	
	public DockingRequestedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationmName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.marketID = json.pullLong("MarketID");
		
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

	public Long getMarketID() {
		return marketID;
	}

	public void setMarketID(Long marketID) {
		this.marketID = marketID;
	}

}
