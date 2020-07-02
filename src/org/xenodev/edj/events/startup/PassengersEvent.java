package org.xenodev.edj.events.startup;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.PassengerManifest;
import org.xenodev.edj.utils.JournalUtils;

public class PassengersEvent extends Event {
	
	private List<PassengerManifest> passengers;

	public PassengersEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.passengers = JournalUtils.createPassengerManifest(json.pullJSONArray("Manifest"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public List<PassengerManifest> getPassengers() {
		return passengers;
	}

}
