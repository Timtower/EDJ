package org.xenodev.edj.utils;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xenodev.edj.EDJApi;
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
											fireEvent(new JSONObject(journalEntries.get(i)), l);
											if(debug) {
												String timeDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
												System.out.println("{" + timeDate + "} [DEBUG] processing journal entry: " + journalEntries.get(i));
											}
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
		String timestamp = json.getString("timestamp");
		String event = json.getString("event");
		
		switch(event) {
		case "Cargo":
			if(json.has("Inventory")) {
				CargoEvent cargoEvent = new CargoEvent(timestamp, json.getString("Vessel"), JournalUtils.createCargoInventory(json.getJSONArray("Inventory")));
				listener.onCargoEvent(cargoEvent);
			}
			break;
		case "ClearSavedGame":
			ClearSavedGameEvent clearSavedGameEvent = new ClearSavedGameEvent(timestamp, json.getString("Name"), json.getString("FID"));
			listener.onClearSavedGameEvent(clearSavedGameEvent);
			break;
		case "Commander":
			CommanderEvent commanderEvent = new CommanderEvent(timestamp, json.getString("Name"), json.getString("FID"));
			listener.onCommanderEvent(commanderEvent);
			break;
		case "Loadout":
			LoadoutEvent loadoutEvent = new LoadoutEvent(timestamp, json.getString("Ship"), json.getString("ShipName"), json.getString("ShipIdent"), json.getInt("ShipID"),
					json.getInt("HullValue"), json.getInt("ModulesValue"), json.getInt("HullHealth"), json.getInt("Rebuy"), JournalUtils.createModuleList(json.getJSONArray("Modules")));
			listener.onLoadoutEvent(loadoutEvent);
			break;
		case "Materials":
			MaterialsEvent materialEvent = new MaterialsEvent(timestamp, JournalUtils.createRawMaterialList(json.getJSONArray("Raw")),
					JournalUtils.createManufacturedMaterialList(json.getJSONArray("Manufactured")), JournalUtils.createEncodedMaterialList(json.getJSONArray("Encoded")));
			listener.onMaterialsEvent(materialEvent);
			break;
		case "Missions":
			MissionsEvent missionEvent = new MissionsEvent(timestamp, JournalUtils.createMissionList(json.getJSONArray("Active")), JournalUtils.createMissionList(json.getJSONArray("Failed")),
					JournalUtils.createMissionList(json.getJSONArray("Complete")));
			listener.onMissionEvent(missionEvent);
			break;
		case "NewCommander":
			NewCommanderEvent newCommanderEvent = new NewCommanderEvent(timestamp, json.getString("Name"), json.getString("FID"), json.getString("starterPackage"));
			listener.onNewCommanderEvent(newCommanderEvent);
			break;
		case "LoadGame":
			LoadGameEvent loadGameEvent = new LoadGameEvent(timestamp, json.getString("Commander"), json.getString("FID"), json.getString("Ship"), json.getString("ShipName"),
					json.getString("ShipIdent"), json.getString("GameMode"), json.getInt("ShipID"), json.getDouble("FuelLevel"), json.getDouble("FuelCapacity"), json.getLong("Credits"),
					json.getLong("Loan"), json.getBoolean("Horizons"));
			listener.onLoadGameEvent(loadGameEvent);
			break;
		case "Passengers":
			listener.onPassengerEvent(new PassengersEvent(timestamp, JournalUtils.createPassengerManifest(json.getJSONArray("Manifest"))));
			break;
		case "Powerplay":
			PowerplayEvent powerplayEvent = new PowerplayEvent(timestamp, json.getString("Power"), json.getInt("Rank"), json.getInt("Merits"), json.getInt("Votes"), json.getInt("TimePledged"));
			listener.onPowerPlayEvent(powerplayEvent);
			break;
		case "Progress":
			ProgressEvent progressEvent = new ProgressEvent(timestamp, json.getInt("Combat"), json.getInt("Trade"), json.getInt("Explore"), json.getInt("Empire"), json.getInt("Federation"),
					json.getInt("CQC"));
			listener.onProgressEvent(progressEvent);
			break;
		case "Rank":
			RankEvent rankEvent = new RankEvent(timestamp, json.getInt("Combat"), json.getInt("Trade"), json.getInt("Explore"), json.getInt("Empire"), json.getInt("Federation"),
					json.getInt("CQC"));
			listener.onRankEvent(rankEvent);
			break;
		case "Reputation":
			ReputationEvent reputationEvent = new ReputationEvent(timestamp, (int)json.getDouble("Empire"), (int)json.getDouble("Federation"), (int)json.getDouble("Alliance"));
			listener.onReputationEvent(reputationEvent);
			break;
		case "Statistics":
			JSONObject bankAccount = json.getJSONObject("Bank_Account");
			JSONObject combat = json.getJSONObject("Combat");
			JSONObject crime = json.getJSONObject("Crime");
			JSONObject smuggling = json.getJSONObject("Smuggling");
			JSONObject trading = json.getJSONObject("Trading");
			JSONObject mining = json.getJSONObject("Mining");
			JSONObject exploration = json.getJSONObject("Exploration");
			JSONObject passengers = json.getJSONObject("Passengers");
			JSONObject searchAndRescue = json.getJSONObject("Search_And_Rescue");
			JSONObject thargoid = json.getJSONObject("TG_ENCOUNTERS");
			JSONObject crafting = json.getJSONObject("Crafting");
			JSONObject crew = json.getJSONObject("Crew");
			JSONObject multicrew = json.getJSONObject("Multicrew");
			JSONObject materialTrader = json.getJSONObject("Material_Trader_Stats");
			StatisticsEvent statisticsEvent = new StatisticsEvent(timestamp, bankAccount.getLong("Current_Wealth"), bankAccount.getLong("Spent_On_Ships"), 
					bankAccount.getLong("Spent_On_Outfitting"), bankAccount.getLong("Spent_On_Repairs"), bankAccount.getLong("Spent_On_Fuel"), bankAccount.getLong("Spent_On_Ammo_Consumables"),
					bankAccount.getLong("Spent_On_Insurance"), combat.getLong("Bounty_Hunting_Profit"), combat.getLong("Combat_Bond_Profits"), combat.getLong("Assassination_Profits"),
					crime.getLong("Total_Fines"), crime.getLong("Total_Bounties"), smuggling.getLong("Black_Markets_Profits"), smuggling.getLong("Average_Profit"),
					trading.getLong("Market_Profits"),	mining.getLong("Mining_Profits"),	exploration.getLong("Exploration_Profits"), searchAndRescue.getLong("SearchRescue_Profit"),
					crew.getLong("NpcCrew_TotalWages"), crime.getInt("Bounties_Received"), bankAccount.getInt("Insurance_Claims"), bankAccount.getInt("Owned_Ship_Count"),
					combat.getInt("Bounties_Claimed"), combat.getInt("Combat_Bonds"), combat.getInt("Assassinations"), combat.getInt("Highest_Single_Reward"), combat.getInt("Skimmers_Killed"),
					crime.getInt("Notoriety"), crime.getInt("Fines"), crime.getInt("Highest_Bounty"), smuggling.getInt("Black_Markets_Traded_With"), smuggling.getInt("Resources_Smuggled"),
					smuggling.getInt("Highest_Single_Transaction"), trading.getInt("Markets_Traded_With"), trading.getInt("Resources_Traded"), trading.getInt("Average_Profit"),
					trading.getInt("Highest_Single_Transaction"), mining.getInt("Quantity_Mined"), mining.getInt("Materials_Collected"), exploration.getInt("Systems_Visited"),
					exploration.getInt("Planets_Scanned_To_Level_2"), exploration.getInt("Planets_Scanned_To_Level_3"),	exploration.getInt("Efficient_Scans"),
					exploration.getInt("Highest_Payout"), exploration.getInt("Total_Hyperspace_Distance"), exploration.getInt("Total_Hyperspace_Jumps"),
					exploration.getInt("Greatest_Distance_From_Start"), exploration.getInt("Time_Played"), passengers.getInt("Passengers_Missions_Accepted"),
					passengers.getInt("Passengers_Missions_Disgruntled"), passengers.getInt("Passengers_Missions_Bulk"), passengers.getInt("Passengers_Missions_VIP"),
					passengers.getInt("Passengers_Missions_Delivered"), passengers.getInt("Passengers_Missions_Ejected"), searchAndRescue.getInt("SearchRescue_Traded"),
					searchAndRescue.getInt("SearchRescue_Count"), thargoid.getInt("TG_ENCOUNTER_TOTAL"), thargoid.getInt("TG_SCOUT_COUNT"), crafting.getInt("Count_Of_Used_Engineers"),
					crafting.getInt("Recipes_Generated"), crafting.getInt("Recipes_Generated_Rank_1"), crafting.getInt("Recipes_Generated_Rank_2"), crafting.getInt("Recipes_Generated_Rank_3"),
					crafting.getInt("Recipes_Generated_Rank_4"), crafting.getInt("Recipes_Generated_Rank_5"), crew.getInt("NpcCrew_Hired"), crew.getInt("NpcCrew_Fired"),
					multicrew.getInt("Multicrew_Time_Total"), multicrew.getInt("Multicrew_Gunner_Time_Total"), multicrew.getInt("Multicrew_Fighter_Time_Total"),
					multicrew.getInt("Multicrew_Credits_Total"), multicrew.getInt("Multicrew_Fines_Total"), materialTrader.getInt("Trades_Completed"), materialTrader.getInt("Materials_Traded"),
					materialTrader.getInt("Encoded_Materials_Traded"), materialTrader.getInt("Grade_1_Materials_Traded"), materialTrader.getInt("Grade_2_Materials_Traded"),
					materialTrader.getInt("Grade_3_Materials_Traded"), materialTrader.getInt("Grade_4_Materials_Traded"), materialTrader.getInt("Grade_5_Materials_Traded"),
					thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_SYSTEM"), thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP"), thargoid.getString("TG_ENCOUNTER_TOTAL_LAST_SHIP"));
			listener.onStatisticsEvent(statisticsEvent);
			break;
		case "ApproachBody":
			ApproachBodyEvent approachBodyEvent = new ApproachBodyEvent(timestamp, json.getString("StartSystem"), json.getString("Body"), json.getInt("BodyID"), json.getLong("SystemAddress"));
			listener.onApproachBodyEvent(approachBodyEvent);
			break;
		case "Docked":
			JSONObject stationFaction = json.getJSONObject("StationFaction");
			JSONArray array = json.getJSONArray("StationServices");
			DockedEvent dockedEvent = new DockedEvent(timestamp, json.getString("StationName"), json.getString("StationType"), json.getString("StarSystem"), json.getString("Name"),
					stationFaction.getString("State"), json.getString("StationGovernment"), json.getString("StationGovernment_Localised"), json.getString("StationAllegiance"),
					json.getString("StationEconomy"), json.getString("StationEconomy_Localised"), JournalUtils.createStationEconomiesList(json.getJSONArray("StationEconomies")),
					json.getLong("SystemAddress"), json.getLong("MarketID"), json.getDouble("DistFromStarLS"), array.toList().stream()
					.map(object -> Objects.toString(object))
					.collect(Collectors.toList()));
			listener.onDockedEvent(dockedEvent);
			break;
		case "DockingDenied":
			DockingDeniedEvent dockingDeniedEvent = new DockingDeniedEvent(timestamp, json.getString("Reason"), json.getString("StationName"), json.getString("StationType"),
					json.getLong("marketID"));
			listener.onDockingDeniedEvent(dockingDeniedEvent);
			break;
		case "DockingGranted":
			DockingGrantedEvent dockingGrantedEvent = new DockingGrantedEvent(timestamp, json.getString("StationName"), json.getString("StationType"), json.getLong("MarketID"),
					json.getInt("LandingPad"));
			listener.onDockingGrantedEvent(dockingGrantedEvent);
			break;
		case "DockingCancelled":
			DockingCancelledEvent dockingCancelledEvent = new DockingCancelledEvent(timestamp);
			listener.onDockingCancelledEvent(dockingCancelledEvent);
			break;
		case "DockingRequested":
			DockingRequestedEvent dockingRequestedEvent = new DockingRequestedEvent(timestamp,  json.getString("StationName"), json.getString("StationType"), json.getLong("MarketID"));
			listener.onDockingRequestedEvent(dockingRequestedEvent);
			break;
		case "FSDJump":
			FSDJumpEvent fsdJumpEvent = new FSDJumpEvent(timestamp, json.getString("StarSystem"), json.getString("SystemAllegiance"),json.getString("SystemEconomy"),
					json.getString("SystemEconomy_Localised"), json.getString("SystemSecondEconomy"), json.getString("SystemSecondEconomy_Localised"), json.getString("SystemGovernment"),
					json.getString("SystemGovernment_Localised"), json.getString("SystemSecurity"), json.getString("SystemSecurity_Localised"), json.getLong("Population"),
					json.getLong("SystemAddress"), json.getDouble("JumpDist"), json.getDouble("FuelUsed"), json.getDouble("FuelLevel"),
					JournalUtils.createFactionList(json.getJSONArray("Factions")), JournalUtils.createPositionArray(json.getJSONArray("StarPos")));
			listener.onFSDJumpEvent(fsdJumpEvent);
			break;
		case "FSDTarget":
			FSDTargetEvent fsdTargetEvent = new FSDTargetEvent(timestamp, json.getString("Name"), json.getLong("SystemAddress"));
			listener.onFSDTargetEvent(fsdTargetEvent);
			break;
		case "LeaveBody":
			LeaveBodyEvent leaveBodyEvent = new LeaveBodyEvent(timestamp, json.getString("StarSystem"), json.getString("Body"), json.getLong("SystemAddress"), json.getInt("BodyID"));
			listener.onLeaveBodyEvent(leaveBodyEvent);
			break;
		case "Liftoff":
			LiftoffEvent liftoffEvent = new LiftoffEvent(timestamp, json.getBoolean("PlayerControlled"));
			if(json.getBoolean("PlayerControlled")) {
				liftoffEvent = new LiftoffEvent(timestamp, json.getBoolean("PlayerControlled"), json.getDouble("Longitude"), json.getDouble("Latitude"));
			}
			listener.onLiftoffEvent(liftoffEvent);
			break;
		case "Location":
			LocationEvent locationEvent = new LocationEvent(timestamp, json.getString("StarSystem"), json.getString("SystemAllegiance"), json.getString("SystemEconomy"),
					json.getString("SystemEconomy_Localised"), json.getString("SystemSecondEconomy"), json.getString("SystemSecondEconomy_Localised"), json.getString("SystemGovernment"),
					json.getString("SystemGovernment_Localised"), json.getString("SystemSecurity"), json.getString("SystemSecurity_Localised"), json.getString("Body"),
					json.getString("BodyType"), JournalUtils.createPositionArray(json.getJSONArray("StarPos")), json.getLong("SystemAddress"),
					json.getLong("Population"), JsonTranslator.getLong(json, "MarketID"), json.getInt("BodyID"), json.getBoolean("Docked"));
			if(json.has("Powers")) {
				locationEvent = new LocationEvent(timestamp, json.getString("StarSystem"), json.getString("SystemAllegiance"), json.getString("SystemEconomy"),
						json.getString("SystemEconomy_Localised"), json.getString("SystemSecondEconomy"), json.getString("SystemSecondEconomy_Localised"),
						json.getString("SystemGovernment"), json.getString("SystemGovernment_Localised"), json.getString("SystemSecurity"), json.getString("SystemSecurity_Localised"),
						json.getString("Body"), json.getString("BodyType"), json.getJSONObject("SystemFaction").getString("Name"), json.getJSONObject("SystemFaction").getString("FactionState"),
						json.getString("PowerplayState"), JournalUtils.createPositionArray(json.getJSONArray("StarPos")), json.getLong("SystemAddress"), json.getLong("Population"),
						JsonTranslator.getLong(json, "MarketID"), json.getInt("BodyID"), json.getBoolean("Docked"), JournalUtils.createFactionList(json.getJSONArray("Factions")),
						JournalUtils.createPowersArray(json.getJSONArray("Powers")));
			}else if(!json.has("Powers") && json.has("")) {
				locationEvent = new LocationEvent(timestamp, json.getString("StarSystem"), json.getString("SystemAllegiance"), json.getString("SystemEconomy"),
						json.getString("SystemEconomy_Localised"), json.getString("SystemSecondEconomy"), json.getString("SystemSecondEconomy_Localised"), json.getString("SystemGovernment"),
						json.getString("SystemGovernment_Localised"), json.getString("SystemSecurity"), json.getString("SystemSecurity_Localised"), json.getString("Body"),
						json.getString("BodyType"), json.getJSONObject("SystemFaction").getString("Name"), json.getJSONObject("SystemFaction").getString("FactionState"),
						JournalUtils.createPositionArray(json.getJSONArray("StarPos")),	json.getLong("SystemAddress"), json.getLong("Population"), JsonTranslator.getLong(json, "MarketID"),
						json.getInt("BodyID"), json.getBoolean("Docked"), JournalUtils.createFactionList(json.getJSONArray("Factions")));
			}
			listener.onLocationEvent(locationEvent);
			break;
		case "StartJump":
			StartJumpEvent startJumpEvent = new StartJumpEvent(timestamp, json.getString("JumpType"));
			if(json.getString("JumpType").equals("SuperCruise")) {
				startJumpEvent = new StartJumpEvent(timestamp, json.getString("JumpType"), json.getString("StarSystem"), json.getString("StarClass"), json.getLong("SystemAddress"));
			}
			listener.onStartJumpEvent(startJumpEvent);
			break;
		case "SupercruiseEntry":
			SupercruiseEntryEvent supercruiseEntryEvent = new SupercruiseEntryEvent(timestamp, json.getString("StarSystem"), json.getLong("SystemAddress"));
			listener.onSupercruiseEntryEvent(supercruiseEntryEvent);
			break;
		case "SupercruiseExit":
			SupercruiseExitEvent supercruiseExitEvent = new SupercruiseExitEvent(timestamp, json.getString("StarSystem"), json.getString("Body"), json.getString("BodyType"),
					json.getLong("SystemAddress"), json.getInt("BodyID"));
			listener.onSupercruiseExitEvent(supercruiseExitEvent);
			break;
		case "Touchdown":
			TouchdownEvent touchdownEvent = new TouchdownEvent(timestamp, json.getBoolean("PlayerControlled"));
			if(json.getBoolean("PlayerControlled")) {
				touchdownEvent = new TouchdownEvent(timestamp, json.getBoolean("PlayerControlled"), json.getDouble("Longitude"), json.getDouble("Latitude"));
			}
			listener.onTouchdownEvent(touchdownEvent);
			break;
		case "Undocked":
			UndockedEvent undockedEvent = new UndockedEvent(timestamp, json.getString("StationName"), json.getString("StationType"), json.getLong("MarketID"));
			listener.onUndockedEvent(undockedEvent);
			break;
		case "Bounty":
			listener.onBountyEvent(new BountyEvent(timestamp, json));
			break;
		case "EscapeInterdiction":
			EscapeInterdictionEvent escapeInterdictionEvent = new EscapeInterdictionEvent(timestamp, json.getString("Interdictor"), json.getBoolean("IsPlayer"));
			listener.onEscapeInterdictionEvent(escapeInterdictionEvent);
			break;
		case "FighterDestroyed":
			listener.onFighterDestroyedEvent(new FighterDestroyedEvent(timestamp));
			break;
		case "CapShipBond":
			CapShipBondEvent capShipBondEvent = new CapShipBondEvent(timestamp, json.getString("VictimFaction"), json.getString("AwardingFaction"), json.getInt("Reward"));
			listener.onCapShipBondEvent(capShipBondEvent);
			break;
		case "Died":
			if(!json.has("Killers")) {
				DiedEvent diedEvent = new DiedEvent(timestamp, json.getString("KillerName"), json.getString("KillerShip"), json.getString("KillerRank"));
				listener.onDiedEvent(diedEvent);
			}else {
				DiedByWingEvent diedByWingEvent = new DiedByWingEvent(timestamp, JournalUtils.createKillerList(json.getJSONArray("Killers")));
				listener.onDiedByWingEvent(diedByWingEvent);
			}
			break;
		case "FactionKillBond":
			FactionKillBondEvent factionKillBondEvent = new FactionKillBondEvent(timestamp, json.getString("VictimFaction"), json.getString("AwardingFaction"), json.getInt("Reward"));
			listener.onFactionKillBondEvent(factionKillBondEvent);
			break;
		case "HeatDamage":
			listener.onHeatDamageEvent(new HeatDamageEvent(timestamp));
			break;
		case "HeatWarning":
			listener.onHeatWarningEvent(new HeatWarningEvent(timestamp));
			break;
		case "HullDamage":
			HullDamageEvent hullDamageEvent = new HullDamageEvent(timestamp, json.getDouble("Health"), json.getBoolean("PlayerPilot"));
			if(json.has("Fighter")) {
				hullDamageEvent = new HullDamageEvent(timestamp, json.getDouble("Health"), json.getBoolean("PlayerPilot"), json.getBoolean("Fighter"));
			}
			listener.onHullDamageEvent(hullDamageEvent);
			break;
		case "Interdicted":
			if(json.getBoolean("IsPlayer")) {
				InterdictedByPlayerEvent interdictedByPlayerEvent = new InterdictedByPlayerEvent(timestamp, json.getBoolean("Submitted"), json.getBoolean("IsPlayer"),
						json.getString("Interdictor"), json.getInt("CombatRank"));
				listener.onInterdictedByPlayerEvent(interdictedByPlayerEvent);
			}else {
				InterdictedByNpcEvent interdictedByNpcEvent = new InterdictedByNpcEvent(timestamp, json.getBoolean("Submitted"), json.getBoolean("IsPlayer"), json.getString("Interdictor"),
						json.getString("Faction"), json.getString("Power"));
				listener.onInterdictedByNpcEvent(interdictedByNpcEvent);
			}
			break;
		case "Interdiction":
			if(json.getBoolean("IsPlayer")) {
				InterdictionByPlayerEvent InterdictionByPlayerEvent = new InterdictionByPlayerEvent(timestamp, json.getBoolean("Submitted"), json.getBoolean("IsPlayer"),
						json.getString("Interdictor"), json.getInt("CombatRank"));
				listener.onInterdictionByPlayerEvent(InterdictionByPlayerEvent);
			}else {
				InterdictionByNpcEvent InterdictionByNpcEvent = new InterdictionByNpcEvent(timestamp, json.getBoolean("Submitted"), json.getBoolean("IsPlayer"), json.getString("Interdictor"),
						json.getString("Faction"), json.getString("Power"));
				listener.onInterdictionByNpcEvent(InterdictionByNpcEvent);
			}
			break;
		case "PvPKill":
			PvPKillEvent pvpKillEvent = new PvPKillEvent(timestamp, json.getString("Victim"), json.getInt("CombatRank"));
			listener.onPvPKillEvent(pvpKillEvent);
			break;
		case "ShieldState":
			ShieldStateEvent shieldStateEvent = new ShieldStateEvent(timestamp, json.getBoolean("ShieldsUp"));
			listener.onShieldStateEvent(shieldStateEvent);
			break;
		case "ShipTargeted":
			ShipTargetedEvent shipTargetedEvent = new ShipTargetedEvent(timestamp, json);
			listener.onShipTargetedEvent(shipTargetedEvent);
			break;
		case "SRVDestroyed":
			listener.onSRVDestroyedEvent(new SRVDestroyedEvent(timestamp));
			break;
		case "UnderAttack":
			listener.onUnderAttackEvent(new UnderAttackEvent(timestamp, json.getString("Target")));
			break;
		case "CodexEntry":
			CodexEntryEvent codexEntryEvent = new CodexEntryEvent(timestamp, json.getString("Name"), json.getString("SubCategory"), json.getString("SubCategory_Localised"),
					json.getString("Category"), json.getString("Category_Localised"), json.getString("Region"), json.getString("System"), json.getInt("EntryID"), json.getLong("SystemAddress"),
					json.getBoolean("IsNewEntry"), json.getBoolean("NewTraitsDiscovered"), JournalUtils.createTraitsList(json.getJSONArray("Traits")));
			listener.onCodexEntryEvent(codexEntryEvent);
			break;
		case "DiscoveryScan":
			DiscoveryScanEvent discoveryScanEvent = new DiscoveryScanEvent(timestamp, json.getLong("SystemAddress"), json.getInt("Bodies"));
			listener.onDiscoveryScanEvent(discoveryScanEvent);
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
		}
		
	}

}
