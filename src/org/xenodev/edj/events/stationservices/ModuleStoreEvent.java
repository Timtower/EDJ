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
	
	String slot, storedItem, storedItemLocalised, ship;
	Integer shipId;
	Boolean hot;
	Long marketId;
	
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

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getStoredItem() {
		return storedItem;
	}

	public void setStoredItem(String storedItem) {
		this.storedItem = storedItem;
	}

	public String getStoredItemLocalised() {
		return storedItemLocalised;
	}

	public void setStoredItemLocalised(String storedItemLocalised) {
		this.storedItemLocalised = storedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

}
