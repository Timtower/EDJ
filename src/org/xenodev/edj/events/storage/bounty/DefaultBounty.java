package org.xenodev.edj.events.storage.bounty;

import java.util.List;

import org.xenodev.edj.events.interfaces.BountyInfo;

public class DefaultBounty implements BountyInfo {
	
	private String target, victimsFaction;
	private Long totalReward;
	private List<BountyReward> rewards;
	
	public DefaultBounty(String target, String victimsFaction, Long totalReward, List<BountyReward> rewards) {
		this.target = target;
		this.victimsFaction = victimsFaction;
		this.totalReward = totalReward;
		this.rewards = rewards;
	}

	public String getTarget() {
		return target;
	}

	public String getVictimsFaction() {
		return victimsFaction;
	}

	public Long getTotalReward() {
		return totalReward;
	}

	public List<BountyReward> getRewards() {
		return rewards;
	}

}
