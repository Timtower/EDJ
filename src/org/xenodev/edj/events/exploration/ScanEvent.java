package org.xenodev.edj.events.exploration;

import java.util.List;

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
	private List<Parent> parents;
	private List<AtmosphereComposition> atmosphereComposition;
	private List<Ring> rings;
	private List<Material> materials;
	private List<Composition> composition;
	
	public ScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.star = json.has("StarType");
		this.scanType = json.pullString("ScanType");
		this.bodyName = json.pullString("BodyName");
		this.distanceFromArrivalLS = json.pullDouble("DistanceFromArrivalLS");
		this.eccentricity = json.pullDouble("Eccentricity");
		this.orbitalInclination = json.pullDouble("OrbitalInclination");
		this.periapsis = json.pullDouble("Periapsis");
		this.rotationPeriod = json.pullDouble("RotationPeriod");
		this.axialTilt = json.pullDouble("AxialTilt");
		this.bodyID = json.pullInt("BodyID");
		this.radius = json.pullLong("Radius");
		this.semiMajorAxis = json.pullLong("SemiMajorAxis");
		this.orbitalPeriod = json.pullLong("OrbitalPeriod");
		this.surfaceTemperature = json.pullDouble("SurfaceTemperature");
		this.parents = json.has("Parents") ? JournalUtils.createParentList(json.pullJSONArray("Parents")) : null;
		this.rings = json.has("Rings") ? JournalUtils.createRingsList(json.pullJSONArray("Rings")) : null;
		
		// Star
		this.starType = json.pullString("StarType");
		this.luminosity = json.pullString("Luminosity");
		this.stellarMass = json.pullDouble("StellarMass");
		this.ageMY = json.pullLong("AgeMY");
		
		// Planet
		this.terraformState = json.pullString("TerraformState");
		this.planetClass = json.pullString("PlanetClass");
		this.atmosphere = json.pullString("Atmosphere");
		this.atmosphereType = json.pullString("AtmosphereType");
		this.atmosphereComposition = json.has("AtmosphereComposition") ? JournalUtils.createAtmosphereCompositionList(json.pullJSONArray("AtmosphereComposition")) : null;
		this.volcanism = json.pullString("Volcanism");
		this.reserveLevel = json.pullString("ReserveLevel");
		this.massEM = json.pullDouble("MassEM");
		this.surfaceGravity = json.pullDouble("SurfaceGravity");
		this.surfacePressure = json.pullDouble("SurfacePressure");
		this.tidalLock = json.pullBoolean("TidalLock");
		this.landable = json.pullBoolean("Landable");
		this.materials = json.has("Materials") ? JournalUtils.createMaterialList(json.pullJSONArray("Materials")) : null;
		this.composition = json.has("Composition") ? JournalUtils.createCompositionList(json.pullJSONObject("Composition")) : null;
		
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
