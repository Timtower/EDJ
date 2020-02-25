package org.xenodev.edj.events;

import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.StationEconomy;

public class DockedEvent extends Event {
	
	String stationName, stationType, starSystem, stationFactionName, stationFactionState, stationGovernment, stationGovernmentLocalised, stationAllegiance, stationEconomy, stationEconomyLocalised;
	StationEconomy[] stationEconomies;
	long systemAddress, marketID;
	double distanceFromStarLS;
	List<String> stationServices;
	
	public DockedEvent(String timestamp, String stationName, String stationType, String starSystem,
			String stationFactionName, String stationFactionState, String stationGovernment,
			String stationGovernmentLocalised, String stationAllegiance, String stationEconomy,
			String stationEconomyLocalised, StationEconomy[] stationEconomies, long systemAddress, long marketID,
			double distanceFromStarLS, List<String> stationServices) {
		super(timestamp);
		this.stationName = stationName;
		this.stationType = stationType;
		this.starSystem = starSystem;
		this.stationFactionName = stationFactionName;
		this.stationFactionState = stationFactionState;
		this.stationGovernment = stationGovernment;
		this.stationGovernmentLocalised = stationGovernmentLocalised;
		this.stationAllegiance = stationAllegiance;
		this.stationEconomy = stationEconomy;
		this.stationEconomyLocalised = stationEconomyLocalised;
		this.stationEconomies = stationEconomies;
		this.systemAddress = systemAddress;
		this.marketID = marketID;
		this.distanceFromStarLS = distanceFromStarLS;
		this.stationServices = stationServices;
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
