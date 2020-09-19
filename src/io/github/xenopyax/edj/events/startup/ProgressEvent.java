package io.github.xenopyax.edj.events.startup;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ProgressEvent extends Event {
	
	private Integer combat, trade, explore, empire, federation, cqc;

	public ProgressEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.combat = json.pullInt("Combat");
		this.trade = json.pullInt("Trade");
		this.explore = json.pullInt("Explore");
		this.empire = json.pullInt("Empire");
		this.federation = json.pullInt("Federation");
		this.cqc = json.pullInt("CQC");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCombatRankProgress() {
		return combat;
	}

	public Integer getTradeRankProgress() {
		return trade;
	}

	public Integer getExploreRankProgress() {
		return explore;
	}

	public Integer getEmpireRankProgress() {
		return empire;
	}

	public Integer getFederationRankProgress() {
		return federation;
	}

	public Integer getCQCRankProgress() {
		return cqc;
	}
	
}
