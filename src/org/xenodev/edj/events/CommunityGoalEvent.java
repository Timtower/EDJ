package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CommunityGoalEvent extends Event {
	
	private Integer cgid, playerContribution, numContributors, topRankSize, playerPercentileBand, bonus;
	private String title, systemName, marketName, tierReached;
	private Long expiry;
	private Boolean isComplete, playerInTopRank;
	
	public CommunityGoalEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.cgid = json.getInt("CGID");
		this.playerContribution = json.getInt("PlayerContribution");
		this.numContributors = json.getInt("NumContributors");
		this.topRankSize = json.getInt("TopRankSize");
		this.playerPercentileBand = json.getInt("PlayerPercentileBand");
		this.bonus = json.getInt("Bonus");
		this.title = json.getString("Title");
		this.systemName = json.getString("SystemName");
		this.marketName = json.getString("MarketName");
		this.tierReached = json.getString("TierReached");
		this.expiry = JournalUtils.getTimeMillis(json.getString("Expiry"));
		this.isComplete = json.getBoolean("IsComplete");
		this.playerInTopRank = json.getBoolean("PlayerInTopRank");
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
