package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class Players
{
    private String id;

    private String username;

    private int level;

    private String discriminator;

    private int xp;

    private String avatar;

    private int[] detailed_xp;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public int getLevel ()
    {
        return level;
    }

    public void setLevel (int level)
    {
        this.level = level;
    }

    public String getDiscriminator ()
    {
        return discriminator;
    }

    public void setDiscriminator (String discriminator)
    {
        this.discriminator = discriminator;
    }

    public int getXp ()
    {
        return xp;
    }

    public void setXp (int xp)
    {
        this.xp = xp;
    }

    public String getAvatar ()
    {
        return avatar;
    }

    public void setAvatar (String avatar)
    {
        this.avatar = avatar;
    }

    public int[] getDetailed_xp ()
    {
        return detailed_xp;
    }

    public void setDetailed_xp (int[] detailed_xp)
    {
        this.detailed_xp = detailed_xp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", username = "+username+", level = "+level+", discriminator = "+discriminator+", xp = "+xp+", avatar = "+avatar+", detailed_xp = "+detailed_xp+"]";
    }
}