/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:15
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleBuyEvent extends Event {
	
	String slot, storedItem, storedItemLocalised, buyItem, buyItemLocalised, ship;
	Long buyPrice;
	Integer shipId;
	
	public ModuleBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.slot = json.pullString("Slot");
		this.storedItem = json.pullString("StoredItem");
		this.storedItemLocalised = json.pullString("StoredItem_Localised");
		this.buyItem = json.pullString("BuyItem");
		this.buyItemLocalised = json.pullString("BuyItem_Localised");
		this.ship = json.pullString("Ship");
		this.buyPrice = json.pullLong("BuyPrice");
		this.shipId = json.pullInt("ShipID");
		
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

	public String getBuyItem() {
		return buyItem;
	}

	public void setBuyItem(String buyItem) {
		this.buyItem = buyItem;
	}

	public String getBuyItemLocalised() {
		return buyItemLocalised;
	}

	public void setBuyItemLocalised(String buyItemLocalised) {
		this.buyItemLocalised = buyItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

}
