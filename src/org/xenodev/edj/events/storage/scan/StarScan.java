package org.xenodev.edj.events.storage.scan;

import org.json.JSONObject;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class StarScan implements ScanInfo {
	
	String scanType, bodyName, starType, luminosity;
	Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude;
	Integer bodyID;
	Long radius, semiMajorAxis, orbitalPeriod, ageMY;
	Parent[] parents;
	Ring[] rings;
	
	public StarScan(JSONObject json) {
		this.scanType = JsonTranslator.getString(json, "ScanType");
		this.bodyName = JsonTranslator.getString(json, "BodyName");
		this.starType = JsonTranslator.getString(json, "StarType");
		this.luminosity = JsonTranslator.getString(json, "Luminosity");
		this.distanceFromArrivalLS = JsonTranslator.getDouble(json, "DistanceFromArrivalLS");
		this.stellarMass = JsonTranslator.getDouble(json, "StellarMass");
		this.surfaceTemperature = JsonTranslator.getDouble(json, "SurfaceTemperature");
		this.eccentricity = JsonTranslator.getDouble(json, "Eccentricity");
		this.orbitalInclination = JsonTranslator.getDouble(json, "OrbitalInclination");
		this.periapsis = JsonTranslator.getDouble(json, "Periapsis");
		this.rotationPeriod = JsonTranslator.getDouble(json, "RotationPeriod");
		this.axialTilt = JsonTranslator.getDouble(json, "AxialTilt");
		this.absoluteMagnitude = JsonTranslator.getDouble(json, "AbsoluteMagnitude");
		this.bodyID = JsonTranslator.getInteger(json, "BodyID");
		this.radius = JsonTranslator.getLong(json, "Radius");
		this.semiMajorAxis = JsonTranslator.getLong(json, "SemiMajorAxis");
		this.orbitalPeriod = JsonTranslator.getLong(json, "OrbitalPeriod");
		this.ageMY = JsonTranslator.getLong(json, "AgeMY");
		this.parents = JournalUtils.createParentList(JsonTranslator.getJSONObject(json, "Parents"));
		this.rings = JournalUtils.createRingsList(JsonTranslator.getJSONArray(json, "Rings"));
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
