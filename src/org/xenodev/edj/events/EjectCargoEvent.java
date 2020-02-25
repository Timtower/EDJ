package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class EjectCargoEvent extends Event {
	
	private String type, powerplayOrigin;
	private Integer count;
	private Long missionID;
	private Boolean abondoned;
	
	public EjectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.type = JsonTranslator.getString(json, "Type");
		this.powerplayOrigin = JsonTranslator.getString(json, "PowerplayOrigin");
		this.count = JsonTranslator.getInteger(json, "Count");
		this.missionID = JsonTranslator.getLong(json, "MissionID");
		this.abondoned = JsonTranslator.getBoolean(json, "Abondoned");
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
