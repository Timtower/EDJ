package org.xenodev.edj.events.startup;

import java.util.List;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.events.storage.material.Encoded;
import org.xenodev.edj.events.storage.material.Manufactured;
import org.xenodev.edj.events.storage.material.Raw;
import org.xenodev.edj.utils.JournalUtils;

public class MaterialsEvent extends Event {
	
	List<Raw> raw;
	List<Manufactured> manufactured;
	List<Encoded> encoded;
	
	public MaterialsEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.raw = JournalUtils.createRawMaterialList(json.pullJSONArray("Raw"));
		this.manufactured = JournalUtils.createManufacturedMaterialList(json.pullJSONArray("Manufactured"));
		this.encoded = JournalUtils.createEncodedMaterialList(json.pullJSONArray("Encoded"));
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
