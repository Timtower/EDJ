package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;
import org.xenodev.edj.utils.JsonTranslator;

public class ScreenshotEvent extends Event {
	
	private String filename, system, body;
	private Integer width, height, heading;
	private Double latitude, longitude, altitude;
	
	public ScreenshotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.filename = JsonTranslator.getString(json, "Filename");
		this.system = JsonTranslator.getString(json, "System");
		this.body = JsonTranslator.getString(json, "Body");
		this.width = JsonTranslator.getInteger(json, "Width");
		this.height = JsonTranslator.getInteger(json, "Height");
		this.heading = JsonTranslator.getInteger(json, "Heading");
		this.latitude = JsonTranslator.getDouble(json, "Latitude");
		this.longitude = JsonTranslator.getDouble(json, "Longitude");
		this.altitude = JsonTranslator.getDouble(json, "Altitude");
	}

	public String getFilename() {
		return filename;
	}

	public String getSystem() {
		return system;
	}

	public String getBody() {
		return body;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getHeading() {
		return heading;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

}
