package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class SAAScanCompleteEvent extends Event {
	
	private String bodyName;
	private Integer bodyID, probesUsed, efficiencyTarget;
	
	public SAAScanCompleteEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.bodyName = json.getString("BodyName");
		this.bodyID = json.getInt("BodyID");
		this.probesUsed = json.getInt("ProbesUsed");
		this.efficiencyTarget = json.getInt("EfficiencyTarget");
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

}
