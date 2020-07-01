/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:07
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardSwapEvent extends Event {
	
	private String shipType, shipTypeLocalised, storeOldShip;
	private Integer shipId, storeShipId;
	private Long marketId;
	
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

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public String getStoreOldShip() {
		return storeOldShip;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Integer getStoreShipId() {
		return storeShipId;
	}

	public Long getMarketId() {
		return marketId;
	}

}
