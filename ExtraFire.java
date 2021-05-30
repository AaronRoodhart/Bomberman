import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExtraFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExtraFire extends Actor
{
    public static boolean extrafire=false;
    public static boolean extrafireP2=false;
    public ExtraFire()
    {
        getImage().scale(50,50);
    }

    /**
     * Act - do whatever the ExtraFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        Actor manhit2 =  getOneIntersectingObject(BombermanP2.class);

        if(manhit2 != null)//if it hits player 2 it will set their spicific boolean to true 
        {
            extrafireP2=true;

        }
        Actor manhit =  getOneIntersectingObject(Bomberman.class);
        if(manhit != null)//if it hits player 1 it will set their spicific boolean to true  
        {
            extrafire=true;

        }
        if(manhit != null||manhit2 != null)//after it has done its cheacks if it has intersected with either one of them it will be removed
        {
            getWorld().removeObject(this);
        }

    }

} 
