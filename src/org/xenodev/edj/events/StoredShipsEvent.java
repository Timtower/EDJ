/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:46
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class StoredShipsEvent extends Event {
	
	String stationName, starSystem;
	Long marketId;
	
	//TODO: Missing ShipsHere & ShipsRemote arrays
	public StoredShipsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.stationName = json.getString("StationName");
		this.starSystem = json.getString("StarSystem");
		this.marketId = json.getLong("MarketID");
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

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
