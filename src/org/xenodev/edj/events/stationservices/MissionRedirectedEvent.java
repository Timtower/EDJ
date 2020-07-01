/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:11
*/

package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MissionRedirectedEvent extends Event {
	
	private String name, newDestinationStation, newDestinationSystem, oldDestinationStation, oldDestinationSystem;
	private Long missionId;
	
	public MissionRedirectedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.newDestinationStation = json.pullString("NewDestinationStation");
		this.newDestinationSystem = json.pullString("NewDestinationSystem");
		this.oldDestinationStation = json.pullString("OldDestinationStation");
		this.oldDestinationSystem = json.pullString("OldDestinationSystem");
		this.missionId = json.pullLong("MissionID");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public String getNewDestinationStation() {
		return newDestinationStation;
	}

	public String getNewDestinationSystem() {
		return newDestinationSystem;
	}

	public String getOldDestinationStation() {
		return oldDestinationStation;
	}

	public String getOldDestinationSystem() {
		return oldDestinationSystem;
	}

	public Long getMissionId() {
		return missionId;
	}

}
