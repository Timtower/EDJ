package io.github.xenopyax.edj.events.startup;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class StatisticsEvent extends Event {
	
	private Long currentWealth, spentOnShips, spentOnOutfitting, spentOnRepairs, spentOnFuel, spentOnAmmoConsumables, spentOnInsurance, bountyHuntingProfit, combatBondsProfit, assassinationProfits,
	totalFines, totalBounties, blackMarketsProfit, averageSmugglingProfit, marketProfit, miningProfits, explorationProfits, searchRescueProfit, totalNpcCrewWages, fleetCarrierRearmTotal,
	fleetCarrierExportTotal, fleetCarrierImportTotal, fleetCarrierRefuelTotal, fleetCarrierRefuelProfit, fleetCarrierRepairsTotal, fleetCarrierShipyardSold, fleetCarrierOutfittingSold,
	fleetCarrierShipyardProfit, fleetCarrierVouchersProfit, fleetCarrierTradespendTotal, fleetCarrierOutfittingProfit, fleetCarrierStolenspendTotal, fleetCarrierTradeprofitTotal,
	fleetCarrierVouchersRedeemed, fleetCarrierStolenprofitTotal, cqcKills, cqcTimePlayed, cqcCreditsEarned, fleetCarrierTotalJumps;
	
	private Integer bountiesReceived, insuranceClaims, ownedShipCount, bountiesClaimed, combatBonds, assassinations, highestSingleReward, skimmersKilled, notoriety, fines, highestBounty,
	blackMartketsTradedWith, ressourcesSmuggled, highestSingleSmugglingTransaction, marketsTradedWith, ressourcesTraded, averageTradingProfit, highestSingleTradingTransaction, quantityMined,
	materialsCollected, systemsVisited, planetsScannedToLevel2, planetsScannedToLevel3, efficientScans, highestPayout, totalHyperspaceDistance, totalHyperspaceJumps, greatestDistanceFromStart,
	timePlayed, passengersMissionsAccepted, passengersMissionsDisgruntled, passengersMissionsBulk, passengersMissionsVIP, passengersMissionsDelivered, passengersMissionsEjected,
	searchRescueTraded,	searchRescueCount, totalTGEncounters, tGScoutCount, engineersUsedCount, totalRecipesGenerated, recipesGeneratedRank1, recipesGeneratedRank2, recipesGeneratedRank3,
	recipesGeneratedRank4, recipesGeneratedRank5, hiredNpcCrew, firedNpcCrew, totalMulticrewTime, totalMulticrewTimeGunner, totalMulticrewTimeFighter, totalMulticrewCredits, totalMulticrewFines,
	materialTraderTradesCompledted, materialTraderMaterialsTraded, materialTraderEncodedMaterialsTraded, materialTraderGrade1Traded, materialTraderGrade2Traded, materialTraderGrade3Traded,
	materialTraderGrade4Traded, materialTraderGrade5Traded;
	
	private String lastTGEncounterSystem, lastTGEncounterTime, lastTGEncounterShip, fleetCarrierDistanceTravelled;
	
	private Double cqcKD, cqcWL;
	
	public StatisticsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		JSONObject bankAccount = json.pullJSONObject("Bank_Account");
		JSONObject combat = json.pullJSONObject("Combat");
		JSONObject crime = json.pullJSONObject("Crime");
		JSONObject smuggling = json.pullJSONObject("Smuggling");
		JSONObject trading = json.pullJSONObject("Trading");
		JSONObject mining = json.pullJSONObject("Mining");
		JSONObject exploration = json.pullJSONObject("Exploration");
		JSONObject passengers = json.pullJSONObject("Passengers");
		JSONObject searchAndRescue = json.pullJSONObject("Search_And_Rescue");
		JSONObject thargoid = json.pullJSONObject("TG_ENCOUNTERS");
		JSONObject crafting = json.pullJSONObject("Crafting");
		JSONObject crew = json.pullJSONObject("Crew");
		JSONObject multicrew = json.pullJSONObject("Multicrew");
		JSONObject materialTrader = json.pullJSONObject("Material_Trader_Stats");
		JSONObject fleetCarrier = json.has("FLEETCARRIER") ? json.pullJSONObject("FLEETCARRIER") : null;
		JSONObject cqc = json.has("CQC") ? json.pullJSONObject("CQC") : null;
		
		// Bank Account
		this.currentWealth = bankAccount.getLong("Current_Wealth");
		this.spentOnShips = bankAccount.getLong("Spent_On_Ships");
		this.spentOnOutfitting = bankAccount.getLong("Spent_On_Outfitting");
		this.spentOnRepairs = bankAccount.getLong("Spent_On_Repairs");
		this.spentOnFuel = bankAccount.getLong("Spent_On_Fuel");
		this.spentOnAmmoConsumables = bankAccount.getLong("Spent_On_Ammo_Consumables");
		this.spentOnInsurance = bankAccount.getLong("Spent_On_Insurance");
		this.insuranceClaims = bankAccount.getInt("Insurance_Claims");
		this.ownedShipCount = bankAccount.getInt("Owned_Ship_Count");
		
		// Combat
		this.bountyHuntingProfit = combat.getLong("Bounty_Hunting_Profit");
		this.combatBondsProfit = combat.getLong("Combat_Bond_Profits");
		this.assassinationProfits = combat.getLong("Assassination_Profits");
		this.bountiesClaimed = combat.getInt("Bounties_Claimed");
		this.combatBonds = combat.getInt("Combat_Bonds");
		this.assassinations = combat.getInt("Assassinations");
		this.highestSingleReward = combat.getInt("Highest_Single_Reward");
		this.skimmersKilled = combat.getInt("Skimmers_Killed");
		
		// Crime
		this.totalFines = crime.getLong("Total_Fines");
		this.totalBounties = crime.getLong("Total_Bounties");
		this.bountiesReceived = crime.getInt("Bounties_Received");
		this.notoriety = crime.getInt("Notoriety");
		this.fines = crime.getInt("Fines");
		this.highestBounty = crime.getInt("Highest_Bounty");
		
		// Smuggling
		this.blackMarketsProfit = smuggling.getLong("Black_Markets_Profits");
		this.averageSmugglingProfit = smuggling.getLong("Average_Profit");
		this.blackMartketsTradedWith = smuggling.getInt("Black_Markets_Traded_With");
		this.ressourcesSmuggled = smuggling.getInt("Resources_Smuggled");
		this.highestSingleSmugglingTransaction = smuggling.getInt("Highest_Single_Transaction");
		
		// Trading
		this.marketProfit = trading.getLong("Market_Profits");
		this.marketsTradedWith = trading.getInt("Markets_Traded_With");
		this.ressourcesTraded = trading.getInt("Resources_Traded");
		this.averageTradingProfit = trading.getInt("Average_Profit");
		this.highestSingleTradingTransaction = trading.getInt("Highest_Single_Transaction");
		
		// Mining
		this.miningProfits = mining.getLong("Mining_Profits");
		this.quantityMined = mining.getInt("Quantity_Mined");
		this.materialsCollected = mining.getInt("Materials_Collected");
		
		// Exploration
		this.explorationProfits = exploration.getLong("Exploration_Profits");
		this.systemsVisited = exploration.getInt("Systems_Visited");
		this.planetsScannedToLevel2 = exploration.getInt("Planets_Scanned_To_Level_2");
		this.planetsScannedToLevel3 = exploration.getInt("Planets_Scanned_To_Level_3");
		this.efficientScans = exploration.getInt("Efficient_Scans");
		this.highestPayout = exploration.getInt("Highest_Payout");
		this.totalHyperspaceDistance = exploration.getInt("Total_Hyperspace_Distance");
		this.totalHyperspaceJumps = exploration.getInt("Total_Hyperspace_Jumps");
		this.greatestDistanceFromStart = exploration.getInt("Greatest_Distance_From_Start");
		this.timePlayed = exploration.getInt("Time_Played");
		
		// Search & Rescue
		this.searchRescueProfit = searchAndRescue.getLong("SearchRescue_Profit");
		this.searchRescueTraded = searchAndRescue.getInt("SearchRescue_Traded");
		this.searchRescueCount = searchAndRescue.getInt("SearchRescue_Count");
		
		// Crew
		this.totalNpcCrewWages = crew.getLong("NpcCrew_TotalWages");
		this.hiredNpcCrew = crew.getInt("NpcCrew_Hired");
		this.firedNpcCrew = crew.getInt("NpcCrew_Fired");
		
		// Passengers
		this.passengersMissionsAccepted = passengers.getInt("Passengers_Missions_Accepted");
		this.passengersMissionsDisgruntled = passengers.getInt("Passengers_Missions_Disgruntled");
		this.passengersMissionsBulk = passengers.getInt("Passengers_Missions_Bulk");
		this.passengersMissionsVIP = passengers.getInt("Passengers_Missions_VIP");
		this.passengersMissionsDelivered = passengers.getInt("Passengers_Missions_Delivered");
		this.passengersMissionsEjected = passengers.getInt("Passengers_Missions_Ejected");
		
		// Thargoid
		this.totalTGEncounters = thargoid.getInt("TG_ENCOUNTER_TOTAL");
		this.tGScoutCount = thargoid.getInt("TG_SCOUT_COUNT");
		this.lastTGEncounterSystem = thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_SYSTEM");
		this.lastTGEncounterTime = thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP");
		this.lastTGEncounterShip = thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_SHIP");
		
		// Crafting
		this.engineersUsedCount = crafting.getInt("Count_Of_Used_Engineers");
		this.totalRecipesGenerated = crafting.getInt("Recipes_Generated");
		this.recipesGeneratedRank1 = crafting.getInt("Recipes_Generated_Rank_1");
		this.recipesGeneratedRank2 = crafting.getInt("Recipes_Generated_Rank_2");
		this.recipesGeneratedRank3 = crafting.getInt("Recipes_Generated_Rank_3");
		this.recipesGeneratedRank4 = crafting.getInt("Recipes_Generated_Rank_4");
		this.recipesGeneratedRank5 = crafting.getInt("Recipes_Generated_Rank_5");
		
		// Multicrew
		this.totalMulticrewTime = multicrew.getInt("Multicrew_Time_Total");
		this.totalMulticrewTimeGunner = multicrew.getInt("Multicrew_Gunner_Time_Total");
		this.totalMulticrewTimeFighter = multicrew.getInt("Multicrew_Fighter_Time_Total");
		this.totalMulticrewCredits = multicrew.getInt("Multicrew_Credits_Total");
		this.totalMulticrewFines = multicrew.getInt("Multicrew_Fines_Total");
		
		// Material Traders
		this.materialTraderTradesCompledted = materialTrader.getInt("Trades_Completed");
		this.materialTraderMaterialsTraded = materialTrader.getInt("Materials_Traded");
		this.materialTraderEncodedMaterialsTraded = materialTrader.getInt("Encoded_Materials_Traded");
		this.materialTraderGrade1Traded = materialTrader.getInt("Grade_1_Materials_Traded");
		this.materialTraderGrade2Traded = materialTrader.getInt("Grade_2_Materials_Traded");
		this.materialTraderGrade3Traded = materialTrader.getInt("Grade_3_Materials_Traded");
		this.materialTraderGrade4Traded = materialTrader.getInt("Grade_4_Materials_Traded");
		this.materialTraderGrade5Traded = materialTrader.getInt("Grade_5_Materials_Traded");
		
		if(fleetCarrier != null) {
			
			// Fleet Carrier
			this.fleetCarrierRearmTotal = fleetCarrier.pullLong("FLEETCARRIER_REARM_TOTAL");
			this.fleetCarrierTotalJumps = fleetCarrier.pullLong("FLEETCARRIER_TOTAL_JUMPS");
			this.fleetCarrierExportTotal = fleetCarrier.pullLong("FLEETCARRIER_EXPORT_TOTAL");
			this.fleetCarrierImportTotal = fleetCarrier.pullLong("FLEETCARRIER_IMPORT_TOTAL");
			this.fleetCarrierRefuelTotal = fleetCarrier.pullLong("FLEETCARRIER_REFUEL_TOTAL");
			this.fleetCarrierRefuelProfit = fleetCarrier.pullLong("FLEETCARRIER_REFUEL_PROFIT");
			this.fleetCarrierRepairsTotal = fleetCarrier.pullLong("FLEETCARRIER_REPAIRS_TOTAL");
			this.fleetCarrierShipyardSold = fleetCarrier.pullLong("FLEETCARRIER_SHIPYARD_SOLD");
			this.fleetCarrierOutfittingSold = fleetCarrier.pullLong("FLEETCARRIER_OUTFITTING_SOLD");
			this.fleetCarrierShipyardProfit = fleetCarrier.pullLong("FLEETCARRIER_SHIPYARD_PROFIT");
			this.fleetCarrierVouchersProfit = fleetCarrier.pullLong("FLEETCARRIER_VOUCHERS_PROFIT");
			this.fleetCarrierTradespendTotal = fleetCarrier.pullLong("FLEETCARRIER_TRADESPEND_TOTAL");
			this.fleetCarrierOutfittingProfit = fleetCarrier.pullLong("FLEETCARRIER_OUTFITTING_PROFIT");
			this.fleetCarrierStolenspendTotal = fleetCarrier.pullLong("FLEETCARRIER_STOLENSPEND_TOTAL");
			this.fleetCarrierTradeprofitTotal = fleetCarrier.pullLong("FLEETCARRIER_TRADEPROFIT_TOTAL");
			this.fleetCarrierVouchersRedeemed = fleetCarrier.pullLong("FLEETCARRIER_VOUCHERS_REDEEMED");
			this.fleetCarrierStolenprofitTotal = fleetCarrier.pullLong("FLEETCARRIER_STOLENPROFIT_TOTAL");
			this.fleetCarrierDistanceTravelled = fleetCarrier.pullString("FLEETCARRIER_DISTANCE_TRAVELLED");
			
		}
		
		if(cqc != null) {
			
			//CQC
			this.cqcKD = cqc.pullDouble("CQC_KD");
			this.cqcWL = cqc.pullDouble("CQC_WL");
			this.cqcKills = cqc.pullLong("CQC_Kills");
			this.cqcTimePlayed = cqc.pullLong("CQC_Time_Played");
			this.cqcCreditsEarned = cqc.pullLong("CQC_Credits_Earned");
			
		}
			
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getCurrentWealth() {
		return currentWealth;
	}

	public Long getSpentOnShips() {
		return spentOnShips;
	}

	public Long getSpentOnOutfitting() {
		return spentOnOutfitting;
	}

	public Long getSpentOnRepairs() {
		return spentOnRepairs;
	}

	public Long getSpentOnFuel() {
		return spentOnFuel;
	}

	public Long getSpentOnAmmoConsumables() {
		return spentOnAmmoConsumables;
	}

	public Long getSpentOnInsurance() {
		return spentOnInsurance;
	}

	public Long getBountyHuntingProfit() {
		return bountyHuntingProfit;
	}

	public Long getCombatBondsProfit() {
		return combatBondsProfit;
	}

	public Long getAssassinationProfits() {
		return assassinationProfits;
	}

	public Long getTotalFines() {
		return totalFines;
	}

	public Long getTotalBounties() {
		return totalBounties;
	}

	public Long getBlackMarketsProfit() {
		return blackMarketsProfit;
	}

	public Long getAverageSmugglingProfit() {
		return averageSmugglingProfit;
	}

	public Long getMarketProfit() {
		return marketProfit;
	}

	public Long getMiningProfits() {
		return miningProfits;
	}

	public Long getExplorationProfits() {
		return explorationProfits;
	}

	public Long getSearchRescueProfit() {
		return searchRescueProfit;
	}

	public Long getTotalNpcCrewWages() {
		return totalNpcCrewWages;
	}

	public Long getFleetCarrierRearmTotal() {
		return fleetCarrierRearmTotal;
	}

	public Long getFleetCarrierExportTotal() {
		return fleetCarrierExportTotal;
	}

	public Long getFleetCarrierImportTotal() {
		return fleetCarrierImportTotal;
	}

	public Long getFleetCarrierRefuelTotal() {
		return fleetCarrierRefuelTotal;
	}

	public Long getFleetCarrierRefuelProfit() {
		return fleetCarrierRefuelProfit;
	}

	public Long getFleetCarrierRepairsTotal() {
		return fleetCarrierRepairsTotal;
	}

	public Long getFleetCarrierShipyardSold() {
		return fleetCarrierShipyardSold;
	}

	public Long getFleetCarrierOutfittingSold() {
		return fleetCarrierOutfittingSold;
	}

	public Long getFleetCarrierShipyardProfit() {
		return fleetCarrierShipyardProfit;
	}

	public Long getFleetCarrierVouchersProfit() {
		return fleetCarrierVouchersProfit;
	}

	public Long getFleetCarrierTradespendTotal() {
		return fleetCarrierTradespendTotal;
	}

	public Long getFleetCarrierOutfittingProfit() {
		return fleetCarrierOutfittingProfit;
	}

	public Long getFleetCarrierStolenspendTotal() {
		return fleetCarrierStolenspendTotal;
	}

	public Long getFleetCarrierTradeprofitTotal() {
		return fleetCarrierTradeprofitTotal;
	}

	public Long getFleetCarrierVouchersRedeemed() {
		return fleetCarrierVouchersRedeemed;
	}

	public Long getFleetCarrierStolenprofitTotal() {
		return fleetCarrierStolenprofitTotal;
	}

	public Long getCqcKills() {
		return cqcKills;
	}

	public Long getCqcTimePlayed() {
		return cqcTimePlayed;
	}

	public Long getCqcCreditsEarned() {
		return cqcCreditsEarned;
	}

	public Long getFleetCarrierTotalJumps() {
		return fleetCarrierTotalJumps;
	}

	public Integer getBountiesReceived() {
		return bountiesReceived;
	}

	public Integer getInsuranceClaims() {
		return insuranceClaims;
	}

	public Integer getOwnedShipCount() {
		return ownedShipCount;
	}

	public Integer getBountiesClaimed() {
		return bountiesClaimed;
	}

	public Integer getCombatBonds() {
		return combatBonds;
	}

	public Integer getAssassinations() {
		return assassinations;
	}

	public Integer getHighestSingleReward() {
		return highestSingleReward;
	}

	public Integer getSkimmersKilled() {
		return skimmersKilled;
	}

	public Integer getNotoriety() {
		return notoriety;
	}

	public Integer getFines() {
		return fines;
	}

	public Integer getHighestBounty() {
		return highestBounty;
	}

	public Integer getBlackMartketsTradedWith() {
		return blackMartketsTradedWith;
	}

	public Integer getRessourcesSmuggled() {
		return ressourcesSmuggled;
	}

	public Integer getHighestSingleSmugglingTransaction() {
		return highestSingleSmugglingTransaction;
	}

	public Integer getMarketsTradedWith() {
		return marketsTradedWith;
	}

	public Integer getRessourcesTraded() {
		return ressourcesTraded;
	}

	public Integer getAverageTradingProfit() {
		return averageTradingProfit;
	}

	public Integer getHighestSingleTradingTransaction() {
		return highestSingleTradingTransaction;
	}

	public Integer getQuantityMined() {
		return quantityMined;
	}

	public Integer getMaterialsCollected() {
		return materialsCollected;
	}

	public Integer getSystemsVisited() {
		return systemsVisited;
	}

	public Integer getPlanetsScannedToLevel2() {
		return planetsScannedToLevel2;
	}

	public Integer getPlanetsScannedToLevel3() {
		return planetsScannedToLevel3;
	}

	public Integer getEfficientScans() {
		return efficientScans;
	}

	public Integer getHighestPayout() {
		return highestPayout;
	}

	public Integer getTotalHyperspaceDistance() {
		return totalHyperspaceDistance;
	}

	public Integer getTotalHyperspaceJumps() {
		return totalHyperspaceJumps;
	}

	public Integer getGreatestDistanceFromStart() {
		return greatestDistanceFromStart;
	}

	public Integer getTimePlayed() {
		return timePlayed;
	}

	public Integer getPassengersMissionsAccepted() {
		return passengersMissionsAccepted;
	}

	public Integer getPassengersMissionsDisgruntled() {
		return passengersMissionsDisgruntled;
	}

	public Integer getPassengersMissionsBulk() {
		return passengersMissionsBulk;
	}

	public Integer getPassengersMissionsVIP() {
		return passengersMissionsVIP;
	}

	public Integer getPassengersMissionsDelivered() {
		return passengersMissionsDelivered;
	}

	public Integer getPassengersMissionsEjected() {
		return passengersMissionsEjected;
	}

	public Integer getSearchRescueTraded() {
		return searchRescueTraded;
	}

	public Integer getSearchRescueCount() {
		return searchRescueCount;
	}

	public Integer getTotalTGEncounters() {
		return totalTGEncounters;
	}

	public Integer gettGScoutCount() {
		return tGScoutCount;
	}

	public Integer getEngineersUsedCount() {
		return engineersUsedCount;
	}

	public Integer getTotalRecipesGenerated() {
		return totalRecipesGenerated;
	}

	public Integer getRecipesGeneratedRank1() {
		return recipesGeneratedRank1;
	}

	public Integer getRecipesGeneratedRank2() {
		return recipesGeneratedRank2;
	}

	public Integer getRecipesGeneratedRank3() {
		return recipesGeneratedRank3;
	}

	public Integer getRecipesGeneratedRank4() {
		return recipesGeneratedRank4;
	}

	public Integer getRecipesGeneratedRank5() {
		return recipesGeneratedRank5;
	}

	public Integer getHiredNpcCrew() {
		return hiredNpcCrew;
	}

	public Integer getFiredNpcCrew() {
		return firedNpcCrew;
	}

	public Integer getTotalMulticrewTime() {
		return totalMulticrewTime;
	}

	public Integer getTotalMulticrewTimeGunner() {
		return totalMulticrewTimeGunner;
	}

	public Integer getTotalMulticrewTimeFighter() {
		return totalMulticrewTimeFighter;
	}

	public Integer getTotalMulticrewCredits() {
		return totalMulticrewCredits;
	}

	public Integer getTotalMulticrewFines() {
		return totalMulticrewFines;
	}

	public Integer getMaterialTraderTradesCompledted() {
		return materialTraderTradesCompledted;
	}

	public Integer getMaterialTraderMaterialsTraded() {
		return materialTraderMaterialsTraded;
	}

	public Integer getMaterialTraderEncodedMaterialsTraded() {
		return materialTraderEncodedMaterialsTraded;
	}

	public Integer getMaterialTraderGrade1Traded() {
		return materialTraderGrade1Traded;
	}

	public Integer getMaterialTraderGrade2Traded() {
		return materialTraderGrade2Traded;
	}

	public Integer getMaterialTraderGrade3Traded() {
		return materialTraderGrade3Traded;
	}

	public Integer getMaterialTraderGrade4Traded() {
		return materialTraderGrade4Traded;
	}

	public Integer getMaterialTraderGrade5Traded() {
		return materialTraderGrade5Traded;
	}

	public String getLastTGEncounterSystem() {
		return lastTGEncounterSystem;
	}

	public String getLastTGEncounterTime() {
		return lastTGEncounterTime;
	}

	public String getLastTGEncounterShip() {
		return lastTGEncounterShip;
	}

	public String getFleetCarrierDistanceTravelled() {
		return fleetCarrierDistanceTravelled;
	}

	public Double getCqcKD() {
		return cqcKD;
	}

	public Double getCqcWL() {
		return cqcWL;
	}
	
}
