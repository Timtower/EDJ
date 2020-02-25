package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.CargoInventory;

public class CargoEvent extends Event {
	
	String timestamp;
	String vessel;
	CargoInventory[] inventory;
	
	public CargoEvent(String timestamp, String vessel, CargoInventory[] inventory) {
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

	public CargoInventory[] getInventory() {
		return inventory;
	}

	public void setInventory(CargoInventory[] inventory) {
		this.inventory = inventory;
	}

}
