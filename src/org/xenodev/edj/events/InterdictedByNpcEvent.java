package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class InterdictedByNpcEvent extends Event {
	
	boolean submitted, isPlayer;
	String interdictor, faction, power;
	
	public InterdictedByNpcEvent(String timestamp, boolean submitted, boolean isPlayer, String interdictor, String faction, String power) {
		super(timestamp);
		this.submitted = submitted;
		this.isPlayer = isPlayer;
		this.interdictor = interdictor;
		this.faction = faction;
		this.power = power;
	}

	public boolean isSubmitted() {
		return submitted;
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
