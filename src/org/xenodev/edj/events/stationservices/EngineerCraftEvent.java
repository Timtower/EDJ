package org.xenodev.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.Modifier;
import org.xenodev.edj.events.storage.engineer.Ingredient;
import org.xenodev.edj.utils.JournalUtils;

public class EngineerCraftEvent extends Event {
	
	private String engineer, blueprintName;
	private Integer engineerID, blueprintID, level;
	private Double quality;
	private List<Ingredient> ingredients;
	private List<Modifier> modifiers;
	
	public EngineerCraftEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.engineer = json.pullString("Engineer");
		this.blueprintName = json.pullString("BlueprintName");
		this.engineerID = json.pullInt("EngineerID");
		this.blueprintID = json.pullInt("BlueprintID");
		this.level = json.pullInt("Level");
		this.quality = json.getDouble("Quality");
		this.ingredients = JournalUtils.createIngredientsList(json.getJSONArray("Ingredients"));
		this.modifiers = JournalUtils.createModifierList(json.getJSONArray("Modifiers"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

}
