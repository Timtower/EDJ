package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class NewCommanderEvent extends Event {
	
	private String name, FID, starterPackage;

	public NewCommanderEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.FID = json.pullString("FID");
		this.starterPackage = json.pullString("starterPackage");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getFID() {
		return FID;
	}

	public String getStarterPackage() {
		return starterPackage;
	}	

}
