package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.market.MarketFile;
import org.xenodev.edj.utils.JournalUtils;

public class MarketEvent extends Event {
	
	private String stationName, starSystem;
	private Integer marketID;
	private MarketFile marketFile;
	
	public MarketEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationName = json.pullString("StationName");
		this.starSystem = json.pullString("StarSystem");
		this.marketID = json.pullInt("MarketID");
		this.marketFile = new MarketFile();
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public Integer getMarketID() {
		return marketID;
	}

	public void setMarketID(Integer marketID) {
		this.marketID = marketID;
	}

	public MarketFile getMarketFile() {
		return marketFile;
	}

	public void setMarketFile(MarketFile marketFile) {
		this.marketFile = marketFile;
	}

}
