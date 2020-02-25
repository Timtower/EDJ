package org.xenodev.edj.utils;

import org.xenodev.edj.events.ApproachBodyEvent;
import org.xenodev.edj.events.AsteroidCrackedEvent;
import org.xenodev.edj.events.BountyEvent;
import org.xenodev.edj.events.BuyAmmoEvent;
import org.xenodev.edj.events.BuyDronesEvent;
import org.xenodev.edj.events.BuyExplorationDataEvent;
import org.xenodev.edj.events.BuyTradeDataEvent;
import org.xenodev.edj.events.CapShipBondEvent;
import org.xenodev.edj.events.CargoDepotEvent;
import org.xenodev.edj.events.CargoEvent;
import org.xenodev.edj.events.ClearSavedGameEvent;
import org.xenodev.edj.events.CodexEntryEvent;
import org.xenodev.edj.events.CollectCargoEvent;
import org.xenodev.edj.events.CommanderEvent;
import org.xenodev.edj.events.CommunityGoalDiscardEvent;
import org.xenodev.edj.events.CommunityGoalEvent;
import org.xenodev.edj.events.CommunityGoalJoinEvent;
import org.xenodev.edj.events.CommunityGoalRewardEvent;
import org.xenodev.edj.events.CrewAssignEvent;
import org.xenodev.edj.events.CrewFireEvent;
import org.xenodev.edj.events.CrewHireEvent;
import org.xenodev.edj.events.DiedByWingEvent;
import org.xenodev.edj.events.DiedEvent;
import org.xenodev.edj.events.DiscoveryScanEvent;
import org.xenodev.edj.events.DockedEvent;
import org.xenodev.edj.events.DockingCancelledEvent;
import org.xenodev.edj.events.DockingDeniedEvent;
import org.xenodev.edj.events.DockingGrantedEvent;
import org.xenodev.edj.events.DockingRequestedEvent;
import org.xenodev.edj.events.EjectCargoEvent;
import org.xenodev.edj.events.EngineerContributionEvent;
import org.xenodev.edj.events.EngineerCraftEvent;
import org.xenodev.edj.events.EngineerProgressEvent;
import org.xenodev.edj.events.EscapeInterdictionEvent;
import org.xenodev.edj.events.FSDJumpEvent;
import org.xenodev.edj.events.FSDTargetEvent;
import org.xenodev.edj.events.FSSAllBodiesFoundEvent;
import org.xenodev.edj.events.FSSDiscoveryScanEvent;
import org.xenodev.edj.events.FSSSignalDiscoveredEvent;
import org.xenodev.edj.events.FactionKillBondEvent;
import org.xenodev.edj.events.FetchRemoteModuleEvent;
import org.xenodev.edj.events.FighterDestroyedEvent;
import org.xenodev.edj.events.HeatDamageEvent;
import org.xenodev.edj.events.HeatWarningEvent;
import org.xenodev.edj.events.HullDamageEvent;
import org.xenodev.edj.events.InterdictedByNpcEvent;
import org.xenodev.edj.events.InterdictedByPlayerEvent;
import org.xenodev.edj.events.InterdictionByNpcEvent;
import org.xenodev.edj.events.InterdictionByPlayerEvent;
import org.xenodev.edj.events.LeaveBodyEvent;
import org.xenodev.edj.events.LiftoffEvent;
import org.xenodev.edj.events.LoadGameEvent;
import org.xenodev.edj.events.LoadoutEvent;
import org.xenodev.edj.events.LocationEvent;
import org.xenodev.edj.events.MarketBuyEvent;
import org.xenodev.edj.events.MarketEvent;
import org.xenodev.edj.events.MarketSellEvent;
import org.xenodev.edj.events.MaterialCollectedEvent;
import org.xenodev.edj.events.MaterialDiscardedEvent;
import org.xenodev.edj.events.MaterialDiscoveredEvent;
import org.xenodev.edj.events.MaterialsEvent;
import org.xenodev.edj.events.MiningRefinedEvent;
import org.xenodev.edj.events.MissionsEvent;
import org.xenodev.edj.events.MultiSellExplorationDataEvent;
import org.xenodev.edj.events.NavBeaconScanEvent;
import org.xenodev.edj.events.NewCommanderEvent;
import org.xenodev.edj.events.PassengersEvent;
import org.xenodev.edj.events.PowerplayEvent;
import org.xenodev.edj.events.ProgressEvent;
import org.xenodev.edj.events.PvPKillEvent;
import org.xenodev.edj.events.RankEvent;
import org.xenodev.edj.events.ReputationEvent;
import org.xenodev.edj.events.SAAScanCompleteEvent;
import org.xenodev.edj.events.SRVDestroyedEvent;
import org.xenodev.edj.events.ScanEvent;
import org.xenodev.edj.events.ScreenshotEvent;
import org.xenodev.edj.events.SellExplorationDataEvent;
import org.xenodev.edj.events.ShieldStateEvent;
import org.xenodev.edj.events.ShipTargetedEvent;
import org.xenodev.edj.events.StartJumpEvent;
import org.xenodev.edj.events.StatisticsEvent;
import org.xenodev.edj.events.SupercruiseEntryEvent;
import org.xenodev.edj.events.SupercruiseExitEvent;
import org.xenodev.edj.events.TouchdownEvent;
import org.xenodev.edj.events.UnderAttackEvent;
import org.xenodev.edj.events.UndockedEvent;

