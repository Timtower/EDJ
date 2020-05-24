package org.xenodev.edj.events.storage;

public class PassengerManifest {
	
	String type;
	Integer count;
	Boolean vip, wanted;
	Long missionID;
	
	public PassengerManifest(String type, Integer count, Boolean vip, Boolean wanted, Long missionID) {
		this.type = type;
		this.count = count;
		this.vip = vip;
		this.wanted = wanted;
		this.missionID = missionID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public Boolean getWanted() {
		return wanted;
	}

	public void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	public Long getMissionID() {
		return missionID;
	}

	public void setMissionID(Long missionID) {
		this.missionID = missionID;
	}

}
