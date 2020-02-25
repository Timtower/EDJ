package org.xenodev.edj.events.storage.scan;

public class Parent {
	
	String bodyType;
	int bodyID;
	
	public Parent(String bodyType, int bodyID) {
		this.bodyType = bodyType;
		this.bodyID = bodyID;
	}
	
	public String getBodyType() {
		return bodyType;
	}
	
	public int getBodyID() {
		return bodyID;
	}

}
