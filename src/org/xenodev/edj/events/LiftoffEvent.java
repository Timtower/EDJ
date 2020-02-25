package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class LiftoffEvent extends Event {
	
	boolean playerControlled;
	double longitude, latitude;
	
	public LiftoffEvent(String timestamp, boolean playerControlled, double longitude, double latitude) {
		super(timestamp);
		this.playerControlled = playerControlled;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public LiftoffEvent(String timestamp, boolean playerControlled) {
		super(timestamp);
		this.playerControlled = playerControlled;
	}

	public boolean isPlayerControlled() {
		return playerControlled;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
