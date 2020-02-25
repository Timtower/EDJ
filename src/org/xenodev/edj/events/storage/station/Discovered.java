package org.xenodev.edj.events.storage.station;

public class Discovered {
	
	private String systemName;
	private Integer numBodies;
	
	public Discovered(String systemName, Integer numBodies) {
		this.systemName = systemName;
		this.numBodies = numBodies;
	}

	public String getSystemName() {
		return systemName;
	}

	public Integer getNumBodies() {
		return numBodies;
	}	

}