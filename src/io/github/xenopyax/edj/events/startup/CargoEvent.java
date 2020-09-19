package io.github.xenopyax.edj.events.startup;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.CargoInventory;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CargoEvent extends Event {

	private String vessel;
	private Integer count;
	private List<CargoInventory> inventory;
	
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

	public List<CargoInventory> getInventory() {
		return inventory;
	}
	
	public Integer getCount() {
		return count;
	}

}
