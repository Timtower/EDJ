package org.xenodev.edj.events.storage.scan;

public class Composition {
	
	private String name;
	private Double percent;
	
	public Composition(String name, Double percent) {
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
