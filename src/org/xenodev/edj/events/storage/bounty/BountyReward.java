package org.xenodev.edj.events.storage.bounty;

public class BountyReward {
	
	String faction;
	Long reward;
	
	public BountyReward(String faction, Long reward) {
		this.faction = faction;
		this.reward = reward;
	}

	public String getFaction() {
		return faction;
	}

	public Long getReward() {
		return reward;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public void setReward(Long reward) {
		this.reward = reward;
	}

}
