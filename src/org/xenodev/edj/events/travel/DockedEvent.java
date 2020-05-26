package org.xenodev.edj.events.travel;

import java.util.List;
import org.json.JSONObject;
import org.xenodev.edj.events.Event;
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
		
		this.stationName = json.pullString("StationName");
		this.stationType = json.pullString("StationType");
		this.starSystem = json.pullString("StarSystem");
		this.stationFactionName = json.getJSONObject("StationFaction").getString("FactionName");
		this.stationFactionState = json.getJSONObject("StationFaction").getString("FactionState");
		this.stationGovernment = json.pullString("StationGovernment");
		this.stationGovernmentLocalised = json.pullString("StationGovernment_Localised");
		this.stationAllegiance = json.pullString("StationAllegiance");
		this.stationEconomy = json.pullString("StationEconomy");
		this.stationEconomyLocalised = json.pullString("StationEconomy_Localised");
		this.stationEconomies = JournalUtils.createStationEconomiesList(json.getJSONArray("StationEconomies"));
		this.systemAddress = json.pullLong("SystemAddress");
		this.marketID = json.pullLong("MarketID");
		this.distanceFromStarLS = json.getDouble("DistFromStarLS");
		this.stationServices = JournalUtils.createStationServiceList(json.getJSONArray("StationServices"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public String getStationFactionName() {
		return stationFactionName;
	}

	public void setStationFactionName(String stationFactionName) {
		this.stationFactionName = stationFactionName;
	}

	public String getStationFactionState() {
		return stationFactionState;
	}

	public void setStationFactionState(String stationFactionState) {
		this.stationFactionState = stationFactionState;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public void setStationGovernment(String stationGovernment) {
		this.stationGovernment = stationGovernment;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
	}

	public void setStationGovernmentLocalised(String stationGovernmentLocalised) {
		this.stationGovernmentLocalised = stationGovernmentLocalised;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public void setStationAllegiance(String stationAllegiance) {
		this.stationAllegiance = stationAllegiance;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public void setStationEconomy(String stationEconomy) {
		this.stationEconomy = stationEconomy;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public void setStationEconomyLocalised(String stationEconomyLocalised) {
		this.stationEconomyLocalised = stationEconomyLocalised;
	}

	public StationEconomy[] getStationEconomies() {
		return stationEconomies;
	}

	public void setStationEconomies(StationEconomy[] stationEconomies) {
		this.stationEconomies = stationEconomies;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public void setSystemAddress(Long systemAddress) {
		this.systemAddress = systemAddress;
	}

	public Long getMarketID() {
		return marketID;
	}

	public void setMarketID(Long marketID) {
		this.marketID = marketID;
	}

	public Double getDistanceFromStarLS() {
		return distanceFromStarLS;
	}

	public void setDistanceFromStarLS(Double distanceFromStarLS) {
		this.distanceFromStarLS = distanceFromStarLS;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

	public void setStationServices(List<String> stationServices) {
		this.stationServices = stationServices;
	}

}
