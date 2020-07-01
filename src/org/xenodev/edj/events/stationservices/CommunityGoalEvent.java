package org.xenodev.edj.events.stationservices;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CommunityGoalEvent extends Event {
	
	private Integer cgid, playerContribution, numContributors, topRankSize, playerPercentileBand, bonus;
	private String title, systemName, marketName, tierReached;
	private Long expiry;
	private Boolean isComplete, playerInTopRank;
	
	public CommunityGoalEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.cgid = json.pullInt("CGID");
		this.playerContribution = json.pullInt("PlayerContribution");
		this.numContributors = json.pullInt("NumContributors");
		this.topRankSize = json.pullInt("TopRankSize");
		this.playerPercentileBand = json.pullInt("PlayerPercentileBand");
		this.bonus = json.pullInt("Bonus");
		this.title = json.pullString("Title");
		this.systemName = json.pullString("SystemName");
		this.marketName = json.pullString("MarketName");
		this.tierReached = json.pullString("TierReached");
		this.expiry = JournalUtils.getTimeMillis(json.pullString("Expiry"));
		this.isComplete = json.pullBoolean("IsComplete");
		this.playerInTopRank = json.pullBoolean("PlayerInTopRank");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Integer getCgid() {
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
