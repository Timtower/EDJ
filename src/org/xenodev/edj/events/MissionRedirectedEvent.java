/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:11
*/

package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MissionRedirectedEvent extends Event {
	
	String name, newDestinationStation, newDestinationSystem, oldDestinationStation, oldDestinationSystem;
	Long missionId;
	
	public MissionRedirectedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.name = json.getString("Name");
		this.newDestinationStation = json.getString("NewDestinationStation");
		this.newDestinationSystem = json.getString("NewDestinationSystem");
		this.oldDestinationStation = json.getString("OldDestinationStation");
		this.oldDestinationSystem = json.getString("OldDestinationSystem");
		this.missionId = json.getLong("MissionID");
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
