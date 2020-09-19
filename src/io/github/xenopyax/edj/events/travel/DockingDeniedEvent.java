package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
