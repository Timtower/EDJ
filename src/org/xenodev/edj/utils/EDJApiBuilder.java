package org.xenodev.edj.utils;

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
import org.xenodev.edj.EDJApi;
import org.xenodev.edj.events.*;

import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class EDJApiBuilder {
	
	private List<EventListener> listenerList = new ArrayList<>();
	private String watchFileName = FileHandler.getLatestJournalFile().getName();
	private Integer lineCount = 0;
	private Boolean debug;
	
	public EDJApiBuilder(Boolean debug) {
		this.debug = debug;
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
			listener.onDiscoveryScanEvent(new DiscoveryScanEvent(timestamp, json));
			break;
		case "Scan":
			listener.onScanEvent(new ScanEvent(timestamp, json));
			break;
		case "FSSAllBodiesFound":
			listener.onFSSAllBodiesFoundEvent(new FSSAllBodiesFoundEvent(timestamp, json));
			break;
		case "FSSDiscoveryScan":
			listener.onFSSDiscoveryScanEvent(new FSSDiscoveryScanEvent(timestamp, json));
			break;
		case "FSSSignalDiscovered":
			listener.onFSSSignalDiscoveredEvent(new FSSSignalDiscoveredEvent(timestamp, json));
			break;
		case "MaterialCollected":
			listener.onMaterialCollectedEvent(new MaterialCollectedEvent(timestamp, json));
			break;
		case "MaterialDiscarded":
			listener.onMaterialDiscardedEvent(new MaterialDiscardedEvent(timestamp, json));
			break;
		case "MaterialDiscovered":
			listener.onMaterialDiscoveredEvent(new MaterialDiscoveredEvent(timestamp, json));
			break;
		case "MultiSellExplorationData":
			listener.onMultiSellExplorationDataEvent(new MultiSellExplorationDataEvent(timestamp, json));
			break;
		case "NavBeaconScan":
			listener.onNavBeaconScanEvent(new NavBeaconScanEvent(timestamp, json));
			break;
		case "BuyExplorationData":
			listener.onBuyExplorationDataEvent(new BuyExplorationDataEvent(timestamp, json));
			break;
		case "SAAScanComplete":
			listener.onSAAScanCompleteEvent(new SAAScanCompleteEvent(timestamp, json));
			break;
		case "SellExplorationData":
			listener.onSellExplorationDataEvent(new SellExplorationDataEvent(timestamp, json));
			break;
		case "Screenshot":
			listener.onScreenshotEvent(new ScreenshotEvent(timestamp, json));
			break;
		case "AsteroidCracked":
			listener.onAsteroidCrackedEvet(new AsteroidCrackedEvent(timestamp, json));
			break;
		case "BuyTradeData":
			listener.onBuyTradeDataEvent(new BuyTradeDataEvent(timestamp, json));
			break;
		case "CollectCargo":
			listener.onCollectCargoEvent(new CollectCargoEvent(timestamp, json));
			break;
		case "EjectCargo":
			listener.onEjectCargoEvent(new EjectCargoEvent(timestamp, json));
			break;
		case "MarketBuy":
			listener.onMarketBuyEvent(new MarketBuyEvent(timestamp, json));
			break;
		case "MarketSell":
			listener.onMarketSellEvent(new MarketSellEvent(timestamp, json));
			break;
		case "MiningRefined":
			listener.onMiningRefinedEvent(new MiningRefinedEvent(timestamp, json));
			break;
		case "BuyAmmo":
			listener.onBuyAmmoEvent(new BuyAmmoEvent(timestamp, json));
			break;
		case "BuyDrones":
			listener.onBuyDronesEvent(new BuyDronesEvent(timestamp, json));
			break;
		case "CargoDepot":
			listener.onCargoDepotEvent(new CargoDepotEvent(timestamp, json));
			break;
		case "CommunityGoal":
			listener.onCommunityGoalEvent(new CommunityGoalEvent(timestamp, json));
			break;
		case "CommunityGoalDiscard":
			listener.onCommunityGoalDiscardEvent(new CommunityGoalDiscardEvent(timestamp, json));
			break;
		case "CommunityGoalJoin":
			listener.onCommunityGoalJoinEvent(new CommunityGoalJoinEvent(timestamp, json));
			break;
		case "CommunityGoalReward":
			listener.onCommunityGoalRewardEvent(new CommunityGoalRewardEvent(timestamp, json));
			break;
		case "CrewAssign":
			listener.onCrewAssignEvent(new CrewAssignEvent(timestamp, json));
			break;
		case "CrewFire":
			listener.onCrewFireEvent(new CrewFireEvent(timestamp, json));
			break;
		case "CrewHire":
			listener.onCrewHireEvent(new CrewHireEvent(timestamp, json));
			break;
		case "EngineerContribution":
			listener.onEngineerContributionEvent(new EngineerContributionEvent(timestamp, json));
			break;
		case "EngineerCraft":
			listener.onEngineerCraftEvent(new EngineerCraftEvent(timestamp, json));
			break;
		case "EngineerProgress":
			listener.onEngineerProgressEvent(new EngineerProgressEvent(timestamp, json));
			break;
		case "FetchRemoteModule":
			listener.onFetchRemoteModuleEvent(new FetchRemoteModuleEvent(timestamp, json));
			break;
		case "Market":
			listener.onMarketEvent(new MarketEvent(timestamp, json));
			break;
		case "MassModuleStore":
			listener.onMassModuleStore(new MassModuleStoreEvent(timestamp, json));
			break;
		case "MaterialTrade":
			listener.onMaterialTrade(new MaterialTradeEvent(timestamp, json));
			break;
		case "MissionAbandoned":
			listener.onMissionAbandoned(new MissionAbandonedEvent(timestamp, json));
			break;
		case "MissionAccepted":
			listener.onMissionAccepted(new MissionAcceptedEvent(timestamp, json));
			break;
		case "MissionCompleted":
			listener.onMissionCompleted(new MissionCompletedEvent(timestamp, json));
			break;
		case "MissionFailed":
			listener.onMissionFailed(new MissionFailedEvent(timestamp, json));
			break;
		case "MissionRedirected":
			listener.onMissionRedirected(new MissionRedirectedEvent(timestamp, json));
			break;
		case "ModuleBuy":
			listener.onModuleBuy(new ModuleBuyEvent(timestamp, json));
			break;
		case "ModuleRetrieve":
			listener.onModuleRetrieve(new ModuleRetrieveEvent(timestamp, json));
			break;
		case "ModuleSell":
			listener.onModuleSell(new ModuleSellEvent(timestamp, json));
			break;
		case "ModuleSellRemote":
			listener.onModuleSellRemote(new ModuleSellRemote(timestamp, json));
			break;
		case "ModuleStore":
			listener.onModuleStore(new ModuleStoreEvent(timestamp, json));
			break;
		case "ModuleSwap":
			listener.onModuleSwap(new ModuleSwapEvent(timestamp, json));
			break;
		case "Outfitting":
			listener.onOutfitting(new OutfittingEvent(timestamp, json));
			break;
		case "PayBounties":
			listener.onPayBounties(new PayBountiesEvent(timestamp, json));
			break;
		case "PayFines":
			listener.onPayFines(new PayFinesEvent(timestamp, json));
			break;
		case "RedeemVoucher":
			listener.onRedeemVoucher(new RedeemVoucherEvent(timestamp, json));
			break;
		case "RefuelAll":
			listener.onRefuelAll(new RefuelAllEvent(timestamp, json));
			break;
		case "RefuelPartial":
			RefuelPartialEvent refuelPartialEvent = new RefuelPartialEvent(timestamp, json);
			listener.onRefuelPartial(refuelPartialEvent);
			break;
		case "Repair":
			listener.onRepair(new RepairEvent(timestamp, json));
			break;
		case "RepairAll":
			listener.onRepairAll(new RepairAllEvent(timestamp, json));
			break;
		case "RestockVehicle":
			listener.onRestockVehicle(new RestockVehicleEvent(timestamp, json));
			break;
		case "ScientificResearch":
			ScientificResearchEvent scientificResearchEvent = new ScientificResearchEvent(timestamp, json);
			listener.onScientificResearch(scientificResearchEvent);
			break;
		case "SearchAndRescue":
			listener.onSearchAndRescue(new SearchAndRescueEvent(timestamp, json));
			break;
		case "SellDrones":
			listener.onSellDrones(new SellDronesEvent(timestamp, json));
			break;
		case "SellShipOnRebuy":
			SellShipOnRebuyEvent sellShipOnRebuyEvent = new SellShipOnRebuyEvent(timestamp, json);
			listener.onSellShipOnRebuy(sellShipOnRebuyEvent);
			break;
		case "SetUserShipName":
			listener.onSetUserShipName(new SetUserShipNameEvent(timestamp, json));
			break;
		case "Shipyard":
			listener.onShipyard(new ShipyardEvent(timestamp, json));
			break;
		case "ShipyardBuy":
			listener.onShipyardBuy(new ShipyardBuyEvent(timestamp, json));
			break;
		case "ShipyardNew":
			listener.onShipyardNew(new ShipyardNewEvent(timestamp, json));
			break;
		case "ShipyardSell":
			listener.onShipyardSell(new ShipyardSellEvent(timestamp, json));
			break;
		case "ShipyardTransfer":
			listener.onShipyardTransfer(new ShipyardTransferEvent(timestamp, json));
			break;
		case "ShipyardSwap":
			listener.onShipyardSwap(new ShipyardSwapEvent(timestamp, json));
			break;
		case "StoredModules":
			listener.onStoredModules(new StoredModulesEvent(timestamp, json));
			break;
		case "StoredShips":
			listener.onStoredShips(new StoredShipsEvent(timestamp, json));
			break;
		}
		
	}

}
