package org.xenodev.edj.events;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.Event;
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
		this.engineer = json.getString("Engineer");
		this.blueprintName = json.getString("BlueprintName");
		this.engineerID = json.getInt("EngineerID");
		this.blueprintID = json.getInt("BlueprintID");
		this.level = json.getInt("Level");
		this.quality = json.getDouble("Quality");
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
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public List<Modifier> getModifiers() {
		return modifiers;
	}

}
