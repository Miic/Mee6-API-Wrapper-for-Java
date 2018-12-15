# MEE6 API Wrapper for Java

Java 8 API Wrapper for the MEE6 Discord Bot

## What is it?
MEE6 is a Discord bot that lets you easily add your own commands to your server
through a user-friendly dashboard, but it is a little known fact is that MEE6 has an API which other applications can call information from.

While building a bot with JDA around Mee6 player statistics, I found that there was no public wrappers for Mee6, so I built one. I thought I would share this with the community in case someone else needed it.

At the moment, we are only allowed to GET data from the API and not POST to update a specific value.

![Jason](https://i.gyazo.com/53d14bf4550f2efd4f835f3bd4563292.png)

**Using Mee6API Object**:
```java
public class Example
{
    public static void main(String[] args)
    {
    	//Note you must build a corresponding JDA with the Server's ID
        Mee6API mee = new Mee6API("222123744959660032");
        
        //Grab a player by ID (will output null if Mee6API is not operational)
        Players player = mee.getPlayer("157692073699573761");
        
        //An output of their level
        System.out.println(player.getUsername() + " : " + player.getLevel());
    }
}
```
