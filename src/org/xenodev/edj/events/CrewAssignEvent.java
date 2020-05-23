package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CrewAssignEvent extends Event {
	
	private String name, role;
	private Integer crewID;
	
	public CrewAssignEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = json.getString("Name");
		this.role = json.getString("Role");
		this.crewID = json.getInt("CrewID");
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
