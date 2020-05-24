package org.xenodev.edj.events.storage;

public class StationEconomy {
	
	String name, nameLocalised;
	Double proportion;
	
	public StationEconomy(String name, String nameLocalised, Double proportion) {
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.proportion = proportion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public void setNameLocalised(String nameLocalised) {
		this.nameLocalised = nameLocalised;
	}

	public Double getProportion() {
		return proportion;
	}

	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}

}
