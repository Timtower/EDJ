package org.xenodev.edj;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
import org.xenodev.edj.utils.JournalUtils;

public class EDJApiBuilder {
	
	private List<EventListener> listenerList = new ArrayList<>();
	private String watchFileName = FileHandler.getLatestJournalFile().getName();
	private Integer lineCount = 0;
	private Boolean debug;
	
	/**
	 * First step to building the EDJ Api, the final API can be accessed after {@link #build()}
	 * which retruns the populated {@link EDJApi} class.
	 *  
	 * @param debug Whether to allow or disallow debug of event strings through {@link System.out.println()}
	 */
	public EDJApiBuilder(Boolean debug) {
		this.debug = debug;
	}
	
    /**
     * Register a class as an eventlistener so it can be listened to.
     * 
     * @param listeners The classes which extend {@link EventListener} and contain the code to run when the events are fired.
     */
    public EDJApiBuilder addListener(EventListener... listeners) {
    	for(EventListener listener : listeners) {
    		listenerList.add(listener);
    	}
        return this;
    }
    
    /**
     * Register a class as an eventlistener so it can be listened to.
     * 
     * @param listener The class which extends {@link EventListener} and contains the code to run when the event is fired.
     */
    public EDJApiBuilder addListener(EventListener listener) {
    	listenerList.add(listener);
        return this;
    }
    
