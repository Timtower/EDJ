package org.xenodev.edj.events.storage.scan;

public class Composition {
	
	String name;
	double percent;
	
	public Composition(String name, double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}
	
	public double getPercent() {
		return percent;
	}

}
