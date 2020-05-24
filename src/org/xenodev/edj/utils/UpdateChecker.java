/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/24/2020 13:06
*/

package org.xenodev.edj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xenodev.edj.EDJApi;

public class UpdateChecker {
	
	private String latestVersion, downloadLink;
	
	private final String LATEST_VERSION_URL = "https://api.github.com/repos/XenoPyax/EDJ/releases/latest";
	private final String RELEASES_URL = "https://api.github.com/repos/XenoPyax/EDJ/releases";
	
	public UpdateChecker() {
		
		try {
			
			collectLatestVersionInfo();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void checkIsLatestVersion() {
		Integer currentVersionInt = Integer.parseInt(EDJApi.VERSION.replaceAll("\\.", ""));
		Integer latestVersionInt = Integer.parseInt(latestVersion.replaceAll("\\.", ""));
		
		Compare(currentVersionInt, latestVersionInt);
	}
	
	private void Compare(Integer currentVersionInt, Integer latestVersionInt) {
		
		if(String.valueOf(currentVersionInt).length() > String.valueOf(latestVersionInt).length()) {
			latestVersionInt *= 10;	// Increasing versionInt to match length
		}else if(String.valueOf(currentVersionInt).length() < String.valueOf(latestVersionInt).length()) {
			currentVersionInt *= 10; // Increasing versionInt to match length
		}
		
		if(latestVersionInt > currentVersionInt) {
			System.out.println("You are " + getVersionsBehind() + " version(s) behind the most recent version of EDJ (" + downloadLink + ").");
		}else if(latestVersionInt < currentVersionInt) {
			System.out.println("No clue how this happend, You have a more recent version of EDJ than the latest version currently available. Please contact the API developer about this"
					+ " and download the latest version of EDJ (" + downloadLink + ").");
		}else if(latestVersionInt == currentVersionInt) {
			System.out.println("You have the latest version of EDJ that is currently available.");
		}
		
	}
	
	private void collectLatestVersionInfo() throws IOException {
		URL url = new URL(LATEST_VERSION_URL);
	    URLConnection request = url.openConnection();
	    request.connect();

	    JSONObject json = new JSONObject(new InputStreamReader((InputStream) request.getContent()));
	    
	    if(json.has("tag_name")) {
	    	latestVersion = json.getString("tag_name");
	    }
	    
	    if(json.has("html_url")) {
	    	downloadLink = json.getString("html_url");
	    }
	    
	}
	
	private Integer getVersionsBehind(){
		try {
			URL url = new URL(RELEASES_URL);
		    URLConnection request = url.openConnection();
		    Integer behind = 0;
		    String currentReleaseDate = "";
		    
		    request.connect();

		    JSONArray array = new JSONArray(new InputStreamReader((InputStream) request.getContent()));
		    
		    if(array.length() > 0) {
		    	
		    	for(Object obj : array) {
		    		JSONObject json = new JSONObject(obj.toString());
		    		
		    		if(json.getString("tag_name").equals(EDJApi.VERSION)) {
		    			currentReleaseDate = json.getString("published_at");
		    		}
		    		
		    	}
		    	
		    	for(Object obj : array) {
		    		JSONObject json = new JSONObject(obj.toString());
		    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		    		
		    		if(!json.getString("tag_name").contains("-beta") || json.getString("tag_name").contains("-alpha")) {
		    			if(sdf.parse(currentReleaseDate).getTime() < sdf.parse(json.getString("published_at")).getTime()) {
			    			behind++;
			    		}
		    		}
		    		
		    	}
		    	
		    }
		    
		    return behind;
		}catch(IOException | JSONException | ParseException e) {
			
		}
	    
	    return 0;
	}

}
