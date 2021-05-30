import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceHole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceHole extends Actor
{
    public IceHole()
    {
        getImage().scale(50,50);
    }

    /**
     * Act - do whatever the IceHole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }    
    public boolean hitBrick()
    {
        Actor removebrick = getOneIntersectingObject(Brick.class);//this is used when they are being placed in level 2 so that way none of them overlap
        if ( removebrick!= null)
        {

            return true;

        } 
        return false;

    }

    public boolean hitBreakBrick()
    {
        Actor removebrick = getOneIntersectingObject(BreakBrick.class);
        if ( removebrick!= null)
        {

            return true;

        } 
        return false;

    }

}
