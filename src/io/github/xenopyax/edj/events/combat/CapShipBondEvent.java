package io.github.xenopyax.edj.events.combat;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class CapShipBondEvent extends Event {
	
	private String victimFaction, awardingFaction;
	private Integer reward;
	
	public CapShipBondEvent(String timestamp, JSONObject json) {
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

	public Integer getReward() {
		return reward;
	}

}
