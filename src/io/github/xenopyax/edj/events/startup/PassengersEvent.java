package io.github.xenopyax.edj.events.startup;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.PassengerManifest;
import io.github.xenopyax.edj.utils.JournalUtils;

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
