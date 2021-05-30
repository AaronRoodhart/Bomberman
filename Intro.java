import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{

    /**
     * Constructor for objects of class Intro.
     * 
     */
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        this.getBackground().scale(getWidth(), getHeight());
        SimpleTimer tshow= new SimpleTimer();
        tshow.mark();
        Label lbest = new Label(("Instructions!! Press J to go back"), 50);
        addObject(lbest, 620, 50);//this is the location of the lable 
        lbest.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lbest.setLineColor(Color.RED);

    }
    public void act()
    {
        if(Greenfoot.isKeyDown("j"))//if you hit the space key
        {

            Greenfoot.setWorld(new Title());//this allows people to go back to the title screen an pick the mode they want to play

        }

    }
}