package org.xenodev.edj.events;

import java.util.List;

import org.xenodev.edj.Event;
import org.xenodev.edj.events.storage.material.Encoded;
import org.xenodev.edj.events.storage.material.Manufactured;
import org.xenodev.edj.events.storage.material.Raw;

public class MaterialsEvent extends Event {
	
	List<Raw> raw;
	List<Manufactured> manufactured;
	List<Encoded> encoded;
	
	public MaterialsEvent(String timestamp, List<Raw> raw, List<Manufactured> manufactured, List<Encoded> encoded) {
		super(timestamp);
		this.raw = raw;
		this.manufactured = manufactured;
		this.encoded = encoded;
	}

	public List<Raw> getRaw() {
		return raw;
	}

	public void setRaw(List<Raw> raw) {
		this.raw = raw;
	}

	public List<Manufactured> getManufactured() {
		return manufactured;
	}

	public void setManufactured(List<Manufactured> manufactured) {
		this.manufactured = manufactured;
	}

	public List<Encoded> getEncoded() {
		return encoded;
	}

	public void setEncoded(List<Encoded> encoded) {
		this.encoded = encoded;
	}
	

}
