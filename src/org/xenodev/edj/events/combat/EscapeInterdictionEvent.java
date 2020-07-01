package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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
