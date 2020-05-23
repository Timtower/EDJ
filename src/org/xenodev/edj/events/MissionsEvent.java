package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Mission;
import org.xenodev.edj.utils.JournalUtils;

public class MissionsEvent extends Event {
	
	Mission[] active;
	Mission[] failed;
	Mission[] complete;
	
	public MissionsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.active = JournalUtils.createMissionList(json.getJSONArray("Active"));
		this.failed = JournalUtils.createMissionList(json.getJSONArray("Failed"));
		this.complete = JournalUtils.createMissionList(json.getJSONArray("Complete"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Mission[] getActive() {
		return active;
	}

	public void setActive(Mission[] active) {
		this.active = active;
	}

	public Mission[] getFailed() {
		return failed;
	}

	public void setFailed(Mission[] failed) {
		this.failed = failed;
	}

	public Mission[] getComplete() {
		return complete;
	}

	public void setComplete(Mission[] complete) {
		this.complete = complete;
	}

}
