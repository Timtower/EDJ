package org.xenodev.edj.events.travel;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class TouchdownEvent extends Event {
	
	Boolean playerControlled;
	Double latitude, longitude;
	
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

	public void setPlayerControlled(Boolean playerControlled) {
		this.playerControlled = playerControlled;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
