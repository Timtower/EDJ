/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:47
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ShipyardNewEvent extends Event {
	
	String shipType;
	Integer newShipId;
	
	public ShipyardNewEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.shipType = json.pullString("ShipType");
		this.newShipId = json.pullInt("NewShipID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public Integer getNewShipId() {
		return newShipId;
	}

	public void setNewShipId(Integer newShipId) {
		this.newShipId = newShipId;
	}

}
