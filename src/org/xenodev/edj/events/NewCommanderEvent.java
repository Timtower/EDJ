package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class NewCommanderEvent extends Event {
	
	String name, FID, starterPackage;

	public NewCommanderEvent(String timestamp, String name, String FID, String starterPackage) {
		super(timestamp);
		this.name = name;
		this.FID = FID;
		this.starterPackage = starterPackage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

	public String getStarterPackage() {
		return starterPackage;
	}

	public void setStarterPackage(String starterPackage) {
		this.starterPackage = starterPackage;
	}	

}
