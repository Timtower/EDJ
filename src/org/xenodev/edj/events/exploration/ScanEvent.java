package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.interfaces.ScanInfo;
import org.xenodev.edj.events.storage.scan.AtmosphereComposition;
import org.xenodev.edj.events.storage.scan.Composition;
import org.xenodev.edj.events.storage.scan.Material;
import org.xenodev.edj.events.storage.scan.Parent;
import org.xenodev.edj.events.storage.scan.PlanetScan;
import org.xenodev.edj.events.storage.scan.Ring;
import org.xenodev.edj.events.storage.scan.StarScan;
import org.xenodev.edj.utils.JournalUtils;

public class ScanEvent extends Event {
	
	private String scanType, bodyName, starType, luminosity, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel;
	private Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude,massEM, surfaceGravity, surfacePressure;
	private Integer bodyID;
	private Long radius, semiMajorAxis, orbitalPeriod, ageMY;
	private Boolean tidalLock, landable, star;
	private Parent[] parents;
	private AtmosphereComposition[] atmosphereComposition;
	private Ring[] rings;
	private Material[] materials;
	private Composition[] composition;
	
	public ScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.star = json.has("StarType");
		this.scanType = json.getString("ScanType");
		this.bodyName = json.getString("BodyName");
		this.distanceFromArrivalLS = json.getDouble("DistanceFromArrivalLS");
		this.eccentricity = json.getDouble("Eccentricity");
		this.orbitalInclination = json.getDouble("OrbitalInclination");
		this.periapsis = json.getDouble("Periapsis");
		this.rotationPeriod = json.getDouble("RotationPeriod");
		this.axialTilt = json.getDouble("AxialTilt");
		this.bodyID = json.getInt("BodyID");
		this.radius = json.getLong("Radius");
		this.semiMajorAxis = json.getLong("SemiMajorAxis");
		this.orbitalPeriod = json.getLong("OrbitalPeriod");
		this.surfaceTemperature = json.getDouble("SurfaceTemperature");
		this.parents = JournalUtils.createParentList(json);
		this.rings = JournalUtils.createRingsList(json.getJSONArray("Rings"));
		
		// Star
		this.starType = json.getString("StarType");
		this.luminosity = json.getString("Luminosity");
		this.stellarMass = json.getDouble("StellarMass");
		this.ageMY = json.getLong("AgeMY");
		
		// Planet
		this.terraformState = json.getString("TerraformState");
		this.planetClass = json.getString("PlanetClass");
		this.atmosphere = json.getString("Atmosphere");
		this.atmosphereType = json.getString("AtmosphereType");
		this.atmosphereComposition = JournalUtils.createAtmosphereCompositionList(json.getJSONArray("AtmosphereComposition"));
		this.volcanism = json.getString("Volcanism");
		this.reserveLevel = json.getString("ReserveLevel");
		this.massEM = json.getDouble("MassEM");
		this.surfaceGravity = json.getDouble("SurfaceGravity");
		this.surfacePressure = json.getDouble("SurfacePressure");
		this.tidalLock = json.getBoolean("TidalLock");
		this.landable = json.getBoolean("Landable");
		this.materials = JournalUtils.createMaterialList(json);
		this.composition = JournalUtils.createCompositionList(json);
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}
	
	public ScanInfo getInfo() {
		if(star) {
			return new StarScan(scanType, bodyName, starType, luminosity, distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod,
					axialTilt, absoluteMagnitude, bodyID, radius, semiMajorAxis, orbitalPeriod, ageMY, parents, rings);
		}
		
		return new PlanetScan(scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, distanceFromArrivalLS, massEM, surfaceGravity, surfaceTemperature,
				surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, bodyID, radius, semiMajorAxis, orbitalPeriod, tidalLock, landable, parents,
				atmosphereComposition, rings, materials, composition);
	}

	public String getScanType() {
		return scanType;
	}

}
