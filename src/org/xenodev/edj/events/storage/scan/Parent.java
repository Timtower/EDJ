package org.xenodev.edj.events.storage.scan;

public class Parent {
	
	String bodyType;
	Integer bodyID;
	
	public Parent(String bodyType, Integer bodyID) {
		this.bodyType = bodyType;
		this.bodyID = bodyID;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

}
