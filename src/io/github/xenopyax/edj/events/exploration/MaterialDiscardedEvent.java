package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

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
