package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures;
public class Role
{
    private int position;

    private String id;

    private boolean managed;

    private long color;

    private String name;

    private boolean hoist;

    private long permissions;

    private boolean mentionable;

    public int getPosition ()
    {
        return position;
    }

    public void setPosition (int position)
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

    public boolean getManaged ()
    {
        return managed;
    }

    public void setManaged (boolean managed)
    {
        this.managed = managed;
    }

    public long getColor ()
    {
        return color;
    }

    public void setColor (long color)
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

    public boolean getHoist ()
    {
        return hoist;
    }

    public void setHoist (boolean hoist)
    {
        this.hoist = hoist;
    }

    public long getPermissions ()
    {
        return permissions;
    }

    public void setPermissions (long permissions)
    {
        this.permissions = permissions;
    }

    public boolean getMentionable ()
    {
        return mentionable;
    }

    public void setMentionable (boolean mentionable)
    {
        this.mentionable = mentionable;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", id = "+id+", managed = "+managed+", color = "+color+", name = "+name+", hoist = "+hoist+", permissions = "+permissions+", mentionable = "+mentionable+"]";
    }
}