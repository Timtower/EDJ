package org.xenodev.edj.events.storage.scan;

public class Material {
	
	String name;
	double percent;
	
	public Material(String name, double percent) {
		super();
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
