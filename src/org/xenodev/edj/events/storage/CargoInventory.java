package org.xenodev.edj.events.storage;

public class CargoInventory {
	
	String name;
	Integer count, missionId, stolen;
	
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Integer getStolen() {
		return stolen;
	}

	public void setStolen(Integer stolen) {
		this.stolen = stolen;
	}

}
