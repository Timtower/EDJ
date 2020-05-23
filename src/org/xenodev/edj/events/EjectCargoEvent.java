package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class EjectCargoEvent extends Event {
	
	private String type, powerplayOrigin;
	private Integer count;
	private Long missionID;
	private Boolean abondoned;
	
	public EjectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = json.getString("Type");
		this.powerplayOrigin = json.getString("PowerplayOrigin");
		this.count = json.getInt("Count");
		this.missionID = json.getLong("MissionID");
		this.abondoned = json.getBoolean("Abondoned");
	}

	public String getType() {
		return type;
	}

	public String getPowerplayOrigin() {
		return powerplayOrigin;
	}

	public Integer getCount() {
		return count;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getAbondoned() {
		return abondoned;
	}

}
