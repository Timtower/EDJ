package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class MaterialDiscoveredEvent extends Event {
	
	private String category, name;
	private Integer count;
	
	public MaterialDiscoveredEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.category = JsonTranslator.getString(json, "Category");
		this.name = JsonTranslator.getString(json, "Category");
		this.count = JsonTranslator.getInteger(json, "Category");
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
