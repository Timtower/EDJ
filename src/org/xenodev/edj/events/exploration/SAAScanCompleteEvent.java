package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class SAAScanCompleteEvent extends Event {
	
	private String bodyName;
	private Integer bodyID, probesUsed, efficiencyTarget;
	
	public SAAScanCompleteEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.bodyName = json.pullString("BodyName");
		this.bodyID = json.pullInt("BodyID");
		this.probesUsed = json.pullInt("ProbesUsed");
		this.efficiencyTarget = json.pullInt("EfficiencyTarget");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getBodyName() {
		return bodyName;
	}

	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

	public Integer getProbesUsed() {
		return probesUsed;
	}

	public void setProbesUsed(Integer probesUsed) {
		this.probesUsed = probesUsed;
	}

	public Integer getEfficiencyTarget() {
		return efficiencyTarget;
	}

	public void setEfficiencyTarget(Integer efficiencyTarget) {
		this.efficiencyTarget = efficiencyTarget;
	}

}
