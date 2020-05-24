package org.xenodev.edj.events.storage.scan;

public class AtmosphereComposition {
	
	String name;
	double percent;
	
	public AtmosphereComposition(String name, double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
}
