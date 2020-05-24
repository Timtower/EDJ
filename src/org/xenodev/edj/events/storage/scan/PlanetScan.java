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

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getBodyName() {
		return bodyName;
	}

	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}

	public String getTerraformState() {
		return terraformState;
	}

	public void setTerraformState(String terraformState) {
		this.terraformState = terraformState;
	}

	public String getPlanetClass() {
		return planetClass;
	}

	public void setPlanetClass(String planetClass) {
		this.planetClass = planetClass;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getAtmosphereType() {
		return atmosphereType;
	}

	public void setAtmosphereType(String atmosphereType) {
		this.atmosphereType = atmosphereType;
	}

	public String getVolcanism() {
		return volcanism;
	}

	public void setVolcanism(String volcanism) {
		this.volcanism = volcanism;
	}

	public String getReserveLevel() {
		return reserveLevel;
	}

	public void setReserveLevel(String reserveLevel) {
		this.reserveLevel = reserveLevel;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public void setDistanceFromArrivalLS(Double distanceFromArrivalLS) {
		this.distanceFromArrivalLS = distanceFromArrivalLS;
	}

	public Double getMassEM() {
		return massEM;
	}

	public void setMassEM(Double massEM) {
		this.massEM = massEM;
	}

	public Double getSurfaceGravity() {
		return surfaceGravity;
	}

	public void setSurfaceGravity(Double surfaceGravity) {
		this.surfaceGravity = surfaceGravity;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public void setSurfaceTemperature(Double surfaceTemperature) {
		this.surfaceTemperature = surfaceTemperature;
	}

	public Double getSurfacePressure() {
		return surfacePressure;
	}

	public void setSurfacePressure(Double surfacePressure) {
		this.surfacePressure = surfacePressure;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public void setEccentricity(Double eccentricity) {
		this.eccentricity = eccentricity;
	}

	public Double getOrbitalInclination() {
		return orbitalInclination;
	}

	public void setOrbitalInclination(Double orbitalInclination) {
		this.orbitalInclination = orbitalInclination;
	}

	public Double getPeriapsis() {
		return periapsis;
	}

	public void setPeriapsis(Double periapsis) {
		this.periapsis = periapsis;
	}

	public Double getRotationPeriod() {
		return rotationPeriod;
	}

	public void setRotationPeriod(Double rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

	public Double getAxialTilt() {
		return axialTilt;
	}

	public void setAxialTilt(Double axialTilt) {
		this.axialTilt = axialTilt;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public void setBodyID(Integer bodyID) {
		this.bodyID = bodyID;
	}

	public Long getRadius() {
		return radius;
	}

	public void setRadius(Long radius) {
		this.radius = radius;
	}

	public Long getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(Long semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public Long getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(Long orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public Boolean getTidalLock() {
		return tidalLock;
	}

	public void setTidalLock(Boolean tidalLock) {
		this.tidalLock = tidalLock;
	}

	public Boolean getLandable() {
		return landable;
	}

	public void setLandable(Boolean landable) {
		this.landable = landable;
	}

	public Parent[] getParents() {
		return parents;
	}

	public void setParents(Parent[] parents) {
		this.parents = parents;
	}

	public AtmosphereComposition[] getAtmosphereComposition() {
		return atmosphereComposition;
	}

	public void setAtmosphereComposition(AtmosphereComposition[] atmosphereComposition) {
		this.atmosphereComposition = atmosphereComposition;
	}

	public Ring[] getRings() {
		return rings;
	}

	public void setRings(Ring[] rings) {
		this.rings = rings;
	}

	public Material[] getMaterials() {
		return materials;
	}

	public void setMaterials(Material[] materials) {
		this.materials = materials;
	}

	public Composition[] getComposition() {
		return composition;
	}

	public void setComposition(Composition[] composition) {
		this.composition = composition;
	}

}
