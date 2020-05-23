package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CommanderEvent extends Event {
	
	String name;
	String FID;
	
	public CommanderEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.getString("Name");
		this.FID = json.getString("FID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

}
