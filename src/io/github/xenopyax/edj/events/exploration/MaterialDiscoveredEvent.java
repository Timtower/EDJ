package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MaterialDiscoveredEvent extends Event {
	
	private String category, name;
	private Integer count;
	
	public MaterialDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.category = json.pullString("Category");
		this.name = json.pullString("Category");
		this.count = json.pullInt("Category");
		
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
