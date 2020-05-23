package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.CargoInventory;
import org.xenodev.edj.utils.JournalUtils;

public class CargoEvent extends Event {
	
	String vessel;
	List<CargoInventory> inventory;
	
	public CargoEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.vessel = json.getString("Vessel");
		this.inventory =  JournalUtils.createCargoInventory(json.getJSONArray("Inventory"));
		
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

}
