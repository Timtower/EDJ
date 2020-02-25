package org.xenodev.edj.events.storage;

public class PassengerManifest {
	
	String type;
	int count;
	boolean vip, wanted;
	long missionID;
	
	public PassengerManifest(String type, int count, boolean vip, boolean wanted, long missionID) {
		this.type = type;
		this.count = count;
		this.vip = vip;
		this.wanted = wanted;
		this.missionID = missionID;
	}

	public String getType() {
		return type;
	}

	public int getCount() {
		return count;
	}

	public boolean isVip() {
		return vip;
	}

	public boolean isWanted() {
		return wanted;
	}

	public long getMissionID() {
		return missionID;
	}

}
