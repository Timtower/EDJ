/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:34
*/

package io.github.xenopyax.edj.events.stationservices;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.StoredModule;
import io.github.xenopyax.edj.utils.JournalUtils;

public class StoredModulesEvent extends Event {
	
	private Long marketId;
	private String stationName, starSystem;
	private List<StoredModule> moduleList = new ArrayList<>();
	
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

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public List<StoredModule> getModuleList() {
		return moduleList;
	}

}
