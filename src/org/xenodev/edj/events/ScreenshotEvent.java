package org.xenodev.edj.events;

import org.json.JSONObject;
import org.xenodev.edj.Event;

public class ScreenshotEvent extends Event {
	
	private String filename, system, body;
	private Integer width, height, heading;
	private Double latitude, longitude, altitude;
	
	public ScreenshotEvent(String timestamp, JSONObject json) {
		super(timestamp);
		this.filename = json.getString("Filename");
		this.system = json.getString("System");
		this.body = json.getString("Body");
		this.width = json.getInt("Width");
		this.height = json.getInt("Height");
		this.heading = json.getInt("Heading");
		this.latitude = json.getDouble("Latitude");
		this.longitude = json.getDouble("Longitude");
		this.altitude = json.getDouble("Altitude");
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
