package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class UnderAttackEvent extends Event {
	
	String target;

	public UnderAttackEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.target = json.pullString("Target");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
