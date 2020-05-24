/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:07
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardSwapEvent extends Event {
	
	String shipType, shipTypeLocalised, storeOldShip;
	Integer shipId, storeShipId;
	Long marketId;
	
	public ShipyardSwapEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.shipTypeLocalised = json.pullString("ShipType_Localised");
		this.storeOldShip = json.pullString("StoreOldShip");
		this.shipId = json.pullInt("ShipID");
		this.storeShipId = json.pullInt("StoreShipID");
		this.marketId = json.pullLong("MarketID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public void setShipTypeLocalised(String shipTypeLocalised) {
		this.shipTypeLocalised = shipTypeLocalised;
	}

	public String getStoreOldShip() {
		return storeOldShip;
	}

	public void setStoreOldShip(String storeOldShip) {
		this.storeOldShip = storeOldShip;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getStoreShipId() {
		return storeShipId;
	}

	public void setStoreShipId(Integer storeShipId) {
		this.storeShipId = storeShipId;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
