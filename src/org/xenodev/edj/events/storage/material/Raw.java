package org.xenodev.edj.events.storage.material;

public class Raw {
	
	String name;
	Integer count;
	
	public Raw(String name, Integer count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
