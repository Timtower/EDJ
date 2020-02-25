package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CrewAssignEvent extends Event {
	
	private String name, role;
	private Integer crewID;
	
	public CrewAssignEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = JsonTranslator.getString(json, "Name");
		this.role = JsonTranslator.getString(json, "Role");
		this.crewID = JsonTranslator.getInteger(json, "CrewID");
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public Integer getCrewID() {
		return crewID;
	}

}
