import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Actor
{
    GreenfootImage ice= new GreenfootImage ("IceBrick.png");
    public Brick()
    {
        getImage().scale(50,50);
    }

    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((getWorld() instanceof Level2)||(getWorld() instanceof PVP2))//if in level 2 the way it looks will be diffrent
        {
            setImage(ice);
            getImage().scale(50,50);
        }
    }    
}
