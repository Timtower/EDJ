package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class ProgressEvent extends Event {
	
	Integer combat, trade, explore, empire, federation, cqc;

	public ProgressEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.combat = json.getInt("Combat");
		this.trade = json.getInt("Trade");
		this.explore = json.getInt("Explore");
		this.empire = json.getInt("Empire");
		this.federation = json.getInt("Federation");
		this.cqc = json.getInt("CQC");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCombatRankProgress() {
		return combat;
	}

	public void setCombatRankProgress(Integer combat) {
		this.combat = combat;
	}

	public Integer getTradeRankProgress() {
		return trade;
	}

	public void setTradeRankProgress(Integer trade) {
		this.trade = trade;
	}

	public Integer getExploreRankProgress() {
		return explore;
	}

	public void setExploreRankProgress(Integer explore) {
		this.explore = explore;
	}

	public Integer getEmpireRankProgress() {
		return empire;
	}

	public void setEmpireRankProgress(Integer empire) {
		this.empire = empire;
	}

	public Integer getFederationRankProgress() {
		return federation;
	}

	public void setFederationRankProgress(Integer federation) {
		this.federation = federation;
	}

	public Integer getCqcRankProgress() {
		return cqc;
	}

	public void setCqcRankProgress(Integer cqc) {
		this.cqc = cqc;
	}
	
	
	
}
