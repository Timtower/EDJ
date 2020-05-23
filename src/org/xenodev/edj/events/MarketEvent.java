package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.market.MarketFile;

public class MarketEvent extends Event {
	
	private String stationName, starSystem;
	private Integer marketID;
	private MarketFile marketFile;
	
	public MarketEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.stationName = json.getString("StationName");
		this.starSystem = json.getString("StarSystem");
		this.marketID = json.getInt("MarketID");
		this.marketFile = new MarketFile();
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public String getStarSystem() {
		return starSystem;
	}
	
	public Integer getMarketID() {
		return marketID;
	}
	
	public MarketFile getMarketFile() {
		return marketFile;
	}

}
