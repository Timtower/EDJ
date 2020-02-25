package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class CommunityGoalEvent extends Event {
	
	private Integer cgid, playerContribution, numContributors, topRankSize, playerPercentileBand, bonus;
	private String title, systemName, marketName, tierReached;
	private Long expiry;
	private Boolean isComplete, playerInTopRank;
	
	public CommunityGoalEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = JsonTranslator.getInteger(json, "CGID");
		this.playerContribution = JsonTranslator.getInteger(json, "PlayerContribution");
		this.numContributors = JsonTranslator.getInteger(json, "NumContributors");
		this.topRankSize = JsonTranslator.getInteger(json, "TopRankSize");
		this.playerPercentileBand = JsonTranslator.getInteger(json, "PlayerPercentileBand");
		this.bonus = JsonTranslator.getInteger(json, "Bonus");
		this.title = JsonTranslator.getString(json, "Title");
		this.systemName = JsonTranslator.getString(json, "SystemName");
		this.marketName = JsonTranslator.getString(json, "MarketName");
		this.tierReached = JsonTranslator.getString(json, "TierReached");
		this.expiry = JournalUtils.getTimeMillis(JsonTranslator.getString(json, "Expiry"));
		this.isComplete = JsonTranslator.getBoolean(json, "IsComplete");
		this.playerInTopRank = JsonTranslator.getBoolean(json, "PlayerInTopRank");
	}

	public Integer getCGID() {
		return cgid;
	}

	public Integer getPlayerContribution() {
		return playerContribution;
	}

	public Integer getNumContributors() {
		return numContributors;
	}

	public Integer getTopRankSize() {
		return topRankSize;
	}

	public Integer getPlayerPercentileBand() {
		return playerPercentileBand;
	}

	public Integer getBonus() {
		return bonus;
	}

	public String getTitle() {
		return title;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getMarketName() {
		return marketName;
	}

	public String getTierReached() {
		return tierReached;
	}

	public Long getExpiry() {
		return expiry;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public Boolean getPlayerInTopRank() {
		return playerInTopRank;
	}

}
