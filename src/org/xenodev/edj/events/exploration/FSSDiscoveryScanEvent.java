package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSSDiscoveryScanEvent extends Event {
	
	private String systemName;
	private Long systemAddress;
	private Double progress;
	private Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemName = json.pullString("systemName");
		this.systemAddress = json.pullLong("SystemAddress");
		this.progress = json.pullDouble("Progress");
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

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

}
