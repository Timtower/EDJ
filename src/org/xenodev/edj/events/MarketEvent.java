package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.market.MarketFile;
import org.xenodev.edj.utils.JsonTranslator;

public class MarketEvent extends Event {
	
	private String stationName, starSystem;
	private Integer marketID;
	private MarketFile marketFile;
	
	public MarketEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.stationName = JsonTranslator.getString(json, "StationName");
		this.starSystem = JsonTranslator.getString(json, "StarSystem");
		this.marketID = JsonTranslator.getInteger(json, "MarketID");
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
