package org.xenodev.edj.events.storage.bounty;

import org.xenodev.edj.events.interfaces.BountyInfo;

public class SkimmerBounty implements BountyInfo {
	
	String faction, target, victimsFaction;
	int reward;
	
	public SkimmerBounty(String faction, String target, String victimsFaction, int reward) {
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

	public String getVictimsFaction() {
		return victimsFaction;
	}

	public int getReward() {
		return reward;
	}

}
