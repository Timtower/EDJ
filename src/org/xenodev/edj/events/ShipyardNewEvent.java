/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:47
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ShipyardNewEvent extends Event {
	
	String shipType;
	Integer newShipId;
	
	public ShipyardNewEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.shipType = json.getString("ShipType");
		this.newShipId = json.getInt("NewShipID");
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
