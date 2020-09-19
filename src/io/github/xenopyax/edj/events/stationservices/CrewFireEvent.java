package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;

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

	public Integer getCrewID() {
		return crewID;
	}

}
