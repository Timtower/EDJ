package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class HullDamageEvent extends Event {
	
	double health;
	boolean playerPilot, fighter;
	
	public HullDamageEvent(String timestamp, double health, boolean playerPilot, boolean fighter) {
		super(timestamp);
		this.health = health;
		this.playerPilot = playerPilot;
		this.fighter = fighter;
	}

	public HullDamageEvent(String timestamp, double health, boolean playerPilot) {
		super(timestamp);
		this.health = health;
		this.playerPilot = playerPilot;
		this.fighter = false;
	}

	public double getHealth() {
		return health;
	}

	public boolean isPlayerPilot() {
		return playerPilot;
	}

	public boolean isFighter() {
		return fighter;
	}
	
	
}
