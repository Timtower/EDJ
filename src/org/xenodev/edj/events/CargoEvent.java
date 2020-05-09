package org.xenodev.edj.events;

import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.CargoInventory;

public class CargoEvent extends Event {
	
	String timestamp;
	String vessel;
	List<CargoInventory> inventory;
	
	public CargoEvent(String timestamp, String vessel, List<CargoInventory> inventory) {
		super(timestamp);
		this.vessel = vessel;
		this.inventory = inventory;
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
