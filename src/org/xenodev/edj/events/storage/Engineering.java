package org.xenodev.edj.events.storage;

public class Engineering {
	
	String engineer, blueprintName, experimentalEffect, experimentalEffect_Localised;
	int engineerID, blueprintID, level;
	double quality;
	Modifier[] modifiers;
	
	public Engineering(String engineer, String blueprintName, String experimentalEffect,
			String experimentalEffect_Localised, int engineerID, int blueprintID, int level, double quality,
			Modifier[] modifiers) {
		this.engineer = engineer;
		this.blueprintName = blueprintName;
		this.experimentalEffect = experimentalEffect;
		this.experimentalEffect_Localised = experimentalEffect_Localised;
		this.engineerID = engineerID;
		this.blueprintID = blueprintID;
		this.level = level;
		this.quality = quality;
		this.modifiers = modifiers;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getBlueprintName() {
		return blueprintName;
	}

	public void setBlueprintName(String blueprintName) {
		this.blueprintName = blueprintName;
	}

	public String getExperimentalEffect() {
		return experimentalEffect;
	}

	public void setExperimentalEffect(String experimentalEffect) {
		this.experimentalEffect = experimentalEffect;
	}

	public String getExperimentalEffect_Localised() {
		return experimentalEffect_Localised;
	}

	public void setExperimentalEffect_Localised(String experimentalEffect_Localised) {
		this.experimentalEffect_Localised = experimentalEffect_Localised;
	}

	public int getEngineerID() {
		return engineerID;
	}

	public void setEngineerID(int engineerID) {
		this.engineerID = engineerID;
	}

	public int getBlueprintID() {
		return blueprintID;
	}

	public void setBlueprintID(int blueprintID) {
		this.blueprintID = blueprintID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getQuality() {
		return quality;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public Modifier[] getModifiers() {
		return modifiers;
	}

	public void setModifiers(Modifier[] modifiers) {
		this.modifiers = modifiers;
	}
	
}
