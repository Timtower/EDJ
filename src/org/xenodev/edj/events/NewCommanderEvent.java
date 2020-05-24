package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class NewCommanderEvent extends Event {
	
	String name, FID, starterPackage;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

	public String getStarterPackage() {
		return starterPackage;
	}

	public void setStarterPackage(String starterPackage) {
		this.starterPackage = starterPackage;
	}	

}
