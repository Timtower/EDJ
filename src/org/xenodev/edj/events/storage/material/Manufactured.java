package org.xenodev.edj.events.storage.material;

public class Manufactured {
	
	String name;
	String name_localised;
	Integer count;
	
	public Manufactured(String name, String name_localised, Integer count) {
		this.name = name;
		this.name_localised = name_localised;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_localised() {
		return name_localised;
	}

	public void setName_localised(String name_localised) {
		this.name_localised = name_localised;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
