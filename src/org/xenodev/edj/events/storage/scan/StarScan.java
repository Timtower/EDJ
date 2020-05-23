package org.xenodev.edj.events.storage.scan;

import org.json.JSONObject;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.utils.JournalUtils;

public class StarScan implements ScanInfo {
	
	String scanType, bodyName, starType, luminosity;
	Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude;
	Integer bodyID;
	Long radius, semiMajorAxis, orbitalPeriod, ageMY;
	Parent[] parents;
	Ring[] rings;
	
	public StarScan(JSONObject json) {
		this.scanType = json.getString("ScanType");
		this.bodyName = json.getString("BodyName");
		this.starType = json.getString("StarType");
		this.luminosity = json.getString("Luminosity");
		this.distanceFromArrivalLS = json.getDouble("DistanceFromArrivalLS");
		this.stellarMass = json.getDouble("StellarMass");
		this.surfaceTemperature = json.getDouble("SurfaceTemperature");
		this.eccentricity = json.getDouble("Eccentricity");
		this.orbitalInclination = json.getDouble("OrbitalInclination");
		this.periapsis = json.getDouble("Periapsis");
		this.rotationPeriod = json.getDouble("RotationPeriod");
		this.axialTilt = json.getDouble("AxialTilt");
		this.absoluteMagnitude = json.getDouble("AbsoluteMagnitude");
		this.bodyID = json.getInt("BodyID");
		this.radius = json.getLong("Radius");
		this.semiMajorAxis = json.getLong("SemiMajorAxis");
		this.orbitalPeriod = json.getLong("OrbitalPeriod");
		this.ageMY = json.getLong("AgeMY");
		this.parents = JournalUtils.createParentList(json.getJSONObject("Parents"));
		this.rings = JournalUtils.createRingsList(json.getJSONArray("Rings"));
	}

	public String getScanType() {
		return scanType;
	}

	public String getBodyName() {
		return bodyName;
	}

	public String getStarType() {
		return starType;
	}

	public String getLuminosity() {
		return luminosity;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public Double getStellarMass() {
		return stellarMass;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public Double getOrbitalInclination() {
		return orbitalInclination;
	}

	public Double getPeriapsis() {
		return periapsis;
	}

	public Double getRotationPeriod() {
		return rotationPeriod;
	}

	public Double getAxialTilt() {
		return axialTilt;
	}

	public Double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Long getRadius() {
		return radius;
	}

	public Long getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public Long getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Long getAgeMY() {
		return ageMY;
	}

	public Parent[] getParents() {
		return parents;
	}

	public Ring[] getRings() {
		return rings;
	}
	
}
