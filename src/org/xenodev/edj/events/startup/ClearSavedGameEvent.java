package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ClearSavedGameEvent extends Event {
	
	private String name;
	private String FID;
	
	public ClearSavedGameEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.FID = json.pullString("FID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getFID() {
		return FID;
	}

}
