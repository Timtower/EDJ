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

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public Integer getNumBodies() {
		return numBodies;
	}

	public void setNumBodies(Integer numBodies) {
		this.numBodies = numBodies;
	}

}
