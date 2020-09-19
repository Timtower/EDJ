package io.github.xenopyax.edj.events.startup;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
