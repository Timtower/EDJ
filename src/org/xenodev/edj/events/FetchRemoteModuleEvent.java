package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FetchRemoteModuleEvent extends Event {
	
	private Integer storageSlots, serverId, transferCost, transferTime, shipId;
	private String storedItem, storedItem_Localised, ship;
	
	public FetchRemoteModuleEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.storageSlots = json.pullInt("StorageSlots");
		this.serverId = json.pullInt("ServerId");
		this.transferCost = json.pullInt( "TransferCost");
		this.transferTime = json.pullInt("TransferTime");
		this.shipId = json.pullInt("ShipId");
		this.storedItem = json.pullString("StoredItem");
		this.storedItem_Localised = json.pullString("StoredItem_Localised");
		this.ship = json.pullString("Ship");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getStorageSlots() {
		return storageSlots;
	}

	public void setStorageSlots(Integer storageSlots) {
		this.storageSlots = storageSlots;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public Integer getTransferCost() {
		return transferCost;
	}

	public void setTransferCost(Integer transferCost) {
		this.transferCost = transferCost;
	}

	public Integer getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Integer transferTime) {
		this.transferTime = transferTime;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getStoredItem() {
		return storedItem;
	}

	public void setStoredItem(String storedItem) {
		this.storedItem = storedItem;
	}

	public String getStoredItem_Localised() {
		return storedItem_Localised;
	}

	public void setStoredItem_Localised(String storedItem_Localised) {
		this.storedItem_Localised = storedItem_Localised;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

}
