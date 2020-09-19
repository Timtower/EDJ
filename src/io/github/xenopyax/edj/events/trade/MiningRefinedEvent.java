package io.github.xenopyax.edj.events.trade;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MiningRefinedEvent extends Event {
	
	private String type, typeLocalised;

	public MiningRefinedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.type = json.pullString("Type");
		this.typeLocalised = json.pullString("Type_Localised");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

}
