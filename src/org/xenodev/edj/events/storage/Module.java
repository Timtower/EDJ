package org.xenodev.edj.events.storage;

public class Module {
	
	String slot, item;
	Boolean on;
	int priority, ammoInClip, ammoInHopper, value;
	double health;
	Engineering engineering;
	
	public Module(String slot, String item, Boolean on, int priority, int ammoInClip, int ammoInHopper, double health,	int value, Engineering engineering) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
		this.value = value;
		this.engineering = engineering;
	}
	
	public Module(String slot, String item, Boolean on, int priority, int ammoInClip, int ammoInHopper, double health,	int value) {
		this.slot = slot;
		this.item = item;
		this.on = on;
		this.priority = priority;
		this.ammoInClip = ammoInClip;
		this.ammoInHopper = ammoInHopper;
		this.health = health;
		this.value = value;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getAmmoInClip() {
		return ammoInClip;
	}

	public void setAmmoInClip(int ammoInClip) {
		this.ammoInClip = ammoInClip;
	}

	public int getAmmoInHopper() {
		return ammoInHopper;
	}

	public void setAmmoInHopper(int ammoInHopper) {
		this.ammoInHopper = ammoInHopper;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Engineering getEngineering() {
		if(hasEngineering()) return null;
		return engineering;
	}

	public void setEngineering(Engineering engineering) {
		this.engineering = engineering;
	}
	
	public boolean hasEngineering() {
		if(this.engineering != null) {
			return true;
		}
		return false;
	}
	

}
