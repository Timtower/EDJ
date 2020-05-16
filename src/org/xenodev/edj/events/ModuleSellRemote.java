/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:29
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ModuleSellRemote extends Event {
	
	Integer storageSlot, shipId;
	String sellItem, sellItemLocalised, ship;
	Long serverId, sellPrice;
	
	public ModuleSellRemote(String timestamp, JSONObject json) {
		super(timestamp);
		this.storageSlot = json.getInt("StorageSlot");
		this.shipId = json.getInt("ShipID");
		this.sellItem = json.getString("SellItem");
		this.sellItemLocalised = json.getString("SellItem_Localised");
		this.ship = json.getString("Ship");
		this.serverId = json.getLong("ServerId");
		this.sellPrice = json.getLong("SellPrice");
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
