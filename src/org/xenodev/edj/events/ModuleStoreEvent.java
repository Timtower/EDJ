/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:34
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ModuleStoreEvent extends Event {
	
	String slot, storedItem, storedItemLocalised, ship;
	Integer shipId;
	
	public ModuleStoreEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.slot = json.getString("Slot");
		this.storedItem = json.getString("StoredItem");
		this.storedItemLocalised = json.getString("StoredItem_Localised");
		this.ship = json.getString("Ship");
		this.shipId = json.getInt("ShipID");
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
