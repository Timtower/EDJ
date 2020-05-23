package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CrewFireEvent extends Event {
	
	private String name;
	private Integer crewID;
	
	public CrewFireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = json.getString("Name");
		this.crewID = json.getInt("CrewID");
	}

	public String getName() {
		return name;
	}

	public Integer getCrewID() {
		return crewID;
	}

}
