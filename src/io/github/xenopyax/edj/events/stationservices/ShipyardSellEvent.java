/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:50
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ShipyardSellEvent extends Event {
	
	private String shipType, shipTypeLocalised;
	private Integer sellShipId;
	private Long shipPrice, marketId;
	
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

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public Integer getSellShipId() {
		return sellShipId;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

}
