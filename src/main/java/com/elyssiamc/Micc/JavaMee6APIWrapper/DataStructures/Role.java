package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class Role
{
    private String position;

    private String id;

    private String managed;

    private String color;

    private String name;

    private String hoist;

    private String permissions;

    private String mentionable;

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getManaged ()
    {
        return managed;
    }

    public void setManaged (String managed)
    {
        this.managed = managed;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getHoist ()
    {
        return hoist;
    }

    public void setHoist (String hoist)
    {
        this.hoist = hoist;
    }

    public String getPermissions ()
    {
        return permissions;
    }

    public void setPermissions (String permissions)
    {
        this.permissions = permissions;
    }

    public String getMentionable ()
    {
        return mentionable;
    }

    public void setMentionable (String mentionable)
    {
        this.mentionable = mentionable;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", id = "+id+", managed = "+managed+", color = "+color+", name = "+name+", hoist = "+hoist+", permissions = "+permissions+", mentionable = "+mentionable+"]";
    }
}