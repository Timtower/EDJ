package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class EscapeInterdictionEvent extends Event {
	
	private String interdictor;
	private Boolean isPlayer;
	
	public EscapeInterdictionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.interdictor = json.pullString("Interdictor");
		this.isPlayer = json.pullBoolean("IsPlayer");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getInterdictor() {
		return interdictor;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

}
