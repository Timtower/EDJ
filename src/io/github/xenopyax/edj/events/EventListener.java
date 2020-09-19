package io.github.xenopyax.edj.events;

import io.github.xenopyax.edj.events.combat.BountyEvent;
import io.github.xenopyax.edj.events.combat.CapShipBondEvent;
import io.github.xenopyax.edj.events.combat.DiedByWingEvent;
import io.github.xenopyax.edj.events.combat.DiedEvent;
import io.github.xenopyax.edj.events.combat.EscapeInterdictionEvent;
import io.github.xenopyax.edj.events.combat.FactionKillBondEvent;
import io.github.xenopyax.edj.events.combat.FighterDestroyedEvent;
import io.github.xenopyax.edj.events.combat.HeatDamageEvent;
import io.github.xenopyax.edj.events.combat.HeatWarningEvent;
import io.github.xenopyax.edj.events.combat.HullDamageEvent;
import io.github.xenopyax.edj.events.combat.InterdictedEvent;
import io.github.xenopyax.edj.events.combat.InterdictionEvent;
import io.github.xenopyax.edj.events.combat.PvPKillEvent;
import io.github.xenopyax.edj.events.combat.SRVDestroyedEvent;
import io.github.xenopyax.edj.events.combat.ShieldStateEvent;
import io.github.xenopyax.edj.events.combat.ShipTargetedEvent;
import io.github.xenopyax.edj.events.combat.UnderAttackEvent;
import io.github.xenopyax.edj.events.exploration.BuyExplorationDataEvent;
import io.github.xenopyax.edj.events.exploration.CodexEntryEvent;
import io.github.xenopyax.edj.events.exploration.DiscoveryScanEvent;
import io.github.xenopyax.edj.events.exploration.FSSAllBodiesFoundEvent;
import io.github.xenopyax.edj.events.exploration.FSSDiscoveryScanEvent;
import io.github.xenopyax.edj.events.exploration.FSSSignalDiscoveredEvent;
import io.github.xenopyax.edj.events.exploration.MaterialCollectedEvent;
import io.github.xenopyax.edj.events.exploration.MaterialDiscardedEvent;
import io.github.xenopyax.edj.events.exploration.MaterialDiscoveredEvent;
import io.github.xenopyax.edj.events.exploration.MultiSellExplorationDataEvent;
import io.github.xenopyax.edj.events.exploration.NavBeaconScanEvent;
import io.github.xenopyax.edj.events.exploration.SAAScanCompleteEvent;
import io.github.xenopyax.edj.events.exploration.ScanEvent;
import io.github.xenopyax.edj.events.exploration.ScreenshotEvent;
import io.github.xenopyax.edj.events.exploration.SellExplorationDataEvent;
import io.github.xenopyax.edj.events.fleetcarrier.CarrierBankTransferEvent;
import io.github.xenopyax.edj.events.fleetcarrier.CarrierCrewServicesEvent;
import io.github.xenopyax.edj.events.fleetcarrier.CarrierDepositFuelEvent;
import io.github.xenopyax.edj.events.fleetcarrier.CarrierFinanceEvent;
import io.github.xenopyax.edj.events.inventory.CargoTransferEvent;
import io.github.xenopyax.edj.events.startup.CargoEvent;
import io.github.xenopyax.edj.events.startup.ClearSavedGameEvent;
import io.github.xenopyax.edj.events.startup.CommanderEvent;
import io.github.xenopyax.edj.events.startup.LoadGameEvent;
import io.github.xenopyax.edj.events.startup.LoadoutEvent;
import io.github.xenopyax.edj.events.startup.MaterialsEvent;
import io.github.xenopyax.edj.events.startup.MissionsEvent;
import io.github.xenopyax.edj.events.startup.NewCommanderEvent;
import io.github.xenopyax.edj.events.startup.PassengersEvent;
import io.github.xenopyax.edj.events.startup.PowerplayEvent;
import io.github.xenopyax.edj.events.startup.ProgressEvent;
import io.github.xenopyax.edj.events.startup.RankEvent;
import io.github.xenopyax.edj.events.startup.ReputationEvent;
import io.github.xenopyax.edj.events.startup.StatisticsEvent;
import io.github.xenopyax.edj.events.stationservices.BuyAmmoEvent;
import io.github.xenopyax.edj.events.stationservices.BuyDronesEvent;
import io.github.xenopyax.edj.events.stationservices.CargoDepotEvent;
import io.github.xenopyax.edj.events.stationservices.CommunityGoalDiscardEvent;
import io.github.xenopyax.edj.events.stationservices.CommunityGoalEvent;
import io.github.xenopyax.edj.events.stationservices.CommunityGoalJoinEvent;
import io.github.xenopyax.edj.events.stationservices.CommunityGoalRewardEvent;
import io.github.xenopyax.edj.events.stationservices.CrewAssignEvent;
import io.github.xenopyax.edj.events.stationservices.CrewFireEvent;
import io.github.xenopyax.edj.events.stationservices.CrewHireEvent;
import io.github.xenopyax.edj.events.stationservices.EngineerContributionEvent;
import io.github.xenopyax.edj.events.stationservices.EngineerCraftEvent;
import io.github.xenopyax.edj.events.stationservices.EngineerProgressEvent;
import io.github.xenopyax.edj.events.stationservices.FetchRemoteModuleEvent;
import io.github.xenopyax.edj.events.stationservices.MarketEvent;
import io.github.xenopyax.edj.events.stationservices.MassModuleStoreEvent;
import io.github.xenopyax.edj.events.stationservices.MaterialTradeEvent;
import io.github.xenopyax.edj.events.stationservices.MissionAbandonedEvent;
import io.github.xenopyax.edj.events.stationservices.MissionAcceptedEvent;
import io.github.xenopyax.edj.events.stationservices.MissionCompletedEvent;
import io.github.xenopyax.edj.events.stationservices.MissionFailedEvent;
import io.github.xenopyax.edj.events.stationservices.MissionRedirectedEvent;
import io.github.xenopyax.edj.events.stationservices.ModuleBuyEvent;
import io.github.xenopyax.edj.events.stationservices.ModuleRetrieveEvent;
import io.github.xenopyax.edj.events.stationservices.ModuleSellEvent;
import io.github.xenopyax.edj.events.stationservices.ModuleSellRemote;
import io.github.xenopyax.edj.events.stationservices.ModuleStoreEvent;
import io.github.xenopyax.edj.events.stationservices.ModuleSwapEvent;
import io.github.xenopyax.edj.events.stationservices.OutfittingEvent;
import io.github.xenopyax.edj.events.stationservices.PayBountiesEvent;
import io.github.xenopyax.edj.events.stationservices.PayFinesEvent;
import io.github.xenopyax.edj.events.stationservices.RedeemVoucherEvent;
import io.github.xenopyax.edj.events.stationservices.RefuelAllEvent;
import io.github.xenopyax.edj.events.stationservices.RefuelPartialEvent;
import io.github.xenopyax.edj.events.stationservices.RepairAllEvent;
import io.github.xenopyax.edj.events.stationservices.RepairEvent;
import io.github.xenopyax.edj.events.stationservices.RestockVehicleEvent;
import io.github.xenopyax.edj.events.stationservices.ScientificResearchEvent;
import io.github.xenopyax.edj.events.stationservices.SearchAndRescueEvent;
import io.github.xenopyax.edj.events.stationservices.SellDronesEvent;
import io.github.xenopyax.edj.events.stationservices.SellShipOnRebuyEvent;
import io.github.xenopyax.edj.events.stationservices.SetUserShipNameEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardBuyEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardNewEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardSellEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardSwapEvent;
import io.github.xenopyax.edj.events.stationservices.ShipyardTransferEvent;
import io.github.xenopyax.edj.events.stationservices.StoredModulesEvent;
import io.github.xenopyax.edj.events.stationservices.StoredShipsEvent;
import io.github.xenopyax.edj.events.stationservices.TechnologyBrokerEvent;
import io.github.xenopyax.edj.events.trade.AsteroidCrackedEvent;
import io.github.xenopyax.edj.events.trade.BuyTradeDataEvent;
import io.github.xenopyax.edj.events.trade.CollectCargoEvent;
import io.github.xenopyax.edj.events.trade.EjectCargoEvent;
import io.github.xenopyax.edj.events.trade.MarketBuyEvent;
import io.github.xenopyax.edj.events.trade.MarketSellEvent;
import io.github.xenopyax.edj.events.trade.MiningRefinedEvent;
import io.github.xenopyax.edj.events.travel.ApproachBodyEvent;
import io.github.xenopyax.edj.events.travel.ApproachSettlementEvent;
import io.github.xenopyax.edj.events.travel.DockedEvent;
import io.github.xenopyax.edj.events.travel.DockingCancelledEvent;
import io.github.xenopyax.edj.events.travel.DockingDeniedEvent;
import io.github.xenopyax.edj.events.travel.DockingGrantedEvent;
import io.github.xenopyax.edj.events.travel.DockingRequestedEvent;
import io.github.xenopyax.edj.events.travel.FSDJumpEvent;
import io.github.xenopyax.edj.events.travel.FSDTargetEvent;
import io.github.xenopyax.edj.events.travel.LeaveBodyEvent;
import io.github.xenopyax.edj.events.travel.LiftoffEvent;
import io.github.xenopyax.edj.events.travel.LocationEvent;
import io.github.xenopyax.edj.events.travel.StartJumpEvent;
import io.github.xenopyax.edj.events.travel.SupercruiseEntryEvent;
import io.github.xenopyax.edj.events.travel.SupercruiseExitEvent;
import io.github.xenopyax.edj.events.travel.TouchdownEvent;
import io.github.xenopyax.edj.events.travel.UndockedEvent;

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
	
	// TODO: Needs sorting
	public void onApproachSettlementEvent(ApproachSettlementEvent event) {}
	public void onCargoTransferEvent(CargoTransferEvent event) {}
	public void onCarrierBankTransferEvent(CarrierBankTransferEvent event) {}
	public void onCarrierCrewServicesEvent(CarrierCrewServicesEvent event) {}
	public void onCarrierDepositFuelEvent(CarrierDepositFuelEvent event) {}
	public void onCarrierFinanceEvent(CarrierFinanceEvent event) {}
	
}
