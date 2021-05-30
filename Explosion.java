import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    SimpleTimer tremove= new SimpleTimer();

    int frameSlow=0;
    int frame=1;
    GreenfootImage exp1= new GreenfootImage ("explosion1.png");
    GreenfootImage exp2= new GreenfootImage ("explosion2.png");
    GreenfootImage exp3= new GreenfootImage ("explosion3.png");
    public Explosion()
    {
        tremove.mark();

        getImage().scale(50, 50);

    }

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        frameSlow++; 
        if(frameSlow % 10 ==0)//this says that if the int frame slow is divisable by 10 and has no remanders it will change the frames this way the computer allows you to see the frames
        {

            changeframe();
        }

        if (tremove.millisElapsed()>1000)
        {
            getWorld().removeObject(this);
        }

    }   

    public void changeframe()
    {
        if(frame == 1)//if the int frame is =1it will change it to the second image
        {
            getImage().scale(50, 50);
            setImage(exp1);
        }
        else if (frame == 2)
        {
            getImage().scale(50, 50);
            setImage(exp2);

        }
        else if (frame == 3)
        {
            getImage().scale(50, 50);
            setImage(exp3);
            frame=1;//it will "restart the frames" so it will go back to the first one
            return;//this is so it won't add 1 to the reseted int
        }
        frame++;//it will add 1 to the int after it changes the image

    }

    public boolean didHit()//these are used in the bomb code to make it so no explosions can spawn ontop of other bricks 
    {

        Actor b = getOneIntersectingObject(Brick.class);
        if (b != null)
        {
            return true;

        }
        return false;
    }

    public boolean didHitbreak()
    {

        Actor a = getOneIntersectingObject(BreakBrick.class);
        if (a != null)
        {
            return true;

        }
        return false;
    }

}