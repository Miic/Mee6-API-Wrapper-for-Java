# Mee6 API Wrapper for Java

Java 8 API Wrapper for the MEE6 Discord Bot

## What is it?
Mee6 is a Discord bot that lets you easily add your own commands to your server
through a user-friendly dashboard. A little known fact is that it has an API which other bots can reference from.

While building a bot with JDA around Mee6 player statistics, I found that there was no public wrappers for Mee6, so I built one. I thought I would share this with the community in case someone else needed it. :D

![Jason](https://i.gyazo.com/53d14bf4550f2efd4f835f3bd4563292.png)

**Using Mee6API Object**:
```java
public class Example
{
    public static void main(String[] args)
    {
    	  //Note you must build a corresponding JDA with the Server's ID
        Mee6API mee = new Mee6API("222123744959660032");
        
        //Grab a player by ID
        Players player = mee.getPlayer("157692073699573761");
        
        //An output of their level
        System.out.println(player.getLevel());
    }

    @Override
    public void onEvent(Event event)
    {
        if (event instanceof ReadyEvent)
            System.out.println("API is ready!");
    }
}
```
