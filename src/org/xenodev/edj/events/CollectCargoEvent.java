package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CollectCargoEvent extends Event {
	
	private String type;
	private Long missionID;
	private Boolean stolen;
	
	public CollectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.missionID = json.pullLong("MissionID");
		this.stolen = json.pullBoolean("Stolen");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getMissionID() {
		return missionID;
	}

	public void setMissionID(Long missionID) {
		this.missionID = missionID;
	}

	public Boolean getStolen() {
		return stolen;
	}

	public void setStolen(Boolean stolen) {
		this.stolen = stolen;
	}

}
