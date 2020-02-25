package org.xenodev.edj.events.storage;

public class Mission {
	
	int missionID, expires;
	String name;
	boolean passengerMission;
	
	public Mission(int missionID, String name, boolean passengerMission, int expires) {
		this.missionID = missionID;
		this.expires = expires;
		this.name = name;
		this.passengerMission = passengerMission;
	}

	public int getMissionID() {
		return missionID;
	}

	public void setMissionID(int missionID) {
		this.missionID = missionID;
	}

	public int getExpires() {
		return expires;
	}

	public void setExpires(int expires) {
		this.expires = expires;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPassengerMission() {
		return passengerMission;
	}

	public void setPassengerMission(boolean passengerMission) {
		this.passengerMission = passengerMission;
	}

}
