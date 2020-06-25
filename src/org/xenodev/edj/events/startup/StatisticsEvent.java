package org.xenodev.edj.events.startup;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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
		JSONObject fleetCarrier = json.pullJSONObject("FLEETCARRIER");
		JSONObject cqc = json.pullJSONObject("CQC");
		
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
		
		//CQC
		this.cqcKD = cqc.pullDouble("CQC_KD");
		this.cqcWL = cqc.pullDouble("CQC_WL");
		this.cqcKills = cqc.pullLong("CQC_Kills");
		this.cqcTimePlayed = cqc.pullLong("CQC_Time_Played");
		this.cqcCreditsEarned = cqc.pullLong("CQC_Credits_Earned");
			
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public Long getCurrentWealth() {
		return currentWealth;
	}

	public void setCurrentWealth(Long currentWealth) {
		this.currentWealth = currentWealth;
	}

	public Long getSpentOnShips() {
		return spentOnShips;
	}

	public void setSpentOnShips(Long spentOnShips) {
		this.spentOnShips = spentOnShips;
	}

	public Long getSpentOnOutfitting() {
		return spentOnOutfitting;
	}

	public void setSpentOnOutfitting(Long spentOnOutfitting) {
		this.spentOnOutfitting = spentOnOutfitting;
	}

	public Long getSpentOnRepairs() {
		return spentOnRepairs;
	}

	public void setSpentOnRepairs(Long spentOnRepairs) {
		this.spentOnRepairs = spentOnRepairs;
	}

	public Long getSpentOnFuel() {
		return spentOnFuel;
	}

	public void setSpentOnFuel(Long spentOnFuel) {
		this.spentOnFuel = spentOnFuel;
	}

	public Long getSpentOnAmmoConsumables() {
		return spentOnAmmoConsumables;
	}

	public void setSpentOnAmmoConsumables(Long spentOnAmmoConsumables) {
		this.spentOnAmmoConsumables = spentOnAmmoConsumables;
	}

	public Long getSpentOnInsurance() {
		return spentOnInsurance;
	}

	public void setSpentOnInsurance(Long spentOnInsurance) {
		this.spentOnInsurance = spentOnInsurance;
	}

	public Long getBountyHuntingProfit() {
		return bountyHuntingProfit;
	}

	public void setBountyHuntingProfit(Long bountyHuntingProfit) {
		this.bountyHuntingProfit = bountyHuntingProfit;
	}

	public Long getCombatBondsProfit() {
		return combatBondsProfit;
	}

	public void setCombatBondsProfit(Long combatBondsProfit) {
		this.combatBondsProfit = combatBondsProfit;
	}

	public Long getAssassinationProfits() {
		return assassinationProfits;
	}

	public void setAssassinationProfits(Long assassinationProfits) {
		this.assassinationProfits = assassinationProfits;
	}

	public Long getTotalFines() {
		return totalFines;
	}

	public void setTotalFines(Long totalFines) {
		this.totalFines = totalFines;
	}

	public Long getTotalBounties() {
		return totalBounties;
	}

	public void setTotalBounties(Long totalBounties) {
		this.totalBounties = totalBounties;
	}

	public Long getBlackMarketsProfit() {
		return blackMarketsProfit;
	}

	public void setBlackMarketsProfit(Long blackMarketsProfit) {
		this.blackMarketsProfit = blackMarketsProfit;
	}

	public Long getAverageSmugglingProfit() {
		return averageSmugglingProfit;
	}

	public void setAverageSmugglingProfit(Long averageSmugglingProfit) {
		this.averageSmugglingProfit = averageSmugglingProfit;
	}

	public Long getMarketProfit() {
		return marketProfit;
	}

	public void setMarketProfit(Long marketProfit) {
		this.marketProfit = marketProfit;
	}

	public Long getMiningProfits() {
		return miningProfits;
	}

	public void setMiningProfits(Long miningProfits) {
		this.miningProfits = miningProfits;
	}

	public Long getExplorationProfits() {
		return explorationProfits;
	}

	public void setExplorationProfits(Long explorationProfits) {
		this.explorationProfits = explorationProfits;
	}

	public Long getSearchRescueProfit() {
		return searchRescueProfit;
	}

	public void setSearchRescueProfit(Long searchRescueProfit) {
		this.searchRescueProfit = searchRescueProfit;
	}

	public Long getTotalNpcCrewWages() {
		return totalNpcCrewWages;
	}

	public void setTotalNpcCrewWages(Long totalNpcCrewWages) {
		this.totalNpcCrewWages = totalNpcCrewWages;
	}

	public Integer getBountiesReceived() {
		return bountiesReceived;
	}

	public void setBountiesReceived(Integer bountiesReceived) {
		this.bountiesReceived = bountiesReceived;
	}

	public Integer getInsuranceClaims() {
		return insuranceClaims;
	}

	public void setInsuranceClaims(Integer insuranceClaims) {
		this.insuranceClaims = insuranceClaims;
	}

	public Integer getOwnedShipCount() {
		return ownedShipCount;
	}

	public void setOwnedShipCount(Integer ownedShipCount) {
		this.ownedShipCount = ownedShipCount;
	}

	public Integer getBountiesClaimed() {
		return bountiesClaimed;
	}

	public void setBountiesClaimed(Integer bountiesClaimed) {
		this.bountiesClaimed = bountiesClaimed;
	}

	public Integer getCombatBonds() {
		return combatBonds;
	}

	public void setCombatBonds(Integer combatBonds) {
		this.combatBonds = combatBonds;
	}

	public Integer getAssassinations() {
		return assassinations;
	}

	public void setAssassinations(Integer assassinations) {
		this.assassinations = assassinations;
	}

	public Integer getHighestSingleReward() {
		return highestSingleReward;
	}

	public void setHighestSingleReward(Integer highestSingleReward) {
		this.highestSingleReward = highestSingleReward;
	}

	public Integer getSkimmersKilled() {
		return skimmersKilled;
	}

	public void setSkimmersKilled(Integer skimmersKilled) {
		this.skimmersKilled = skimmersKilled;
	}

	public Integer getNotoriety() {
		return notoriety;
	}

	public void setNotoriety(Integer notoriety) {
		this.notoriety = notoriety;
	}

	public Integer getFines() {
		return fines;
	}

	public void setFines(Integer fines) {
		this.fines = fines;
	}

	public Integer getHighestBounty() {
		return highestBounty;
	}

	public void setHighestBounty(Integer highestBounty) {
		this.highestBounty = highestBounty;
	}

	public Integer getBlackMartketsTradedWith() {
		return blackMartketsTradedWith;
	}

	public void setBlackMartketsTradedWith(Integer blackMartketsTradedWith) {
		this.blackMartketsTradedWith = blackMartketsTradedWith;
	}

	public Integer getRessourcesSmuggled() {
		return ressourcesSmuggled;
	}

	public void setRessourcesSmuggled(Integer ressourcesSmuggled) {
		this.ressourcesSmuggled = ressourcesSmuggled;
	}

	public Integer getHighestSingleSmugglingTransaction() {
		return highestSingleSmugglingTransaction;
	}

	public void setHighestSingleSmugglingTransaction(Integer highestSingleSmugglingTransaction) {
		this.highestSingleSmugglingTransaction = highestSingleSmugglingTransaction;
	}

	public Integer getMarketsTradedWith() {
		return marketsTradedWith;
	}

	public void setMarketsTradedWith(Integer marketsTradedWith) {
		this.marketsTradedWith = marketsTradedWith;
	}

	public Integer getRessourcesTraded() {
		return ressourcesTraded;
	}

	public void setRessourcesTraded(Integer ressourcesTraded) {
		this.ressourcesTraded = ressourcesTraded;
	}

	public Integer getAverageTradingProfit() {
		return averageTradingProfit;
	}

	public void setAverageTradingProfit(Integer averageTradingProfit) {
		this.averageTradingProfit = averageTradingProfit;
	}

	public Integer getHighestSingleTradingTransaction() {
		return highestSingleTradingTransaction;
	}

	public void setHighestSingleTradingTransaction(Integer highestSingleTradingTransaction) {
		this.highestSingleTradingTransaction = highestSingleTradingTransaction;
	}

	public Integer getQuantityMined() {
		return quantityMined;
	}

	public void setQuantityMined(Integer quantityMined) {
		this.quantityMined = quantityMined;
	}

	public Integer getMaterialsCollected() {
		return materialsCollected;
	}

	public void setMaterialsCollected(Integer materialsCollected) {
		this.materialsCollected = materialsCollected;
	}

	public Integer getSystemsVisited() {
		return systemsVisited;
	}

	public void setSystemsVisited(Integer systemsVisited) {
		this.systemsVisited = systemsVisited;
	}

	public Integer getPlanetsScannedToLevel2() {
		return planetsScannedToLevel2;
	}

	public void setPlanetsScannedToLevel2(Integer planetsScannedToLevel2) {
		this.planetsScannedToLevel2 = planetsScannedToLevel2;
	}

	public Integer getPlanetsScannedToLevel3() {
		return planetsScannedToLevel3;
	}

	public void setPlanetsScannedToLevel3(Integer planetsScannedToLevel3) {
		this.planetsScannedToLevel3 = planetsScannedToLevel3;
	}

	public Integer getEfficientScans() {
		return efficientScans;
	}

	public void setEfficientScans(Integer efficientScans) {
		this.efficientScans = efficientScans;
	}

	public Integer getHighestPayout() {
		return highestPayout;
	}

	public void setHighestPayout(Integer highestPayout) {
		this.highestPayout = highestPayout;
	}

	public Integer getTotalHyperspaceDistance() {
		return totalHyperspaceDistance;
	}

	public void setTotalHyperspaceDistance(Integer totalHyperspaceDistance) {
		this.totalHyperspaceDistance = totalHyperspaceDistance;
	}

	public Integer getTotalHyperspaceJumps() {
		return totalHyperspaceJumps;
	}

	public void setTotalHyperspaceJumps(Integer totalHyperspaceJumps) {
		this.totalHyperspaceJumps = totalHyperspaceJumps;
	}

	public Integer getGreatestDistanceFromStart() {
		return greatestDistanceFromStart;
	}

	public void setGreatestDistanceFromStart(Integer greatestDistanceFromStart) {
		this.greatestDistanceFromStart = greatestDistanceFromStart;
	}

	public Integer getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(Integer timePlayed) {
		this.timePlayed = timePlayed;
	}

	public Integer getPassengersMissionsAccepted() {
		return passengersMissionsAccepted;
	}

	public void setPassengersMissionsAccepted(Integer passengersMissionsAccepted) {
		this.passengersMissionsAccepted = passengersMissionsAccepted;
	}

	public Integer getPassengersMissionsDisgruntled() {
		return passengersMissionsDisgruntled;
	}

	public void setPassengersMissionsDisgruntled(Integer passengersMissionsDisgruntled) {
		this.passengersMissionsDisgruntled = passengersMissionsDisgruntled;
	}

	public Integer getPassengersMissionsBulk() {
		return passengersMissionsBulk;
	}

	public void setPassengersMissionsBulk(Integer passengersMissionsBulk) {
		this.passengersMissionsBulk = passengersMissionsBulk;
	}

	public Integer getPassengersMissionsVIP() {
		return passengersMissionsVIP;
	}

	public void setPassengersMissionsVIP(Integer passengersMissionsVIP) {
		this.passengersMissionsVIP = passengersMissionsVIP;
	}

	public Integer getPassengersMissionsDelivered() {
		return passengersMissionsDelivered;
	}

	public void setPassengersMissionsDelivered(Integer passengersMissionsDelivered) {
		this.passengersMissionsDelivered = passengersMissionsDelivered;
	}

	public Integer getPassengersMissionsEjected() {
		return passengersMissionsEjected;
	}

	public void setPassengersMissionsEjected(Integer passengersMissionsEjected) {
		this.passengersMissionsEjected = passengersMissionsEjected;
	}

	public Integer getSearchRescueTraded() {
		return searchRescueTraded;
	}

	public void setSearchRescueTraded(Integer searchRescueTraded) {
		this.searchRescueTraded = searchRescueTraded;
	}

	public Integer getSearchRescueCount() {
		return searchRescueCount;
	}

	public void setSearchRescueCount(Integer searchRescueCount) {
		this.searchRescueCount = searchRescueCount;
	}

	public Integer getTotalTGEncounters() {
		return totalTGEncounters;
	}

	public void setTotalTGEncounters(Integer totalTGEncounters) {
		this.totalTGEncounters = totalTGEncounters;
	}

	public Integer gettGScoutCount() {
		return tGScoutCount;
	}

	public void settGScoutCount(Integer tGScoutCount) {
		this.tGScoutCount = tGScoutCount;
	}

	public Integer getEngineersUsedCount() {
		return engineersUsedCount;
	}

	public void setEngineersUsedCount(Integer engineersUsedCount) {
		this.engineersUsedCount = engineersUsedCount;
	}

	public Integer getTotalRecipesGenerated() {
		return totalRecipesGenerated;
	}

	public void setTotalRecipesGenerated(Integer totalRecipesGenerated) {
		this.totalRecipesGenerated = totalRecipesGenerated;
	}

	public Integer getRecipesGeneratedRank1() {
		return recipesGeneratedRank1;
	}

	public void setRecipesGeneratedRank1(Integer recipesGeneratedRank1) {
		this.recipesGeneratedRank1 = recipesGeneratedRank1;
	}

	public Integer getRecipesGeneratedRank2() {
		return recipesGeneratedRank2;
	}

	public void setRecipesGeneratedRank2(Integer recipesGeneratedRank2) {
		this.recipesGeneratedRank2 = recipesGeneratedRank2;
	}

	public Integer getRecipesGeneratedRank3() {
		return recipesGeneratedRank3;
	}

	public void setRecipesGeneratedRank3(Integer recipesGeneratedRank3) {
		this.recipesGeneratedRank3 = recipesGeneratedRank3;
	}

	public Integer getRecipesGeneratedRank4() {
		return recipesGeneratedRank4;
	}

	public void setRecipesGeneratedRank4(Integer recipesGeneratedRank4) {
		this.recipesGeneratedRank4 = recipesGeneratedRank4;
	}

	public Integer getRecipesGeneratedRank5() {
		return recipesGeneratedRank5;
	}

	public void setRecipesGeneratedRank5(Integer recipesGeneratedRank5) {
		this.recipesGeneratedRank5 = recipesGeneratedRank5;
	}

	public Integer getHiredNpcCrew() {
		return hiredNpcCrew;
	}

	public void setHiredNpcCrew(Integer hiredNpcCrew) {
		this.hiredNpcCrew = hiredNpcCrew;
	}

	public Integer getFiredNpcCrew() {
		return firedNpcCrew;
	}

	public void setFiredNpcCrew(Integer firedNpcCrew) {
		this.firedNpcCrew = firedNpcCrew;
	}

	public Integer getTotalMulticrewTime() {
		return totalMulticrewTime;
	}

	public void setTotalMulticrewTime(Integer totalMulticrewTime) {
		this.totalMulticrewTime = totalMulticrewTime;
	}

	public Integer getTotalMulticrewTimeGunner() {
		return totalMulticrewTimeGunner;
	}

	public void setTotalMulticrewTimeGunner(Integer totalMulticrewTimeGunner) {
		this.totalMulticrewTimeGunner = totalMulticrewTimeGunner;
	}

	public Integer getTotalMulticrewTimeFighter() {
		return totalMulticrewTimeFighter;
	}

	public void setTotalMulticrewTimeFighter(Integer totalMulticrewTimeFighter) {
		this.totalMulticrewTimeFighter = totalMulticrewTimeFighter;
	}

	public Integer getTotalMulticrewCredits() {
		return totalMulticrewCredits;
	}

	public void setTotalMulticrewCredits(Integer totalMulticrewCredits) {
		this.totalMulticrewCredits = totalMulticrewCredits;
	}

	public Integer getTotalMulticrewFines() {
		return totalMulticrewFines;
	}

	public void setTotalMulticrewFines(Integer totalMulticrewFines) {
		this.totalMulticrewFines = totalMulticrewFines;
	}

	public Integer getMaterialTraderTradesCompledted() {
		return materialTraderTradesCompledted;
	}

	public void setMaterialTraderTradesCompledted(Integer materialTraderTradesCompledted) {
		this.materialTraderTradesCompledted = materialTraderTradesCompledted;
	}

	public Integer getMaterialTraderMaterialsTraded() {
		return materialTraderMaterialsTraded;
	}

	public void setMaterialTraderMaterialsTraded(Integer materialTraderMaterialsTraded) {
		this.materialTraderMaterialsTraded = materialTraderMaterialsTraded;
	}

	public Integer getMaterialTraderEncodedMaterialsTraded() {
		return materialTraderEncodedMaterialsTraded;
	}

	public void setMaterialTraderEncodedMaterialsTraded(Integer materialTraderEncodedMaterialsTraded) {
		this.materialTraderEncodedMaterialsTraded = materialTraderEncodedMaterialsTraded;
	}

	public Integer getMaterialTraderGrade1Traded() {
		return materialTraderGrade1Traded;
	}

	public void setMaterialTraderGrade1Traded(Integer materialTraderGrade1Traded) {
		this.materialTraderGrade1Traded = materialTraderGrade1Traded;
	}

	public Integer getMaterialTraderGrade2Traded() {
		return materialTraderGrade2Traded;
	}

	public void setMaterialTraderGrade2Traded(Integer materialTraderGrade2Traded) {
		this.materialTraderGrade2Traded = materialTraderGrade2Traded;
	}

	public Integer getMaterialTraderGrade3Traded() {
		return materialTraderGrade3Traded;
	}

	public void setMaterialTraderGrade3Traded(Integer materialTraderGrade3Traded) {
		this.materialTraderGrade3Traded = materialTraderGrade3Traded;
	}

	public Integer getMaterialTraderGrade4Traded() {
		return materialTraderGrade4Traded;
	}

	public void setMaterialTraderGrade4Traded(Integer materialTraderGrade4Traded) {
		this.materialTraderGrade4Traded = materialTraderGrade4Traded;
	}

	public Integer getMaterialTraderGrade5Traded() {
		return materialTraderGrade5Traded;
	}

	public void setMaterialTraderGrade5Traded(Integer materialTraderGrade5Traded) {
		this.materialTraderGrade5Traded = materialTraderGrade5Traded;
	}

	public String getLastTGEncounterSystem() {
		return lastTGEncounterSystem;
	}

	public void setLastTGEncounterSystem(String lastTGEncounterSystem) {
		this.lastTGEncounterSystem = lastTGEncounterSystem;
	}

	public String getLastTGEncounterTime() {
		return lastTGEncounterTime;
	}

	public void setLastTGEncounterTime(String lastTGEncounterTime) {
		this.lastTGEncounterTime = lastTGEncounterTime;
	}

	public String getLastTGEncounterShip() {
		return lastTGEncounterShip;
	}

	public void setLastTGEncounterShip(String lastTGEncounterShip) {
		this.lastTGEncounterShip = lastTGEncounterShip;
	}

	public Long getFleetCarrierRearmTotal() {
		return fleetCarrierRearmTotal;
	}

	public void setFleetCarrierRearmTotal(Long fleetCarrierRearmTotal) {
		this.fleetCarrierRearmTotal = fleetCarrierRearmTotal;
	}

	public Long getFleetCarrierExportTotal() {
		return fleetCarrierExportTotal;
	}

	public void setFleetCarrierExportTotal(Long fleetCarrierExportTotal) {
		this.fleetCarrierExportTotal = fleetCarrierExportTotal;
	}

	public Long getFleetCarrierImportTotal() {
		return fleetCarrierImportTotal;
	}

	public void setFleetCarrierImportTotal(Long fleetCarrierImportTotal) {
		this.fleetCarrierImportTotal = fleetCarrierImportTotal;
	}

	public Long getFleetCarrierRefuelTotal() {
		return fleetCarrierRefuelTotal;
	}

	public void setFleetCarrierRefuelTotal(Long fleetCarrierRefuelTotal) {
		this.fleetCarrierRefuelTotal = fleetCarrierRefuelTotal;
	}

	public Long getFleetCarrierRefuelProfit() {
		return fleetCarrierRefuelProfit;
	}

	public void setFleetCarrierRefuelProfit(Long fleetCarrierRefuelProfit) {
		this.fleetCarrierRefuelProfit = fleetCarrierRefuelProfit;
	}

	public Long getFleetCarrierRepairsTotal() {
		return fleetCarrierRepairsTotal;
	}

	public void setFleetCarrierRepairsTotal(Long fleetCarrierRepairsTotal) {
		this.fleetCarrierRepairsTotal = fleetCarrierRepairsTotal;
	}

	public Long getFleetCarrierShipyardSold() {
		return fleetCarrierShipyardSold;
	}

	public void setFleetCarrierShipyradSold(Long fleetCarrierShipyardSold) {
		this.fleetCarrierShipyardSold = fleetCarrierShipyardSold;
	}

	public Long getFleetCarrierOutfittingSold() {
		return fleetCarrierOutfittingSold;
	}

	public void setFleetCarrierOutfittingSold(Long fleetCarrierOutfittingSold) {
		this.fleetCarrierOutfittingSold = fleetCarrierOutfittingSold;
	}

	public Long getFleetCarrierShipyardProfit() {
		return fleetCarrierShipyardProfit;
	}

	public void setFleetCarrierShipyardProfit(Long fleetCarrierShipyardProfit) {
		this.fleetCarrierShipyardProfit = fleetCarrierShipyardProfit;
	}

	public Long getFleetCarrierVouchersProfit() {
		return fleetCarrierVouchersProfit;
	}

	public void setFleetCarrierVouchersProfit(Long fleetCarrierVouchersProfit) {
		this.fleetCarrierVouchersProfit = fleetCarrierVouchersProfit;
	}

	public Long getFleetCarrierTradeSpendTotal() {
		return fleetCarrierTradespendTotal;
	}

	public void setFleetCarrierTradeSpendTotal(Long fleetCarrierTradespendTotal) {
		this.fleetCarrierTradespendTotal = fleetCarrierTradespendTotal;
	}

	public Long getFleetCarrierOutfittingProfit() {
		return fleetCarrierOutfittingProfit;
	}

	public void setFleetCarrierOutfittingProfit(Long fleetCarrierOutfittingProfit) {
		this.fleetCarrierOutfittingProfit = fleetCarrierOutfittingProfit;
	}

	public Long getFleetCarrierStolenSpendTotal() {
		return fleetCarrierStolenspendTotal;
	}

	public void setFleetCarrierStolenSpendTotal(Long fleetCarrierStolenspendTotal) {
		this.fleetCarrierStolenspendTotal = fleetCarrierStolenspendTotal;
	}

	public Long getFleetCarrierTradeProfitTotal() {
		return fleetCarrierTradeprofitTotal;
	}

	public void setFleetCarrierTradeProfitTotal(Long fleetCarrierTradeprofitTotal) {
		this.fleetCarrierTradeprofitTotal = fleetCarrierTradeprofitTotal;
	}

	public Long getFleetCarrierVouchersRedeemed() {
		return fleetCarrierVouchersRedeemed;
	}

	public void setFleetCarrierVouchersRedeemed(Long fleetCarrierVouchersRedeemed) {
		this.fleetCarrierVouchersRedeemed = fleetCarrierVouchersRedeemed;
	}

	public Long getFleetCarrierStolenProfitTotal() {
		return fleetCarrierStolenprofitTotal;
	}

	public void setFleetCarrierStolenProfitTotal(Long fleetCarrierStolenprofitTotal) {
		this.fleetCarrierStolenprofitTotal = fleetCarrierStolenprofitTotal;
	}

	public Long getCQCKills() {
		return cqcKills;
	}

	public void setCQCKills(Long cqcKills) {
		this.cqcKills = cqcKills;
	}

	public Long getCQCTimePlayed() {
		return cqcTimePlayed;
	}

	public void setCQCTimePlayed(Long cqcTimePlayed) {
		this.cqcTimePlayed = cqcTimePlayed;
	}

	public Long getCQCCreditsEarned() {
		return cqcCreditsEarned;
	}

	public void setCQCCreditsEarned(Long cqcCreditsEarned) {
		this.cqcCreditsEarned = cqcCreditsEarned;
	}

	public Long getFleetCarrierTotalJumps() {
		return fleetCarrierTotalJumps;
	}

	public void setFleetCarrierTotalJumps(Long fleetCarrierTotalJumps) {
		this.fleetCarrierTotalJumps = fleetCarrierTotalJumps;
	}

	public String getFleetCarrierDistanceTravelled() {
		return fleetCarrierDistanceTravelled;
	}

	public void setFleetCarrierDistanceTravelled(String fleetCarrierDistanceTravelled) {
		this.fleetCarrierDistanceTravelled = fleetCarrierDistanceTravelled;
	}

	public Double getCQCKD() {
		return cqcKD;
	}

	public void setCQCKD(Double cqcKD) {
		this.cqcKD = cqcKD;
	}

	public Double getCQCWL() {
		return cqcWL;
	}

	public void setCQCWL(Double cqcWL) {
		this.cqcWL = cqcWL;
	}
	
}
