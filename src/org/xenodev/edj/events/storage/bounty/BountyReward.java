package org.xenodev.edj.events.storage.bounty;

public class BountyReward {
	
	String faction;
	int reward;
	
	public BountyReward(String faction, int reward) {
		this.faction = faction;
		this.reward = reward;
	}

	public String getFaction() {
		return faction;
	}

	public int getReward() {
		return reward;
	}

}
