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
	