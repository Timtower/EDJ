/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:34
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleStoreEvent extends Event {
	
	private String slot, storedItem, storedItemLocalised, ship;
	private Integer shipId;
	private Boolean hot;
	private Long marketId;
	
	public ModuleStoreEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.slot = json.pullString("Slot");
		this.storedItem = json.pullString("StoredItem");
		this.storedItemLocalised = json.pullString("StoredItem_Localised");
		this.ship = json.pullString("Ship");
		this.shipId = json.pullInt("ShipID");
		this.hot = json.pullBoolean("Hot");
		this.marketId = json.pullLong("MarketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSlot() {
		return slot;
	}

	public String getStoredItem() {
		return storedItem;
	}

	public String getStoredItemLocalised() {
		return storedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getHot() {
		return hot;
	}

	public Long getMarketId() {
		return marketId;
	}

}
