package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class MaterialDiscardedEvent extends Event {
	
	private String category, name;
	private Integer count;
	
	public MaterialDiscardedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.category = json.getString("Category");
		this.name = json.getString("Name");;
		this.count = json.getInt("Count");
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
