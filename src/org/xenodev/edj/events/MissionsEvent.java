package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Mission;

public class MissionsEvent extends Event {
	
	Mission[] active;
	Mission[] failed;
	Mission[] complete;
	
	public MissionsEvent(String timestamp, Mission[] active, Mission[] failed, Mission[] complete) {
		super(timestamp);
		this.active = active;
		this.failed = failed;
		this.complete = complete;
	}

	public Mission[] getActive() {
		return active;
	}

	public void setActive(Mission[] active) {
		this.active = active;
	}

	public Mission[] getFailed() {
		return failed;
	}

	public void setFailed(Mission[] failed) {
		this.failed = failed;
	}

	public Mission[] getComplete() {
		return complete;
	}

	public void setComplete(Mission[] complete) {
		this.complete = complete;
	}

}
