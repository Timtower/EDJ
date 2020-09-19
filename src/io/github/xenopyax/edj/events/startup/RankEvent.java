package io.github.xenopyax.edj.events.startup;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;
import io.github.xenopyax.edj.utils.localiser.CQCRank;
import io.github.xenopyax.edj.utils.localiser.CombatRank;
import io.github.xenopyax.edj.utils.localiser.EmpireRank;
import io.github.xenopyax.edj.utils.localiser.ExplorationRank;
import io.github.xenopyax.edj.utils.localiser.FederationRank;
import io.github.xenopyax.edj.utils.localiser.TradeRank;

public class RankEvent extends Event {
	
	private Integer combat, trade, explore, empire, federation, cqc;

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
	 * Gets the Combat rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Combat Rank as Integer.
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
	 * Gets Trade Rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Trade Rank as Integer.
	 */
	public Integer getTradeRank() {
		return trade;
	}
	
	/**
	 * Gets Trade Rank as name.
	 * 
	 * @return String Trade Rank name.
	 */
	public String getTradeRankName() {
		return TradeRank.getLocalisedName(trade);
	}

	/**
	 * Gets the Explore rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Explore Rank as Integer.
	 */
	public Integer getExploreRank() {
		return explore;
	}
	
	/**
	 * Gets Explore Rank name.
	 * 
	 * @return String Explore Rank name.
	 */
	public String getExplorerRankName() {
		return ExplorationRank.getLocalisedName(explore);
	}

	/**
	 * Gets the Empire rank as an Integer between 0 - 14.
	 * 
	 * @return Integer Empire Rank as Integer.
	 */
	public Integer getEmpireRank() {
		return empire;
	}
	
	/**
	 * Gets Empire Rank name.
	 * 
	 * @return String Empire Rank name.
	 */
	public String getEmpireRankName() {
		return EmpireRank.getLocalisedName(empire);
	}

	/**
	 * Gets the Federation rank as an Integer between 0 - 14.
	 * 
	 * @return Integer Federation Rank as Integer.
	 */
	public Integer getFederationRank() {
		return federation;
	}
	
	/**
	 * Gets Federation Rank name.
	 * 
	 * @return String Federation Rank name.
	 */
	public String getFederationRankName() {
		return FederationRank.getLocalisedName(federation);
	}

	/**
	 * Gets the CQC rank as an Integer between 0 - 14.
	 * 
	 * @return Integer CQC Rank as Integer.
	 */
	public Integer getCQCRank() {
		return cqc;
	}
	

	/**
	 * Gets CQC Rank name.
	 * 
	 * @return String CQC Rank name.
	 */
	public String getCQCRankName() {
		return CQCRank.getLocalisedName(cqc);
	}
	
}
