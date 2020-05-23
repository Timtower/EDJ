package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class LiftoffEvent extends Event {
	
	Boolean playerControlled;
	Double longitude, latitude;
	
	public LiftoffEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.playerControlled = json.getBoolean("PlayerControlled");
		this.longitude = playerControlled ? json.getDouble("Longitude") : null;
		this.latitude = playerControlled ? json.getDouble("Latitude") : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean getPlayerControlled() {
		return playerControlled;
	}

	public void setPlayerControlled(Boolean playerControlled) {
		this.playerControlled = playerControlled;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
