package org.xenodev.edj.events.travel;

import java.util.List;
import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.StationEconomy;
import org.xenodev.edj.utils.JournalUtils;

public class DockedEvent extends Event {
	
	private String stationName, stationType, starSystem, stationFactionName, stationFactionState, stationGovernment, stationGovernmentLocalised, stationAllegiance, stationEconomy,
	stationEconomyLocalised;
	private List<StationEconomy> stationEconomies;
	private Long systemAddress, marketID;
	private Double distanceFromStarLS;
	private Boolean activeFine;
	private List<String> stationServices;
	
	public DockedEvent(String timestamp, JSONObject json) {
		super(timestamp);
		JSONObject stationFaction = json.pullJSONObject("StationFaction");
		
		this.stationName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.starSystem = json.pullString("StarSystem");
		this.stationFactionName = stationFaction.pullString("Name");
		this.stationFactionState = stationFaction.pullString("FactionState");
		this.stationGovernment = json.pullString("StationGovernment");
		this.stationGovernmentLocalised = json.pullString("StationGovernment_Localised");
		this.stationAllegiance = json.pullString("StationAllegiance");
		this.stationEconomy = json.pullString("StationEconomy");
		this.stationEconomyLocalised = json.pullString("StationEconomy_Localised");
		this.stationEconomies = JournalUtils.createStationEconomiesList(json.pullJSONArray("StationEconomies"));
		this.systemAddress = json.pullLong("SystemAddress");
		this.marketID = json.pullLong("MarketID");
		this.distanceFromStarLS = json.pullDouble("DistFromStarLS");
		this.stationServices = JournalUtils.createStationServiceList(json.pullJSONArray("StationServices"));
		this.activeFine = json.pullBoolean("ActiveFine");
		
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

	public List<StationEconomy> getStationEconomies() {
		return stationEconomies;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getMarketID() {
		return marketID;
	}

	public Double getDistanceFromStarLS() {
		return distanceFromStarLS;
	}

	public Boolean getActiveFine() {
		return activeFine;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

}
