package org.xenodev.edj.events;

import java.util.List;
import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.StationEconomy;
import org.xenodev.edj.utils.JournalUtils;

public class DockedEvent extends Event {
	
	String stationName, stationType, starSystem, stationFactionName, stationFactionState, stationGovernment, stationGovernmentLocalised, stationAllegiance, stationEconomy, stationEconomyLocalised;
	StationEconomy[] stationEconomies;
	Long systemAddress, marketID;
	Double distanceFromStarLS;
	List<String> stationServices;
	
	public DockedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.stationName = json.getString("StationName");
		this.stationType = json.getString("StationType");
		this.starSystem = json.getString("StarSystem");
		this.stationFactionName = json.getJSONObject("StationFaction").getString("FactionName");
		this.stationFactionState = json.getJSONObject("StationFaction").getString("FactionState");
		this.stationGovernment = json.getString("StationGovernment");
		this.stationGovernmentLocalised = json.getString("StationGovernment_Localised");
		this.stationAllegiance = json.getString("StationAllegiance");
		this.stationEconomy = json.getString("StationEconomy");
		this.stationEconomyLocalised = json.getString("StationEconomy_Localised");
		this.stationEconomies = JournalUtils.createStationEconomiesList(json.getJSONArray("StationEconomies"));
		this.systemAddress = json.getLong("SystemAddress");
		this.marketID = json.getLong("MarketID");
		this.distanceFromStarLS = json.getDouble("DistFromStarLS");
		this.stationServices = JournalUtils.createStationServiceList(json.getJSONArray("StationServices"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getStationFactionName() {
		return stationFactionName;
	}

	public String getStationFactionState() {
		return stationFactionState;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public StationEconomy[] getStationEconomies() {
		return stationEconomies;
	}

	public long getSystemAddress() {
		return systemAddress;
	}

	public long getMarketID() {
		return marketID;
	}

	public double getDistanceFromStarLS() {
		return distanceFromStarLS;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

}
