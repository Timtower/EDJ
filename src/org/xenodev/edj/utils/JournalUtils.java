package org.xenodev.edj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.CargoInventory;
import org.xenodev.edj.events.storage.ConflicFaction;
import org.xenodev.edj.events.storage.Conflict;
import org.xenodev.edj.events.storage.Engineering;
import org.xenodev.edj.events.storage.Faction;
import org.xenodev.edj.events.storage.FactionState;
import org.xenodev.edj.events.storage.Killer;
import org.xenodev.edj.events.storage.Mission;
import org.xenodev.edj.events.storage.Modifier;
import org.xenodev.edj.events.storage.Module;
import org.xenodev.edj.events.storage.ModuleItem;
import org.xenodev.edj.events.storage.PassengerManifest;
import org.xenodev.edj.events.storage.StationEconomy;
import org.xenodev.edj.events.storage.StoredModule;
import org.xenodev.edj.events.storage.StoredShipHere;
import org.xenodev.edj.events.storage.StoredShipRemote;
import org.xenodev.edj.events.storage.TradeData;
import org.xenodev.edj.events.storage.bounty.BountyReward;
import org.xenodev.edj.events.storage.bounty.FactionBounty;
import org.xenodev.edj.events.storage.engineer.EngineerProgress;
import org.xenodev.edj.events.storage.engineer.Ingredient;
import org.xenodev.edj.events.storage.market.Item;
import org.xenodev.edj.events.storage.material.Encoded;
import org.xenodev.edj.events.storage.material.Manufactured;
import org.xenodev.edj.events.storage.material.Raw;
import org.xenodev.edj.events.storage.scan.AtmosphereComposition;
import org.xenodev.edj.events.storage.scan.Composition;
import org.xenodev.edj.events.storage.scan.Material;
import org.xenodev.edj.events.storage.scan.Parent;
import org.xenodev.edj.events.storage.scan.Ring;
import org.xenodev.edj.events.storage.station.Discovered;
import org.xenodev.edj.utils.exceptions.UnusedEventDataException;

public class JournalUtils {
	
