import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombBounce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombBounce extends Actor
{
    public static Boolean bounce =false;
    /**
     * Act - do whatever the BombBounce wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         Actor manhit =  getOneIntersectingObject(Bomberman.class);
        if(manhit != null)//if it does hit a brick it will do the code below 
        {
            bounce=true;
            getWorld().removeObject(this);
            
            
            

        }
    }    
}
