/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:50
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardSellEvent extends Event {
	
	String shipType, shipTypeLocalised;
	Integer sellShipId;
	Long shipPrice, marketId;
	
	public ShipyardSellEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.shipTypeLocalised = json.pullString("ShipType_Localised");
		this.sellShipId = json.pullInt("SellShipID");
		this.shipPrice = json.pullLong("ShipPrice");
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

	public Integer getSellShipId() {
		return sellShipId;
	}

	public void setSellShipId(Integer sellShipId) {
		this.sellShipId = sellShipId;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Long shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
