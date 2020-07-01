/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:46
*/

package org.xenodev.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.StoredShipHere;
import org.xenodev.edj.events.storage.StoredShipRemote;
import org.xenodev.edj.utils.JournalUtils;

public class StoredShipsEvent extends Event {
	
	private String stationName, starSystem;
	private Long marketId;
	private List<StoredShipHere> shipsHere;
	private List<StoredShipRemote> shipsRemote;
	
	public StoredShipsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationName = json.pullString("StationName");
		this.starSystem = json.pullString("StarSystem");
		this.marketId = json.pullLong("MarketID");
		this.shipsHere = JournalUtils.createStoredShipsHereList(json.pullJSONArray("ShipsHere"));
		this.shipsRemote = JournalUtils.createStoredShipsRemoteList(json.pullJSONArray("ShipsRemote"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<StoredShipHere> getShipsHere() {
		return shipsHere;
	}

	public List<StoredShipRemote> getShipsRemote() {
		return shipsRemote;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Long getMarketId() {
		return marketId;
	}

}
