package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