public abstract class EventListener {
	
	//Startup Events
	public void onCargoEvent(CargoEvent event) {}
	public void onClearSavedGameEvent(ClearSavedGameEvent event) {}
	public void onCommanderEvent(CommanderEvent event) {}
	public void onLoadoutEvent(LoadoutEvent event) {}
	public void onMaterialsEvent(MaterialsEvent event) {}
	public void onMissionEvent(MissionsEvent event) {}
	public void onNewCommanderEvent(NewCommanderEvent event) {}
	public void onLoadGameEvent(LoadGameEvent event) {}
	//public void onPassengers(PassengersEvent event) {} TDOD: Missing JSON Event Data
	public void onPowerPlayEvent(PowerplayEvent event) {}
	public void onProgressEvent(ProgressEvent event) {}
	public void onRankEvent(RankEvent event) {}
	public void onReputationEvent(ReputationEvent event) {}
	public void onStatisticsEvent(StatisticsEvent event) {}
	
	//Travel Events
	public void onApproachBodyEvent(ApproachBodyEvent event) {}
	public void onDockedEvent(DockedEvent event) {}
	public void onDockingDeniedEvent(DockingDeniedEvent event) {}
	public void onDockingGrantedEvent(DockingGrantedEvent event) {}
	public void onDockingCancelledEvent(DockingCancelledEvent event) {}
	public void onDockingRequestedEvent(DockingRequestedEvent event) {}
	public void onFSDJumpEvent(FSDJumpEvent event) {}
	public void onFSDTargetEvent(FSDTargetEvent event) {}
	public void onLeaveBodyEvent(LeaveBodyEvent event) {}
	public void onLiftoffEvent(LiftoffEvent event) {}
	public void onLocationEvent(LocationEvent event) {}
	public void onStartJumpEvent(StartJumpEvent event) {}
	public void onSupercruiseEntryEvent(SupercruiseEntryEvent event) {}
	public void onSupercruiseExitEvent(SupercruiseExitEvent event) {}
	public void onTouchdownEvent(TouchdownEvent event) {}
	public void onUndockedEvent(UndockedEvent event) {}
	
