package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.PassengerManifest;

public class PassengersEvent extends Event {
	
	PassengerManifest[] passengers;

	public PassengersEvent(String timestamp, PassengerManifest[] passengers) {
		super(timestamp);
		this.passengers = passengers;
	}

	public PassengerManifest[] getPassengers() {
		return passengers;
	}

}
