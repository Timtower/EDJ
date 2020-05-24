/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:41
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ModuleSwapEvent extends Event {

	Long marketId;
	String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
	Integer shipId;
	
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

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getFromSlot() {
		return fromSlot;
	}

	public void setFromSlot(String fromSlot) {
		this.fromSlot = fromSlot;
	}

	public String getToSlot() {
		return toSlot;
	}

	public void setToSlot(String toSlot) {
		this.toSlot = toSlot;
	}

	public String getFromItem() {
		return fromItem;
	}

	public void setFromItem(String fromItem) {
		this.fromItem = fromItem;
	}

	public String getFromItemLocalised() {
		return fromItemLocalised;
	}

	public void setFromItemLocalised(String fromItemLocalised) {
		this.fromItemLocalised = fromItemLocalised;
	}

	public String getToItem() {
		return toItem;
	}

	public void setToItem(String toItem) {
		this.toItem = toItem;
	}

	public String getToItemLocalised() {
		return toItemLocalised;
	}

	public void setToItemLocalised(String toItemLocalised) {
		this.toItemLocalised = toItemLocalised;
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

}
