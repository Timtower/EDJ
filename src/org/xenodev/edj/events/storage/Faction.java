package org.xenodev.edj.events.storage;

public class Faction {
	
	String name, factionState, goverment, allegiance, happiness;
	Double myReputation, influence;
	FactionState activeStates, pendingStates, recoveringStates;
	Boolean squadronSystem, happiestSystem, homeSystem;
	
	public Faction(String name, String factionState, String goverment, String allegiance, String happiness,
			Double myReputation, Double influence, FactionState activeStates, FactionState pendingStates,
			FactionState recoveringStates, Boolean squadronSystem, Boolean happiestSystem, Boolean homeSystem) {
		this.name = name;
		this.factionState = factionState;
		this.goverment = goverment;
		this.allegiance = allegiance;
		this.happiness = happiness;
		this.myReputation = myReputation;
		this.influence = influence;
		this.activeStates = activeStates;
		this.pendingStates = pendingStates;
		this.recoveringStates = recoveringStates;
		this.squadronSystem = squadronSystem;
		this.happiestSystem = happiestSystem;
		this.homeSystem = homeSystem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactionState() {
		return factionState;
	}

	public void setFactionState(String factionState) {
		this.factionState = factionState;
	}

	public String getGoverment() {
		return goverment;
	}

	public void setGoverment(String goverment) {
		this.goverment = goverment;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public String getHappiness() {
		return happiness;
	}

	public void setHappiness(String happiness) {
		this.happiness = happiness;
	}

	public Double getMyReputation() {
		return myReputation;
	}

	public void setMyReputation(Double myReputation) {
		this.myReputation = myReputation;
	}

	public Double getInfluence() {
		return influence;
	}

	public void setInfluence(Double influence) {
		this.influence = influence;
	}

	public FactionState getActiveStates() {
		return activeStates;
	}

	public void setActiveStates(FactionState activeStates) {
		this.activeStates = activeStates;
	}

	public FactionState getPendingStates() {
		return pendingStates;
	}

	public void setPendingStates(FactionState pendingStates) {
		this.pendingStates = pendingStates;
	}

	public FactionState getRecoveringStates() {
		return recoveringStates;
	}

	public void setRecoveringStates(FactionState recoveringStates) {
		this.recoveringStates = recoveringStates;
	}

	public Boolean getSquadronSystem() {
		return squadronSystem;
	}

	public void setSquadronSystem(Boolean squadronSystem) {
		this.squadronSystem = squadronSystem;
	}

	public Boolean getHappiestSystem() {
		return happiestSystem;
	}

	public void setHappiestSystem(Boolean happiestSystem) {
		this.happiestSystem = happiestSystem;
	}

	public Boolean getHomeSystem() {
		return homeSystem;
	}

	public void setHomeSystem(Boolean homeSystem) {
		this.homeSystem = homeSystem;
	}

}
