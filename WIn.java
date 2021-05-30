import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WIn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WIn extends World
{
    int total = ((Level2.iTimedisplay*20)+Level2.total);//it will take the score that you have then give you 20 points for every second remaining 
    /**
     * Constructor for objects of class WIn.
     * 
     */
    public WIn()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        this.getBackground().scale(getWidth(), getHeight());
        int total = ((Level2.iTimedisplay*20)+Level2.total);//it will take the total of the of level 2 and give a time bonus of 20 points per second
        System.out.print(total);//it will show the total
        Label lScore = new Label(("Your score was "+ total), 50);//this shows the score
        addObject(lScore, 500, 390);//this is the location of the lable 
        lScore.setFillColor(Color.BLUE);//it will be yellow in the center 
        lScore.setLineColor(Color.RED);//it will have a red outline 
    }
}
