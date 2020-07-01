package org.xenodev.edj.events.storage.bounty;

public class BountyReward {
	
	private String faction;
	private Long reward;
	
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

}