	public static String getFormattedDate(String dateString) {
		String formattedDate = "";
		
		try {
				
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
			Date date = inputFormat.parse(dateString);
			formattedDate = outputFormat.format(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}
	
	public static void isAllEventDataProcessed(Event event, JSONObject json) {
		
		try {
			if(json.length() > 0) {
				throw new UnusedEventDataException();
			}
			
		}catch(UnusedEventDataException e) {
			sendUnusedEventData(event.getClass().getSimpleName().replace("Event", ""), json.toString());
		}
		
	}
	
	@SuppressWarnings("unused")
	public static void sendUnprocessedEvent(String event, JSONObject json) {

        try {
        	URL url = new URL("http://192.168.178.46/edj/uereporter.php"); // URL to your application
        	Map<String,Object> params = new LinkedHashMap<>();
        	params.put("eventname", event); // All parameters, also easy
        	params.put("jsontext", json.toString().replace("'", "").replace("\\\\", "-").replace("/", "-"));
        	
        	StringBuilder postData = new StringBuilder();
        	// POST as urlencoded is basically key-value pairs, as with GET
        	// This creates key=value&key=value&... pairs
        	for (Map.Entry<String,Object> param : params.entrySet()) {
        		if (postData.length() != 0) postData.append('&');
        		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        		postData.append('=');
        		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        	}
        	
        	// Convert string to byte array, as it should be sent
        	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        	
        	// Connect, easy
        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        	// Tell server that this is POST and in which format is the data
        	conn.setRequestMethod("POST");
        	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        	conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        	conn.setDoOutput(true);
        	conn.getOutputStream().write(postDataBytes);
        	
        	// This gets the output from your server
        	
        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	
        	
			/*
        	for (int c; (c = in.read()) >= 0;) {
         		System.out.print((char)c);
         	}
         	*/
         	
        }catch (IOException e) {
        	e.printStackTrace();
        }

    }
	
	@SuppressWarnings("unused")
	private static void sendUnusedEventData(String event, String s) {
        try {
        	URL url = new URL("http://192.168.178.46/edj/uedreporter.php"); // URL to your application
        	Map<String,Object> params = new LinkedHashMap<>();
        	params.put("eventname", event); // All parameters, also easy
        	params.put("jsontext", s.replace("'", ""));
        	
        	StringBuilder postData = new StringBuilder();
        	// POST as urlencoded is basically key-value pairs, as with GET
        	// This creates key=value&key=value&... pairs
        	for (Map.Entry<String,Object> param : params.entrySet()) {
        		if (postData.length() != 0) postData.append('&');
        		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        		postData.append('=');
        		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        	}
        	
        	// Convert string to byte array, as it should be sent
        	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        	
        	// Connect, easy
        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        	// Tell server that this is POST and in which format is the data
        	conn.setRequestMethod("POST");
        	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        	conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        	conn.setDoOutput(true);
        	conn.getOutputStream().write(postDataBytes);
        	
        	// This gets the output from your server
        	
        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        	
        	/*
        	for (int c; (c = in.read()) >= 0;) {
        		System.out.print((char)c);
        	}
        	*/
        	 
        }catch (IOException e) {
        	e.printStackTrace();
        }

    }
	
	public static long getTimeMillis(String timestamp) {
		long millis = 0;
		
		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			millis = inputFormat.parse(timestamp).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return millis;
	}
	
	//EventData Generators
	public static List<Item> createItemList(JSONArray array) {
		List<Item> itemsList = new ArrayList<Item>();
		
		for(Object comp : array) {
			JSONObject json = new JSONObject(comp.toString());
			
			Item item = new Item(json.getInt("id"), json.getInt("BuyPrice"),	json.getInt("SellPrice"), json.getInt("MeanPrice"), json.getInt("StockBracket"), json.getInt("DemandBracket"),
			json.getInt("Stock"), json.getInt("Demand"), json.getString("Name"), json.getString("Category"), json.getBoolean("Consumer"), json.getBoolean("Producer"), json.getBoolean("Rare"));
			
			itemsList.add(item);
		}
		
		return itemsList;
	}
	
	public static List<EngineerProgress> createEngineerProgressList(JSONArray array) {
		List<EngineerProgress> engineerProgressList = new ArrayList<EngineerProgress>();
		
		for(Object comp : array) {
			JSONObject json = new JSONObject(comp.toString());
			
			EngineerProgress engineerProgress = new EngineerProgress(json.getString("Engineer"), json.getString("Progress"), json.getInt("Rank"), json.getInt("EngineerID"), json.getDouble("RankProgress"));
			
			engineerProgressList.add(engineerProgress);
		}
		
		return engineerProgressList;
	}
	
	public static List<Ingredient> createIngredientsList(JSONArray array) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(Object comp : array) {
			Ingredient ingredient;
			JSONObject json = new JSONObject(comp.toString());
			
			ingredient = new Ingredient(json.getString("Name"), json.getInt("Count"));
			
			ingredients.add(ingredient);
		}
		
		return ingredients;
	}
	
	public static String[] createDataSystemsList(JSONArray array) {
		String[] systems = new String[] {};
		int arrayPos = 0;
		
		for(Object system : array) {
			systems[arrayPos] = (String) system; 
			arrayPos++;
		}
		
		return systems;
	}
	
	public static String[] createDataDiscoveredList(JSONArray array) {
		String[] discoveries = new String[] {};
		int arrayPos = 0;
		
		for(Object discovered : array) {
			discoveries[arrayPos] = (String) discovered; 
			arrayPos++;
		}
		
		return discoveries;
	}
	
	public static List<Discovered> createDiscoveredList(JSONArray array) {
		List<Discovered> discoveries = new ArrayList<Discovered>();
		
		for(Object comp : array) {
			JSONObject json = new JSONObject(comp.toString());
			
			discoveries.add(new Discovered(json.getString("SystemName"), json.getInt("NumBodies")));
		}
		
		return discoveries;
	}
	
	public static List<Material> createMaterialList(JSONArray array) {
		List<Material> materials = new ArrayList<>();
		
		for(Object o : array) {
			JSONObject json = new JSONObject(o.toString());
			materials.add(new Material(json.getString("Name"), json.getDouble("Percent")));
			
		}
		
		return materials;		
	}
	
	public static List<Parent> createParentList(JSONArray array) {
		List<Parent> parents = new ArrayList<>();
		
		for(Object o : array) {
			JSONObject json = new JSONObject(o.toString());
			for(Entry<String, Object> map : json.toMap().entrySet()) {
				parents.add(new Parent(map.getKey(), (Integer)map.getValue()));
			}
		}
		
		return parents;		
	}
	
	public static List<Ring> createRingsList(JSONArray array) {
		List<Ring> rings = new ArrayList<>();
		
		for(Object o : array) {
			JSONObject json = new JSONObject(o.toString());
			rings.add(new Ring(json.getString("Name"), json.getString("RingClass"), json.getLong("MassMT"), json.getLong("InnerRad"), json.getLong("OuterRad")));
		}
		
		return rings;		
	}
	
	public static List<Composition> createCompositionList(JSONObject json) {
		List<Composition> compositions = new ArrayList<Composition>();
		
		for(Entry<String, Object> map : json.toMap().entrySet()) {				
			compositions.add(new Composition(map.getKey(), (double)map.getValue()));
		}
		
		return compositions;		
	}
	
	public static List<AtmosphereComposition> createAtmosphereCompositionList(JSONArray array) {
		List<AtmosphereComposition> atmosphereCompositions = new ArrayList<AtmosphereComposition>();
		
		for(Object comp : array) {
			JSONObject obj = new JSONObject(comp.toString());
				
			atmosphereCompositions.add(new AtmosphereComposition(obj.getString("Name"), obj.getDouble("Percent")));	
		}
		
		return atmosphereCompositions;		
	}
	
	public static String[] createTraitsList(JSONArray array) {
		String[] traits = new String[] {};
		int arrayPos = 0;
		
		for(Object trait : array) {
			traits[arrayPos] = (String) trait; 
			arrayPos++;
		}
		
		return traits;
	}
	
	public static Double[] createPositionArray(JSONArray array) {
		Double[] pos = new Double[3];
		int arrayPos = 0;
		
		for(Object num : array) {
			pos[arrayPos] = Double.parseDouble(num.toString());
			arrayPos++;
		}
		
		return pos;
	}
	
	public static List<String> createPowersArray(JSONArray array) {
		List<String> powers = new ArrayList<String>();
		
		for(Object power : array) {
			powers.add(power.toString()); 
		}
		
		return powers;
	}
	
	public static Killer[] createKillerList(JSONArray array) {
		Killer[] killers = new Killer[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Killer killer;
			int pos = 0;
				
			killer = new Killer(json.getString("Name"), json.getString("Ship"), json.getString("Rank"));
			
			killers[pos] = killer;
			pos++;
		}
		
		return killers;				
	}
	
	public static PassengerManifest[] createPassengerManifest(JSONArray array) {
		PassengerManifest[] passengers = new PassengerManifest[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			PassengerManifest passenger;
			int pos = 0;
				
			passenger = new PassengerManifest(json.getString("Type"), json.getInt("Count"), json.getBoolean("VIP"), json.getBoolean("Wanted"), json.getLong("MissionID"));
			
			passengers[pos] = passenger;
			pos++;
		}
		
		return passengers;				
	}
	
	public static BountyReward[] createBountyRewardList(JSONArray array) {
		BountyReward[] bountyRewards = new BountyReward[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			BountyReward bountyReward;
			int pos = 0;
				
			bountyReward = new BountyReward(json.getString("Faction"), json.getLong("Reward"));
			
			bountyRewards[pos] = bountyReward;
			pos++;
		}
		
		return bountyRewards;				
	}
	
	public static List<StationEconomy> createStationEconomiesList(JSONArray array) {
		List<StationEconomy> stationEconomiesList = new ArrayList<StationEconomy>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			StationEconomy stationEconomy = new StationEconomy(json.getString("Name"), json.getString("Name_Localised"), json.getDouble("Proportion"));
			
			stationEconomiesList.add(stationEconomy);
			
		}
		
		return stationEconomiesList;				
	}
	
