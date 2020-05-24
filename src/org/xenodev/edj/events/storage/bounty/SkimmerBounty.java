package org.xenodev.edj.events.storage.bounty;

import org.xenodev.edj.events.interfaces.BountyInfo;

public class SkimmerBounty implements BountyInfo {
	
	String faction, target, victimsFaction;
	Long reward;
	
	public SkimmerBounty(String faction, String target, String victimsFaction, Long reward) {
		this.faction = faction;
		this.target = target;
		this.victimsFaction = victimsFaction;
		this.reward = reward;
	}

	public String getFaction() {
		return faction;
	}

	public String getTarget() {
		return target;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setVictimsFaction(String victimsFaction) {
		this.victimsFaction = victimsFaction;
	}

	public void setReward(Long reward) {
		this.reward = reward;
	}

	public String getVictimsFaction() {
		return victimsFaction;
	}

	public Long getReward() {
		return reward;
	}

}
