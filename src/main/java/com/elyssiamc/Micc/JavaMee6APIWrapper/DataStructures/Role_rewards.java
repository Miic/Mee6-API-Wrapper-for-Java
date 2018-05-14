package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class Role_rewards
{
    private String rank;

    private Role role;

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public Role getRole ()
    {
        return role;
    }

    public void setRole (Role role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rank = "+rank+", role = "+role+"]";
    }
}
	