	//Combat Events
	public void onBountyEvent(BountyEvent event) {}
	public void onEscapeInterdictionEvent(EscapeInterdictionEvent event) {}
	public void onFighterDestroyedEvent(FighterDestroyedEvent event) {}
	public void onCapShipBondEvent(CapShipBondEvent event) {}
	public void onDiedByWingEvent(DiedByWingEvent event) {}
	public void onDiedEvent(DiedEvent event) {}
	public void onFactionKillBondEvent(FactionKillBondEvent event) {}
	public void onHeatDamageEvent(HeatDamageEvent event) {}
	public void onHeatWarningEvent(HeatWarningEvent heatWarningEvent) {}
	public void onPassengerEvent(PassengersEvent event) {}
	public void onHullDamageEvent(HullDamageEvent event) {}
	public void onInterdictedByPlayerEvent(InterdictedByPlayerEvent event) {}
	public void onInterdictedByNpcEvent(InterdictedByNpcEvent event) {}
	public void onInterdictionByPlayerEvent(InterdictionByPlayerEvent event) {}
	public void onInterdictionByNpcEvent(InterdictionByNpcEvent event) {}
	public void onPvPKillEvent(PvPKillEvent event) {}
	public void onShieldStateEvent(ShieldStateEvent event) {}
	public void onShipTargetedEvent(ShipTargetedEvent event) {}
	public void onSRVDestroyedEvent(SRVDestroyedEvent event) {}
	public void onUnderAttackEvent(UnderAttackEvent event) {}
	
	//Exploration
	public void onCodexEntryEvent(CodexEntryEvent event) {}
	public void onDiscoveryScanEvent(DiscoveryScanEvent event) {}
	public void onScanEvent(ScanEvent event) {}
	public void onFSSAllBodiesFoundEvent(FSSAllBodiesFoundEvent event) {}
	public void onFSSDiscoveryScanEvent(FSSDiscoveryScanEvent event) {}
	public void onFSSSignalDiscoveredEvent(FSSSignalDiscoveredEvent event) {}
	public void onMaterialCollectedEvent(MaterialCollectedEvent event) {}
	public void onMaterialDiscardedEvent(MaterialDiscardedEvent event) {}
	public void onMaterialDiscoveredEvent(MaterialDiscoveredEvent event) {}
	public void onMultiSellExplorationDataEvent(MultiSellExplorationDataEvent event) {}
	public void onNavBeaconScanEvent(NavBeaconScanEvent event) {}
	public void onBuyExplorationDataEvent(BuyExplorationDataEvent event) {}
	public void onSAAScanCompleteEvent(SAAScanCompleteEvent event) {}
	public void onSellExplorationDataEvent(SellExplorationDataEvent event) {} 
	public void onScreenshotEvent(ScreenshotEvent event) {}
	
	//Trade
	public void onAsteroidCrackedEvet(AsteroidCrackedEvent event) {}
	public void onBuyTradeDataEvent(BuyTradeDataEvent event) {}
	public void onCollectCargoEvent(CollectCargoEvent event) {}
	public void onEjectCargoEvent(EjectCargoEvent event) {}
	public void onMarketBuyEvent(MarketBuyEvent event) {}
	public void onMarketSellEvent(MarketSellEvent event) {}
	public void onMiningRefinedEvent(MiningRefinedEvent event) {}
	
	//Station Services
	public void onBuyAmmoEvent(BuyAmmoEvent event) {}
	public void onBuyDronesEvent(BuyDronesEvent event) {}
	public void onCargoDepotEvent(CargoDepotEvent event) {}
	public void onCommunityGoalEvent(CommunityGoalEvent event) {}
	public void onCommunityGoalDiscardEvent(CommunityGoalDiscardEvent event) {}
	public void onCommunityGoalJoinEvent(CommunityGoalJoinEvent event) {}
	public void onCommunityGoalRewardEvent(CommunityGoalRewardEvent event) {}
	public void onCrewAssignEvent(CrewAssignEvent event) {}
	public void onCrewFireEvent(CrewFireEvent event) {}
	public void onCrewHireEvent(CrewHireEvent event) {}
	public void onEngineerContributionEvent(EngineerContributionEvent event) {}
	public void onEngineerCraftEvent(EngineerCraftEvent event) {}
	public void onEngineerProgressEvent(EngineerProgressEvent event) {}
	public void onFetchRemoteModuleEvent(FetchRemoteModuleEvent event) {}
	public void onMarketEvent(MarketEvent event) {}
	
}
