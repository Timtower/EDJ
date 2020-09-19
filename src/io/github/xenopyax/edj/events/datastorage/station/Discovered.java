package io.github.xenopyax.edj.events.datastorage.station;

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
