package org.xenodev.edj.events.storage.scan;

public class Material {
	
	String name;
	Double percent;
	
	public Material(String name, Double percent) {
		super();
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

}
