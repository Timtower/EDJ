package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FSSAllBodiesFoundEvent extends Event {
	
	private String systemName;
	private Long systemAddress;
	private Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.systemName = json.pullString("SystemName");
		this.systemAddress = json.pullLong("SystemAddress");
		this.count = json.pullInt("Count");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSystemName() {
		return systemName;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getCount() {
		return count;
	}

}
