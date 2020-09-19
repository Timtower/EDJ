package io.github.xenopyax.edj.events.combat;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.bounty.BountyReward;
import io.github.xenopyax.edj.events.datastorage.bounty.DefaultBounty;
import io.github.xenopyax.edj.events.datastorage.bounty.SkimmerBounty;
import io.github.xenopyax.edj.events.interfaces.BountyInfo;
import io.github.xenopyax.edj.utils.JournalUtils;

public class BountyEvent extends Event {
	
	private String faction, target, victimsFaction;
	private Long reward, totalReward;
	private List<BountyReward> rewards;
	
	public BountyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.faction = json.pullString("Faction");
		this.target = json.pullString("Target");
		this.victimsFaction = json.pullString("VictimsFaction");
		this.reward = json.pullLong("Reward");
		this.totalReward = json.has("TotalReward") ? json.pullLong("TotalReward") : null;
		this.rewards = json.has("Rewards") ? JournalUtils.createBountyRewardList(json.pullJSONArray("Rewards")) : null;
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public BountyInfo getBountyInfo() {
		if(target.equals("Skimmer")) {
			return new SkimmerBounty(faction, target, victimsFaction, reward);
		}else {
			return new DefaultBounty(target, victimsFaction, totalReward, rewards);
		}
	}

}
