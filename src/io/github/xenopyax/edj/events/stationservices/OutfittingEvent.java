/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:46
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class OutfittingEvent extends Event {
	
	private Long marketId;
	private String stationName, starSystem;
	
	public OutfittingEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.stationName = json.pullString("StationName");
		this.starSystem = json.pullString("StarSystem");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketId() {
		return marketId;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

}
