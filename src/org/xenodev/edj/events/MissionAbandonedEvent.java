/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 12:15
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MissionAbandonedEvent extends Event {
	
	String name;
	Long missionId;
	
	public MissionAbandonedEvent(String timestamp,JSONObject json) {
		super(timestamp);
		this.name = json.getString("Name");
		this.missionId = json.getLong("MissionID");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

}
