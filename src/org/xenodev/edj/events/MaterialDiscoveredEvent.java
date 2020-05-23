package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MaterialDiscoveredEvent extends Event {
	
	private String category, name;
	private Integer count;
	
	public MaterialDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.category = json.getString("Category");
		this.name = json.getString("Category");
		this.count = json.getInt("Category");
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
