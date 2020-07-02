package org.xenodev.edj.events;

import org.xenodev.edj.events.combat.BountyEvent;
import org.xenodev.edj.events.combat.CapShipBondEvent;
import org.xenodev.edj.events.combat.DiedByWingEvent;
import org.xenodev.edj.events.combat.DiedEvent;
import org.xenodev.edj.events.combat.EscapeInterdictionEvent;
import org.xenodev.edj.events.combat.FactionKillBondEvent;
import org.xenodev.edj.events.combat.FighterDestroyedEvent;
import org.xenodev.edj.events.combat.HeatDamageEvent;
import org.xenodev.edj.events.combat.HeatWarningEvent;
import org.xenodev.edj.events.combat.HullDamageEvent;
import org.xenodev.edj.events.combat.InterdictedEvent;
import org.xenodev.edj.events.combat.InterdictionEvent;
import org.xenodev.edj.events.combat.PvPKillEvent;
import org.xenodev.edj.events.combat.SRVDestroyedEvent;
import org.xenodev.edj.events.combat.ShieldStateEvent;
import org.xenodev.edj.events.combat.ShipTargetedEvent;
import org.xenodev.edj.events.combat.UnderAttackEvent;
import org.xenodev.edj.events.exploration.BuyExplorationDataEvent;
import org.xenodev.edj.events.exploration.CodexEntryEvent;
import org.xenodev.edj.events.exploration.DiscoveryScanEvent;
import org.xenodev.edj.events.exploration.FSSAllBodiesFoundEvent;
import org.xenodev.edj.events.exploration.FSSDiscoveryScanEvent;
import org.xenodev.edj.events.exploration.FSSSignalDiscoveredEvent;
import org.xenodev.edj.events.exploration.MaterialCollectedEvent;
import org.xenodev.edj.events.exploration.MaterialDiscardedEvent;
import org.xenodev.edj.events.exploration.MaterialDiscoveredEvent;
import org.xenodev.edj.events.exploration.MultiSellExplorationDataEvent;
import org.xenodev.edj.events.exploration.NavBeaconScanEvent;
import org.xenodev.edj.events.exploration.SAAScanCompleteEvent;
import org.xenodev.edj.events.exploration.ScanEvent;
import org.xenodev.edj.events.exploration.ScreenshotEvent;
import org.xenodev.edj.events.exploration.SellExplorationDataEvent;
import org.xenodev.edj.events.startup.CargoEvent;
import org.xenodev.edj.events.startup.ClearSavedGameEvent;
import org.xenodev.edj.events.startup.CommanderEvent;
import org.xenodev.edj.events.startup.LoadGameEvent;
import org.xenodev.edj.events.startup.LoadoutEvent;
import org.xenodev.edj.events.startup.MaterialsEvent;
import org.xenodev.edj.events.startup.MissionsEvent;
import org.xenodev.edj.events.startup.NewCommanderEvent;
import org.xenodev.edj.events.startup.PassengersEvent;
import org.xenodev.edj.events.startup.PowerplayEvent;
import org.xenodev.edj.events.startup.ProgressEvent;
import org.xenodev.edj.events.startup.RankEvent;
import org.xenodev.edj.events.startup.ReputationEvent;
import org.xenodev.edj.events.startup.StatisticsEvent;
import org.xenodev.edj.events.stationservices.BuyAmmoEvent;
import org.xenodev.edj.events.stationservices.BuyDronesEvent;
import org.xenodev.edj.events.stationservices.CargoDepotEvent;
import org.xenodev.edj.events.stationservices.CommunityGoalDiscardEvent;
import org.xenodev.edj.events.stationservices.CommunityGoalEvent;
import org.xenodev.edj.events.stationservices.CommunityGoalJoinEvent;
import org.xenodev.edj.events.stationservices.CommunityGoalRewardEvent;
import org.xenodev.edj.events.stationservices.CrewAssignEvent;
import org.xenodev.edj.events.stationservices.CrewFireEvent;
import org.xenodev.edj.events.stationservices.CrewHireEvent;
import org.xenodev.edj.events.stationservices.EngineerContributionEvent;
import org.xenodev.edj.events.stationservices.EngineerCraftEvent;
import org.xenodev.edj.events.stationservices.EngineerProgressEvent;
import org.xenodev.edj.events.stationservices.FetchRemoteModuleEvent;
import org.xenodev.edj.events.stationservices.MarketEvent;
import org.xenodev.edj.events.stationservices.MassModuleStoreEvent;
import org.xenodev.edj.events.stationservices.MaterialTradeEvent;
import org.xenodev.edj.events.stationservices.MissionAbandonedEvent;
import org.xenodev.edj.events.stationservices.MissionAcceptedEvent;
import org.xenodev.edj.events.stationservices.MissionCompletedEvent;
import org.xenodev.edj.events.stationservices.MissionFailedEvent;
import org.xenodev.edj.events.stationservices.MissionRedirectedEvent;
import org.xenodev.edj.events.stationservices.ModuleBuyEvent;
import org.xenodev.edj.events.stationservices.ModuleRetrieveEvent;
import org.xenodev.edj.events.stationservices.ModuleSellEvent;
import org.xenodev.edj.events.stationservices.ModuleSellRemote;
import org.xenodev.edj.events.stationservices.ModuleStoreEvent;
import org.xenodev.edj.events.stationservices.ModuleSwapEvent;
import org.xenodev.edj.events.stationservices.OutfittingEvent;
import org.xenodev.edj.events.stationservices.PayBountiesEvent;
import org.xenodev.edj.events.stationservices.PayFinesEvent;
import org.xenodev.edj.events.stationservices.RedeemVoucherEvent;
import org.xenodev.edj.events.stationservices.RefuelAllEvent;
import org.xenodev.edj.events.stationservices.RefuelPartialEvent;
import org.xenodev.edj.events.stationservices.RepairAllEvent;
import org.xenodev.edj.events.stationservices.RepairEvent;
import org.xenodev.edj.events.stationservices.RestockVehicleEvent;
import org.xenodev.edj.events.stationservices.ScientificResearchEvent;
import org.xenodev.edj.events.stationservices.SearchAndRescueEvent;
import org.xenodev.edj.events.stationservices.SellDronesEvent;
import org.xenodev.edj.events.stationservices.SellShipOnRebuyEvent;
import org.xenodev.edj.events.stationservices.SetUserShipNameEvent;
import org.xenodev.edj.events.stationservices.ShipyardBuyEvent;
import org.xenodev.edj.events.stationservices.ShipyardEvent;
import org.xenodev.edj.events.stationservices.ShipyardNewEvent;
import org.xenodev.edj.events.stationservices.ShipyardSellEvent;
import org.xenodev.edj.events.stationservices.ShipyardSwapEvent;
import org.xenodev.edj.events.stationservices.ShipyardTransferEvent;
import org.xenodev.edj.events.stationservices.StoredModulesEvent;
import org.xenodev.edj.events.stationservices.StoredShipsEvent;
import org.xenodev.edj.events.stationservices.TechnologyBrokerEvent;
import org.xenodev.edj.events.trade.AsteroidCrackedEvent;
import org.xenodev.edj.events.trade.BuyTradeDataEvent;
import org.xenodev.edj.events.trade.CollectCargoEvent;
import org.xenodev.edj.events.trade.EjectCargoEvent;
import org.xenodev.edj.events.trade.MarketBuyEvent;
import org.xenodev.edj.events.trade.MarketSellEvent;
import org.xenodev.edj.events.trade.MiningRefinedEvent;
import org.xenodev.edj.events.travel.ApproachBodyEvent;
import org.xenodev.edj.events.travel.ApproachSettlementEvent;
import org.xenodev.edj.events.travel.DockedEvent;
import org.xenodev.edj.events.travel.DockingCancelledEvent;
import org.xenodev.edj.events.travel.DockingDeniedEvent;
import org.xenodev.edj.events.travel.DockingGrantedEvent;
import org.xenodev.edj.events.travel.DockingRequestedEvent;
import org.xenodev.edj.events.travel.FSDJumpEvent;
import org.xenodev.edj.events.travel.FSDTargetEvent;
import org.xenodev.edj.events.travel.LeaveBodyEvent;
import org.xenodev.edj.events.travel.LiftoffEvent;
import org.xenodev.edj.events.travel.LocationEvent;
import org.xenodev.edj.events.travel.StartJumpEvent;
import org.xenodev.edj.events.travel.SupercruiseEntryEvent;
import org.xenodev.edj.events.travel.SupercruiseExitEvent;
import org.xenodev.edj.events.travel.TouchdownEvent;
import org.xenodev.edj.events.travel.UndockedEvent;

