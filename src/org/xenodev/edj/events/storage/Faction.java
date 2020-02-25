package org.xenodev.edj.events.storage;

import java.util.List;

public class Faction {
	
	String name, factionState, goverment, allegiance, happiness;
	double myReputation, influence;
	List<String> activeStates, pendingStates, recoveringStates;
	boolean squadronSystem, happiestSystem, homeSystem;
	
	public Faction(String name, String factionState, String goverment, String allegiance, String happiness, double myReputation, double influence) {
		this.name = name;
		this.factionState = factionState;
		this.goverment = goverment;
		this.allegiance = allegiance;
		this.happiness = happiness;
		this.myReputation = myReputation;
		this.influence = influence;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFactionState() {
		return factionState;
	}
	
	public String getGoverment() {
		return goverment;
	}
	
	public String getAllegiance() {
		return allegiance;
	}
	
	public String getHappiness() {
		return happiness;
	}
	
	public double getMyReputation() {
		return myReputation;
	}
	
	public double getInfluence() {
		return influence;
	}
	
}
