package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.interfaces.BountyInfo;
import org.xenodev.edj.events.storage.bounty.DefaultBounty;
import org.xenodev.edj.events.storage.bounty.SkimmerBounty;
import org.xenodev.edj.utils.JournalUtils;

public class BountyEvent extends Event {
	
	JSONObject json;
	
	public BountyEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.json = json;
	}

	public BountyInfo getBountyInfo() {
		if(json.pullString("Target").equals("Skimmer")) {
			return new SkimmerBounty(json.pullString("Faction"), json.pullString("Target"), json.pullString("VictimsFaction"), json.pullLong("Reward"));
		}else {
			return new DefaultBounty(json.pullString("Target"), json.pullString("VictimFaction"), json.pullLong("TotalReward"), JournalUtils.createBountyRewardList(json.getJSONArray("Rewards")));
		}
	}

}
