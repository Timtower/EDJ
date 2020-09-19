package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class DockingRequestedEvent extends Event {
	
	private String stationmName, stationType;
	private Long marketID;
	
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

	public String getStationType() {
		return stationType;
	}

	public Long getMarketID() {
		return marketID;
	}

}
