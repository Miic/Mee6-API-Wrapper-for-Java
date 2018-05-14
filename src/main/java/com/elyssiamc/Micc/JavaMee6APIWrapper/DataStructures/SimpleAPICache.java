package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

public class SimpleAPICache {
	private long cacheLifespan;
	private long lastQuery;
	private int limit;
	
	private String toBeCheck;
	private Gson gson;	
	
	private MeeResponse cache;
	
	public SimpleAPICache(String url, int limit, long cacheLifespan) {
		toBeCheck = url;
		this.limit = limit;
		this.cacheLifespan = cacheLifespan;
		lastQuery = 0;
		gson = new Gson();
	}
	
	public MeeResponse getJson() throws IOException {
		if (cache != null && System.currentTimeMillis() - lastQuery < cacheLifespan) {
			return cache;
		}
		
		int page = 0;
		boolean contFlag = false;
		
		do {
	       	HttpURLConnection httpcon = (HttpURLConnection) ((new URL(toBeCheck + "?limit=" + limit + "&page=" + page).openConnection()));
	    	httpcon.setDoOutput(true);
	    	httpcon.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64)");
	    	httpcon.setRequestMethod("GET");
	    	httpcon.connect();
	    	
	    	//Read response
	    	InputStream is = httpcon.getInputStream();
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    	String line = null;
	    	StringBuffer sb = new StringBuffer();
	    	while ((line = reader.readLine()) != null) {
	    	    sb.append(line);
	    	}
	    	is.close();
	    	httpcon.disconnect();
	    	//Get specified data needed.	    	
	    	
	    	MeeResponse responseInstance = gson.fromJson(sb.toString(), MeeResponse.class);
	    	
	    	if (cache == null) {
	    		cache = gson.fromJson(sb.toString(), MeeResponse.class);
	    	} else if (cache.getPlayers().length != 0) {
	    		cache.setPlayers(concatenate(cache.getPlayers(), responseInstance.getPlayers()));
	    	}
	    	
	    	if (responseInstance.getPlayers().length == limit) {
	    		contFlag = true;
	    		page++;
	    	}
		} while (contFlag);
    	
    	return cache;
	}
	
	private static Players[] concatenate(Players[] a, Players[] b) {
	    int aLen = a.length;
	    int bLen = b.length;

	    @SuppressWarnings("unchecked")
	    Players[] c = (Players[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
	    System.arraycopy(a, 0, c, 0, aLen);
	    System.arraycopy(b, 0, c, aLen, bLen);

	    return c;
	}
}
