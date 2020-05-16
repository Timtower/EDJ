/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:15
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class SetUserShipNameEvent extends Event {
	
	String ship;
	Integer shipId;
	String userShipName, userShipId;
	
	public SetUserShipNameEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.ship = json.getString("Ship");
		this.shipId = json.getInt("ShipID");
		this.userShipName = json.getString("UserShipName");
		this.userShipId = json.getString("UserShipId");
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getUserShipName() {
		return userShipName;
	}

	public void setUserShipName(String userShipName) {
		this.userShipName = userShipName;
	}

	public String getUserShipId() {
		return userShipId;
	}

	public void setUserShipId(String userShipId) {
		this.userShipId = userShipId;
	}

}
