/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:53
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardTransferEvent extends Event {
	
	String shipType, shipTypeLocalised, system;
	Integer shipId;
	Long shipMarketId, transferPrice, transferTime, marketId;
	Double distance;
	
	public ShipyardTransferEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.shipTypeLocalised = json.pullString("ShipType_Localised");
		this.system = json.pullString("System");
		this.shipId = json.pullInt("ShipID");
		this.shipMarketId = json.pullLong("ShipMarketID");
		this.transferPrice = json.pullLong("TransferPrice");
		this.transferTime = json.pullLong("TransferTime");
		this.marketId = json.pullLong("MarketID");
		this.distance = json.getDouble("Distance");
		
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

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Long getShipMarketId() {
		return shipMarketId;
	}

	public void setShipMarketId(Long shipMarketId) {
		this.shipMarketId = shipMarketId;
	}

	public Long getTransferPrice() {
		return transferPrice;
	}

	public void setTransferPrice(Long transferPrice) {
		this.transferPrice = transferPrice;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}
