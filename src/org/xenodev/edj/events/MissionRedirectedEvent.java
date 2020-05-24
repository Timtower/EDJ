/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:11
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MissionRedirectedEvent extends Event {
	
	String name, newDestinationStation, newDestinationSystem, oldDestinationStation, oldDestinationSystem;
	Long missionId;
	
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

	public void setName(String name) {
		this.name = name;
	}

	public String getNewDestinationStation() {
		return newDestinationStation;
	}

	public void setNewDestinationStation(String newDestinationStation) {
		this.newDestinationStation = newDestinationStation;
	}

	public String getNewDestinationSystem() {
		return newDestinationSystem;
	}

	public void setNewDestinationSystem(String newDestinationSystem) {
		this.newDestinationSystem = newDestinationSystem;
	}

	public String getOldDestinationStation() {
		return oldDestinationStation;
	}

	public void setOldDestinationStation(String oldDestinationStation) {
		this.oldDestinationStation = oldDestinationStation;
	}

	public String getOldDestinationSystem() {
		return oldDestinationSystem;
	}

	public void setOldDestinationSystem(String oldDestinationSystem) {
		this.oldDestinationSystem = oldDestinationSystem;
	}

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

}
