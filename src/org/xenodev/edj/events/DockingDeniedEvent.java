package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingDeniedEvent extends Event {

	String reason, stationName, stationType;
	Long marketID;
	
	public DockingDeniedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.reason = json.getString("Reason");
		this.stationName = json.getString("StationName");
		this.stationType = json.getString("StationType");
		this.marketID = json.getLong("marketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
