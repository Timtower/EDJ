package org.xenodev.edj.events.stationservices;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.datastorage.Modifier;
import org.xenodev.edj.events.datastorage.engineer.Ingredient;
import org.xenodev.edj.utils.JournalUtils;

public class EngineerCraftEvent extends Event {
	
	private String engineer, blueprintName, slot, module;
	private Integer engineerID, blueprintID, level;
	private Double quality;
	private List<Ingredient> ingredients;
	private List<Modifier> modifiers;
	
	public EngineerCraftEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.module = json.pullString("Module");
		this.slot = json.pullString("Slot");
		this.engineer = json.pullString("Engineer");
		this.blueprintName = json.pullString("BlueprintName");
		this.engineerID = json.pullInt("EngineerID");
		this.blueprintID = json.pullInt("BlueprintID");
		this.level = json.pullInt("Level");
		this.quality = json.pullDouble("Quality");
		this.ingredients = JournalUtils.createIngredientsList(json.pullJSONArray("Ingredients"));
		this.modifiers = JournalUtils.createModifierList(json.pullJSONArray("Modifiers"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getSlot() {
		return slot;
	}

	public String getModule() {
		return module;
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
