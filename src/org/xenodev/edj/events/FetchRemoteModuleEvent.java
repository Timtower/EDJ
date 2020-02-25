package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class FetchRemoteModuleEvent extends Event {
	
	private Integer storageSlots, serverId, transferCost, transferTime, shipId;
	private String storedItem, storedItem_Localised, ship;
	
	public FetchRemoteModuleEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.storageSlots = JsonTranslator.getInteger(json, "StorageSlots");
		this.serverId = JsonTranslator.getInteger(json, "ServerId");
		this.transferCost = JsonTranslator.getInteger(json, "TransferCost");
		this.transferTime = JsonTranslator.getInteger(json, "TransferTime");
		this.shipId = JsonTranslator.getInteger(json, "ShipId");
		this.storedItem = JsonTranslator.getString(json, "StoredItem");
		this.storedItem_Localised = JsonTranslator.getString(json, "StoredItem_Localised");
		this.ship = JsonTranslator.getString(json, "Ship");
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
