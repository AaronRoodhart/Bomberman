
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class breakBrickGone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class breakBrickGone extends Actor
{
    public static int Transparency=100;
    boolean Tran=true;
    int spawnpower;

    SimpleTimer tremove= new SimpleTimer();
    GreenfootImage ice= new GreenfootImage ("fireicebreak.png");
    /**
     * Act - do whatever the breakBrickGone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((getWorld() instanceof Level2)||(getWorld() instanceof PVP2))//if your in level 2 the image will be diffrent to look like the snowball onfire 
        {
            setImage(ice);
            getImage().scale(50,50);
        }

        if (tremove.millisElapsed()>1100)
        {
            if (Tran)
            {
                Transparency=100;
                Tran=false;//this was done because for some reason it wasn't reseting the transparency so I put it into the act with a boolean effecting it so it will only happen once 
            }
            if (Transparency>0)
            {
                Transparency-=4;//it will reduce the tranceparency int
                getImage().setTransparency(Transparency);//and it will set the transparency to that int
                if (Transparency<25)
                {
                    spawnpower=Greenfoot.getRandomNumber(15);//when all the animations are done there is a random chance of a powerup spawning
                    if(spawnpower==1)
                    {
                        getWorld().addObject(new ExtraFire(),getX() , getY());
                    }
                    if(spawnpower==2)
                    {
                        getWorld().addObject(new ExtraBomb(),getX() , getY());
                    }

                    getWorld().removeObject(this);//then it will be fully removed

                }

            }
        }
    }  

    public breakBrickGone()//this is what increases the score 
    {
        tremove.mark();
        MyWorld.iscore+=100;
    }
}
