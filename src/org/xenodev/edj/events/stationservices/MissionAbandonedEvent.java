/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 12:15
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MissionAbandonedEvent extends Event {
	
	private String name;
	private Long missionId;
	
	public MissionAbandonedEvent(String timestamp,JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.missionId = json.pullLong("MissionID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public Long getMissionId() {
		return missionId;
	}

}
