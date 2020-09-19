/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:26
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ModuleSellEvent extends Event {
	
	private String slot, sellItem, sellItemLocalised, ship;
	private Long sellPrice, marketId;
	private Integer shipId;
	
	public ModuleSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.slot = json.pullString("Slot");
		this.sellItem = json.pullString("SellItem");
		this.sellItemLocalised = json.pullString("SellItem_Localised");
		this.ship = json.pullString("Ship");
		this.sellPrice = json.pullLong("SellPrice");
		this.shipId = json.pullInt("ShipID");
		this.marketId = json.pullLong("MarketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSlot() {
		return slot;
	}

	public String getSellItem() {
		return sellItem;
	}

	public String getSellItemLocalised() {
		return sellItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Integer getShipId() {
		return shipId;
	}

}
