import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExtraBomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExtraBomb extends Actor
{
    public static boolean extra=true;
    public static boolean extraP2=true;
    SimpleTimer tPowerEnd= new SimpleTimer();
    SimpleTimer tPowerEndP2= new SimpleTimer();
    public ExtraBomb()
    {
        getImage().scale(50,50);
        extra=false;
        extraP2=false;

    }

    /**
     * Act - do whatever the ExtraBomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor manhit =  getOneIntersectingObject(Bomberman.class);
        if(manhit != null)//if it hits player 1 it will give them the powerup and then start a timer for how long the powerup lasts  
        {
            extra=true;

            tPowerEnd.mark();

        }
        Actor manhit2 =  getOneIntersectingObject(BombermanP2.class);
        if(manhit2 != null)//if it does hit a brick it will do the code below 
        {
            extraP2=true;

            tPowerEndP2.mark();

        }
        if (extra==true||extraP2==true)//this makes it so if eitther the first or second player has picked up the power up the powerup will disappere and will also make it so no other ones can spawn if someone has the powerup
        {
            getWorld().removeObject(this);
        }
        if (tPowerEnd.millisElapsed()>2500)//after the iloted time the powerup will be removed 
        {
            extra=false;//this is what controls the powerup

        }
        if(tPowerEndP2.millisElapsed()>2500)//sets a limit for how long you can have the powerup 
        {
            extraP2=false;
        }

    }    
}
