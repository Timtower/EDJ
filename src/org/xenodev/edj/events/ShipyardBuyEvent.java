/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:17
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ShipyardBuyEvent extends Event {
	
	String shipType, sellOldShip;
	Long shipPrice, sellPrice;
	Integer sellShipId;
	
	public ShipyardBuyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.shipType = json.getString("ShipType");
		this.sellOldShip = json.getString("SellOldShip");
		this.shipPrice = json.getLong("ShipPrice");
		this.sellPrice = json.getLong("SellPrice");
		this.sellShipId = json.getInt("SellShipID");
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
