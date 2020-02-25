package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class NavBeaconScanEvent extends Event {
	
	private Long systemAddress;
	private Integer numBodies;
	
	public NavBeaconScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.systemAddress = JsonTranslator.getLong(json, "SystemAddress");
		this.numBodies = JsonTranslator.getInteger(json, "NumBodies");
	}
	
	public Long getSystemAddress() {
		return systemAddress;
	}
	
	public Integer getNumBodies() {
		return numBodies;
	}

}
