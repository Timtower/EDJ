package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
