package org.xenodev.edj.events.exploration;

import org.json.JSONObject;
import org.xenodev.edj.events.Event;
import org.xenodev.edj.utils.JournalUtils;

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

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getHeading() {
		return heading;
	}

	public void setHeading(Integer heading) {
		this.heading = heading;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

}
