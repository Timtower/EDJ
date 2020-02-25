package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Killer;

public class DiedByWingEvent extends Event {

	Killer[] killers;

	public DiedByWingEvent(String timestamp, Killer[] killers) {
		super(timestamp);
		this.killers = killers;
	}

	public Killer[] getKillers() {
		return killers;
	}
	
}
