package org.xenodev.edj.events.storage.scan;

public class Ring {
	
	String name, ringClass;
	Long massMT, innerRad, outerRad;
    
	public Ring(String name, String ringClass, Long massMT, Long innerRad, Long outerRad) {
		this.name = name;
		this.ringClass = ringClass;
		this.massMT = massMT;
		this.innerRad = innerRad;
		this.outerRad = outerRad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRingClass() {
		return ringClass;
	}

	public void setRingClass(String ringClass) {
		this.ringClass = ringClass;
	}

	public Long getMassMT() {
		return massMT;
	}

	public void setMassMT(Long massMT) {
		this.massMT = massMT;
	}

	public Long getInnerRad() {
		return innerRad;
	}

	public void setInnerRad(Long innerRad) {
		this.innerRad = innerRad;
	}

	public Long getOuterRad() {
		return outerRad;
	}

	public void setOuterRad(Long outerRad) {
		this.outerRad = outerRad;
	}

}
