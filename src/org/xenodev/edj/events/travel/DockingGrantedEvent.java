package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingGrantedEvent extends Event {
	
	private String stationName, stationType;
	private Long marketID;
	private Integer landingPad;
	
	public DockingGrantedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.marketID = json.pullLong("MarketID");
		this.landingPad = json.pullInt("LandingPad");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public Integer getLandingPad() {
		return landingPad;
	}

}
