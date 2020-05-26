package org.xenodev.edj;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xenodev.edj.events.*;
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
import org.xenodev.edj.events.trade.AsteroidCrackedEvent;
import org.xenodev.edj.events.trade.BuyTradeDataEvent;
import org.xenodev.edj.events.trade.CollectCargoEvent;
import org.xenodev.edj.events.trade.EjectCargoEvent;
import org.xenodev.edj.events.trade.MarketBuyEvent;
import org.xenodev.edj.events.trade.MarketSellEvent;
import org.xenodev.edj.events.trade.MiningRefinedEvent;
import org.xenodev.edj.events.travel.ApproachBodyEvent;
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
import org.xenodev.edj.utils.FileHandler;
import org.xenodev.edj.utils.UpdateChecker;

import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class EDJApiBuilder {
	
	private List<EventListener> listenerList = new ArrayList<>();
	private String watchFileName = FileHandler.getLatestJournalFile().getName();
	private Integer lineCount = 0;
	private Boolean debug;
	
	public EDJApiBuilder(Boolean debug) {
		this.debug = debug;
		new UpdateChecker().checkIsLatestVersion();
	}
	
	public void runTests() {
		//TODO: run testes for all events
	}
	
    /**
     * Register a class so it can be listen to.
     * 
     * @param listener
     */
    public EDJApiBuilder addListener(EventListener... listeners) {
    	for(EventListener listener : listeners) {
    		listenerList.add(listener);
    	}
        return this;
    }
    
    public EDJApiBuilder addListener(EventListener listener) {
    	listenerList.add(listener);
        return this;
    }
    
    public EDJApi build() {
    	
    	propagateEvents();
    	
    	//TODO: return api
		return new EDJApi();
    }
    
    /**
     * Start the Watcher and fire events when file changes are detected.
     * @return 
     */
    private void propagateEvents() {
        // We obtain the file system of the Path
        FileSystem fileSystem = EDJApi.getJournalDir().getFileSystem();

        // We create the new WatchService using the try-with-resources block
        try (WatchService service = fileSystem.newWatchService()) {
            // We watch for modification events
        	EDJApi.getJournalDir().register(service, ENTRY_MODIFY);

            // Start the infinite polling loop
            while (true) {
                // Wait for the next event
                WatchKey watchKey = service.take();

                for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                    // Get the type of the event
                    Kind<?> kind = watchEvent.kind();

                    if (kind == ENTRY_MODIFY) {
                        Path watchEventPath = (Path) watchEvent.context();
                        
                        // Call this if the right file is involved || Latest File Only
                        if (watchEventPath.toString().equals(watchFileName)) {
                            //File has been modified, call event registered
                        	listenerList.forEach(l -> {
                                if (!l.getClass().equals(EventListener.class)) {
                                	try {
                                		List<String> journalEntries = Files.readAllLines(new File(EDJApi.getJournalDir() + "/" + watchEventPath).toPath());
                                		
										for(int i = lineCount; i < journalEntries.size(); i++) {
											if(debug) System.out.println(journalEntries.get(i));
											
											fireEvent(new JSONObject(journalEntries.get(i)), l);
											
											lineCount++;
										}
										
										if(lineCount == journalEntries.size()) {
											  //Check if is still latest file
					                        if(watchFileName.equals(FileHandler.getLatestJournalFile().getName())) {
					                        	watchFileName = FileHandler.getLatestJournalFile().getName();
					                        }
										}
										
									} catch (JSONException | IOException e) {
										e.printStackTrace();
									}
                                }
                            });

                        }
                    }
                }

                if (!watchKey.reset()) {
                    // Exit if no longer valid
                    break;
                }

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    	
    }

	private void fireEvent(JSONObject json, EventListener listener) {
		String timestamp = json.pullString("timestamp");
		String event = json.pullString("event");
		
		switch(event) {
		case "Cargo":
			if(json.has("Inventory")) {
				CargoEvent cargoEvent = new CargoEvent(timestamp, json);
				listener.onCargoEvent(cargoEvent);
			}
			break;
		case "ClearSavedGame":
			ClearSavedGameEvent clearSavedGameEvent = new ClearSavedGameEvent(timestamp, json);
			listener.onClearSavedGameEvent(clearSavedGameEvent);
			break;
		case "Commander":
			CommanderEvent commanderEvent = new CommanderEvent(timestamp, json);
			listener.onCommanderEvent(commanderEvent);
			break;
		case "Loadout":
			LoadoutEvent loadoutEvent = new LoadoutEvent(timestamp, json);
			listener.onLoadoutEvent(loadoutEvent);
			break;
		case "Materials":
			MaterialsEvent materialEvent = new MaterialsEvent(timestamp, json);
			listener.onMaterialsEvent(materialEvent);
			break;
		case "Missions":
			MissionsEvent missionEvent = new MissionsEvent(timestamp, json);
			listener.onMissionEvent(missionEvent);
			break;
		case "NewCommander":
			NewCommanderEvent newCommanderEvent = new NewCommanderEvent(timestamp, json);
			listener.onNewCommanderEvent(newCommanderEvent);
			break;
		case "LoadGame":
			LoadGameEvent loadGameEvent = new LoadGameEvent(timestamp, json);
			listener.onLoadGameEvent(loadGameEvent);
			break;
		case "Passengers":
			PassengersEvent passengersEvent = new PassengersEvent(timestamp, json);
			listener.onPassengerEvent(passengersEvent);
			break;
		case "Powerplay":
			PowerplayEvent powerplayEvent = new PowerplayEvent(timestamp, json);
			listener.onPowerPlayEvent(powerplayEvent);
			break;
		case "Progress":
			ProgressEvent progressEvent = new ProgressEvent(timestamp, json);
			listener.onProgressEvent(progressEvent);
			break;
		case "Rank":
			RankEvent rankEvent = new RankEvent(timestamp, json);
			listener.onRankEvent(rankEvent);
			break;
		case "Reputation":
			ReputationEvent reputationEvent = new ReputationEvent(timestamp, json);
			listener.onReputationEvent(reputationEvent);
			break;
		case "Statistics":
			StatisticsEvent statisticsEvent = new StatisticsEvent(timestamp, json);
			listener.onStatisticsEvent(statisticsEvent);
			break;
		case "ApproachBody":
			ApproachBodyEvent approachBodyEvent = new ApproachBodyEvent(timestamp, json);
			listener.onApproachBodyEvent(approachBodyEvent);
			break;
		case "Docked":
			DockedEvent dockedEvent = new DockedEvent(timestamp, json);
			listener.onDockedEvent(dockedEvent);
			break;
		case "DockingDenied":
			DockingDeniedEvent dockingDeniedEvent = new DockingDeniedEvent(timestamp, json);
			listener.onDockingDeniedEvent(dockingDeniedEvent);
			break;
		case "DockingGranted":
			DockingGrantedEvent dockingGrantedEvent = new DockingGrantedEvent(timestamp, json);
			listener.onDockingGrantedEvent(dockingGrantedEvent);
			break;
		case "DockingCancelled":
			DockingCancelledEvent dockingCancelledEvent = new DockingCancelledEvent(timestamp, json);
			listener.onDockingCancelledEvent(dockingCancelledEvent);
			break;
		case "DockingRequested":
			DockingRequestedEvent dockingRequestedEvent = new DockingRequestedEvent(timestamp,  json);
			listener.onDockingRequestedEvent(dockingRequestedEvent);
			break;
		case "FSDJump":
			FSDJumpEvent fsdJumpEvent = new FSDJumpEvent(timestamp, json);
			listener.onFSDJumpEvent(fsdJumpEvent);
			break;
		case "FSDTarget":
			FSDTargetEvent fsdTargetEvent = new FSDTargetEvent(timestamp, json);
			listener.onFSDTargetEvent(fsdTargetEvent);
			break;
		case "LeaveBody":
			LeaveBodyEvent leaveBodyEvent = new LeaveBodyEvent(timestamp, json);
			listener.onLeaveBodyEvent(leaveBodyEvent);
			break;
		case "Liftoff":
			LiftoffEvent liftoffEvent = new LiftoffEvent(timestamp, json);
			listener.onLiftoffEvent(liftoffEvent);
			break;
		case "Location":
			LocationEvent locationEvent = new LocationEvent(timestamp, json);
			listener.onLocationEvent(locationEvent);
			break;
		case "StartJump":
			StartJumpEvent startJumpEvent = new StartJumpEvent(timestamp, json);
			listener.onStartJumpEvent(startJumpEvent);
			break;
		case "SupercruiseEntry":
			SupercruiseEntryEvent supercruiseEntryEvent = new SupercruiseEntryEvent(timestamp, json);
			listener.onSupercruiseEntryEvent(supercruiseEntryEvent);
			break;
		case "SupercruiseExit":
			SupercruiseExitEvent supercruiseExitEvent = new SupercruiseExitEvent(timestamp, json);
			listener.onSupercruiseExitEvent(supercruiseExitEvent);
			break;
		case "Touchdown":
			TouchdownEvent touchdownEvent = new TouchdownEvent(timestamp, json);
			listener.onTouchdownEvent(touchdownEvent);
			break;
		case "Undocked":
			UndockedEvent undockedEvent = new UndockedEvent(timestamp, json);
			listener.onUndockedEvent(undockedEvent);
			break;
		case "Bounty":
			BountyEvent bountyEvent = new BountyEvent(timestamp, json);
			listener.onBountyEvent(bountyEvent);
			break;
		case "EscapeInterdiction":
			EscapeInterdictionEvent escapeInterdictionEvent = new EscapeInterdictionEvent(timestamp, json);
			listener.onEscapeInterdictionEvent(escapeInterdictionEvent);
			break;
		case "FighterDestroyed":
			FighterDestroyedEvent fighterDestroyedEvent = new FighterDestroyedEvent(timestamp, json);
			listener.onFighterDestroyedEvent(fighterDestroyedEvent);
			break;
		case "CapShipBond":
			CapShipBondEvent capShipBondEvent = new CapShipBondEvent(timestamp, json);
			listener.onCapShipBondEvent(capShipBondEvent);
			break;
		case "Died":
			if(!json.has("Killers")) {
				DiedEvent diedEvent = new DiedEvent(timestamp, json);
				listener.onDiedEvent(diedEvent);
			}else {
				DiedByWingEvent diedByWingEvent = new DiedByWingEvent(timestamp, json);
				listener.onDiedByWingEvent(diedByWingEvent);
			}
			break;
		case "FactionKillBond":
			FactionKillBondEvent factionKillBondEvent = new FactionKillBondEvent(timestamp, json);
			listener.onFactionKillBondEvent(factionKillBondEvent);
			break;
		case "HeatDamage":
			HeatDamageEvent heatDamageEvent = new HeatDamageEvent(timestamp, json);
			listener.onHeatDamageEvent(heatDamageEvent);
			break;
		case "HeatWarning":
			HeatWarningEvent hHeatWarningEvent = new HeatWarningEvent(timestamp, json);
			listener.onHeatWarningEvent(hHeatWarningEvent);
			break;
		case "HullDamage":
			HullDamageEvent hullDamageEvent = new HullDamageEvent(timestamp, json);
			listener.onHullDamageEvent(hullDamageEvent);
			break;
		case "Interdicted":
			InterdictedEvent interdictedEvent = new InterdictedEvent(timestamp, json);
			listener.onInterdictedEvent(interdictedEvent);
			break;
		case "Interdiction":
			InterdictionEvent InterdictionEvent = new InterdictionEvent(timestamp, json);
			listener.onInterdictionEvent(InterdictionEvent);
			break;
		case "PvPKill":
			PvPKillEvent pvpKillEvent = new PvPKillEvent(timestamp, json);
			listener.onPvPKillEvent(pvpKillEvent);
			break;
		case "ShieldState":
			ShieldStateEvent shieldStateEvent = new ShieldStateEvent(timestamp, json);
			listener.onShieldStateEvent(shieldStateEvent);
			break;
		case "ShipTargeted":
			ShipTargetedEvent shipTargetedEvent = new ShipTargetedEvent(timestamp, json);
			listener.onShipTargetedEvent(shipTargetedEvent);
			break;
		case "SRVDestroyed":
			SRVDestroyedEvent srvDestroyedEvent = new SRVDestroyedEvent(timestamp, json);
			listener.onSRVDestroyedEvent(srvDestroyedEvent);
			break;
		case "UnderAttack":
			UnderAttackEvent underAttackEvent = new UnderAttackEvent(timestamp, json);
			listener.onUnderAttackEvent(underAttackEvent);
			break;
		case "CodexEntry":
			CodexEntryEvent codexEntryEvent = new CodexEntryEvent(timestamp, json);
			listener.onCodexEntryEvent(codexEntryEvent);
			break;
		case "DiscoveryScan":
			DiscoveryScanEvent discoveryScanEvent = new DiscoveryScanEvent(timestamp, json);
			listener.onDiscoveryScanEvent(discoveryScanEvent);
			break;
		case "Scan":
			ScanEvent scanEvent = new ScanEvent(timestamp, json);
			listener.onScanEvent(scanEvent);
			break;
		case "FSSAllBodiesFound":
			FSSAllBodiesFoundEvent fssAllBodiesFoundEvent = new FSSAllBodiesFoundEvent(timestamp, json);
			listener.onFSSAllBodiesFoundEvent(fssAllBodiesFoundEvent);
			break;
		case "FSSDiscoveryScan":
			FSSDiscoveryScanEvent fssDiscoveryScanEvent = new FSSDiscoveryScanEvent(timestamp, json);
			listener.onFSSDiscoveryScanEvent(fssDiscoveryScanEvent);
			break;
		case "FSSSignalDiscovered":
			FSSSignalDiscoveredEvent fssSignalDiscoveredEvent = new FSSSignalDiscoveredEvent(timestamp, json);
			listener.onFSSSignalDiscoveredEvent(fssSignalDiscoveredEvent);
			break;
		case "MaterialCollected":
			MaterialCollectedEvent materialCollectedEvent = new MaterialCollectedEvent(timestamp, json);
			listener.onMaterialCollectedEvent(materialCollectedEvent);
			break;
		case "MaterialDiscarded":
			MaterialDiscardedEvent materialDiscardedEvent = new MaterialDiscardedEvent(timestamp, json);
			listener.onMaterialDiscardedEvent(materialDiscardedEvent);
			break;
		case "MaterialDiscovered":
			MaterialDiscoveredEvent materialDiscoveredEvent = new MaterialDiscoveredEvent(timestamp, json);
			listener.onMaterialDiscoveredEvent(materialDiscoveredEvent);
			break;
		case "MultiSellExplorationData":
			MultiSellExplorationDataEvent multiSellExplorationDataEvent = new MultiSellExplorationDataEvent(timestamp, json);
			listener.onMultiSellExplorationDataEvent(multiSellExplorationDataEvent);
			break;
		case "NavBeaconScan":
			NavBeaconScanEvent navBeaconScanEvent = new NavBeaconScanEvent(timestamp, json);
			listener.onNavBeaconScanEvent(navBeaconScanEvent);
			break;
		case "BuyExplorationData":
			BuyExplorationDataEvent buyExplorationDataEvent = new BuyExplorationDataEvent(timestamp, json);
			listener.onBuyExplorationDataEvent(buyExplorationDataEvent);
			break;
		case "SAAScanComplete":
			SAAScanCompleteEvent saaScanCompleteEvent = new SAAScanCompleteEvent(timestamp, json);
			listener.onSAAScanCompleteEvent(saaScanCompleteEvent);
			break;
		case "SellExplorationData":
			SellExplorationDataEvent sellExplorationDataEvent = new SellExplorationDataEvent(timestamp, json);
			listener.onSellExplorationDataEvent(sellExplorationDataEvent);
			break;
		case "Screenshot":
			ScreenshotEvent screenshotEvent = new ScreenshotEvent(timestamp, json);
			listener.onScreenshotEvent(screenshotEvent);
			break;
		case "AsteroidCracked":
			AsteroidCrackedEvent asteroidCrackedEvent = new AsteroidCrackedEvent(timestamp, json);
			listener.onAsteroidCrackedEvet(asteroidCrackedEvent);
			break;
		case "BuyTradeData":
			BuyTradeDataEvent buyTradeDataEvent = new BuyTradeDataEvent(timestamp, json);
			listener.onBuyTradeDataEvent(buyTradeDataEvent);
			break;
		case "CollectCargo":
			CollectCargoEvent collectCargoEvent = new CollectCargoEvent(timestamp, json);
			listener.onCollectCargoEvent(collectCargoEvent);
			break;
		case "EjectCargo":
			EjectCargoEvent ejectCargoEvent = new EjectCargoEvent(timestamp, json);
			listener.onEjectCargoEvent(ejectCargoEvent);
			break;
		case "MarketBuy":
			MarketBuyEvent marketBuyEvent = new MarketBuyEvent(timestamp, json);
			listener.onMarketBuyEvent(marketBuyEvent);
			break;
		case "MarketSell":
			MarketSellEvent marketSellEvent = new MarketSellEvent(timestamp, json);
			listener.onMarketSellEvent(marketSellEvent);
			break;
		case "MiningRefined":
			MiningRefinedEvent miningRefinedEvent = new MiningRefinedEvent(timestamp, json);
			listener.onMiningRefinedEvent(miningRefinedEvent);
			break;
		case "BuyAmmo":
			BuyAmmoEvent buyAmmoEvent = new BuyAmmoEvent(timestamp, json);
			listener.onBuyAmmoEvent(buyAmmoEvent);
			break;
		case "BuyDrones":
			BuyDronesEvent buyDronesEvent = new BuyDronesEvent(timestamp, json);
			listener.onBuyDronesEvent(buyDronesEvent);
			break;
		case "CargoDepot":
			CargoDepotEvent cargoDepotEvent = new CargoDepotEvent(timestamp, json);
			listener.onCargoDepotEvent(cargoDepotEvent);
			break;
		case "CommunityGoal":
			CommunityGoalEvent communityGoalEvent = new CommunityGoalEvent(timestamp, json);
			listener.onCommunityGoalEvent(communityGoalEvent);
			break;
		case "CommunityGoalDiscard":
			CommunityGoalDiscardEvent communityGoalDiscardEvent = new CommunityGoalDiscardEvent(timestamp, json);
			listener.onCommunityGoalDiscardEvent(communityGoalDiscardEvent);
			break;
		case "CommunityGoalJoin":
			CommunityGoalJoinEvent communityGoalJoinEvent = new CommunityGoalJoinEvent(timestamp, json);
			listener.onCommunityGoalJoinEvent(communityGoalJoinEvent);
			break;
		case "CommunityGoalReward":
			CommunityGoalRewardEvent communityGoalRewardEvent = new CommunityGoalRewardEvent(timestamp, json);
			listener.onCommunityGoalRewardEvent(communityGoalRewardEvent);
			break;
		case "CrewAssign":
			CrewAssignEvent crewAssignEvent = new CrewAssignEvent(timestamp, json);
			listener.onCrewAssignEvent(crewAssignEvent);
			break;
		case "CrewFire":
			CrewFireEvent crewFireEvent = new CrewFireEvent(timestamp, json);
			listener.onCrewFireEvent(crewFireEvent);
			break;
		case "CrewHire":
			CrewHireEvent crewHireEvent = new CrewHireEvent(timestamp, json);
			listener.onCrewHireEvent(crewHireEvent);
			break;
		case "EngineerContribution":
			EngineerContributionEvent engineerContributionEvent = new EngineerContributionEvent(timestamp, json);
			listener.onEngineerContributionEvent(engineerContributionEvent);
			break;
		case "EngineerCraft":
			EngineerCraftEvent engineerCraftEvent = new EngineerCraftEvent(timestamp, json);
			listener.onEngineerCraftEvent(engineerCraftEvent);
			break;
		case "EngineerProgress":
			EngineerProgressEvent engineerProgressEvent = new EngineerProgressEvent(timestamp, json);
			listener.onEngineerProgressEvent(engineerProgressEvent);
			break;
		case "FetchRemoteModule":
			FetchRemoteModuleEvent fetchRemoteModuleEvent = new FetchRemoteModuleEvent(timestamp, json);
			listener.onFetchRemoteModuleEvent(fetchRemoteModuleEvent);
			break;
		case "Market":
			MarketEvent marketEvent = new MarketEvent(timestamp, json);
			listener.onMarketEvent(marketEvent);
			break;
		case "MassModuleStore":
			MassModuleStoreEvent massModuleStoreEvent = new MassModuleStoreEvent(timestamp, json);
			listener.onMassModuleStore(massModuleStoreEvent);
			break;
		case "MaterialTrade":
			MaterialTradeEvent materialTradeEvent = new MaterialTradeEvent(timestamp, json);
			listener.onMaterialTrade(materialTradeEvent);
			break;
		case "MissionAbandoned":
			MissionAbandonedEvent missionAbandonedEvent = new MissionAbandonedEvent(timestamp, json);
			listener.onMissionAbandoned(missionAbandonedEvent);
			break;
		case "MissionAccepted":
			MissionAcceptedEvent missionAcceptedEvent = new MissionAcceptedEvent(timestamp, json);
			listener.onMissionAccepted(missionAcceptedEvent);
			break;
		case "MissionCompleted":
			MissionCompletedEvent missionCompletedEvent = new MissionCompletedEvent(timestamp, json);
			listener.onMissionCompleted(missionCompletedEvent);
			break;
		case "MissionFailed":
			MissionFailedEvent missionFailedEvent = new MissionFailedEvent(timestamp, json);
			listener.onMissionFailed(missionFailedEvent);
			break;
		case "MissionRedirected":
			MissionRedirectedEvent missionRedirectedEvent = new MissionRedirectedEvent(timestamp, json);
			listener.onMissionRedirected(missionRedirectedEvent);
			break;
		case "ModuleBuy":
			ModuleBuyEvent moduleBuyEvent = new ModuleBuyEvent(timestamp, json);
			listener.onModuleBuy(moduleBuyEvent);
			break;
		case "ModuleRetrieve":
			ModuleRetrieveEvent moduleRetrieveEvent = new ModuleRetrieveEvent(timestamp, json);
			listener.onModuleRetrieve(moduleRetrieveEvent);
			break;
		case "ModuleSell":
			ModuleSellEvent moduleSellEvent = new ModuleSellEvent(timestamp, json);
			listener.onModuleSell(moduleSellEvent);
			break;
		case "ModuleSellRemote":
			ModuleSellRemote moduleSellRemote = new ModuleSellRemote(timestamp, json);
			listener.onModuleSellRemote(moduleSellRemote);
			break;
		case "ModuleStore":
			ModuleStoreEvent moduleStoreEvent = new ModuleStoreEvent(timestamp, json);
			listener.onModuleStore(moduleStoreEvent);
			break;
		case "ModuleSwap":
			ModuleSwapEvent moduleSwapEvent = new ModuleSwapEvent(timestamp, json);
			listener.onModuleSwap(moduleSwapEvent);
			break;
		case "Outfitting":
			OutfittingEvent outfittingEvent = new OutfittingEvent(timestamp, json);
			listener.onOutfitting(outfittingEvent);
			break;
		case "PayBounties":
			PayBountiesEvent payBountiesEvent = new PayBountiesEvent(timestamp, json);
			listener.onPayBounties(payBountiesEvent);
			break;
		case "PayFines":
			PayFinesEvent payFinesEvent = new PayFinesEvent(timestamp, json);
			listener.onPayFines(payFinesEvent);
			break;
		case "RedeemVoucher":
			RedeemVoucherEvent redeemVoucherEvent = new RedeemVoucherEvent(timestamp, json);
			listener.onRedeemVoucher(redeemVoucherEvent);
			break;
		case "RefuelAll":
			RefuelAllEvent refuelAllEvent = new RefuelAllEvent(timestamp, json);
			listener.onRefuelAll(refuelAllEvent);
			break;
		case "RefuelPartial":
			RefuelPartialEvent refuelPartialEvent = new RefuelPartialEvent(timestamp, json);
			listener.onRefuelPartial(refuelPartialEvent);
			break;
		case "Repair":
			RepairEvent repairEvent = new RepairEvent(timestamp, json);
			listener.onRepair(repairEvent);
			break;
		case "RepairAll":
			RepairAllEvent repairAllEvent = new RepairAllEvent(timestamp, json);
			listener.onRepairAll(repairAllEvent);
			break;
		case "RestockVehicle":
			RestockVehicleEvent restockVehicleEvent = new RestockVehicleEvent(timestamp, json);
			listener.onRestockVehicle(restockVehicleEvent);
			break;
		case "ScientificResearch":
			ScientificResearchEvent scientificResearchEvent = new ScientificResearchEvent(timestamp, json);
			listener.onScientificResearch(scientificResearchEvent);
			break;
		case "SearchAndRescue":
			SearchAndRescueEvent searchAndRescueEvent = new SearchAndRescueEvent(timestamp, json);
			listener.onSearchAndRescue(searchAndRescueEvent);
			break;
		case "SellDrones":
			SellDronesEvent sellDronesEvent = new SellDronesEvent(timestamp, json);
			listener.onSellDrones(sellDronesEvent);
			break;
		case "SellShipOnRebuy":
			SellShipOnRebuyEvent sellShipOnRebuyEvent = new SellShipOnRebuyEvent(timestamp, json);
			listener.onSellShipOnRebuy(sellShipOnRebuyEvent);
			break;
		case "SetUserShipName":
			SetUserShipNameEvent setUserShipNameEvent = new SetUserShipNameEvent(timestamp, json);
			listener.onSetUserShipName(setUserShipNameEvent);
			break;
		case "Shipyard":
			ShipyardEvent shipyardEvent = new ShipyardEvent(timestamp, json);
			listener.onShipyard(shipyardEvent);
			break;
		case "ShipyardBuy":
			ShipyardBuyEvent shipyardBuyEvent = new ShipyardBuyEvent(timestamp, json);
			listener.onShipyardBuy(shipyardBuyEvent);
			break;
		case "ShipyardNew":
			ShipyardNewEvent shipyardNewEvent = new ShipyardNewEvent(timestamp, json);
			listener.onShipyardNew(shipyardNewEvent);
			break;
		case "ShipyardSell":
			ShipyardSellEvent shipyardSellEvent = new ShipyardSellEvent(timestamp, json);
			listener.onShipyardSell(shipyardSellEvent);
			break;
		case "ShipyardTransfer":
			ShipyardTransferEvent shipyardTransferEvent = new ShipyardTransferEvent(timestamp, json);
			listener.onShipyardTransfer(shipyardTransferEvent);
			break;
		case "ShipyardSwap":
			ShipyardSwapEvent shipyardSwapEvent = new ShipyardSwapEvent(timestamp, json);
			listener.onShipyardSwap(shipyardSwapEvent);
			break;
		case "StoredModules":
			StoredModulesEvent storedModulesEvent = new StoredModulesEvent(timestamp, json);
			listener.onStoredModules(storedModulesEvent);
			break;
		case "StoredShips":
			StoredShipsEvent storedShipsEvent = new StoredShipsEvent(timestamp, json);
			listener.onStoredShips(storedShipsEvent);
			break;
		}
	}

}
