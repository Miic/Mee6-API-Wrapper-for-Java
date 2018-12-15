/* 
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;

import java.net.URL;

import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.ErrorMessage;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.MeeResponse;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.Players;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Exceptions.Mee6Exception;
import com.google.gson.Gson;

public class M6CacheManager {
	private long cacheLifespan;
	private long lastQuery;
	private int limit;
	
	private String toBeCheck;
	private Gson gson;	
	
	private MeeResponse cache = null;
	
	private static final int LIMIT_MAX = 999;
	
	/**
	 * Constructs a CacheManager to Mee6 Rest API to prevent too frequent querying
	 * 
	 * @param url The starting url
	 * @param limit How many player ids should be queried per url request? Recommended: 999
	 * @param cacheLifespanMS How long in milliseconds should we wait until we refresh the cache
	 */
	public M6CacheManager(String url, int limit, long cacheLifespanMS) {
		this.toBeCheck = url;
		this.cacheLifespan = cacheLifespanMS;
		lastQuery = 0;
		gson = new Gson();
		
		if (limit > LIMIT_MAX) {
			limit = LIMIT_MAX;
		} else if (limit <= 0) {
			limit = 1;
		}
		this.limit = limit;

		try {
			getJson();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return {@link com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.MeeResponse} of the Target Server 
	 * @throws IOException
	 */
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
	    	httpcon.setConnectTimeout(5000);
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
	    	reader.close();
	    	//Get specified data needed.	    	
	    	
	    	final String response = sb.toString();
	    	
	    	if (response.startsWith("{\"error\":")) {
	    		ErrorMessage errorMsg = gson.fromJson(response, ErrorMessage.class);
	    		throw new Mee6Exception(errorMsg);
	    	}
	    	
	    	MeeResponse responseInstance = gson.fromJson(response, MeeResponse.class);
	    		    	
	    	if (cache == null) {
	    		cache = gson.fromJson(response, MeeResponse.class);
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
