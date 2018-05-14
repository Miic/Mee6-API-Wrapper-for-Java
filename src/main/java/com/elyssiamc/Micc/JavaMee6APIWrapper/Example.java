package com.elyssiamc.Micc.JavaMee6APIWrapper;

import com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Players;

public class Example 
{
    public static void main( String[] args )
    {
    	//A guild's id
        Mee6API mee = new Mee6API("222123744959660032");
        
        //A player's id
        Players player = mee.getPlayer("157692073699573761");
        
        //An output of their level
        System.out.println(player.getLevel());
    }
}
