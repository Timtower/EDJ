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

	public Integer getCGID() {
		return cgid;
	}

	public void setCGID(Integer cgid) {
		this.cgid = cgid;
	}

	public Integer getPlayerContribution() {
		return playerContribution;
	}

	public void setPlayerContribution(Integer playerContribution) {
		this.playerContribution = playerContribution;
	}

	public Integer getNumContributors() {
		return numContributors;
	}

	public void setNumContributors(Integer numContributors) {
		this.numContributors = numContributors;
	}

	public Integer getTopRankSize() {
		return topRankSize;
	}

	public void setTopRankSize(Integer topRankSize) {
		this.topRankSize = topRankSize;
	}

	public Integer getPlayerPercentileBand() {
		return playerPercentileBand;
	}

	public void setPlayerPercentileBand(Integer playerPercentileBand) {
		this.playerPercentileBand = playerPercentileBand;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getTierReached() {
		return tierReached;
	}

	public void setTierReached(String tierReached) {
		this.tierReached = tierReached;
	}

	public Long getExpiry() {
		return expiry;
	}

	public void setExpiry(Long expiry) {
		this.expiry = expiry;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Boolean getPlayerInTopRank() {
		return playerInTopRank;
	}

	public void setPlayerInTopRank(Boolean playerInTopRank) {
		this.playerInTopRank = playerInTopRank;
	}

}
