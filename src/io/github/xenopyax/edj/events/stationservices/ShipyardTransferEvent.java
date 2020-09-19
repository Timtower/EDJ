/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:53
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ShipyardTransferEvent extends Event {
	
	private String shipType, shipTypeLocalised, system;
	private Integer shipId;
	private Long shipMarketId, transferPrice, transferTime, marketId;
	private Double distance;
	
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

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public String getSystem() {
		return system;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Long getShipMarketId() {
		return shipMarketId;
	}

	public Long getTransferPrice() {
		return transferPrice;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Double getDistance() {
		return distance;
	}

}
