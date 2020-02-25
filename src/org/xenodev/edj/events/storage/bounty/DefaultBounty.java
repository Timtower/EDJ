package org.xenodev.edj.events.storage.bounty;

import org.xenodev.edj.events.interfaces.BountyInfo;

public class DefaultBounty implements BountyInfo {
	
	String target, victimFaction;
	int totalReward;
	BountyReward[] rewards;
	
	public DefaultBounty(String target, String victimFaction, int totalReward, BountyReward[] rewards) {
		this.target = target;
		this.victimFaction = victimFaction;
		this.totalReward = totalReward;
		this.rewards = rewards;
	}

	public String getTarget() {
		return target;
	}

	public String getVictimFaction() {
		return victimFaction;
	}

	public int getTotalReward() {
		return totalReward;
	}

	public BountyReward[] getRewards() {
		return rewards;
	}

}
