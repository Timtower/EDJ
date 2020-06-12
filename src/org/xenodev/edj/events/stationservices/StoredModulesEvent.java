/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:34
*/

package org.xenodev.edj.events.stationservices;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.StoredModule;
import org.xenodev.edj.utils.JournalUtils;

public class StoredModulesEvent extends Event {
	
	Long marketId;
	String stationName, starSystem;
	List<StoredModule> moduleList = new ArrayList<>();
	
	public StoredModulesEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.stationName = json.pullString("StationName");
		this.starSystem = json.pullString("StarSystem");
		this.moduleList = JournalUtils.createStoredModuleList(json.pullJSONArray("Items"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public List<StoredModule> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<StoredModule> moduleList) {
		this.moduleList = moduleList;
	}

}
