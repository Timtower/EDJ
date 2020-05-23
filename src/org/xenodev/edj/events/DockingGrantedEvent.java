package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class DockingGrantedEvent extends Event {
	
	String stationName, stationType;
	Long marketID;
	Integer landingPad;
	
	public DockingGrantedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationName = json.getString("StationName");
		this.stationType = json.getString("StationType");
		this.marketID = json.getLong("MarketID");
		this.landingPad = json.getInt("LandingPad");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public Integer getLandingPad() {
		return landingPad;
	}

	public void setLandingPad(Integer landingPad) {
		this.landingPad = landingPad;
	}

}
