package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class UnderAttackEvent extends Event {
	
	String target;

	public UnderAttackEvent(String timestamp, String target) {
		super(timestamp);
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

}
