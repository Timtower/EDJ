/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:15
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class SetUserShipNameEvent extends Event {
	
	private String ship;
	private Integer shipId;
	private String userShipName, userShipId;
	
	public SetUserShipNameEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.ship = json.pullString("Ship");
		this.shipId = json.pullInt("ShipID");
		this.userShipName = json.pullString("UserShipName");
		this.userShipId = json.pullString("UserShipId");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public String getUserShipName() {
		return userShipName;
	}

	public String getUserShipId() {
		return userShipId;
	}

}
