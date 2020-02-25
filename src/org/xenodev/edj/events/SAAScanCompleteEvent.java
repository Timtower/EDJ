package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class SAAScanCompleteEvent extends Event {
	
	private String bodyName;
	private Integer bodyID, probesUsed, efficiencyTarget;
	
	public SAAScanCompleteEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.bodyName = JsonTranslator.getString(json, "BodyName");
		this.bodyID = JsonTranslator.getInteger(json, "BodyID");
		this.probesUsed = JsonTranslator.getInteger(json, "ProbesUsed");
		this.efficiencyTarget = JsonTranslator.getInteger(json, "EfficiencyTarget");
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
