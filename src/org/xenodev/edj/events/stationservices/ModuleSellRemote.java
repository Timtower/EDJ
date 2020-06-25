/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:29
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleSellRemote extends Event {
	
	Integer storageSlot, shipId;
	String sellItem, sellItemLocalised, ship;
	Long serverId, sellPrice;
	
	public ModuleSellRemote(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.storageSlot = json.pullInt("StorageSlot");
		this.shipId = json.pullInt("ShipID");
		this.sellItem = json.pullString("SellItem");
		this.sellItemLocalised = json.pullString("SellItem_Localised");
		this.ship = json.pullString("Ship");
		this.serverId = json.pullLong("ServerId");
		this.sellPrice = json.pullLong("SellPrice");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getStorageSlot() {
		return storageSlot;
	}

	public void setStorageSlot(Integer storageSlot) {
		this.storageSlot = storageSlot;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
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

	public Long getServerId() {
		return serverId;
	}

	public void setServerId(Long serverId) {
		this.serverId = serverId;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

}
