package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
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

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
