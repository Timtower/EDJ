package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class NavBeaconScanEvent extends Event {
	
	private Long systemAddress;
	private Integer numBodies;
	
	public NavBeaconScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemAddress = json.pullLong("SystemAddress");
		this.numBodies = json.pullInt("NumBodies");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getNumBodies() {
		return numBodies;
	}

}
