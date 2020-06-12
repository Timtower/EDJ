package org.xenodev.edj.events.startup;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.CargoInventory;
import org.xenodev.edj.utils.JournalUtils;

public class CargoEvent extends Event {

	String vessel;
	Integer count;
	List<CargoInventory> inventory;
	
	public CargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.vessel = json.pullString("Vessel");
		this.count = json.pullInt("Count");
		this.inventory =  JournalUtils.createCargoInventory(json.pullJSONArray("Inventory"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	public List<CargoInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<CargoInventory> inventory) {
		this.inventory = inventory;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
