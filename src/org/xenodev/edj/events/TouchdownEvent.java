package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class TouchdownEvent extends Event {
	
	boolean playerControlled;
	double latitude, longitude;
	
	public TouchdownEvent(String timestamp, boolean playerControlled, double latitude, double longitude) {
		super(timestamp);
		this.playerControlled = playerControlled;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public TouchdownEvent(String timestamp, boolean playerControlled) {
		super(timestamp);
		this.playerControlled = playerControlled;
	}

	public boolean isPlayerControlled() {
		return playerControlled;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
