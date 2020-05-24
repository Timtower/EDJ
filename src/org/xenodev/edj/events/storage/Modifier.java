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

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(Double originalValue) {
		this.originalValue = originalValue;
	}

	public Integer getLessIsGood() {
		return lessIsGood;
	}

	public void setLessIsGood(Integer lessIsGood) {
		this.lessIsGood = lessIsGood;
	}
	
}
