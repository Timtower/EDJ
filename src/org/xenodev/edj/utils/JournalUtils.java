package org.xenodev.edj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xenodev.edj.events.storage.CargoInventory;
import org.xenodev.edj.events.storage.Engineering;
import org.xenodev.edj.events.storage.Faction;
import org.xenodev.edj.events.storage.Killer;
import org.xenodev.edj.events.storage.Mission;
import org.xenodev.edj.events.storage.Modifier;
import org.xenodev.edj.events.storage.Module;
import org.xenodev.edj.events.storage.PassengerManifest;
import org.xenodev.edj.events.storage.StationEconomy;
import org.xenodev.edj.events.storage.bounty.BountyReward;
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
	public static Item[] createItemList(JSONArray array) {
		Item[] items = new Item[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			Item item;
			JSONObject json = new JSONObject(comp);
			
			item = new Item(json.getInt("id"), json.getInt("BuyPrice"),	json.getInt("SellPrice"), json.getInt("MeanPrice"), json.getInt("StockBracket"), json.getInt("DemandBracket"),
			json.getInt("Stock"), json.getInt("Demand"), json.getString("Name"), json.getString("Category"), json.getBoolean("Consumer"), json.getBoolean("Producer"), json.getBoolean("Rare"));
			
			items[arrayPos] = item;
			arrayPos++;	
		}
		
		return items;
	}
	
	public static EngineerProgress[] createEngineerProgressList(JSONArray array) {
		EngineerProgress[] engineerProgressList = new EngineerProgress[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			EngineerProgress engineerProgress;
			JSONObject json = new JSONObject(comp);
			
			engineerProgress = new EngineerProgress(json.getString("Engineer"), json.getString("Progress"), json.getInt("Rank"), json.getInt("EngineerID"), json.getDouble("RankProgress"));
			
			engineerProgressList[arrayPos] = engineerProgress;
			arrayPos++;	
		}
		
		return engineerProgressList;
	}
	
	public static Ingredient[] createIngredientsList(JSONArray array) {
		Ingredient[] ingredients = new Ingredient[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			Ingredient ingredient;
			JSONObject json = new JSONObject(comp);
			
			ingredient = new Ingredient(json.getString("Name"), json.getInt("Count"));
			
			ingredients[arrayPos] = ingredient;
			arrayPos++;	
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
	
	public static Discovered[] createDiscoveredList(JSONArray array) {
		Discovered[] discoveries = new Discovered[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			Discovered discovered;
			JSONObject json = new JSONObject(comp);
			
			discovered = new Discovered(json.getString("SystemName"), json.getInt("NumBodies"));
			
			discoveries[arrayPos] = discovered;
			arrayPos++;	
		}
		
		return discoveries;
	}
	
	public static Material[] createMaterialList(JSONObject json) {
		Material[] materials = new Material[] {};
		
		Map<String, Object> obj = new JSONObject(json).getJSONObject("Material").toMap();
		for(Entry<String, Object> map : obj.entrySet()) {
			Material material;
			int pos = 0;
				
			material = new Material(map.getKey(), (int)map.getValue());
			
			materials[pos] = material;
			pos++;
		}
		
		return materials;		
	}
	
	public static Parent[] createParentList(JSONObject json) {
		Parent[] parents = new Parent[] {};
		
		Map<String, Object> obj = new JSONObject(json).getJSONObject("Parents").toMap();
		for(Entry<String, Object> map : obj.entrySet()) {
			Parent parent;
			int pos = 0;
				
			parent = new Parent(map.getKey(), (int)map.getValue());
			
			parents[pos] = parent;
			pos++;
		}
		
		return parents;		
	}
	
	public static Ring[] createRingsList(JSONArray array) {
		Ring[] rings = new Ring[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			Ring ring;
			JSONObject json = new JSONObject(comp);
			
			ring = new Ring(json.getString("Name"), json.getString("RingClass"), json.getLong("MassMT"), json.getLong("InnerRad"), json.getLong("OuterRad"));
			
			rings[arrayPos] = ring;
			arrayPos++;
		}
		
		return rings;		
	}
	
	public static Composition[] createCompositionList(JSONObject json) {
		Composition[] compositions = new Composition[] {};
		
		Map<String, Object> obj = new JSONObject(json).getJSONObject("Composition").toMap();
		for(Entry<String, Object> map : obj.entrySet()) {
			Composition composition;
			int pos = 0;
				
			composition = new Composition(map.getKey(), (double)map.getValue());
			
			compositions[pos] = composition;
			pos++;
		}
		
		return compositions;		
	}
	
	public static AtmosphereComposition[] createAtmosphereCompositionList(JSONArray array) {
		AtmosphereComposition[] atmosphereCompositions = new AtmosphereComposition[] {};
		int arrayPos = 0;
		
		for(Object comp : array) {
			AtmosphereComposition atmosphereComposition;
			JSONObject obj = new JSONObject(comp);
				
			atmosphereComposition = new AtmosphereComposition(obj.getString("Name"), obj.getDouble("Percent"));
			
			atmosphereCompositions[arrayPos] = atmosphereComposition;
			arrayPos++;
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
	
	public static double[] createPositionArray(JSONArray array) {
		double[] pos = new double[3];
		int arrayPos = 0;
		
		for(Object num : array) {
			pos[arrayPos] = Double.parseDouble((String) num);
			arrayPos++;
		}
		
		return pos;
	}
	
	public static String[] createPowersArray(JSONArray array) {
		String[] powers = new String[] {};
		int arrayPos = 0;
		
		for(Object power : array) {
			powers[arrayPos] = (String) power; 
			arrayPos++;
		}
		
		return powers;
	}
	
	public static Killer[] createKillerList(JSONArray array) {
		Killer[] killers = new Killer[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
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
			JSONObject json = new JSONObject(str);
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
			JSONObject json = new JSONObject(str);
			BountyReward bountyReward;
			int pos = 0;
				
			bountyReward = new BountyReward(json.getString("Faction"), json.getInt("Reward"));
			
			bountyRewards[pos] = bountyReward;
			pos++;
		}
		
		return bountyRewards;				
	}
	
	public static Faction[] createFactionList(JSONArray array) {
		Faction[] factions = new Faction[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Faction faction;
			int pos = 0;
				
			faction = new Faction(json.getString("Name"), json.getString("FactionState"), json.getString("Government"), json.getString("Allegiance"), json.getString("Happiness_Localised"),
					json.getDouble("MyReputation"), json.getDouble("Influence"));
			
			factions[pos] = faction;
			pos++;
		}
		
		return factions;				
	}
	
	public static StationEconomy[] createStationEconomiesList(JSONArray array) {
		StationEconomy[] stationEconomies = new StationEconomy[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			StationEconomy stationEconomy;
			int pos = 0;
				
			stationEconomy = new StationEconomy(json.getString("Name"), json.getString("Name_Localised"), json.getDouble("Proportion"));
			
			stationEconomies[pos] = stationEconomy;
			pos++;
		}
		
		return stationEconomies;				
	}
	
	public static Module[] createModuleList(JSONArray array) {
		Module[] modules = new Module[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Module module;
			int pos = 0;
			
			if(json.has("Engineering")) {				
				JSONObject engineer = json.getJSONObject("Engineering");
				module = new Module(json.getString("Slot"), json.getString("Item"), json.getBoolean("On"), json.getInt("Priority"), json.getInt("AmmoInClip"), json.getInt("AmmoInHopper"),
						json.getDouble("health"), json.getInt("Value"), 
							new Engineering(engineer.getString("Engineer"), engineer.getString("BlueprintName"), engineer.getString("ExperimentalEffect"),
									engineer.getString("ExperimentalEffect_Localised"), engineer.getInt("EngineerID"), engineer.getInt("BlueprintID"), engineer.getInt("Level"),
									engineer.getInt("Quality"), createModifierList(json.getJSONArray("Modifiers"))));
			}else {		
				module = new Module(json.getString("Slot"), json.getString("Item"), json.getBoolean("On"), json.getInt("Priority"), json.getInt("AmmoInClip"), json.getInt("AmmoInHopper"),
						json.getDouble("health"), json.getInt("Value"));
			}
			
			modules[pos] = module;
			pos++;
		}
		
		return modules;
		
	}
	
	public static Mission[] createMissionList(JSONArray array) {
		Mission[] missions = new Mission[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Mission mission;
			int pos = 0;
				
			mission = new Mission(json.getInt("MissionID"), json.getString("Name"), json.getBoolean("PassengerMission"), json.getInt("Expires"));
			
			missions[pos] = mission;
			pos++;
		}
		
		return missions;				
	}
	
	public static Modifier[] createModifierList(JSONArray array) {
		Modifier[] modifier = new Modifier[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Modifier mod;
			int pos = 0;
				
			mod = new Modifier(json.getString("Label"), json.getDouble("Value"), json.getDouble("OriginalValue"), json.getInt("LessIsGood"));
			
			modifier[pos] = mod;
			pos++;
		}
		
		return modifier;				
	}
	
	public static Raw[] createRawMaterialList(JSONArray array) {
		Raw[] raw = new Raw[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Raw rawMat;
			int pos = 0;
				
			rawMat = new Raw(json.getString("Name"), json.getInt("Count"));
			
			raw[pos] = rawMat;
			pos++;
		}
		
		return raw;				
	}
	
	public static Manufactured[] createManufacturedMaterialList(JSONArray array) {
		Manufactured[] manufactured = new Manufactured[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Manufactured manufacturedMat;
			int pos = 0;
				
			manufacturedMat = new Manufactured(json.getString("Name"), json.getString("Name_Localised"), json.getInt("Count"));
			
			manufactured[pos] = manufacturedMat;
			pos++;
		}
		
		return manufactured;				
	}
	
	public static Encoded[] createEncodedMaterialList(JSONArray array) {
		Encoded[] encoded = new Encoded[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			Encoded encodedMat;
			int pos = 0;
				
			encodedMat = new Encoded(json.getString("Name"), json.getString("Name_Localised"), json.getInt("Count"));
			
			encoded[pos] = encodedMat;
			pos++;
		}
		
		return encoded;				
	}
	
	public static CargoInventory[] createCargoInventory(JSONArray array) {
		CargoInventory[] inv = new CargoInventory[] {};
		
		for(Object str : array) {
			JSONObject json = new JSONObject(str);
			CargoInventory cargoInv;
			int pos = 0;
			
			if(json.has("MissionID")) {
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
			
			inv[pos] = cargoInv;
			pos++;
		}
		
		return inv;
	}

}
