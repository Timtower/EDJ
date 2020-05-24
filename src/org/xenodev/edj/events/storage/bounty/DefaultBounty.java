package org.xenodev.edj.events.storage.bounty;

import org.xenodev.edj.events.interfaces.BountyInfo;

public class DefaultBounty implements BountyInfo {
	
	String target, victimFaction;
	Long totalReward;
	BountyReward[] rewards;
	
	public DefaultBounty(String target, String victimFaction, Long totalReward, BountyReward[] rewards) {
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

	public void setTarget(String target) {
		this.target = target;
	}

	public void setVictimFaction(String victimFaction) {
		this.victimFaction = victimFaction;
	}

	public void setTotalReward(Long totalReward) {
		this.totalReward = totalReward;
	}

	public void setRewards(BountyReward[] rewards) {
		this.rewards = rewards;
	}

	public Long getTotalReward() {
		return totalReward;
	}

	public BountyReward[] getRewards() {
		return rewards;
	}

}
