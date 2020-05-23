package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CollectCargoEvent extends Event {
	
	private String type;
	private Long missionID;
	private Boolean stolen;
	
	public CollectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = json.getString("Type");
		this.missionID = json.getLong("MissionID");
		this.stolen = json.getBoolean("Stolen");
	}

	public String getType() {
		return type;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getStolen() {
		return stolen;
	}

}
