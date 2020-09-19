/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/10/2020 10:43
*/

package io.github.xenopyax.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.ModuleItem;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MassModuleStoreEvent extends Event {
	
	public Long marketID;
	public String ship;
	public Integer shipId;
	public List<ModuleItem> items;

	public MassModuleStoreEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketID = json.pullLong("MarketID");
		this.ship = json.pullString("Ship");
		this.shipId = json.pullInt("ShipID");
		this.items = JournalUtils.createModuleItemsList(json.getJSONArray("Items"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketID() {
		return marketID;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public List<ModuleItem> getItems() {
		return items;
	}

}
