/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:47
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ShipyardNewEvent extends Event {
	
	private String shipType;
	private Integer newShipId;
	
	public ShipyardNewEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.newShipId = json.pullInt("NewShipID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShipType() {
		return shipType;
	}

	public Integer getNewShipId() {
		return newShipId;
	}

}
