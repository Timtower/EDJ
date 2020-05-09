package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class StartJumpEvent extends Event {
	
	String jumpType, starSystem, starClass;
	Long systemAddress;
	
	public StartJumpEvent(String timestamp, String jumpType, String starSystem, String starClass, Long systemAddress) {
		super(timestamp);
		this.jumpType = jumpType;
		this.starSystem = starSystem;
		this.starClass = starClass;
		this.systemAddress = systemAddress;
	}
	
	public StartJumpEvent(String timestamp, String jumpType) {
		super(timestamp);
		this.jumpType = jumpType;
	}

	public String getJumpType() {
		return jumpType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getStarClass() {
		return starClass;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}
}
