import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombermanP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombermanP2 extends Actor
{
    int Move_Speed=50;
    int frame=1;
    int frameSlow=20;

    int frameSlowR=20;
    int animate=0;
    int stopwalking=0;
    boolean blnGo=false;
    int xVal, yVal;
    int XMove=5;
    int YMove=5;
    int stop=0;
    public static int livesP2=4;

    final int TimeLimit=300;
    public static GreenfootImage WalkL1= new GreenfootImage ("Walk Left 1P2.png");
    public static GreenfootImage WalkL2= new GreenfootImage ("Walk Left 2P2.png");
    public static GreenfootImage WalkL3= new GreenfootImage ("Walk Left 3P2.png");
    public static GreenfootImage WalkR1= new GreenfootImage ("Walk Right 1P2.png");
    public static GreenfootImage WalkR2= new GreenfootImage ("Walk Right 2P2.png");
    public static GreenfootImage WalkR3= new GreenfootImage ("Walk Right 3P2.png");
    public static GreenfootImage WalkU1= new GreenfootImage ("Walk Up 1P2.png");
    public static GreenfootImage WalkU2= new GreenfootImage ("Walk Up 2P2.png");
    public static GreenfootImage WalkD1= new GreenfootImage ("Walk Down 1P2.png");
    public static GreenfootImage WalkD2= new GreenfootImage ("Walk Down 2P2.png");
    public static boolean timestart=false;
    SimpleTimer tbombdelay= new SimpleTimer();
    SimpleTimer twalkdelay= new SimpleTimer();
    SimpleTimer tlifeloss= new SimpleTimer();

    int slide;
    public BombermanP2()
    {

        getImage().scale(50,50);
        tbombdelay.mark();
        twalkdelay.mark();
        timestart=false;
        tlifeloss.mark();
    }

    /**
     * Act - do whatever the BombermanP2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(50,50);

        hitWall();
        hitBreakWall();
        spawnbomb();

        if (frame>3)
        {
            frame=1;

        }
        if(twalkdelay.millisElapsed()>250)
        {

            if(Greenfoot.isKeyDown("a")) 
            {

                twalkdelay.mark();
                blnGo=true;
                xVal=-XMove;
                yVal=0;
                stop=0;

                moveleftframe();

            }
            if(Greenfoot.isKeyDown("d"))
            {
                twalkdelay.mark();
                blnGo=true;
                xVal=+XMove;
                yVal=0;
                stop=0;
                moverightframe();
            }
            if(Greenfoot.isKeyDown("w")&& twalkdelay.millisElapsed()>150)
            {

                twalkdelay.mark();
                blnGo=true;
                yVal=-YMove;
                xVal=0;
                stop=0;
                moveupframe();
            }
            if(Greenfoot.isKeyDown("s")&& twalkdelay.millisElapsed()>150)
            {
                twalkdelay.mark();
                blnGo=true;
                yVal=+YMove;
                xVal=0;
                stop=0;
                movedownframe();
            }
        }
        if(getWorld() instanceof Level2)//this was going to be used if i had made the second pvp world with the ice
        {

            if(stop<20 && blnGo == true)//this was the old way i did my slideing 
            {
                setLocation(getX() + xVal, getY()+yVal);
                stop++;
                timestart=true;
                if((hitWall()==true||(hitBreakWall()==true)))
                {
                    setLocation(getX() - xVal, getY()-yVal);
                }
            }

        }
        else if (stop<10 && blnGo == true)
        {
            setLocation(getX() + xVal, getY()+yVal);
            stop++;
            timestart=true;
            if((hitWall()==true||(hitBreakWall()==true)))
            {
                setLocation(getX() - xVal, getY()-yVal);
            }
        }

        hitexplode();
        hithole();

    }

    public void hitexplode()
    {
        Actor explodehit =  getOneIntersectingObject(Explosion.class);
        if((explodehit != null)&&(tlifeloss.millisElapsed()>3000))//if it does hit a brick it will do the code below 
        {
            livesP2--;
            tlifeloss.mark();

        }
    }

    public void moveleftframe()
    {

        if(frame == 1)//if the int frame is =1it will change it to the second image
        {
            setImage(WalkL1);
            getImage().scale(50,50);
        }
        else if (frame == 2)
        {
            setImage(WalkL2);
            getImage().scale(50,50);

        }
        else if (frame == 3)
        {
            setImage(WalkL3);
            getImage().scale(50,50);
            frame=1;//it will "restart the frames" so it will go back to the first one
            return;//this is so it won't add 1 to the reseted int
        }
        frame++;//it will add 1 to the int after it changes the image

    }

    public void moverightframe()
    {

        if(frame == 1)//if the int frame is =1it will change it to the second image
        {
            setImage(WalkR1);
            getImage().scale(50,50);
        }
        else if (frame == 2)
        {
            setImage(WalkR2);
            getImage().scale(50,50);

        }
        else if (frame == 3)
        {
            setImage(WalkR3);
            getImage().scale(50,50);
            frame=1;//it will "restart the frames" so it will go back to the first one
            return;//this is so it won't add 1 to the reseted int
        }
        frame++;//it will add 1 to the int after it changes the image
    }

    public void moveupframe()
    {

        if(frame == 1)//if the int frame is =1it will change it to the second image
        {
            setImage(WalkU1);
            getImage().scale(50,50);
        }
        else if (frame == 2)
        {
            setImage(WalkU2);
            getImage().scale(50,50);
            frame=1;//it will "restart the frames" so it will go back to the first one
            return;//this is so it won't add 1 to the reseted int

        }

        frame++;//it will add 1 to the int after it changes the image
    }

    public void movedownframe()
    {

        if(frame == 1)//if the int frame is =1it will change it to the second image
        {
            setImage(WalkD1);
            getImage().scale(50,50);
        }
        else if (frame == 2)
        {
            setImage(WalkD2);
            getImage().scale(50,50);
            frame=1;//it will "restart the frames" so it will go back to the first one
            return;//this is so it won't add 1 to the reseted int

        }

        frame++;//it will add 1 to the int after it changes the image
    }

    public void spawnbomb()
    {

        if((Greenfoot.isKeyDown("f")  && (tbombdelay.millisElapsed() > 2090)))//when you hit the space key as well as it has been .5 seconds since the last time you hit space you will shoot a projectile (arrow) 
        {
            //Greenf  oot.playSound("bow.mp3.mp3");//plays the sound of the arrow flinging from the bow

            getWorld().addObject(new BombP2(),getX() , getY());//adds a new arrow actor
            tbombdelay.mark();//reset the timer that impacts how many you can shoot in a given period of time 

        }

    }

    public boolean hitWall()
    {
        Brick Brickhit = (Brick) getOneIntersectingObject(Brick.class);
        if(Brickhit != null)//if it does hit a brick it will do the code below 
        {
            return true;

        }
        return false;
    }

    public boolean hitBreakWall()
    {
        Actor Brickhit =  getOneIntersectingObject(BreakBrick.class);
        if(Brickhit != null)//if it does hit a brick it will do the code below 
        {
            return true;

        }
        return false;
    }

    public void hithole()
    {
        Actor manhit =  getOneIntersectingObject(IceHole.class);
        if((manhit != null)&&stop>9)//if it does hit a brick it will do the code below 
        {

            setLocation(775,775);

        }
    }
}    

