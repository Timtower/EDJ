package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CollectCargoEvent extends Event {
	
	private String type;
	private Long missionID;
	private Boolean stolen;
	
	public CollectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = JsonTranslator.getString(json, "Type");
		this.missionID = JsonTranslator.getLong(json, "MissionID");
		this.stolen = JsonTranslator.getBoolean(json, "Stolen");
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
