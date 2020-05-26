/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:20
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleRetrieveEvent extends Event {
	
	Long marketId;
	String slot, retrievedItem, retrievedItemLocalised, ship, swapOutItem, swapOutItemLocalised;
	Integer shipId;
	Boolean hot;
	
	public ModuleRetrieveEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.slot = json.pullString("Slot");
		this.retrievedItem = json.pullString("RetrievedItem");
		this.retrievedItemLocalised = json.pullString("RetrievedItem_Localised");
		this.ship = json.pullString("Ship");
		this.swapOutItem = json.pullString("SwapOutItem");
		this.swapOutItemLocalised = json.pullString("SwapOutItem_Localised");
		this.shipId = json.pullInt("ShipID");
		this.hot = json.pullBoolean("Hot");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getRetrievedItem() {
		return retrievedItem;
	}

	public void setRetrievedItem(String retrievedItem) {
		this.retrievedItem = retrievedItem;
	}

	public String getRetrievedItemLocalised() {
		return retrievedItemLocalised;
	}

	public void setRetrievedItemLocalised(String retrievedItemLocalised) {
		this.retrievedItemLocalised = retrievedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getSwapOutItem() {
		return swapOutItem;
	}

	public void setSwapOutItem(String swapOutItem) {
		this.swapOutItem = swapOutItem;
	}

	public String getSwapOutItemLocalised() {
		return swapOutItemLocalised;
	}

	public void setSwapOutItemLocalised(String swapOutItemLocalised) {
		this.swapOutItemLocalised = swapOutItemLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}