/**
 * The Eventlistener to extend from to execute code when a certain event with a registered eventlistener has been found.
 * <p>
 * <pre>{@code 
 * public class FSDJumpListener extends Eventlistener {
 * 
 * 	@Override
 * 	public void onFSDJumpEvent(FSDJumpEvent event) {
 * 		//TODO: Code to execute when an FSDJump event is detected
 * 	}
 * 
 * }</pre>
 * 
 * @author XenoPyax
 *
 */
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
	public void onPassengers(PassengersEvent event) {}
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
	public void onInterdictedEvent(InterdictedEvent event) {}
	public void onInterdictionEvent(InterdictionEvent event) {}
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
	public void onMassModuleStore(MassModuleStoreEvent event) {}
	public void onMaterialTrade(MaterialTradeEvent event) {}
	public void onMissionAbandoned(MissionAbandonedEvent event) {}
	public void onMissionAccepted(MissionAcceptedEvent event) {}
	public void onMissionCompleted(MissionCompletedEvent event) {}
	public void onMissionFailed(MissionFailedEvent event) {}
	public void onMissionRedirected(MissionRedirectedEvent event) {}
	public void onModuleBuy(ModuleBuyEvent event) {}
	public void onModuleRetrieve(ModuleRetrieveEvent event) {}
	public void onModuleSell(ModuleSellEvent event) {}
	public void onModuleSellRemote(ModuleSellRemote event) {}
	public void onModuleStore(ModuleStoreEvent event) {}
	public void onModuleSwap(ModuleSwapEvent event) {}
	public void onOutfitting(OutfittingEvent event) {}
	public void onPayBounties(PayBountiesEvent event) {}
	public void onPayFines(PayFinesEvent event) {}
	public void onRedeemVoucher(RedeemVoucherEvent event) {}
	public void onRefuelAll(RefuelAllEvent event) {}
	public void onRefuelPartial(RefuelPartialEvent event) {}
	public void onRepair(RepairEvent event) {}
	public void onRepairAll(RepairAllEvent event) {}
	public void onRestockVehicle(RestockVehicleEvent event) {}
	public void onScientificResearch(ScientificResearchEvent event) {}
	public void onSearchAndRescue(SearchAndRescueEvent event) {}
	public void onSellDrones(SellDronesEvent event) {}
	public void onSellShipOnRebuy(SellShipOnRebuyEvent event) {}
	public void onSetUserShipName(SetUserShipNameEvent event) {}
	public void onShipyard(ShipyardEvent event) {}
	public void onShipyardBuy(ShipyardBuyEvent eveent) {}
	public void onShipyardNew(ShipyardNewEvent event) {}
	public void onShipyardSell(ShipyardSellEvent event) {}
	public void onShipyardTransfer(ShipyardTransferEvent event) {}
	public void onShipyardSwap(ShipyardSwapEvent event) {}
	public void onStoredModules(StoredModulesEvent event) {}
	public void onStoredShips(StoredShipsEvent event) {}
	public void onTechnologyBrokerEvent(TechnologyBrokerEvent event) {}
	public void onApproachSettlementEvent(ApproachSettlementEvent event) {}
	
}
