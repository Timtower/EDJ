package org.xenodev.edj.events.storage;

public class StationEconomy {
	
	String name, nameLocalised;
	double proportion;
	
	public StationEconomy(String name, String nameLocalised, double proportion) {
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.proportion = proportion;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public double getProportion() {
		return proportion;
	}

}
