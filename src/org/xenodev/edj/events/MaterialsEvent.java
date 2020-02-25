package org.xenodev.edj.events;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.material.Encoded;
import org.xenodev.edj.events.storage.material.Manufactured;
import org.xenodev.edj.events.storage.material.Raw;

public class MaterialsEvent extends Event {
	
	Raw[] raw;
	Manufactured[] manufactured;
	Encoded[] encoded;
	
	public MaterialsEvent(String timestamp, Raw[] raw, Manufactured[] manufactured, Encoded[] encoded) {
		super(timestamp);
		this.raw = raw;
		this.manufactured = manufactured;
		this.encoded = encoded;
	}

	public Raw[] getRaw() {
		return raw;
	}

	public void setRaw(Raw[] raw) {
		this.raw = raw;
	}

	public Manufactured[] getManufactured() {
		return manufactured;
	}

	public void setManufactured(Manufactured[] manufactured) {
		this.manufactured = manufactured;
	}

	public Encoded[] getEncoded() {
		return encoded;
	}

	public void setEncoded(Encoded[] encoded) {
		this.encoded = encoded;
	}	

}
