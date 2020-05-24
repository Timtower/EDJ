package org.xenodev.edj.events.storage.engineer;

public class Ingredient {
	
	private String name;
	private Integer count;
	
	public Ingredient(String name, Integer count) {
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
