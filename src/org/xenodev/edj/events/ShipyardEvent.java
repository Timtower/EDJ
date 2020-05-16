/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 10:56
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ShipyardEvent extends Event {
	
	Long marketId;
	String stationName, starSystem;
	
	public ShipyardEvent(String timestamp, JSONObject json) {
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
