/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:46
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class OutfittingEvent extends Event {
	
	Long marketId;
	String stationName, starSystem;
	
	public OutfittingEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketId = json.getLong("MarketID");
		this.stationName = json.getString("StationName");
		this.starSystem = json.getString("StarSystem");
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
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

}
