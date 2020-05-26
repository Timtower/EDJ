package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CodexEntryEvent extends Event {
	
	String name, subCategory, subCategoryLocalised, category, categoryLocalised, region, system;
	Integer entryID;
	Long systemAdress;
	Boolean isNewEntry, newTraitsDiscovered;
	String[] traits;
	
	public CodexEntryEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.name = json.pullString("Name");
		this.subCategory = json.pullString("SubCategory");
		this.subCategoryLocalised = json.pullString("SubCategory_Localised");
		this.category = json.pullString("Category");
		this.categoryLocalised = json.pullString("Category_Localised");
		this.region = json.pullString("Region");
		this.system = json.pullString("System");
		this.entryID = json.pullInt("EntryID");
		this.systemAdress = json.pullLong("SystemAddress");
		this.isNewEntry = json.pullBoolean("IsNewEntry");
		this.newTraitsDiscovered = json.pullBoolean("NewTraitsDiscovered");
		this.traits = JournalUtils.createTraitsList(json.pullJSONArray("Traits"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSubCategoryLocalised() {
		return subCategoryLocalised;
	}

	public void setSubCategory_Localised(String subCategoryLocalised) {
		this.subCategoryLocalised = subCategoryLocalised;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_Localised() {
		return categoryLocalised;
	}

	public void setCategory_Localised(String categoryLocalised) {
		this.categoryLocalised = categoryLocalised;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Integer getEntryID() {
		return entryID;
	}

	public void setEntryID(Integer entryID) {
		this.entryID = entryID;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public void setSystemAdress(Long systemAdress) {
		this.systemAdress = systemAdress;
	}

	public Boolean getIsNewEntry() {
		return isNewEntry;
	}

	public void setIsNewEntry(Boolean isNewEntry) {
		this.isNewEntry = isNewEntry;
	}

	public Boolean getNewTraitsDiscovered() {
		return newTraitsDiscovered;
	}

	public void setNewTraitsDiscovered(Boolean newTraitsDiscovered) {
		this.newTraitsDiscovered = newTraitsDiscovered;
	}

	public String[] getTraits() {
		return traits;
	}

	public void setTraits(String[] traits) {
		this.traits = traits;
	}

}
