package org.xenodev.edj.events.storage.scan;

import org.json.JSONObject;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.utils.JournalUtils;

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
		this.scanType = json.getString("ScanType");
		this.bodyName = json.getString("BodyName");
		this.terraformState = json.getString("TerraformState");
		this.planetClass = json.getString("PlanetClass");
		this.atmosphere = json.getString("Atmosphere");
		this.atmosphereType = json.getString("AtmosphereType");
		this.atmosphereComposition = JournalUtils.createAtmosphereCompositionList(json.getJSONArray("AtmosphereComposition"));
		this.volcanism = json.getString("Volcanism");
		this.reserveLevel = json.getString("ReserveLevel");
		this.distanceFromArrivalLS = json.getDouble("DistanceFromArrivalLS");
		this.massEM = json.getDouble("MassEM");
		this.surfaceGravity = json.getDouble("SurfaceGravity");
		this.surfaceTemperature = json.getDouble("SurfaceTemperature");
		this.surfacePressure = json.getDouble("SurfacePressure");
		this.eccentricity = json.getDouble("Eccentricity");
		this.orbitalInclination = json.getDouble("OrbitalInclination");
		this.periapsis = json.getDouble("Periapsis");
		this.rotationPeriod = json.getDouble("RotationPeriod");
		this.axialTilt = json.getDouble("AxialTilt");
		this.bodyID = json.getInt("BodyID");
		this.radius = json.getLong("Radius");
		this.semiMajorAxis = json.getLong("SemiMajorAxis");
		this.orbitalPeriod = json.getLong("OrbitalPeriod");
		this.tidalLock = json.getBoolean("TidalLock");
		this.landable = json.getBoolean("Landable");
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
