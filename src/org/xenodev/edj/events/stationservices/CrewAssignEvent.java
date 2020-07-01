package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CrewAssignEvent extends Event {
	
	private String name, role;
	private Integer crewID;
	
	public CrewAssignEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.role = json.pullString("Role");
		this.crewID = json.pullInt("CrewID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
