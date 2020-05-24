package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class CrewFireEvent extends Event {
	
	private String name;
	private Integer crewID;
	
	public CrewFireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = json.pullString("Name");
		this.crewID = json.pullInt("CrewID");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCrewID() {
		return crewID;
	}

	public void setCrewID(Integer crewID) {
		this.crewID = crewID;
	}

}
