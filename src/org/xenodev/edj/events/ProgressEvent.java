package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class ProgressEvent extends Event {
	
	int combat, trade, explore, empire, federation, cqc;

	public ProgressEvent(String timestamp, int combat, int trade, int explore, int empire, int federation, int cqc) {
		super(timestamp);
		this.combat = combat;
		this.trade = trade;
		this.explore = explore;
		this.empire = empire;
		this.federation = federation;
		this.cqc = cqc;
	}

	public int getCombatRankProgress() {
		return combat;
	}

	public void setCombatRankProgress(int combat) {
		this.combat = combat;
	}

	public int getTradeRankProgress() {
		return trade;
	}

	public void setTradeRankProgress(int trade) {
		this.trade = trade;
	}

	public int getExploreRankProgress() {
		return explore;
	}

	public void setExploreRankProgress(int explore) {
		this.explore = explore;
	}

	public int getEmpireRankProgress() {
		return empire;
	}

	public void setEmpireRankProgress(int empire) {
		this.empire = empire;
	}

	public int getFederationRankProgress() {
		return federation;
	}

	public void setFederationRankProgress(int federation) {
		this.federation = federation;
	}

	public int getCqcRankProgress() {
		return cqc;
	}

	public void setCqcRankProgress(int cqc) {
		this.cqc = cqc;
	}
	
	
	
}
