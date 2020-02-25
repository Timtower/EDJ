package org.xenodev.edj.events.storage;

public class CargoInventory {
	
	String name;
	int count;
	int stolen;
	int missionId;
	
	public CargoInventory(String name, int count, int stolen, int missionId) {
		this.name = name;
		this.count = count;
		this.stolen = stolen;
		this.missionId = missionId;
		
	}
	
	public CargoInventory(String name, int count, int stolen) {
		this.name = name;
		this.count = count;
		this.stolen = stolen;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStolen() {
		return stolen;
	}

	public void setStolen(int stolen) {
		this.stolen = stolen;
	}

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

}
