/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:41
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleSwapEvent extends Event {

	private Long marketId;
	private String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
	private Integer shipId;
	
	public ModuleSwapEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.marketId = json.pullLong("MarketID");
		this.fromSlot = json.pullString("FromSlot");
		this.toSlot = json.pullString("ToSlot");
		this.fromItem = json.pullString("FromItem");
		this.fromItemLocalised = json.pullString("FromItem_Localised");
		this.toItem = json.pullString("ToItem");
		this.toItemLocalised = json.pullString("ToItem_Localised");
		this.ship = json.pullString("Ship");
		this.shipId = json.pullInt("ShipID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getMarketId() {
		return marketId;
	}

	public String getFromSlot() {
		return fromSlot;
	}

	public String getToSlot() {
		return toSlot;
	}

	public String getFromItem() {
		return fromItem;
	}

	public String getFromItemLocalised() {
		return fromItemLocalised;
	}

	public String getToItem() {
		return toItem;
	}

	public String getToItemLocalised() {
		return toItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

}
