/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:20
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ModuleRetrieveEvent extends Event {
	
	private Long marketId;
	private String slot, retrievedItem, retrievedItemLocalised, ship, swapOutItem, swapOutItemLocalised;
	private Integer shipId;
	private Boolean hot;
	
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

	public String getSlot() {
		return slot;
	}

	public String getRetrievedItem() {
		return retrievedItem;
	}

	public String getRetrievedItemLocalised() {
		return retrievedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public String getSwapOutItem() {
		return swapOutItem;
	}

	public String getSwapOutItemLocalised() {
		return swapOutItemLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getHot() {
		return hot;
	}

}
