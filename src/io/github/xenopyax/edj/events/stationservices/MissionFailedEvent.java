/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:08
*/

package io.github.xenopyax.edj.events.stationservices;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MissionFailedEvent extends Event {
	
	private String name;
	private Long missionId;
	
	public MissionFailedEvent(String timestamp, JSONObject json) {
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
