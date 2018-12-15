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