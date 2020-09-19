package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class FSSDiscoveryScanEvent extends Event {
	
	private String systemName;
	private Long systemAddress;
	private Double progress;
	private Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemName = json.pullString("SystemName");
		this.systemAddress = json.pullLong("SystemAddress");
		this.progress = json.pullDouble("Progress");
		this.bodyCount = json.pullInt("BodyCount");
		this.nonBodyCount = json.pullInt("NonBodyCount");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
	
	public String getSystemName() {
		return systemName;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
