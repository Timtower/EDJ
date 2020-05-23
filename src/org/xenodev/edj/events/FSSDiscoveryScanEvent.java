package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class FSSDiscoveryScanEvent extends Event {
	
	Double progress;
	Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.progress = json.getDouble("Progress");
		this.bodyCount = json.getInt("BodyCount");
		this.nonBodyCount = json.getInt("NonBodyCount");
	}

	public Double getProgress() {
		return progress;
	}

	public Integer getBodyCount() {
		return bodyCount;
	}

	public Integer getNonBodyCount() {
		return nonBodyCount;
	}

}
