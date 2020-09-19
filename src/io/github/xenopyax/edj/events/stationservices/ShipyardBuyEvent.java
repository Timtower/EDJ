/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:17
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ShipyardBuyEvent extends Event {
	
	private String shipType, sellOldShip;
	private Long shipPrice, sellPrice;
	private Integer sellShipId;
	
	public ShipyardBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.sellOldShip = json.pullString("SellOldShip");
		this.shipPrice = json.pullLong("ShipPrice");
		this.sellPrice = json.pullLong("SellPrice");
		this.sellShipId = json.pullInt("SellShipID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShipType() {
		return shipType;
	}

	public String getSellOldShip() {
		return sellOldShip;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Integer getSellShipId() {
		return sellShipId;
	}

}
