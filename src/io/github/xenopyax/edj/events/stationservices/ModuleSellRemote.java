/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:29
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ModuleSellRemote extends Event {
	
	private Integer storageSlot, shipId;
	private String sellItem, sellItemLocalised, ship;
	private Long serverId, sellPrice;
	
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

	public Integer getShipId() {
		return shipId;
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

	public Long getServerId() {
		return serverId;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

}
