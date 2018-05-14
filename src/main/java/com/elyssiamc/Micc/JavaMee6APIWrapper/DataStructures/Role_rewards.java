package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class Role_rewards
{
    private int rank;

    private Role role;

    public int getRank ()
    {
        return rank;
    }

    public void setRank (int rank)
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
	