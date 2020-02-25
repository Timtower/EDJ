package org.xenodev.edj.events.storage.scan;

public class Ring {
	
	String name, ringClass;
    long massMT, innerRad, outerRad;
    
	public Ring(String name, String ringClass, long massMT, long innerRad, long outerRad) {
		this.name = name;
		this.ringClass = ringClass;
		this.massMT = massMT;
		this.innerRad = innerRad;
		this.outerRad = outerRad;
	}

	public String getName() {
		return name;
	}

	public String getRingClass() {
		return ringClass;
	}

	public long getMassMT() {
		return massMT;
	}

	public long getInnerRad() {
		return innerRad;
	}

	public long getOuterRad() {
		return outerRad;
	}

}
