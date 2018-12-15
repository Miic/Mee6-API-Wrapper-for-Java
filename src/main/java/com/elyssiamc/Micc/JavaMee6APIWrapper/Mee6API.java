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

package com.elyssiamc.Micc.JavaMee6APIWrapper;

import java.io.IOException;

import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.M6CacheManager;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.Guild;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.MeeResponse;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.Players;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters.Role_rewards;

public class Mee6API {
	private String serverid;
	private M6CacheManager mee;
	private static final int[] xpList = getXPForLvls(200);
	
	private static final String URL = "https://mee6.xyz/api/plugins/levels/leaderboard/";
	
	public Mee6API(String serverid) {
		this.serverid = serverid;
		mee = new M6CacheManager(
			URL + serverid, 999, 300000);
	}
	
	public String getServerId() {
		return serverid;
	}
	
	public Guild getGuild() {
		MeeResponse response = getAbstractResponse();
		return response.getGuild();
	}
	
	public Role_rewards[] getRewards() {
		MeeResponse response = getAbstractResponse();
		return response.getRole_rewards();
	}
	
	public MeeResponse getAbstractResponse() {
		try {
			return mee.getJson();
		} catch (IOException e) {}
		return null;
	}
	
	public Players[] getPlayers() {
		return getAbstractResponse().getPlayers();
	}
	
	public Players getPlayer(String discordid) {
		Players[] meePlayers = getPlayers();
		if (meePlayers != null) {
			for(Players player : meePlayers) {
				if (player.getId().equals(discordid)) {
					return player;
				}
			}
		}
		return null;
	}
	
	
	//
	public static int getLevelFromXP(int xp) {
		int remainingXP = xp;
		int lvl = 0;
		while (remainingXP >= xpList[lvl]) {
			remainingXP -= xpList[lvl];
			lvl++;
		}
		return lvl;
	}
	
	private static int[] getXPForLvls(int lvl) {
		int[] xps = new int[lvl];
		for(int i = 0; i < xps.length; i++) {
			xps[i] = 5 * (i*i) + 50 * i + 100;
		}
		return xps;
	}
	
} 
