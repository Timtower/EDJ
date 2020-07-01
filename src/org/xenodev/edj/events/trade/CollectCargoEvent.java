package org.xenodev.edj.events.trade;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CollectCargoEvent extends Event {
	
	private String type;
	private Long missionID;
	private Boolean stolen;
	
	public CollectCargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.missionID = json.pullLong("MissionID");
		this.stolen = json.pullBoolean("Stolen");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getStolen() {
		return stolen;
	}

}
