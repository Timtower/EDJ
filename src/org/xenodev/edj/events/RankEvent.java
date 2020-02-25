package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.utils.localiser.CQCRank;
import org.xenodev.edj.utils.localiser.CombatRank;
import org.xenodev.edj.utils.localiser.EmpireRank;
import org.xenodev.edj.utils.localiser.ExplorationRank;
import org.xenodev.edj.utils.localiser.FederationRank;
import org.xenodev.edj.utils.localiser.TradeRank;

public class RankEvent extends Event {
	
	int combat, trade, explore, empire, federation, cqc;

	public RankEvent(String timestamp, int combat, int trade, int explore, int empire, int federation, int cqc) {
		super(timestamp);
		this.combat = combat;
		this.trade = trade;
		this.explore = explore;
		this.empire = empire;
		this.federation = federation;
		this.cqc = cqc;
	}

	/**
	 * Gets the Combat rank as an Integer between 0 - 8.
	 * 
	 * @return int Combat Rank as Integer.
	 */
	public int getCombatRank() {
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
	 * @return int Trade Rank as Integer.
	 */
	public int getTradeRank() {
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
	 * Gets the Explore rank as an Integer between 0 - 8.
	 * 
	 * @return int Explore Rank as Integer.
	 */
	public int getExploreRank() {
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
	 * Gets the Explore rank as an Integer between 0 - 14.
	 * 
	 * @return int Empire Rank as Integer.
	 */
	public int getEmpireRank() {
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
	public int getFederationRank() {
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
	public int getCqcRank() {
		return cqc;
	}
	
	/**
	 * @return
	 */
	public String getCQCRankkName() {
		return CQCRank.getLocalisedName(cqc);
	}
	
	
	
}
