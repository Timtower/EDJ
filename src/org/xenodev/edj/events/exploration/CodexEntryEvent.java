package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

public class CodexEntryEvent extends Event {
	
	private String name, subCategory, subCategoryLocalised, category, categoryLocalised, region, system;
	private Integer entryID;
	private Long systemAdress;
	private Boolean isNewEntry, newTraitsDiscovered;
	private String[] traits;
	
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

	public String getSubCategory() {
		return subCategory;
	}

	public String getSubCategoryLocalised() {
		return subCategoryLocalised;
	}

	public String getCategory() {
		return category;
	}

	public String getCategoryLocalised() {
		return categoryLocalised;
	}

	public String getRegion() {
		return region;
	}

	public String getSystem() {
		return system;
	}

	public Integer getEntryID() {
		return entryID;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Boolean getIsNewEntry() {
		return isNewEntry;
	}

	public Boolean getNewTraitsDiscovered() {
		return newTraitsDiscovered;
	}

	public String[] getTraits() {
		return traits;
	}

}
