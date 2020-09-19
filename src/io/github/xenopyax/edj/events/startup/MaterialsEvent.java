package io.github.xenopyax.edj.events.startup;

import java.util.List;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.events.datastorage.material.Encoded;
import io.github.xenopyax.edj.events.datastorage.material.Manufactured;
import io.github.xenopyax.edj.events.datastorage.material.Raw;
import io.github.xenopyax.edj.utils.JournalUtils;

public class MaterialsEvent extends Event {
	
	private List<Raw> raw;
	private List<Manufactured> manufactured;
	private List<Encoded> encoded;
	
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

	public List<Manufactured> getManufactured() {
		return manufactured;
	}

	public List<Encoded> getEncoded() {
		return encoded;
	}
	
}
