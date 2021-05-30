import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P2win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2win extends World
{

    /**
     * Constructor for objects of class P2win.
     * 
     */
    public P2win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        this.getBackground().scale(getWidth(), getHeight());
        Label lScore = new Label(("Player 2 Wins!"), 50);
        addObject(lScore, 500, 250);//this is the location of the lable 
        lScore.setFillColor(Color.BLUE);//it will be yellow in the center 
        lScore.setLineColor(Color.RED);//it will have a red outline 
    }
}
