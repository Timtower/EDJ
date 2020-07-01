package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingDeniedEvent extends Event {

	private String reason, stationName, stationType;
	private Long marketID;
	
	public DockingDeniedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.reason = json.pullString("Reason");
		this.stationName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.marketID = json.pullLong("MarketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public Long getMarketID() {
		return marketID;
	}

}
