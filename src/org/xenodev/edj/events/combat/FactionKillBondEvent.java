package org.xenodev.edj.events.combat;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class FactionKillBondEvent extends Event {
	
	private String victimFaction, awardingFaction;
	private  Integer reward;
	
	public FactionKillBondEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.victimFaction = json.pullString("VictimFaction");
		this.awardingFaction = json.pullString("AwardingFaction");
		this.reward = json.pullInt("Reward");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getVictimFaction() {
		return victimFaction;
	}

	public String getAwardingFaction() {
		return awardingFaction;
	}

	public int getReward() {
		return reward;
	}

}
