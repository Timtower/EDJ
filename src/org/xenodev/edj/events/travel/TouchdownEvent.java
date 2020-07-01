package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class TouchdownEvent extends Event {
	
	private Boolean playerControlled;
	private Double latitude, longitude;
	
	public TouchdownEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.playerControlled = json.pullBoolean("PlayerControlled");
		this.latitude = playerControlled ?  json.getDouble("Latitude") : null;
		this.longitude = playerControlled ?  json.getDouble("Longitude") : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Boolean getPlayerControlled() {
		return playerControlled;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

}
