package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class FactionKillBondEvent extends Event {
	
	String victimFaction, awardingFaction;
	int reward;
	
	public FactionKillBondEvent(String timestamp, String victimFaction, String awardingFaction, int reward) {
		super(timestamp);
		this.victimFaction = victimFaction;
		this.awardingFaction = awardingFaction;
		this.reward = reward;
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
