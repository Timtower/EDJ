/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/10/2020 10:43
*/

package org.xenodev.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.ModuleItem;
import org.xenodev.edj.utils.JournalUtils;

public class MassModuleStoreEvent extends Event {
	
	public Long marketID;
	public String ship;
	public Integer shipId;
	public List<ModuleItem> items;

	public MassModuleStoreEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketID = json.pullLong("MarketID");
		this.ship = json.pullString("Ship");
		this.shipId = json.pullInt("ShipID");
		this.items = JournalUtils.createModuleItemsList(json.getJSONArray("Items"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketID() {
		return marketID;
	}

	public void setMarketID(Long marketID) {
		this.marketID = marketID;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public List<ModuleItem> getItems() {
		return items;
	}

	public void setItems(List<ModuleItem> items) {
		this.items = items;
	}

}
