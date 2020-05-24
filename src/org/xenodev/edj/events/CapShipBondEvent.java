package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CapShipBondEvent extends Event {
	
	String victimFaction, awardingFaction;
	Integer reward;
	
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

	public void setVictimFaction(String victimFaction) {
		this.victimFaction = victimFaction;
	}

	public String getAwardingFaction() {
		return awardingFaction;
	}

	public void setAwardingFaction(String awardingFaction) {
		this.awardingFaction = awardingFaction;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

}
