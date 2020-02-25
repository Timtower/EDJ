package org.xenodev.edj.events.storage;

public class Modifier {
	
	String label;
	Double value, originalValue;
	Integer lessIsGood;
	
	public Modifier(String label, Double value, Double originalValue, Integer lessIsGood) {
		this.label = label;
		this.value = value;
		this.originalValue = originalValue;
		this.lessIsGood = lessIsGood;
	}

	public String getLabel() {
		return label;
	}

	public double getValue() {
		return value;
	}

	public double getOriginalValue() {
		return originalValue;
	}

	public int getLessIsGood() {
		return lessIsGood;
	}	
	
}
