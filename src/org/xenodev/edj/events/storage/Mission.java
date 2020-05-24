package org.xenodev.edj.events.storage;

public class Mission {
	
	Integer missionID, expires;
	String name;
	Boolean passengerMission;
	
	public Mission(Integer missionID, String name, Boolean passengerMission, Integer expires) {
		this.missionID = missionID;
		this.expires = expires;
		this.name = name;
		this.passengerMission = passengerMission;
	}

	public Integer getMissionID() {
		return missionID;
	}

	public void setMissionID(Integer missionID) {
		this.missionID = missionID;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPassengerMission() {
		return passengerMission;
	}

	public void setPassengerMission(Boolean passengerMission) {
		this.passengerMission = passengerMission;
	}

}
