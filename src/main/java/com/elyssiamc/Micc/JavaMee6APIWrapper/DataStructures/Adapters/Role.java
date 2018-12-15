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

package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters;

/**
 * Auto-generated code used to translate Guild a JSON Response to a Java object
 * 
 * @author Micc
 *
 */
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