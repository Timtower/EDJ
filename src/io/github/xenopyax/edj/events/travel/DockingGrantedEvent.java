package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
