package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class InterdictionByNpcEvent extends Event {
	
	boolean success, isPlayer;
	String interdictor, faction, power;
	
	public InterdictionByNpcEvent(String timestamp, boolean success, boolean isPlayer, String interdictor, String faction, String power) {
		super(timestamp);
		this.success = success;
		this.isPlayer = isPlayer;
		this.interdictor = interdictor;
		this.faction = faction;
		this.power = power;
	}

	public boolean isSuccessful() {
		return success;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public String getInterdictor() {
		return interdictor;
	}

	public String getFaction() {
		return faction;
	}

	public String getPower() {
		return power;
	}

}
