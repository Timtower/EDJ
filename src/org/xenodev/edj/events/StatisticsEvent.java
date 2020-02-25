package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class StatisticsEvent extends Event {
	
	long currentWealth, spentOnShips, spentOnOutfitting, spentOnRepairs, spentOnFuel, spentOnAmmoConsumables, spentOnInsurance, bountyHuntingProfit, combatBondsProfit, assassinationProfits, totalFines, totalBounties, blackMarketsProfit, averageSmugglingProfit, marketProfit, miningProfits, explorationProfits, searchRescueProfit, totalNpcCrewWages;
	int bountiesReceived, insuranceClaims, ownedShipCount, bountiesClaimed, combatBonds, assassinations, highestSingleReward, skimmersKilled, notoriety, fines, highestBounty, blackMartketsTradedWith, ressourcesSmuggled, highestSingleSmugglingTransaction, marketsTradedWith, ressourcesTraded, averageTradingProfit, highestSingleTradingTransaction, quantityMined, materialsCollected, systemsVisited, planetsScannedToLevel2, planetsScannedToLevel3, EfficientScans, highestPayout, totalHyperspaceDistance, totalHyperspaceJumps, greatestDistanceFromStart, timePlayed, passengersMissionsAccepted, passengersMissionsDisgruntled, passengersMissionsBulk, passengersMissionsVIP, passengersMissionsDelivered, passengersMissionsEjected, searchRescueTraded, searchRescueCount, totalTGEncounters, TGScoutCount, engineersUsedCount, totalRecipesGenerated, recipesGeneratedRank1, recipesGeneratedRank2, recipesGeneratedRank3, recipesGeneratedRank4, recipesGeneratedRank5, hiredNpcCrew, firedNpcCrew, totalMulticrewTime, totalMulticrewTimeGunner, totalMulticrewTimeFighter, totalMulticrewCredits, totalMulticrewFines, materialTraderTradesCompledted, materialTraderMaterialsTraded, materialTraderEncodedMaterialsTraded, materialTraderGrade1Traded, materialTraderGrade2Traded, materialTraderGrade3Traded, materialTraderGrade4Traded, materialTraderGrade5Traded;
	String LastTGEncounterSystem, lastTGEncounterTime, lastTGEncounterShip;
	
	public StatisticsEvent(String timestamp, long currentWealth, long spentOnShips, long spentOnOutfitting,
			long spentOnRepairs, long spentOnFuel, long spentOnAmmoConsumables, long spentOnInsurance,
			long bountyHuntingProfit, long combatBondsProfit, long assassinationProfits, long totalFines,
			long totalBounties, long blackMarketsProfit, long averageSmugglingProfit,
			long marketProfit, long miningProfits, long explorationProfits, long searchRescueProfit,
			long totalNpcCrewWages, int bountiesReceived, int insuranceClaims, int ownedShipCount, int bountiesClaimed, int combatBonds,
			int assassinations, int highestSingleReward, int skimmersKilled, int notoriety, int fines,
			int highestBounty, int blackMartketsTradedWith, int ressourcesSmuggled,
			int highestSingleSmugglingTransaction, int marketsTradedWith, int ressourcesTraded,
			int averageTradingProfit, int highestSingleTradingTransaction, int quantityMined, int materialsCollected,
			int systemsVisited, int planetsScannedToLevel2, int planetsScannedToLevel3, int efficientScans,
			int highestPayout, int totalHyperspaceDistance, int totalHyperspaceJumps, int greatestDistanceFromStart,
			int timePlayed, int passengersMissionsAccepted, int passengersMissionsDisgruntled,
			int passengersMissionsBulk, int passengersMissionsVIP, int passengersMissionsDelivered,
			int passengersMissionsEjected, int searchRescueTraded, int searchRescueCount, int totalTGEncounters,
			int tGScoutCount, int engineersUsedCount, int totalRecipesGenerated, int recipesGeneratedRank1,
			int recipesGeneratedRank2, int recipesGeneratedRank3, int recipesGeneratedRank4, int recipesGeneratedRank5,
			int hiredNpcCrew, int firedNpcCrew, int totalMulticrewTime, int totalMulticrewTimeGunner,
			int totalMulticrewTimeFighter, int totalMulticrewCredits, int totalMulticrewFines,
			int materialTraderTradesCompledted, int materialTraderMaterialsTraded,
			int materialTraderEncodedMaterialsTraded, int materialTraderGrade1Traded, int materialTraderGrade2Traded,
			int materialTraderGrade3Traded, int materialTraderGrade4Traded, int materialTraderGrade5Traded,
			String lastTGEncounterSystem, String lastTGEncounterTime, String lastTGEncounterShip) {
		super(timestamp);
		this.currentWealth = currentWealth;
		this.spentOnShips = spentOnShips;
		this.spentOnOutfitting = spentOnOutfitting;
		this.spentOnRepairs = spentOnRepairs;
		this.spentOnFuel = spentOnFuel;
		this.spentOnAmmoConsumables = spentOnAmmoConsumables;
		this.spentOnInsurance = spentOnInsurance;
		this.bountyHuntingProfit = bountyHuntingProfit;
		this.combatBondsProfit = combatBondsProfit;
		this.assassinationProfits = assassinationProfits;
		this.totalFines = totalFines;
		this.bountiesReceived = bountiesReceived;
		this.totalBounties = totalBounties;
		this.blackMarketsProfit = blackMarketsProfit;
		this.averageSmugglingProfit = averageSmugglingProfit;
		this.marketProfit = marketProfit;
		this.miningProfits = miningProfits;
		this.explorationProfits = explorationProfits;
		this.searchRescueProfit = searchRescueProfit;
		this.totalNpcCrewWages = totalNpcCrewWages;
		this.insuranceClaims = insuranceClaims;
		this.ownedShipCount = ownedShipCount;
		this.bountiesClaimed = bountiesClaimed;
		this.combatBonds = combatBonds;
		this.assassinations = assassinations;
		this.highestSingleReward = highestSingleReward;
		this.skimmersKilled = skimmersKilled;
		this.notoriety = notoriety;
		this.fines = fines;
		this.highestBounty = highestBounty;
		this.blackMartketsTradedWith = blackMartketsTradedWith;
		this.ressourcesSmuggled = ressourcesSmuggled;
		this.highestSingleSmugglingTransaction = highestSingleSmugglingTransaction;
		this.marketsTradedWith = marketsTradedWith;
		this.ressourcesTraded = ressourcesTraded;
		this.averageTradingProfit = averageTradingProfit;
		this.highestSingleTradingTransaction = highestSingleTradingTransaction;
		this.quantityMined = quantityMined;
		this.materialsCollected = materialsCollected;
		this.systemsVisited = systemsVisited;
		this.planetsScannedToLevel2 = planetsScannedToLevel2;
		this.planetsScannedToLevel3 = planetsScannedToLevel3;
		EfficientScans = efficientScans;
		this.highestPayout = highestPayout;
		this.totalHyperspaceDistance = totalHyperspaceDistance;
		this.totalHyperspaceJumps = totalHyperspaceJumps;
		this.greatestDistanceFromStart = greatestDistanceFromStart;
		this.timePlayed = timePlayed;
		this.passengersMissionsAccepted = passengersMissionsAccepted;
		this.passengersMissionsDisgruntled = passengersMissionsDisgruntled;
		this.passengersMissionsBulk = passengersMissionsBulk;
		this.passengersMissionsVIP = passengersMissionsVIP;
		this.passengersMissionsDelivered = passengersMissionsDelivered;
		this.passengersMissionsEjected = passengersMissionsEjected;
		this.searchRescueTraded = searchRescueTraded;
		this.searchRescueCount = searchRescueCount;
		this.totalTGEncounters = totalTGEncounters;
		TGScoutCount = tGScoutCount;
		this.engineersUsedCount = engineersUsedCount;
		this.totalRecipesGenerated = totalRecipesGenerated;
		this.recipesGeneratedRank1 = recipesGeneratedRank1;
		this.recipesGeneratedRank2 = recipesGeneratedRank2;
		this.recipesGeneratedRank3 = recipesGeneratedRank3;
		this.recipesGeneratedRank4 = recipesGeneratedRank4;
		this.recipesGeneratedRank5 = recipesGeneratedRank5;
		this.hiredNpcCrew = hiredNpcCrew;
		this.firedNpcCrew = firedNpcCrew;
		this.totalMulticrewTime = totalMulticrewTime;
		this.totalMulticrewTimeGunner = totalMulticrewTimeGunner;
		this.totalMulticrewTimeFighter = totalMulticrewTimeFighter;
		this.totalMulticrewCredits = totalMulticrewCredits;
		this.totalMulticrewFines = totalMulticrewFines;
		this.materialTraderTradesCompledted = materialTraderTradesCompledted;
		this.materialTraderMaterialsTraded = materialTraderMaterialsTraded;
		this.materialTraderEncodedMaterialsTraded = materialTraderEncodedMaterialsTraded;
		this.materialTraderGrade1Traded = materialTraderGrade1Traded;
		this.materialTraderGrade2Traded = materialTraderGrade2Traded;
		this.materialTraderGrade3Traded = materialTraderGrade3Traded;
		this.materialTraderGrade4Traded = materialTraderGrade4Traded;
		this.materialTraderGrade5Traded = materialTraderGrade5Traded;
		LastTGEncounterSystem = lastTGEncounterSystem;
		this.lastTGEncounterTime = lastTGEncounterTime;
		this.lastTGEncounterShip = lastTGEncounterShip;
	}
	
	public long getCurrentWealth() {
		return currentWealth;
	}
	public long getSpentOnShips() {
		return spentOnShips;
	}
	public long getSpentOnOutfitting() {
		return spentOnOutfitting;
	}
	public long getSpentOnRepairs() {
		return spentOnRepairs;
	}
	public long getSpentOnFuel() {
		return spentOnFuel;
	}
	public long getSpentOnAmmoConsumables() {
		return spentOnAmmoConsumables;
	}
	public long getSpentOnInsurance() {
		return spentOnInsurance;
	}
	public long getBountyHuntingProfit() {
		return bountyHuntingProfit;
	}
	public long getCombatBondsProfit() {
		return combatBondsProfit;
	}
	public long getAssassinationProfits() {
		return assassinationProfits;
	}
	public long getTotalFines() {
		return totalFines;
	}
	public long getBountiesReceived() {
		return bountiesReceived;
	}
	public long getTotalBounties() {
		return totalBounties;
	}
	public long getBlackMarketsProfit() {
		return blackMarketsProfit;
	}
	public long getAverageSmugglingProfit() {
		return averageSmugglingProfit;
	}
	public long getMarketProfit() {
		return marketProfit;
	}
	public long getMiningProfits() {
		return miningProfits;
	}
	public long getExplorationProfits() {
		return explorationProfits;
	}
	public long getSearchRescueProfit() {
		return searchRescueProfit;
	}
	public long getTotalNpcCrewWages() {
		return totalNpcCrewWages;
	}
	public int getInsuranceClaims() {
		return insuranceClaims;
	}
	public int getOwnedShipCount() {
		return ownedShipCount;
	}
	public int getBountiesClaimed() {
		return bountiesClaimed;
	}
	public int getCombatBonds() {
		return combatBonds;
	}
	public int getAssassinations() {
		return assassinations;
	}
	public int getHighestSingleReward() {
		return highestSingleReward;
	}
	public int getSkimmersKilled() {
		return skimmersKilled;
	}
	public int getNotoriety() {
		return notoriety;
	}
	public int getFines() {
		return fines;
	}
	public int getHighestBounty() {
		return highestBounty;
	}
	public int getBlackMartketsTradedWith() {
		return blackMartketsTradedWith;
	}
	public int getRessourcesSmuggled() {
		return ressourcesSmuggled;
	}
	public int getHighestSingleSmugglingTransaction() {
		return highestSingleSmugglingTransaction;
	}
	public int getMarketsTradedWith() {
		return marketsTradedWith;
	}
	public int getRessourcesTraded() {
		return ressourcesTraded;
	}
	public int getAverageTradingProfit() {
		return averageTradingProfit;
	}
	public int getHighestSingleTradingTransaction() {
		return highestSingleTradingTransaction;
	}
	public int getQuantityMined() {
		return quantityMined;
	}
	public int getMaterialsCollected() {
		return materialsCollected;
	}
	public int getSystemsVisited() {
		return systemsVisited;
	}
	public int getPlanetsScannedToLevel2() {
		return planetsScannedToLevel2;
	}
	public int getPlanetsScannedToLevel3() {
		return planetsScannedToLevel3;
	}
	public int getEfficientScans() {
		return EfficientScans;
	}
	public int getHighestPayout() {
		return highestPayout;
	}
	public int getTotalHyperspaceDistance() {
		return totalHyperspaceDistance;
	}
	public int getTotalHyperspaceJumps() {
		return totalHyperspaceJumps;
	}
	public int getGreatestDistanceFromStart() {
		return greatestDistanceFromStart;
	}
	public int getTimePlayed() {
		return timePlayed;
	}
	public int getPassengersMissionsAccepted() {
		return passengersMissionsAccepted;
	}
	public int getPassengersMissionsDisgruntled() {
		return passengersMissionsDisgruntled;
	}
	public int getPassengersMissionsBulk() {
		return passengersMissionsBulk;
	}
	public int getPassengersMissionsVIP() {
		return passengersMissionsVIP;
	}
	public int getPassengersMissionsDelivered() {
		return passengersMissionsDelivered;
	}
	public int getPassengersMissionsEjected() {
		return passengersMissionsEjected;
	}
	public int getSearchRescueTraded() {
		return searchRescueTraded;
	}
	public int getSearchRescueCount() {
		return searchRescueCount;
	}
	public int getTotalTGEncounters() {
		return totalTGEncounters;
	}
	public int getTGScoutCount() {
		return TGScoutCount;
	}
	public int getEngineersUsedCount() {
		return engineersUsedCount;
	}
	public int getTotalRecipesGenerated() {
		return totalRecipesGenerated;
	}
	public int getRecipesGeneratedRank1() {
		return recipesGeneratedRank1;
	}
	public int getRecipesGeneratedRank2() {
		return recipesGeneratedRank2;
	}
	public int getRecipesGeneratedRank3() {
		return recipesGeneratedRank3;
	}
	public int getRecipesGeneratedRank4() {
		return recipesGeneratedRank4;
	}
	public int getRecipesGeneratedRank5() {
		return recipesGeneratedRank5;
	}
	public int getHiredNpcCrew() {
		return hiredNpcCrew;
	}
	public int getFiredNpcCrew() {
		return firedNpcCrew;
	}
	public int getTotalMulticrewTime() {
		return totalMulticrewTime;
	}
	public int getTotalMulticrewTimeGunner() {
		return totalMulticrewTimeGunner;
	}
	public int getTotalMulticrewTimeFighter() {
		return totalMulticrewTimeFighter;
	}
	public int getTotalMulticrewCredits() {
		return totalMulticrewCredits;
	}
	public int getTotalMulticrewFines() {
		return totalMulticrewFines;
	}
	public int getMaterialTraderTradesCompledted() {
		return materialTraderTradesCompledted;
	}
	public int getMaterialTraderMaterialsTraded() {
		return materialTraderMaterialsTraded;
	}
	public int getMaterialTraderEncodedMaterialsTraded() {
		return materialTraderEncodedMaterialsTraded;
	}
	public int getMaterialTraderGrade1Traded() {
		return materialTraderGrade1Traded;
	}
	public int getMaterialTraderGrade2Traded() {
		return materialTraderGrade2Traded;
	}
	public int getMaterialTraderGrade3Traded() {
		return materialTraderGrade3Traded;
	}
	public int getMaterialTraderGrade4Traded() {
		return materialTraderGrade4Traded;
	}
	public int getMaterialTraderGrade5Traded() {
		return materialTraderGrade5Traded;
	}
	public String getLastTGEncounterSystem() {
		return LastTGEncounterSystem;
	}
	public String getLastTGEncounterTime() {
		return lastTGEncounterTime;
	}
	public String getLastTGEncounterShip() {
		return lastTGEncounterShip;
	}
	
	
}
