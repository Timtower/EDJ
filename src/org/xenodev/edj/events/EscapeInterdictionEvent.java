package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class EscapeInterdictionEvent extends Event {
	
	String interdictor;
	Boolean isPlayer;
	
	public EscapeInterdictionEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.interdictor = json.pullString("Interdictor");
		this.isPlayer = json.pullBoolean("IsPlayer");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getInterdictor() {
		return interdictor;
	}

	public void setInterdictor(String interdictor) {
		this.interdictor = interdictor;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

	public void setIsPlayer(Boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

}
