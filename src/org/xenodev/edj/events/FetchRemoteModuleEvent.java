package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class FetchRemoteModuleEvent extends Event {
	
	private Integer storageSlots, serverId, transferCost, transferTime, shipId;
	private String storedItem, storedItem_Localised, ship;
	
	public FetchRemoteModuleEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.storageSlots = json.getInt("StorageSlots");
		this.serverId = json.getInt("ServerId");
		this.transferCost = json.getInt( "TransferCost");
		this.transferTime = json.getInt("TransferTime");
		this.shipId = json.getInt("ShipId");
		this.storedItem = json.getString("StoredItem");
		this.storedItem_Localised = json.getString("StoredItem_Localised");
		this.ship = json.getString("Ship");
	}

	public Integer getStorageSlots() {
		return storageSlots;
	}

	public Integer getServerId() {
		return serverId;
	}

	public Integer getTransferCost() {
		return transferCost;
	}

	public Integer getTransferTime() {
		return transferTime;
	}

	public Integer getShipId() {
		return shipId;
	}

	public String getStoredItem() {
		return storedItem;
	}

	public String getStoredItem_Localised() {
		return storedItem_Localised;
	}

	public String getShip() {
		return ship;
	}
	
}
