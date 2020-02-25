package org.xenodev.edj.events.storage.material;

public class Encoded {
	
	String name;
	String name_localised;
	int count;
	
	public Encoded(String name, String name_localised, int count) {
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
