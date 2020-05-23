package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.PassengerManifest;
import org.xenodev.edj.utils.JournalUtils;

public class PassengersEvent extends Event {
	
	PassengerManifest[] passengers;

	public PassengersEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.passengers = JournalUtils.createPassengerManifest(json.getJSONArray("Manifest"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public PassengerManifest[] getPassengers() {
		return passengers;
	}

	public void setPassengers(PassengerManifest[] passengers) {
		this.passengers = passengers;
	}

}
