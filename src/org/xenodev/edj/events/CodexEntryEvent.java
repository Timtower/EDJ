package org.xenodev.edj.events;

import org.xenodev.edj.Event;

public class CodexEntryEvent extends Event {
	
	String name, subCategory, subCategory_Localised, category, category_Localised, region, system;
	int entryID;
	long systemAdress;
	boolean isNewEntry, newTraitsDiscovered;
	String[] traits;
	
	public CodexEntryEvent(String timestamp, String name, String subCategory, String subCategory_Localised,String category, String category_Localised, String region, String system, int entryID, long systemAdress,
			boolean isNewEntry, boolean newTraitsDiscovered, String[] traits) {
		super(timestamp);
		this.name = name;
		this.subCategory = subCategory;
		this.subCategory_Localised = subCategory_Localised;
		this.category = category;
		this.category_Localised = category_Localised;
		this.region = region;
		this.system = system;
		this.entryID = entryID;
		this.systemAdress = systemAdress;
		this.isNewEntry = isNewEntry;
		this.newTraitsDiscovered = newTraitsDiscovered;
		this.traits = traits;
	}

	public String getName() {
		return name;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public String getSubCategory_Localised() {
		return subCategory_Localised;
	}

	public String getCategory() {
		return category;
	}

	public String getCategory_Localised() {
		return category_Localised;
	}

	public String getRegion() {
		return region;
	}

	public String getSystem() {
		return system;
	}

	public int getEntryID() {
		return entryID;
	}

	public long getSystemAdress() {
		return systemAdress;
	}

	public boolean isNewEntry() {
		return isNewEntry;
	}

	public boolean isNewTraitsDiscovered() {
		return newTraitsDiscovered;
	}

	public String[] getTraits() {
		return traits;
	}

}