package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LiftoffEvent extends Event {
	
	private Boolean playerControlled;
	private Double longitude, latitude;
	
	public LiftoffEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.playerControlled = json.pullBoolean("PlayerControlled");
		this.longitude = playerControlled ? json.getDouble("Longitude") : null;
		this.latitude = playerControlled ? json.getDouble("Latitude") : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean getPlayerControlled() {
		return playerControlled;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}
	
}
