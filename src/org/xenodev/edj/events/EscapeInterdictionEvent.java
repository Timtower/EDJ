package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class EscapeInterdictionEvent extends Event {
	
	String interdictor;
	boolean isPlayer;
	
	public EscapeInterdictionEvent(String timestamp, String interdictor, boolean isPlayer) {
		super(timestamp);
		this.interdictor = interdictor;
		this.isPlayer = isPlayer;
	}

	public String getInterdictor() {
		return interdictor;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

}
