package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.Modifier;
import org.xenodev.edj.events.storage.engineer.Ingredient;
import org.xenodev.edj.utils.JournalUtils;
import org.xenodev.edj.utils.JsonTranslator;

public class EngineerCraftEvent extends Event {
	
	private String engineer, blueprintName;
	private Integer engineerID, blueprintID, level;
	private Double quality;
	private Ingredient[] ingredients;
	private Modifier[] modifiers;
	
	public EngineerCraftEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.engineer = JsonTranslator.getString(json, "Engineer");
		this.blueprintName = JsonTranslator.getString(json, "BlueprintName");
		this.engineerID = JsonTranslator.getInteger(json, "EngineerID");
		this.blueprintID = JsonTranslator.getInteger(json, "BlueprintID");
		this.level = JsonTranslator.getInteger(json, "Level");
		this.quality = JsonTranslator.getDouble(json, "Quality");
		this.ingredients = JournalUtils.createIngredientsList(json.getJSONArray("Ingredients"));
		this.modifiers = JournalUtils.createModifierList(json.getJSONArray("Modifiers"));
	}
	
	public String getEngineer() {
		return engineer;
	}
	
	public String getBlueprintName() {
		return blueprintName;
	}
	
	public Integer getEngineerID() {
		return engineerID;
	}
	
	public Integer getBlueprintID() {
		return blueprintID;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public Double getQuality() {
		return quality;
	}
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}
	
	public Modifier[] getModifiers() {
		return modifiers;
	}

}
