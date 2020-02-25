package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class DiedEvent extends Event {
	
	String killerName, killerShip, killerRank;

	public DiedEvent(String timestamp, String killerName, String killerShip, String killerRank) {
		super(timestamp);
		this.killerName = killerName;
		this.killerShip = killerShip;
		this.killerRank = killerRank;
	}

	public String getKillerName() {
		return killerName;
	}

	public String getKillerShip() {
		return killerShip;
	}

	public String getKillerRank() {
		return killerRank;
	}

}
