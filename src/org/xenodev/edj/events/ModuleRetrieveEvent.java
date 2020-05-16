/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:20
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ModuleRetrieveEvent extends Event {
	
	Long marketId;
	String slot, retrievedItem, retrievedItemLocalised, ship, swapOutItem, swapOutItemLocalised;
	Integer shipId;
	Boolean hot;
	
	public ModuleRetrieveEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.marketId = json.getLong("MarketID");
		this.slot = json.getString("Slot");
		this.retrievedItem = json.getString("RetrievedItem");
		this.retrievedItemLocalised = json.getString("RetrievedItem_Localised");
		this.ship = json.getString("Ship");
		this.swapOutItem = json.getString("SwapOutItem");
		this.swapOutItemLocalised = json.getString("SwapOutItem_Localised");
		this.shipId = json.getInt("ShipID");
		this.hot = json.getBoolean("Hot");
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
