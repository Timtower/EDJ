package org.xenodev.edj.events.storage;

public class Module {
	
	String slot, item;
	Boolean on;
	Integer priority, ammoInClip, ammoInHopper;
	Double health;
	Engineering engineering;
	
	public Module(String slot, String item, Boolean on, Integer priority, Integer ammoInClip, Integer ammoInHopper, Double health, Engineering engineering) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
		this.engineering = engineering;
	}
	
	public Module(String slot, String item, Boolean on, Integer priority, Integer ammoInClip, Integer ammoInHopper, Double health) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Boolean getOn() {
		return on;
	}

	public void setOn(Boolean on) {
		this.on = on;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getAmmoInClip() {
		return ammoInClip;
	}

	public void setAmmoInClip(Integer ammoInClip) {
		this.ammoInClip = ammoInClip;
	}

	public Integer getAmmoInHopper() {
		return ammoInHopper;
	}

	public void setAmmoInHopper(Integer ammoInHopper) {
		this.ammoInHopper = ammoInHopper;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Engineering getEngineering() {
		return engineering;
	}

	public void setEngineering(Engineering engineering) {
		this.engineering = engineering;
	}

}
