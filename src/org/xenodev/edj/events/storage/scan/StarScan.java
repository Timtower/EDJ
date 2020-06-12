package org.xenodev.edj.events.storage.scan;

import org.xenodev.edj.events.interfaces.ScanInfo;

public class StarScan implements ScanInfo {
	
	String scanType, bodyName, starType, luminosity;
	Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude;
	Integer bodyID;
	Long radius, semiMajorAxis, orbitalPeriod, ageMY;
	Parent[] parents;
	Ring[] rings;

	public StarScan(String scanType, String bodyName, String starType, String luminosity, Double distanceFromArrivalLS,
			Double stellarMass, Double surfaceTemperature, Double eccentricity, Double orbitalInclination,
			Double periapsis, Double rotationPeriod, Double axialTilt, Double absoluteMagnitude, Integer bodyID,
			Long radius, Long semiMajorAxis, Long orbitalPeriod, Long ageMY, Parent[] parents, Ring[] rings) {
		this.scanType = scanType;
		this.bodyName = bodyName;
		this.starType = starType;
		this.luminosity = luminosity;
		this.distanceFromArrivalLS = distanceFromArrivalLS;
		this.stellarMass = stellarMass;
		this.surfaceTemperature = surfaceTemperature;
		this.eccentricity = eccentricity;
		this.orbitalInclination = orbitalInclination;
		this.periapsis = periapsis;
		this.rotationPeriod = rotationPeriod;
		this.axialTilt = axialTilt;
		this.absoluteMagnitude = absoluteMagnitude;
		this.bodyID = bodyID;
		this.radius = radius;
		this.semiMajorAxis = semiMajorAxis;
		this.orbitalPeriod = orbitalPeriod;
		this.ageMY = ageMY;
		this.parents = parents;
		this.rings = rings;
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

	public String getStarType() {
		return starType;
	}

	public void setStarType(String starType) {
		this.starType = starType;
	}

	public String getLuminosity() {
		return luminosity;
	}

	public void setLuminosity(String luminosity) {
		this.luminosity = luminosity;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public void setDistanceFromArrivalLS(Double distanceFromArrivalLS) {
		this.distanceFromArrivalLS = distanceFromArrivalLS;
	}

	public Double getStellarMass() {
		return stellarMass;
	}

	public void setStellarMass(Double stellarMass) {
		this.stellarMass = stellarMass;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public void setSurfaceTemperature(Double surfaceTemperature) {
		this.surfaceTemperature = surfaceTemperature;
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

	public Double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public void setAbsoluteMagnitude(Double absoluteMagnitude) {
		this.absoluteMagnitude = absoluteMagnitude;
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

	public Long getAgeMY() {
		return ageMY;
	}

	public void setAgeMY(Long ageMY) {
		this.ageMY = ageMY;
	}

	public Parent[] getParents() {
		return parents;
	}

	public void setParents(Parent[] parents) {
		this.parents = parents;
	}

	public Ring[] getRings() {
		return rings;
	}

	public void setRings(Ring[] rings) {
		this.rings = rings;
	}
	
}
