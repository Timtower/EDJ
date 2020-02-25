package org.xenodev.edj.events.storage.scan;

import org.json.JSONObject;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class PlanetScan implements ScanInfo {
	
	String scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel;
	Double distanceFromArrivalLS, massEM, surfaceGravity, surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt;
	Integer bodyID;
	Long radius, semiMajorAxis, orbitalPeriod;
	Boolean tidalLock, landable;
	Parent[] parents;
	AtmosphereComposition[] atmosphereComposition;
	Ring[] rings;
	Material[] materials;
	Composition[] composition;
	
	public PlanetScan(JSONObject json) {
		this.scanType = JsonTranslator.getString(json, "ScanType");
		this.bodyName = JsonTranslator.getString(json, "BodyName");
		this.terraformState = JsonTranslator.getString(json, "TerraformState");
		this.planetClass = JsonTranslator.getString(json, "PlanetClass");
		this.atmosphere = JsonTranslator.getString(json, "Atmosphere");
		this.atmosphereType = JsonTranslator.getString(json, "AtmosphereType");
		this.atmosphereComposition = JournalUtils.createAtmosphereCompositionList(JsonTranslator.getJSONArray(json, "AtmosphereComposition"));
		this.volcanism = JsonTranslator.getString(json, "Volcanism");
		this.reserveLevel = JsonTranslator.getString(json, "ReserveLevel");
		this.distanceFromArrivalLS = JsonTranslator.getDouble(json, "DistanceFromArrivalLS");
		this.massEM = JsonTranslator.getDouble(json, "MassEM");
		this.surfaceGravity = JsonTranslator.getDouble(json, "SurfaceGravity");
		this.surfaceTemperature = JsonTranslator.getDouble(json, "SurfaceTemperature");
		this.surfacePressure = JsonTranslator.getDouble(json, "SurfacePressure");
		this.eccentricity = JsonTranslator.getDouble(json, "Eccentricity");
		this.orbitalInclination = JsonTranslator.getDouble(json, "OrbitalInclination");
		this.periapsis = JsonTranslator.getDouble(json, "Periapsis");
		this.rotationPeriod = JsonTranslator.getDouble(json, "RotationPeriod");
		this.axialTilt = JsonTranslator.getDouble(json, "AxialTilt");
		this.bodyID = JsonTranslator.getInteger(json, "BodyID");
		this.radius = JsonTranslator.getLong(json, "Radius");
		this.semiMajorAxis = JsonTranslator.getLong(json, "SemiMajorAxis");
		this.orbitalPeriod = JsonTranslator.getLong(json, "OrbitalPeriod");
		this.tidalLock = JsonTranslator.getBoolean(json, "TidalLock");
		this.landable = JsonTranslator.getBoolean(json, "Landable");
		this.parents = JournalUtils.createParentList(json);
		this.rings = JournalUtils.createRingsList(json.getJSONArray("Rings"));
		this.materials = JournalUtils.createMaterialList(json);
		this.composition = JournalUtils.createCompositionList(json);
	}

	public String getScanType() {
		return scanType;
	}

	public String getBodyName() {
		return bodyName;
	}

	public String getTerraformState() {
		return terraformState;
	}

	public String getPlanetClass() {
		return planetClass;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public String getAtmosphereType() {
		return atmosphereType;
	}

	public String getVolcanism() {
		return volcanism;
	}

	public String getReserveLevel() {
		return reserveLevel;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public Double getMassEM() {
		return massEM;
	}

	public Double getSurfaceGravity() {
		return surfaceGravity;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public Double getSurfacePressure() {
		return surfacePressure;
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

	public Boolean getTidalLock() {
		return tidalLock;
	}

	public Boolean getLandable() {
		return landable;
	}

	public Parent[] getParents() {
		return parents;
	}

	public AtmosphereComposition[] getAtmosphereComposition() {
		return atmosphereComposition;
	}

	public Ring[] getRings() {
		return rings;
	}

	public Material[] getMaterials() {
		return materials;
	}

	public Composition[] getComposition() {
		return composition;
	}

}
