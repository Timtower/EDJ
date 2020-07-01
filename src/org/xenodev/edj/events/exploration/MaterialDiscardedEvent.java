package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class MaterialDiscardedEvent extends Event {
	
	private String category, name;
	private Integer count;
	
	public MaterialDiscardedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.category = json.pullString("Category");
		this.name = json.pullString("Name");
		this.count = json.pullInt("Count");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}

	public Integer getCount() {
		return count;
	}

}
