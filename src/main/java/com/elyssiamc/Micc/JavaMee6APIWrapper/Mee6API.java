package com.elyssiamc.Micc.JavaMee6APIWrapper;

import java.io.IOException;

import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Guild;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.MeeResponse;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Players;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Role_rewards;
import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.SimpleAPICache;

public class Mee6API {
	private String serverid;
	private SimpleAPICache mee;
	private static final int[] xpList = getXPForLvls(200);
	
	public Mee6API(String serverid) {
		this.serverid = serverid;
		mee = new SimpleAPICache(
			"https://mee6.xyz/api/plugins/levels/leaderboard/" +
			serverid, 1000, 300000);
	}
	
	public String getServerId() {
		return serverid;
	}
	
	public Guild getGuild() {
		MeeResponse response = getAbstractResponse();
		return response != null ? response.getGuild() : null;
	}
	
	public Role_rewards[] getRewards() {
		MeeResponse response = getAbstractResponse();
		return response != null ? response.getRole_rewards() : null;
	}
	
	public MeeResponse getAbstractResponse() {
		try {
			return mee.getJson();
		} catch (IOException e) {}
		return null;
	}
	
	public Players[] getPlayers() {
		MeeResponse response = getAbstractResponse();
		return response != null ? response.getPlayers() : null;
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