    /**
     * Populates the {@link EDJApi} class and returns it for fruther use.
     * 
     * @return The populated {@link EDJApi} class
     */
    public EDJApi build() {
    	
    	Timer t = new Timer();
    	
    	t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				propagateEvents();
				
			}
		}, 0, 5*1000);
    	
    	//TODO: return api
		return new EDJApi();
    }
    
    /**
     * Start the Watcher and fire events when file changes are detected.
     */
    private void propagateEvents() {

        if(listenerList.size() == 0) {
    		
    		try {
        		List<String> journalEntries = Files.readAllLines(new File(EDJApi.getJournalDir() + "/" + watchFileName).toPath());
        		
				for(int i = lineCount; i < journalEntries.size(); i++) {
					if(debug) System.out.println("DEBUG: " + journalEntries.get(i));
					
					fireEvent(new JSONObject(journalEntries.get(i)), null);
					lineCount++;
				}
				
				if(lineCount >= journalEntries.size()) {
					  //Check if is still latest file
                    if(watchFileName.equals(FileHandler.getLatestJournalFile().getName())) {
                    	watchFileName = FileHandler.getLatestJournalFile().getName();
                    }
				}
				
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
    		
    	}else {
    		//File has been modified, call event registered
        	listenerList.forEach(l -> {
        		if (!l.getClass().equals(EventListener.class)) {
                	try {
                		List<String> journalEntries = Files.readAllLines(new File(EDJApi.getJournalDir() + "/" + watchFileName).toPath());
                		
						for(int i = lineCount; i < journalEntries.size(); i++) {
							if(debug) System.out.println(journalEntries.get(i));
							
							fireEvent(new JSONObject(journalEntries.get(i)), l);
							lineCount++;
						}
						
						if(lineCount >= journalEntries.size()) {
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
    
    /**
     * Fires the JSON string with the eventlistener registered.
     * 
     * @param json the json event string from the player journal.
     * @param listener eventlistener with the code to run.
     */
	private void fireEvent(JSONObject json, EventListener listener) {
		String timestamp = json.pullString("timestamp");
		String event = json.pullString("event");
		
		switch(event) {
		case "Cargo":
			if(json.has("Inventory")) {
				CargoEvent cargoEvent = new CargoEvent(timestamp, json);
				if(listener != null) listener.onCargoEvent(cargoEvent);
			}
			break;
		case "ClearSavedGame":
			ClearSavedGameEvent clearSavedGameEvent = new ClearSavedGameEvent(timestamp, json);
			if(listener != null) listener.onClearSavedGameEvent(clearSavedGameEvent);
			break;
		case "Commander":
			CommanderEvent commanderEvent = new CommanderEvent(timestamp, json);
			if(listener != null) listener.onCommanderEvent(commanderEvent);
			break;
		case "Loadout":
			LoadoutEvent loadoutEvent = new LoadoutEvent(timestamp, json);
			if(listener != null) listener.onLoadoutEvent(loadoutEvent);
			break;
		case "Materials":
			MaterialsEvent materialEvent = new MaterialsEvent(timestamp, json);
			if(listener != null) listener.onMaterialsEvent(materialEvent);
			break;
		case "Missions":
			MissionsEvent missionEvent = new MissionsEvent(timestamp, json);
			if(listener != null) listener.onMissionEvent(missionEvent);
			break;
		case "NewCommander":
			NewCommanderEvent newCommanderEvent = new NewCommanderEvent(timestamp, json);
			if(listener != null) listener.onNewCommanderEvent(newCommanderEvent);
			break;
		case "LoadGame":
			LoadGameEvent loadGameEvent = new LoadGameEvent(timestamp, json);
			if(listener != null) listener.onLoadGameEvent(loadGameEvent);
			break;
		case "Passengers":
			PassengersEvent passengersEvent = new PassengersEvent(timestamp, json);
			if(listener != null) listener.onPassengerEvent(passengersEvent);
			break;
		case "Powerplay":
			PowerplayEvent powerplayEvent = new PowerplayEvent(timestamp, json);
			if(listener != null) listener.onPowerPlayEvent(powerplayEvent);
			break;
		case "Progress":
			ProgressEvent progressEvent = new ProgressEvent(timestamp, json);
			if(listener != null) listener.onProgressEvent(progressEvent);
			break;
		case "Rank":
			RankEvent rankEvent = new RankEvent(timestamp, json);
			if(listener != null) listener.onRankEvent(rankEvent);
			break;
		case "Reputation":
			ReputationEvent reputationEvent = new ReputationEvent(timestamp, json);
			if(listener != null) listener.onReputationEvent(reputationEvent);
			break;
		case "Statistics":
			StatisticsEvent statisticsEvent = new StatisticsEvent(timestamp, json);
			if(listener != null) listener.onStatisticsEvent(statisticsEvent);
			break;
		case "ApproachBody":
			ApproachBodyEvent approachBodyEvent = new ApproachBodyEvent(timestamp, json);
			if(listener != null) listener.onApproachBodyEvent(approachBodyEvent);
			break;
		case "Docked":
			DockedEvent dockedEvent = new DockedEvent(timestamp, json);
			if(listener != null) listener.onDockedEvent(dockedEvent);
			break;
		case "DockingDenied":
			DockingDeniedEvent dockingDeniedEvent = new DockingDeniedEvent(timestamp, json);
			if(listener != null) listener.onDockingDeniedEvent(dockingDeniedEvent);
			break;
		case "DockingGranted":
			DockingGrantedEvent dockingGrantedEvent = new DockingGrantedEvent(timestamp, json);
			if(listener != null) listener.onDockingGrantedEvent(dockingGrantedEvent);
			break;
		case "DockingCancelled":
			DockingCancelledEvent dockingCancelledEvent = new DockingCancelledEvent(timestamp, json);
			if(listener != null) listener.onDockingCancelledEvent(dockingCancelledEvent);
			break;
		case "DockingRequested":
			DockingRequestedEvent dockingRequestedEvent = new DockingRequestedEvent(timestamp,  json);
			if(listener != null) listener.onDockingRequestedEvent(dockingRequestedEvent);
			break;
		case "FSDJump":
			FSDJumpEvent fsdJumpEvent = new FSDJumpEvent(timestamp, json);
			if(listener != null) listener.onFSDJumpEvent(fsdJumpEvent);
			break;
		case "FSDTarget":
			FSDTargetEvent fsdTargetEvent = new FSDTargetEvent(timestamp, json);
			if(listener != null) listener.onFSDTargetEvent(fsdTargetEvent);
			break;
		case "LeaveBody":
			LeaveBodyEvent leaveBodyEvent = new LeaveBodyEvent(timestamp, json);
			if(listener != null) listener.onLeaveBodyEvent(leaveBodyEvent);
			break;
		case "Liftoff":
			LiftoffEvent liftoffEvent = new LiftoffEvent(timestamp, json);
			if(listener != null) listener.onLiftoffEvent(liftoffEvent);
			break;
		case "Location":
			 LocationEvent locationEvent = new LocationEvent(timestamp, json);
			 if(listener != null) listener.onLocationEvent(locationEvent);
			break;
		case "StartJump":
			StartJumpEvent startJumpEvent = new StartJumpEvent(timestamp, json);
			if(listener != null) listener.onStartJumpEvent(startJumpEvent);
			break;
		case "SupercruiseEntry":
			SupercruiseEntryEvent supercruiseEntryEvent = new SupercruiseEntryEvent(timestamp, json);
			if(listener != null) listener.onSupercruiseEntryEvent(supercruiseEntryEvent);
			break;
		case "SupercruiseExit":
			SupercruiseExitEvent supercruiseExitEvent = new SupercruiseExitEvent(timestamp, json);
			if(listener != null) listener.onSupercruiseExitEvent(supercruiseExitEvent);
			break;
		case "Touchdown":
			TouchdownEvent touchdownEvent = new TouchdownEvent(timestamp, json);
			if(listener != null) listener.onTouchdownEvent(touchdownEvent);
			break;
		case "Undocked":
			UndockedEvent undockedEvent = new UndockedEvent(timestamp, json);
			if(listener != null) listener.onUndockedEvent(undockedEvent);
			break;
		case "Bounty":
			BountyEvent bountyEvent = new BountyEvent(timestamp, json);
			if(listener != null) listener.onBountyEvent(bountyEvent);
			break;
		case "EscapeInterdiction":
			EscapeInterdictionEvent escapeInterdictionEvent = new EscapeInterdictionEvent(timestamp, json);
			if(listener != null) listener.onEscapeInterdictionEvent(escapeInterdictionEvent);
			break;
		case "FighterDestroyed":
			FighterDestroyedEvent fighterDestroyedEvent = new FighterDestroyedEvent(timestamp, json);
			if(listener != null) listener.onFighterDestroyedEvent(fighterDestroyedEvent);
			break;
		case "CapShipBond":
			CapShipBondEvent capShipBondEvent = new CapShipBondEvent(timestamp, json);
			if(listener != null) listener.onCapShipBondEvent(capShipBondEvent);
			break;
		case "Died":
			if(!json.has("Killers")) {
				DiedEvent diedEvent = new DiedEvent(timestamp, json);
				if(listener != null) listener.onDiedEvent(diedEvent);
			}else {
				DiedByWingEvent diedByWingEvent = new DiedByWingEvent(timestamp, json);
				if(listener != null) listener.onDiedByWingEvent(diedByWingEvent);
			}
			break;
		case "FactionKillBond":
			FactionKillBondEvent factionKillBondEvent = new FactionKillBondEvent(timestamp, json);
			if(listener != null) listener.onFactionKillBondEvent(factionKillBondEvent);
			break;
		case "HeatDamage":
			HeatDamageEvent heatDamageEvent = new HeatDamageEvent(timestamp, json);
			if(listener != null) listener.onHeatDamageEvent(heatDamageEvent);
			break;
		case "HeatWarning":
			HeatWarningEvent hHeatWarningEvent = new HeatWarningEvent(timestamp, json);
			if(listener != null) listener.onHeatWarningEvent(hHeatWarningEvent);
			break;
		case "HullDamage":
			HullDamageEvent hullDamageEvent = new HullDamageEvent(timestamp, json);
			if(listener != null) listener.onHullDamageEvent(hullDamageEvent);
			break;
		case "Interdicted":
			InterdictedEvent interdictedEvent = new InterdictedEvent(timestamp, json);
			if(listener != null) listener.onInterdictedEvent(interdictedEvent);
			break;
		case "Interdiction":
			InterdictionEvent InterdictionEvent = new InterdictionEvent(timestamp, json);
			if(listener != null) listener.onInterdictionEvent(InterdictionEvent);
			break;
		case "PvPKill":
			PvPKillEvent pvpKillEvent = new PvPKillEvent(timestamp, json);
			if(listener != null) listener.onPvPKillEvent(pvpKillEvent);
			break;
		case "ShieldState":
			ShieldStateEvent shieldStateEvent = new ShieldStateEvent(timestamp, json);
			if(listener != null) listener.onShieldStateEvent(shieldStateEvent);
			break;
		case "ShipTargeted":
			ShipTargetedEvent shipTargetedEvent = new ShipTargetedEvent(timestamp, json);
			if(listener != null) listener.onShipTargetedEvent(shipTargetedEvent);
			break;
		case "SRVDestroyed":
			SRVDestroyedEvent srvDestroyedEvent = new SRVDestroyedEvent(timestamp, json);
			if(listener != null) listener.onSRVDestroyedEvent(srvDestroyedEvent);
			break;
		case "UnderAttack":
			UnderAttackEvent underAttackEvent = new UnderAttackEvent(timestamp, json);
			if(listener != null) listener.onUnderAttackEvent(underAttackEvent);
			break;
		case "CodexEntry":
			CodexEntryEvent codexEntryEvent = new CodexEntryEvent(timestamp, json);
			if(listener != null) listener.onCodexEntryEvent(codexEntryEvent);
			break;
		case "DiscoveryScan":
			DiscoveryScanEvent discoveryScanEvent = new DiscoveryScanEvent(timestamp, json);
			if(listener != null) listener.onDiscoveryScanEvent(discoveryScanEvent);
			break;
		case "Scan":
			ScanEvent scanEvent = new ScanEvent(timestamp, json);
			if(listener != null) listener.onScanEvent(scanEvent);
			break;
		case "FSSAllBodiesFound":
			FSSAllBodiesFoundEvent fssAllBodiesFoundEvent = new FSSAllBodiesFoundEvent(timestamp, json);
			if(listener != null) listener.onFSSAllBodiesFoundEvent(fssAllBodiesFoundEvent);
			break;
		case "FSSDiscoveryScan":
			FSSDiscoveryScanEvent fssDiscoveryScanEvent = new FSSDiscoveryScanEvent(timestamp, json);
			if(listener != null) listener.onFSSDiscoveryScanEvent(fssDiscoveryScanEvent);
			break;
		case "FSSSignalDiscovered":
			FSSSignalDiscoveredEvent fssSignalDiscoveredEvent = new FSSSignalDiscoveredEvent(timestamp, json);
			if(listener != null) listener.onFSSSignalDiscoveredEvent(fssSignalDiscoveredEvent);
			break;
		case "MaterialCollected":
			MaterialCollectedEvent materialCollectedEvent = new MaterialCollectedEvent(timestamp, json);
			if(listener != null) listener.onMaterialCollectedEvent(materialCollectedEvent);
			break;
		case "MaterialDiscarded":
			MaterialDiscardedEvent materialDiscardedEvent = new MaterialDiscardedEvent(timestamp, json);
			if(listener != null) listener.onMaterialDiscardedEvent(materialDiscardedEvent);
			break;
		case "MaterialDiscovered":
			MaterialDiscoveredEvent materialDiscoveredEvent = new MaterialDiscoveredEvent(timestamp, json);
			if(listener != null) listener.onMaterialDiscoveredEvent(materialDiscoveredEvent);
			break;
		case "MultiSellExplorationData":
			MultiSellExplorationDataEvent multiSellExplorationDataEvent = new MultiSellExplorationDataEvent(timestamp, json);
			if(listener != null) listener.onMultiSellExplorationDataEvent(multiSellExplorationDataEvent);
			break;
		case "NavBeaconScan":
			NavBeaconScanEvent navBeaconScanEvent = new NavBeaconScanEvent(timestamp, json);
			if(listener != null) listener.onNavBeaconScanEvent(navBeaconScanEvent);
			break;
		case "BuyExplorationData":
			BuyExplorationDataEvent buyExplorationDataEvent = new BuyExplorationDataEvent(timestamp, json);
			if(listener != null) listener.onBuyExplorationDataEvent(buyExplorationDataEvent);
			break;
		case "SAAScanComplete":
			SAAScanCompleteEvent saaScanCompleteEvent = new SAAScanCompleteEvent(timestamp, json);
			if(listener != null) listener.onSAAScanCompleteEvent(saaScanCompleteEvent);
			break;
		case "SellExplorationData":
			SellExplorationDataEvent sellExplorationDataEvent = new SellExplorationDataEvent(timestamp, json);
			if(listener != null) listener.onSellExplorationDataEvent(sellExplorationDataEvent);
			break;
		case "Screenshot":
			ScreenshotEvent screenshotEvent = new ScreenshotEvent(timestamp, json);
			if(listener != null) listener.onScreenshotEvent(screenshotEvent);
			break;
		case "AsteroidCracked":
			AsteroidCrackedEvent asteroidCrackedEvent = new AsteroidCrackedEvent(timestamp, json);
			if(listener != null) listener.onAsteroidCrackedEvet(asteroidCrackedEvent);
			break;
		case "BuyTradeData":
			BuyTradeDataEvent buyTradeDataEvent = new BuyTradeDataEvent(timestamp, json);
			if(listener != null) listener.onBuyTradeDataEvent(buyTradeDataEvent);
			break;
		case "CollectCargo":
			CollectCargoEvent collectCargoEvent = new CollectCargoEvent(timestamp, json);
			if(listener != null) listener.onCollectCargoEvent(collectCargoEvent);
			break;
		case "EjectCargo":
			EjectCargoEvent ejectCargoEvent = new EjectCargoEvent(timestamp, json);
			if(listener != null) listener.onEjectCargoEvent(ejectCargoEvent);
			break;
		case "MarketBuy":
			MarketBuyEvent marketBuyEvent = new MarketBuyEvent(timestamp, json);
			if(listener != null) listener.onMarketBuyEvent(marketBuyEvent);
			break;
		case "MarketSell":
			MarketSellEvent marketSellEvent = new MarketSellEvent(timestamp, json);
			if(listener != null) listener.onMarketSellEvent(marketSellEvent);
			break;
		case "MiningRefined":
			MiningRefinedEvent miningRefinedEvent = new MiningRefinedEvent(timestamp, json);
			if(listener != null) listener.onMiningRefinedEvent(miningRefinedEvent);
			break;
		case "BuyAmmo":
			BuyAmmoEvent buyAmmoEvent = new BuyAmmoEvent(timestamp, json);
			if(listener != null) listener.onBuyAmmoEvent(buyAmmoEvent);
			break;
		case "BuyDrones":
			BuyDronesEvent buyDronesEvent = new BuyDronesEvent(timestamp, json);
			if(listener != null) listener.onBuyDronesEvent(buyDronesEvent);
			break;
		case "CargoDepot":
			CargoDepotEvent cargoDepotEvent = new CargoDepotEvent(timestamp, json);
			if(listener != null) listener.onCargoDepotEvent(cargoDepotEvent);
			break;
		case "CommunityGoal":
			CommunityGoalEvent communityGoalEvent = new CommunityGoalEvent(timestamp, json);
			if(listener != null) listener.onCommunityGoalEvent(communityGoalEvent);
			break;
		case "CommunityGoalDiscard":
			CommunityGoalDiscardEvent communityGoalDiscardEvent = new CommunityGoalDiscardEvent(timestamp, json);
			if(listener != null) listener.onCommunityGoalDiscardEvent(communityGoalDiscardEvent);
			break;
		case "CommunityGoalJoin":
			CommunityGoalJoinEvent communityGoalJoinEvent = new CommunityGoalJoinEvent(timestamp, json);
			if(listener != null) listener.onCommunityGoalJoinEvent(communityGoalJoinEvent);
			break;
		case "CommunityGoalReward":
			CommunityGoalRewardEvent communityGoalRewardEvent = new CommunityGoalRewardEvent(timestamp, json);
			if(listener != null) listener.onCommunityGoalRewardEvent(communityGoalRewardEvent);
			break;
		case "CrewAssign":
			CrewAssignEvent crewAssignEvent = new CrewAssignEvent(timestamp, json);
			if(listener != null) listener.onCrewAssignEvent(crewAssignEvent);
			break;
		case "CrewFire":
			CrewFireEvent crewFireEvent = new CrewFireEvent(timestamp, json);
			if(listener != null) listener.onCrewFireEvent(crewFireEvent);
			break;
		case "CrewHire":
			CrewHireEvent crewHireEvent = new CrewHireEvent(timestamp, json);
			if(listener != null) listener.onCrewHireEvent(crewHireEvent);
			break;
		case "EngineerContribution":
			EngineerContributionEvent engineerContributionEvent = new EngineerContributionEvent(timestamp, json);
			if(listener != null) listener.onEngineerContributionEvent(engineerContributionEvent);
			break;
		case "EngineerCraft":
			EngineerCraftEvent engineerCraftEvent = new EngineerCraftEvent(timestamp, json);
			if(listener != null) listener.onEngineerCraftEvent(engineerCraftEvent);
			break;
		case "EngineerProgress":
			EngineerProgressEvent engineerProgressEvent = new EngineerProgressEvent(timestamp, json);
			if(listener != null) listener.onEngineerProgressEvent(engineerProgressEvent);
			break;
		case "FetchRemoteModule":
			FetchRemoteModuleEvent fetchRemoteModuleEvent = new FetchRemoteModuleEvent(timestamp, json);
			if(listener != null) listener.onFetchRemoteModuleEvent(fetchRemoteModuleEvent);
			break;
		case "Market":
			MarketEvent marketEvent = new MarketEvent(timestamp, json);
			if(listener != null) listener.onMarketEvent(marketEvent);
			break;
		case "MassModuleStore":
			MassModuleStoreEvent massModuleStoreEvent = new MassModuleStoreEvent(timestamp, json);
			if(listener != null) listener.onMassModuleStore(massModuleStoreEvent);
			break;
		case "MaterialTrade":
			MaterialTradeEvent materialTradeEvent = new MaterialTradeEvent(timestamp, json);
			if(listener != null) listener.onMaterialTrade(materialTradeEvent);
			break;
		case "MissionAbandoned":
			MissionAbandonedEvent missionAbandonedEvent = new MissionAbandonedEvent(timestamp, json);
			if(listener != null) listener.onMissionAbandoned(missionAbandonedEvent);
			break;
		case "MissionAccepted":
			MissionAcceptedEvent missionAcceptedEvent = new MissionAcceptedEvent(timestamp, json);
			if(listener != null) listener.onMissionAccepted(missionAcceptedEvent);
			break;
		case "MissionCompleted":
			MissionCompletedEvent missionCompletedEvent = new MissionCompletedEvent(timestamp, json);
			if(listener != null) listener.onMissionCompleted(missionCompletedEvent);
			break;
		case "MissionFailed":
			MissionFailedEvent missionFailedEvent = new MissionFailedEvent(timestamp, json);
			if(listener != null) listener.onMissionFailed(missionFailedEvent);
			break;
		case "MissionRedirected":
			MissionRedirectedEvent missionRedirectedEvent = new MissionRedirectedEvent(timestamp, json);
			if(listener != null) listener.onMissionRedirected(missionRedirectedEvent);
			break;
		case "ModuleBuy":
			ModuleBuyEvent moduleBuyEvent = new ModuleBuyEvent(timestamp, json);
			if(listener != null) listener.onModuleBuy(moduleBuyEvent);
			break;
		case "ModuleRetrieve":
			ModuleRetrieveEvent moduleRetrieveEvent = new ModuleRetrieveEvent(timestamp, json);
			if(listener != null) listener.onModuleRetrieve(moduleRetrieveEvent);
			break;
		case "ModuleSell":
			ModuleSellEvent moduleSellEvent = new ModuleSellEvent(timestamp, json);
			if(listener != null) listener.onModuleSell(moduleSellEvent);
			break;
		case "ModuleSellRemote":
			ModuleSellRemote moduleSellRemote = new ModuleSellRemote(timestamp, json);
			if(listener != null) listener.onModuleSellRemote(moduleSellRemote);
			break;
		case "ModuleStore":
			ModuleStoreEvent moduleStoreEvent = new ModuleStoreEvent(timestamp, json);
			if(listener != null) listener.onModuleStore(moduleStoreEvent);
			break;
		case "ModuleSwap":
			ModuleSwapEvent moduleSwapEvent = new ModuleSwapEvent(timestamp, json);
			if(listener != null) listener.onModuleSwap(moduleSwapEvent);
			break;
		case "Outfitting":
			OutfittingEvent outfittingEvent = new OutfittingEvent(timestamp, json);
			if(listener != null) listener.onOutfitting(outfittingEvent);
			break;
		case "PayBounties":
			PayBountiesEvent payBountiesEvent = new PayBountiesEvent(timestamp, json);
			if(listener != null) listener.onPayBounties(payBountiesEvent);
			break;
		case "PayFines":
			PayFinesEvent payFinesEvent = new PayFinesEvent(timestamp, json);
			if(listener != null) listener.onPayFines(payFinesEvent);
			break;
		case "RedeemVoucher":
			RedeemVoucherEvent redeemVoucherEvent = new RedeemVoucherEvent(timestamp, json);
			if(listener != null) listener.onRedeemVoucher(redeemVoucherEvent);
			break;
		case "RefuelAll":
			RefuelAllEvent refuelAllEvent = new RefuelAllEvent(timestamp, json);
			if(listener != null) listener.onRefuelAll(refuelAllEvent);
			break;
		case "RefuelPartial":
			RefuelPartialEvent refuelPartialEvent = new RefuelPartialEvent(timestamp, json);
			if(listener != null) listener.onRefuelPartial(refuelPartialEvent);
			break;
		case "Repair":
			RepairEvent repairEvent = new RepairEvent(timestamp, json);
			if(listener != null) listener.onRepair(repairEvent);
			break;
		case "RepairAll":
			RepairAllEvent repairAllEvent = new RepairAllEvent(timestamp, json);
			if(listener != null) listener.onRepairAll(repairAllEvent);
			break;
		case "RestockVehicle":
			RestockVehicleEvent restockVehicleEvent = new RestockVehicleEvent(timestamp, json);
			if(listener != null) listener.onRestockVehicle(restockVehicleEvent);
			break;
		case "ScientificResearch":
			ScientificResearchEvent scientificResearchEvent = new ScientificResearchEvent(timestamp, json);
			if(listener != null) listener.onScientificResearch(scientificResearchEvent);
			break;
		case "SearchAndRescue":
			SearchAndRescueEvent searchAndRescueEvent = new SearchAndRescueEvent(timestamp, json);
			if(listener != null) listener.onSearchAndRescue(searchAndRescueEvent);
			break;
		case "SellDrones":
			SellDronesEvent sellDronesEvent = new SellDronesEvent(timestamp, json);
			if(listener != null) listener.onSellDrones(sellDronesEvent);
			break;
		case "SellShipOnRebuy":
			SellShipOnRebuyEvent sellShipOnRebuyEvent = new SellShipOnRebuyEvent(timestamp, json);
			if(listener != null) listener.onSellShipOnRebuy(sellShipOnRebuyEvent);
			break;
		case "SetUserShipName":
			SetUserShipNameEvent setUserShipNameEvent = new SetUserShipNameEvent(timestamp, json);
			if(listener != null) listener.onSetUserShipName(setUserShipNameEvent);
			break;
		case "Shipyard":
			ShipyardEvent shipyardEvent = new ShipyardEvent(timestamp, json);
			if(listener != null) listener.onShipyard(shipyardEvent);
			break;
		case "ShipyardBuy":
			ShipyardBuyEvent shipyardBuyEvent = new ShipyardBuyEvent(timestamp, json);
			if(listener != null) listener.onShipyardBuy(shipyardBuyEvent);
			break;
		case "ShipyardNew":
			ShipyardNewEvent shipyardNewEvent = new ShipyardNewEvent(timestamp, json);
			if(listener != null) listener.onShipyardNew(shipyardNewEvent);
			break;
		case "ShipyardSell":
			ShipyardSellEvent shipyardSellEvent = new ShipyardSellEvent(timestamp, json);
			if(listener != null) listener.onShipyardSell(shipyardSellEvent);
			break;
		case "ShipyardTransfer":
			ShipyardTransferEvent shipyardTransferEvent = new ShipyardTransferEvent(timestamp, json);
			if(listener != null) listener.onShipyardTransfer(shipyardTransferEvent);
			break;
		case "ShipyardSwap":
			ShipyardSwapEvent shipyardSwapEvent = new ShipyardSwapEvent(timestamp, json);
			if(listener != null) listener.onShipyardSwap(shipyardSwapEvent);
			break;
		case "StoredModules":
			StoredModulesEvent storedModulesEvent = new StoredModulesEvent(timestamp, json);
			if(listener != null) listener.onStoredModules(storedModulesEvent);
			break;
		case "StoredShips":
			StoredShipsEvent storedShipsEvent = new StoredShipsEvent(timestamp, json);
			if(listener != null) listener.onStoredShips(storedShipsEvent);
			break;
		case "TechnologyBroker":
			//TechnologyBrokerEvent technologyBrokerEent= new TechnologyBrokerEvent(timestamp, json); Continue
			break;
		default:
			JournalUtils.sendUnprocessedEvent(event, json);
			break;
		}
	}

}
