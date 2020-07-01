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
	
	private String slot, storedItem, storedItemLocalised, buyItem, buyItemLocalised, ship, sellItem, sellItemLocalised;
	private Long buyPrice, marketId, sellPrice;
	private Integer shipId;
	
	public ModuleBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.sellPrice = json.pullLong("SellPrice");
		this.sellItem = json.pullString("SellItem");
		this.sellItemLocalised = json.pullString("SellItem_Localised");
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

	public String getStoredItem() {
		return storedItem;
	}

	public String getStoredItemLocalised() {
		return storedItemLocalised;
	}

	public String getBuyItem() {
		return buyItem;
	}

	public String getBuyItemLocalised() {
		return buyItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public String getSellItem() {
		return sellItem;
	}

	public String getSellItemLocalised() {
		return sellItemLocalised;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Integer getShipId() {
		return shipId;
	}

}