	public static List<Module> createModuleList(JSONArray array) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Module module;
			
			if(json.has("Engineering")) {				
				JSONObject engineer = json.getJSONObject("Engineering");
				module = new Module(json.getString("Slot"), json.getString("Item"), json.getBoolean("On"), json.getInt("Priority"),
						json.getInt("AmmoInClip"), json.getInt("AmmoInHopper"), json.getDouble("Health"),
						new Engineering(engineer.getString("Engineer"), engineer.getString("BlueprintName"), engineer.getString("ExperimentalEffect"),
								engineer.getString("ExperimentalEffect_Localised"), engineer.getInt("EngineerID"),
								engineer.getInt("BlueprintID"), engineer.getInt("Level"), 
									engineer.getDouble("Quality"), createModifierList(engineer.getJSONArray("Modifiers"))));
			}else {		
				module = new Module(json.getString("Slot"), json.getString("Item"), json.getBoolean("On"), json.getInt("Priority"), json.getInt("AmmoInClip"),
						json.getInt("AmmoInHopper"), json.getDouble("Health"));
			}
			
			modules.add(module);
		}
		
		return modules;
		
	}
	
	public static Mission[] createMissionList(JSONArray array) {
		Mission[] missions = new Mission[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Mission mission;
			int pos = 0;
				
			mission = new Mission(json.getInt("MissionID"), json.getString("Name"), json.getBoolean("PassengerMission"), json.getInt("Expires"));
			
			missions[pos] = mission;
			pos++;
		}
		
		return missions;				
	}
	
	public static List<Modifier> createModifierList(JSONArray array) {
		List<Modifier> modifier = new ArrayList<Modifier>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Modifier mod;
				
			mod = new Modifier(json.getString("Label"), json.getDouble("Value"), json.getDouble("OriginalValue"), json.getInt("LessIsGood"));
			
			modifier.add(mod);
		}
		
		return modifier;				
	}
	
	public static List<Raw> createRawMaterialList(JSONArray array) {
		List<Raw> raw = new ArrayList<>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Raw rawMat;
			
			rawMat = new Raw(json.getString("Name"), json.getInt("Count"));
			
			raw.add(rawMat);
		}
		
		return raw;				
	}
	
	public static List<Manufactured> createManufacturedMaterialList(JSONArray array) {
		List<Manufactured> manufactured = new ArrayList<Manufactured>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Manufactured manufacturedMat;
				
			manufacturedMat = new Manufactured(json.getString("Name"), json.getString("Name_Localised"), json.getInt("Count"));
			
			manufactured.add(manufacturedMat);
		}
		
		return manufactured;				
	}
	
	public static List<Encoded> createEncodedMaterialList(JSONArray array) {
		List<Encoded> encoded = new ArrayList<Encoded>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			Encoded encodedMat;
				
			encodedMat = new Encoded(json.getString("Name"), json.getString("Name_Localised"), json.getInt("Count"));
			
			encoded.add(encodedMat);
		}
		
		return encoded;				
	}
	
	public static List<CargoInventory> createCargoInventory(JSONArray array) {
		List<CargoInventory> inv = new ArrayList<CargoInventory>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			CargoInventory cargoInv;
			
			if(!json.has("MissionID")) {
				String name = json.getString("Name");
				int count = json.getInt("Count");
				int stolen = json.getInt("Stolen");
				if(json.has("Name_Localised")) {
					name = json.getString("Name_Localised");
				}
				
				cargoInv = new CargoInventory(name, count, stolen);
			}else {
				String name = json.getString("Name");
				int count = json.getInt("Count");
				int stolen = json.getInt("Stolen");
				int missionId = json.getInt("MissionID");
				if(json.has("Name_Localised")) {
					name = json.getString("Name_Localised");
				}
				
				cargoInv = new CargoInventory(name, count, stolen, missionId);
			}
			
			inv.add(cargoInv);
		}
		
		return inv;
	}

	public static List<ModuleItem> createModuleItemsList(JSONArray array) {
		List<ModuleItem> itemList = new ArrayList<ModuleItem>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			String slot = json.getString("Slot");
			String name = json.getString("Name");
			String nameLocalised = json.getString("Name_Localised");
			Boolean hot = json.getBoolean("Hot");
			String engineerModifications = json.getString("EngineerModifications");
			Integer engineeeredLevel = json.getInt("Level");
			Double quality = json.getDouble("Quality");
			
			itemList.add(new ModuleItem(slot, name, nameLocalised, engineerModifications, hot, engineeeredLevel, quality));
		}
		
		return itemList;
	}

	public static TradeData createTradeData(JSONArray array) {
		JSONObject json = new JSONObject(array.toString());
		TradeData tData = new TradeData(json.getString("Material"), json.getString("Material_Localised"), json.getString("Category"), json.getString("Category_Localised"), json.getInt("Quantity"));
		return tData;
	}
	
	public static List<FactionBounty> createFactionBountyList(JSONArray array) {
		List<FactionBounty> factionBountyList = new ArrayList<FactionBounty>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			factionBountyList.add(new FactionBounty(json.getString("Faction"), json.getLong("Amount")));
		}
		
		return factionBountyList;
	}

	public static List<StoredModule> createStoredModuleList(JSONArray array) {
		List<StoredModule> storedModuleList = new ArrayList<StoredModule>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			storedModuleList.add(new StoredModule(json.getString("Name"), json.getString("Name_Localised"), json.getString("StarSystem"), json.getInt("StorageSlot"), json.getLong("MarketID"),
					json.getLong("TransferCost"), json.getLong("TransferTime"), json.getLong("BuyPrice"), json.getBoolean("Hot")));
		}
		
		return storedModuleList;
	}

	public static List<String> createStationServiceList(JSONArray array) {
		List<String> stationServiceList = new ArrayList<String>();
		
		for(Object str : array) {
			stationServiceList.add(str.toString());
		}
		return stationServiceList;
	}

	public static List<Faction> createFactionsList(JSONArray array) {
		List<Faction> factionsList = new ArrayList<Faction>();
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str.toString());
			JSONArray activeStatesArray = json.has("ActiveStates") ? json.getJSONArray("ActiveStates") : null;
			JSONArray recoveringStatesArray = json.has("RecoveringStates") ? json.getJSONArray("RecoveringStates") : null;
			JSONArray pendingStatesArray = json.has("PendingStates") ? json.getJSONArray("PendingStates") : null;
			
			factionsList.add(new Faction(json.getString("Name"), json.getString("FactionState"), json.getString("Goverment"), json.getString("Allegiance"), json.getString("Happiness"),
					json.getDouble("MyReputation"), json.getDouble("Influence"), JournalUtils.createFactionStates(activeStatesArray), JournalUtils.createFactionStates(pendingStatesArray),
					JournalUtils.createFactionStates(recoveringStatesArray), json.getBoolean("SquadronSystem"), json.getBoolean("HappiestSystem"), json.getBoolean("HomeSystem")));
		}
		return factionsList;
	}

	private static FactionState createFactionStates(JSONArray array) {
		if(array != null) {
			for(Object o : array) {
				JSONObject json = new JSONObject(o.toString());
				return new FactionState(json.getString("State"), json.getDouble("Trend"));
			}
		}
		return null;
	}

	public static Conflict createConflict(JSONArray array) {
		List<ConflicFaction> conflictFactionList = new ArrayList<>();
		
		JSONObject json = array.getJSONObject(0);
		JSONObject faction1 = new JSONObject(json.getJSONObject("Faction1"));
		JSONObject faction2 = new JSONObject(json.getJSONObject("Faction2"));
		
		String status = json.getString("Status");
		String warType = json.getString("WarType");
		
		ConflicFaction cf1 = new ConflicFaction(faction1.getString("Name"), faction1.getString("Stake"), faction1.getInt("WonDays"));
		ConflicFaction cf2 = new ConflicFaction(faction2.getString("Name"), faction2.getString("Stake"), faction2.getInt("WonDays"));
		
		conflictFactionList.add(cf1);
		conflictFactionList.add(cf2);
		
		return new Conflict(status, warType, conflictFactionList);
	}

	public static List<StoredShipHere> createStoredShipsHereList(JSONArray array) {
		List<StoredShipHere> storedShipHereList = new ArrayList<>();
		
		for(Object o : array) {
			JSONObject json = new JSONObject(o.toString());
			
			storedShipHereList.add(new StoredShipHere(json.getBoolean("Hot"), json.getString("Name"), json.getString("ShipType"), json.getString("ShipType_Localised"),
					json.getLong("Value"), json.getInt("ShipID")));
		}
		
		return storedShipHereList;
	}
	
	public static List<StoredShipRemote> createStoredShipsRemoteList(JSONArray array) {
		List<StoredShipRemote> storedShipRemoteList = new ArrayList<>();
		
		for(Object o : array) {
			JSONObject json = new JSONObject(o.toString());
			
			storedShipRemoteList.add(new StoredShipRemote(json.getBoolean("Hot"), json.getString("Name"), json.getString("ShipType"), json.getString("ShipType_Localised"),
					json.getString("StarSystem"),  json.getLong("Value"), json.getLong("ShipMarketID"), json.getLong("TransferTime"), json.getLong("TransferPrice"), json.getInt("ShipID")));
		}
		
		return storedShipRemoteList;
	}

}
