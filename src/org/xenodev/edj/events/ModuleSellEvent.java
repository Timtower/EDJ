/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:26
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ModuleSellEvent extends Event {
	
	String slot, sellItem, sellItemLocalised, ship;
	Long sellPrice;
	Integer shipId;
	
	public ModuleSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.slot = json.getString("Slot");
		this.sellItem = json.getString("SellItem");
		this.sellItemLocalised = json.getString("SellItem_Localised");
		this.ship = json.getString("Ship");
		this.sellPrice = json.getLong("SellPrice");
		this.shipId = json.getInt("ShipID");
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getSellItem() {
		return sellItem;
	}

	public void setSellItem(String sellItem) {
		this.sellItem = sellItem;
	}

	public String getSellItemLocalised() {
		return sellItemLocalised;
	}

	public void setSellItemLocalised(String sellItemLocalised) {
		this.sellItemLocalised = sellItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

}
