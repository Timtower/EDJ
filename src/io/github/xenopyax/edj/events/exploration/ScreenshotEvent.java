package io.github.xenopyax.edj.events.exploration;

import org.json.JSONObject;

import io.github.xenopyax.edj.events.Event;
import io.github.xenopyax.edj.utils.JournalUtils;

public class ScreenshotEvent extends Event {
	
	private String filename, system, body;
	private Integer width, height, heading;
	private Double latitude, longitude, altitude;
	
	public ScreenshotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		
		this.filename = json.pullString("Filename");
		this.system = json.pullString("System");
		this.body = json.pullString("Body");
		this.width = json.pullInt("Width");
		this.height = json.pullInt("Height");
		this.heading = json.pullInt("Heading");
		this.latitude = json.getDouble("Latitude");
		this.longitude = json.getDouble("Longitude");
		this.altitude = json.getDouble("Altitude");
		
		JournalUtils.isAllEventDataProcessed(this, json);
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
