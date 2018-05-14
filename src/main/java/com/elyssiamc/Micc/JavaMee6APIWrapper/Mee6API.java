package com.elyssiamc.Micc.JavaMee6APIWrapper;

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
			"https://api.mee6.xyz/plugins/levels/leaderboard/" +
			serverid, 1000, 30000);
	}
	
	public String getServerId() {
		return serverid;
	}
	
	public Guild getGuild() {
		return getAbstractResponse().getGuild();
	}
	
	public Role_rewards[] getRewards() {
		return getAbstractResponse().getRole_rewards();
	}
	
	public MeeResponse getAbstractResponse() {
		return mee.getJson();
	}
	
	public Players[] getPlayers() {
		return getAbstractResponse().getPlayers();
	}
	
	public Players getPlayer(String discordid) {
		Players[] meePlayers = getPlayers();
		for(Players player : meePlayers) {
			if (player.getId().equals(discordid)) {
				return player;
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
