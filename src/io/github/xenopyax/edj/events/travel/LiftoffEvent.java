package io.github.xenopyax.edj.events.travel;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
