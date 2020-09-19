package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class HeatDamageEvent extends Event {

	public HeatDamageEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

}
