package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FetchRemoteModuleEvent extends Event {
	
	private Integer storageSlots, serverId, transferCost, transferTime, shipId;
	private String storedItem, storedItemLocalised, ship;
	
	public FetchRemoteModuleEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.storageSlots = json.pullInt("StorageSlot");
		this.serverId = json.pullInt("ServerId");
		this.transferCost = json.pullInt( "TransferCost");
		this.transferTime = json.pullInt("TransferTime");
		this.shipId = json.pullInt("ShipID");
		this.storedItem = json.pullString("StoredItem");
		this.storedItemLocalised = json.pullString("StoredItem_Localised");
		this.ship = json.pullString("Ship");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public String getStoredItemLocalised() {
		return storedItemLocalised;
	}

	public String getShip() {
		return ship;
	}


}
