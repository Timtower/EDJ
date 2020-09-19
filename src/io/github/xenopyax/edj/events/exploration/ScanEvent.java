package io.github.xenopyax.edj.events.exploration;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.scan.AtmosphereComposition;
import io.github.xenopyax.edj.events.datastorage.scan.Composition;
import io.github.xenopyax.edj.events.datastorage.scan.Material;
import io.github.xenopyax.edj.events.datastorage.scan.Parent;
import io.github.xenopyax.edj.events.datastorage.scan.PlanetScan;
import io.github.xenopyax.edj.events.datastorage.scan.Ring;
import io.github.xenopyax.edj.events.datastorage.scan.StarScan;
import io.github.xenopyax.edj.events.interfaces.ScanInfo;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ScanEvent extends Event {
	
	private String scanType, bodyName, starType, luminosity, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, starSystem;
	private Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude, massEM, surfaceGravity,
	surfacePressure;
	private Integer bodyID, subclass;
	private Long radius, semiMajorAxis, orbitalPeriod, ageMY, systemAddress;
	private Boolean tidalLock, landable, star, wasMapped, wasDiscovered;
	private List<Parent> parents;
	private List<AtmosphereComposition> atmosphereComposition;
	private List<Ring> rings;
	private List<Material> materials;
	private List<Composition> composition;
	
	public ScanEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.star = json.has("StarType");
		this.starSystem = json.pullString("StarSystem");
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
		this.absoluteMagnitude = json.pullDouble("AbsoluteMagnitude");
		this.wasDiscovered = json.pullBoolean("WasDiscovered");
		this.systemAddress = json.pullLong("SystemAddress");
		
		// Star
		this.starType = json.pullString("StarType");
		this.luminosity = json.pullString("Luminosity");
		this.stellarMass = json.pullDouble("StellarMass");
		this.ageMY = json.pullLong("Age_MY");
		
		// Planet
		this.terraformState = json.pullString("TerraformState");
		this.wasMapped = json.pullBoolean("WasMapped");
		this.subclass = json.pullInt("Subclass");
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
					axialTilt, absoluteMagnitude, bodyID, radius, semiMajorAxis, orbitalPeriod, ageMY, parents, rings, wasDiscovered, starSystem, systemAddress);
		}
		
		return new PlanetScan(scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, distanceFromArrivalLS, massEM, surfaceGravity,
				surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, bodyID, radius, semiMajorAxis, orbitalPeriod, tidalLock, landable,
				parents, atmosphereComposition, rings, materials, composition, wasMapped, wasDiscovered, starSystem, subclass, systemAddress);
	}

	public String getScanType() {
		return scanType;
	}

}
