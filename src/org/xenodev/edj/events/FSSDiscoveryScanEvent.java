package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSSDiscoveryScanEvent extends Event {
	
	Double progress;
	Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.progress = json.getDouble("Progress");
		this.bodyCount = json.pullInt("BodyCount");
		this.nonBodyCount = json.pullInt("NonBodyCount");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	public Integer getBodyCount() {
		return bodyCount;
	}

	public void setBodyCount(Integer bodyCount) {
		this.bodyCount = bodyCount;
	}

	public Integer getNonBodyCount() {
		return nonBodyCount;
	}

	public void setNonBodyCount(Integer nonBodyCount) {
		this.nonBodyCount = nonBodyCount;
	}

}
