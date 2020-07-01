package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SAAScanCompleteEvent extends Event {
	
	private String bodyName;
	private Integer bodyID, probesUsed, efficiencyTarget;
	private Long systemAddress;
	
	public SAAScanCompleteEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.bodyName = json.pullString("BodyName");
		this.bodyID = json.pullInt("BodyID");
		this.probesUsed = json.pullInt("ProbesUsed");
		this.efficiencyTarget = json.pullInt("EfficiencyTarget");
		this.systemAddress = json.pullLong("SystemAddress");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getBodyName() {
		return bodyName;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Integer getProbesUsed() {
		return probesUsed;
	}

	public Integer getEfficiencyTarget() {
		return efficiencyTarget;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
