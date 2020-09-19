package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MaterialCollectedEvent extends Event {
	
	private String category, name, nameLocalised;
	private Integer count;
	
	public MaterialCollectedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.category = json.pullString("Category");
		this.name = json.pullString("Name");
		this.nameLocalised = json.pullString("Name_Localised");
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

	public String getNameLocalised() {
		return nameLocalised;
	}
	
}
