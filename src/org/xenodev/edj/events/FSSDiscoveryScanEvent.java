package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class FSSDiscoveryScanEvent extends Event {
	
	Double progress;
	Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.progress = JsonTranslator.getDouble(json, "Progress");
		this.bodyCount = JsonTranslator.getInteger(json, "BodyCount");
		this.nonBodyCount = JsonTranslator.getInteger(json, "NonBodyCount");
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
