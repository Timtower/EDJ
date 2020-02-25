package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class ShieldStateEvent extends Event {
	
	boolean shieldsUp;

	public ShieldStateEvent(String timestamp, boolean shieldsUp) {
		super(timestamp);
		this.shieldsUp = shieldsUp;
	}

	public boolean isShieldsUp() {
		return shieldsUp;
	}

}
