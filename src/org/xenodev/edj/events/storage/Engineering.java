package org.xenodev.edj.events.storage;

import java.util.List;

public class Engineering {
	
	String engineer, blueprintName, experimentalEffect, experimentalEffect_Localised;
	Integer engineerID, blueprintID, level;
	Double quality;
	List<Modifier> modifiers;
	
	public Engineering(String engineer, String blueprintName, String experimentalEffect,
			String experimentalEffect_Localised, Integer engineerID, Integer blueprintID, Integer level, Double quality,
			List<Modifier> modifiers) {
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

	public Integer getEngineerID() {
		return engineerID;
	}

	public void setEngineerID(Integer engineerID) {
		this.engineerID = engineerID;
	}

	public Integer getBlueprintID() {
		return blueprintID;
	}

	public void setBlueprintID(Integer blueprintID) {
		this.blueprintID = blueprintID;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Double getQuality() {
		return quality;
	}

	public void setQuality(Double quality) {
		this.quality = quality;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<Modifier> modifiers) {
		this.modifiers = modifiers;
	}
	
}
