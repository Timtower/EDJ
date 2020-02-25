package org.xenodev.edj.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTranslator {
	
	public static String getString(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getString(keyword);
		}
		
		return null;
	}
	
	public static Integer getInteger(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getInt(keyword);
		}
		
		return null;
	}
	
	public static Long getLong(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getLong(keyword);
		}
		
		return null;
	}
	
	public static Double getDouble(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getDouble(keyword);
		}
		
		return null;
	}
	
	public static Boolean getBoolean(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getBoolean(keyword);
		}
		
		return null;
	}
	
	public static JSONArray getJSONArray(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getJSONArray(keyword);
		}
		
		return null;
	}
	
	public static JSONObject getJSONObject(JSONObject json, String keyword) {
		if(json.has(keyword)) {
			return json.getJSONObject(keyword);
		}
		
		return null;
	}

}
