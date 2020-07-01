package org.xenodev.edj.events.storage.scan;

public class Material {
	
	private String name;
	private Double percent;
	
	public Material(String name, Double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public Double getPercent() {
		return percent;
	}

}
