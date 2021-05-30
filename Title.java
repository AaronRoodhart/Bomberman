import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    boolean playsong=true;

    public static GreenfootSound Start1;//states that there is a greenfoot sound called start1

    SimpleTimer tshow= new SimpleTimer();
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 850, 1);
        this.getBackground().scale(getWidth(), getHeight());
        tshow.mark();
        Start1 =null;//this will make any thing atached to start1 from previous runs nothing this was put in because it seemed to be messing up the sound file after it was played befor so i got rid of anything that was attached to that name 
        Start1 = new GreenfootSound("intro.mp3.mp3");//Every time I reset the start 1 sound will be re-defined as the mp3 file 

    }
    public void act()
    {
        Label lScore = new Label(("Press H for Score Mode!?!"), 50);//this makes a lable called lScore and it will be size 50 font 
         if (tshow.millisElapsed()>4000)//this makes it so the text doesn't just apper 
        {
            addObject(lScore, 300, 600);//this is the location of the lable 
            lScore.setFillColor(Color.YELLOW);//it will be yellow in the center 
            lScore.setLineColor(Color.RED);//it will have a red outline 
        }
        Label lPvP = new Label(("Press G for PVP"), 50);//this makes a lable called lScore and it will be size 50 font 
        if (tshow.millisElapsed()>4000)
        {
            addObject(lPvP, 300, 400);//this is the location of the lable 
            lPvP.setFillColor(Color.YELLOW);//it will be yellow in the center 
            lPvP.setLineColor(Color.RED);//it will have a red outline 
        }
        Label lbest = new Label(("Press J for the best mode"), 50);//this makes a lable called lbest and it will be size 50 font 
        if (tshow.millisElapsed()>4000)
        {
            addObject(lbest, 300, 500);//this is the location of the lable 
            lbest.setFillColor(Color.YELLOW);//it will be yellow in the center 
            lbest.setLineColor(Color.RED);//it will have a red outline 
        }
        if(playsong)
        {

            Start1.playLoop();//playes the introsong forever
            playsong=false;//makes it so this if statement won't be repeted 
        }
        if(Greenfoot.isKeyDown("G"))//if you hit the space key
        {
            Start1.stop();//main theme stops 
            Greenfoot.setWorld(new PVP1());//goes to MyWorld

        }
        if(Greenfoot.isKeyDown("H"))//if you hit the space key
        {
            Start1.stop();//main theme stops 
            Greenfoot.setWorld(new MyWorld());//goes to MyWorld

        }
         if(Greenfoot.isKeyDown("j"))//if you hit the space key
        {
            Start1.stop();//main theme stops 
            Greenfoot.setWorld(new Intro());//goes to the instructions

        }

    }
}
