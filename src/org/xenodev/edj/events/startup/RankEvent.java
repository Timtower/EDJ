package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.localiser.CQCRank;
import org.xenodev.edj.utils.localiser.CombatRank;
import org.xenodev.edj.utils.localiser.EmpireRank;
import org.xenodev.edj.utils.localiser.ExplorationRank;
import org.xenodev.edj.utils.localiser.FederationRank;
import org.xenodev.edj.utils.localiser.TradeRank;

public class RankEvent extends Event {
	
	Integer combat, trade, explore, empire, federation, cqc;

	public RankEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.combat = json.pullInt("Combat");
		this.trade =  json.pullInt("Trade");
		this.explore = json.pullInt("Explore");
		this.empire = json.pullInt("Empire");
		this.federation = json.pullInt("Federation");
		this.cqc = json.pullInt("CQC");
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	/**
	 * Gets the Combat rank as an Integereger between 0 - 8.
	 * 
	 * @return Integer Combat Rank as Integereger.
	 */
	public Integer getCombatRank() {
		return combat;
	}
	
	/**
	 * Gets Combat Rank as name.
	 * 
	 * @return String Combat Rank name.
	 */
	public String getCombatRankName() {
		return CombatRank.getLocalisedName(combat);
	}

	/**
	 * Gets Trade Rank as an Integereger between 0 - 8.
	 * 
	 * @return Integer Trade Rank as Integereger.
	 */
	public Integer getTradeRank() {
		return trade;
	}
	
	/**
	 * Gets Trade Rank as name.
	 * 
	 * @return String Trade Rank name.
	 */
	public String getTradeRankkName() {
		return TradeRank.getLocalisedName(trade);
	}

	/**
	 * Gets the Explore rank as an Integereger between 0 - 8.
	 * 
	 * @return Integer Explore Rank as Integereger.
	 */
	public Integer getExploreRank() {
		return explore;
	}
	
	/**
	 * Gets Explore Rank name.
	 * 
	 * @return String Explore Rank name.
	 */
	public String getExplorerRankkName() {
		return ExplorationRank.getLocalisedName(explore);
	}

	/**
	 * Gets the Explore rank as an Integereger between 0 - 14.
	 * 
	 * @return Integer Empire Rank as Integereger.
	 */
	public Integer getEmpireRank() {
		return empire;
	}
	
	/**
	 * Gets Empire Rank name.
	 * 
	 * @return String Empire Rank name.
	 */
	public String getEmpireRankkName() {
		return EmpireRank.getLocalisedName(empire);
	}

	/**
	 * @return
	 */
	public Integer getFederationRank() {
		return federation;
	}
	
	/**
	 * @return
	 */
	public String getFederationRankkName() {
		return FederationRank.getLocalisedName(federation);
	}

	/**
	 * @return
	 */
	public Integer getCqcRank() {
		return cqc;
	}
	
	/**
	 * @return
	 */
	public String getCQCRankkName() {
		return CQCRank.getLocalisedName(cqc);
	}

	public void setCombat(Integer combat) {
		this.combat = combat;
	}

	public void setTrade(Integer trade) {
		this.trade = trade;
	}

	public void setExplore(Integer explore) {
		this.explore = explore;
	}

	public void setEmpire(Integer empire) {
		this.empire = empire;
	}

	public void setFederation(Integer federation) {
		this.federation = federation;
	}

	public void setCqc(Integer cqc) {
		this.cqc = cqc;
	}
	
	
	
}
