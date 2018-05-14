package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class MeeResponse
{
    private Role_rewards[] role_rewards;

    private String page;

    private Players[] players;

    private Guild guild;

    public Role_rewards[] getRole_rewards ()
    {
        return role_rewards;
    }

    public void setRole_rewards (Role_rewards[] role_rewards)
    {
        this.role_rewards = role_rewards;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public Players[] getPlayers ()
    {
        return players;
    }

    public void setPlayers (Players[] players)
    {
        this.players = players;
    }

    public Guild getGuild ()
    {
        return guild;
    }

    public void setGuild (Guild guild)
    {
        this.guild = guild;
    }

    @Override
    public String toString()
    {
        return "[role_rewards = "+role_rewards+", page = "+page+", players = "+players+", guild = "+guild+"]";
    }
}
	