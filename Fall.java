import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fall extends Actor
{
    int xsize=30;
    int ysize=50;
    
    
    
    public void Fall()
    {
    getImage().scale(50,50);
    }
    /**
     * Act - do whatever the Fall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        xsize--;
        ysize--;
        getImage().scale(xsize,ysize);
         getImage().scale(xsize,ysize);
         if(xsize<3)
         {
             getWorld().removeObject(this);
            }
        
        
    }    
}
