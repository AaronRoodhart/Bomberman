import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P1win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1win extends World
{

    /**
     * Constructor for objects of class P1win.
     * 
     */
    public P1win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        this.getBackground().scale(getWidth(), getHeight());
        Label lScore = new Label(("Player 1 Wins!"), 50);
        addObject(lScore, 500, 250);//this is the location of the lable 
        lScore.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lScore.setLineColor(Color.RED);//it will have a red outline 
    }
}
