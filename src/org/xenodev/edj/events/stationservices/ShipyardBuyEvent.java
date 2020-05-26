/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:17
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardBuyEvent extends Event {
	
	String shipType, sellOldShip;
	Long shipPrice, sellPrice;
	Integer sellShipId;
	
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

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getSellOldShip() {
		return sellOldShip;
	}

	public void setSellOldShip(String sellOldShip) {
		this.sellOldShip = sellOldShip;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Long shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getSellShipId() {
		return sellShipId;
	}

	public void setSellShipId(Integer sellShipId) {
		this.sellShipId = sellShipId;
	}

}
