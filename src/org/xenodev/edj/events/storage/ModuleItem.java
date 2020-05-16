/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/10/2020 10:46
*/

package org.xenodev.edj.events.storage;

public class ModuleItem {
	
	public String slot, name, nameLocalised, engineerModifications;
	public Boolean hot;
	public Integer engineeeredLevel;
	public Double quality;
	
	public ModuleItem(String slot, String name, String nameLocalised, String engineerModifications, Boolean hot,
			Integer engineeeredLevel, Double quality) {
		this.slot = slot;
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.engineerModifications = engineerModifications;
		this.hot = hot;
		this.engineeeredLevel = engineeeredLevel;
		this.quality = quality;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public void setNameLocalised(String nameLocalised) {
		this.nameLocalised = nameLocalised;
	}

	public String getEngineerModifications() {
		return engineerModifications;
	}

	public void setEngineerModifications(String engineerModifications) {
		this.engineerModifications = engineerModifications;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Integer getEngineeeredLevel() {
		return engineeeredLevel;
	}

	public void setEngineeeredLevel(Integer engineeeredLevel) {
		this.engineeeredLevel = engineeeredLevel;
	}

	public Double getQuality() {
		return quality;
	}

	public void setQuality(Double quality) {
		this.quality = quality;
	}

}
