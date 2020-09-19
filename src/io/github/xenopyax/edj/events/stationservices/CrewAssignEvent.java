package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
