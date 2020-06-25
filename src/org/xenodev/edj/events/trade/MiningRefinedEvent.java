package org.xenodev.edj.events.trade;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public void setTypeLocalised(String typeLocalised) {
		this.typeLocalised = typeLocalised;
	}

}
