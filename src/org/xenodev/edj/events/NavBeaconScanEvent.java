package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class NavBeaconScanEvent extends Event {
	
	private Long systemAddress;
	private Integer numBodies;
	
	public NavBeaconScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemAddress = json.getLong("SystemAddress");
		this.numBodies = json.getInt("NumBodies");
	}
	
	public Long getSystemAddress() {
		return systemAddress;
	}
	
	public Integer getNumBodies() {
		return numBodies;
	}

}
