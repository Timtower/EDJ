package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class CrewFireEvent extends Event {
	
	private String name;
	private Integer crewID;
	
	public CrewFireEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = JsonTranslator.getString(json, "Name");
		this.crewID = JsonTranslator.getInteger(json, "CrewID");
	}

	public String getName() {
		return name;
	}

	public Integer getCrewID() {
		return crewID;
	}

}
