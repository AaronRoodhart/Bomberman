
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomberman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomberman extends Actor
{

    int frame=1;//sets the first frame

    boolean blnGo=false;
    int xVal, yVal;
    int XMove=5;
    int YMove=5;
    int stop=0;
    public static int livesP1=4;
    SimpleTimer tlifeloss= new SimpleTimer();

    

    final int TimeLimit=300;
    public static GreenfootImage WalkL1= new GreenfootImage ("Walk Left 1.png");//these are all the frames to show nwalking
    public static GreenfootImage WalkL2= new GreenfootImage ("Walk Left 2.png");
    public static GreenfootImage WalkL3= new GreenfootImage ("Walk Left 3.png");
    public static GreenfootImage WalkR1= new GreenfootImage ("Walk Right 1.png");
    public static GreenfootImage WalkR2= new GreenfootImage ("Walk Right 2.png");
    public static GreenfootImage WalkR3= new GreenfootImage ("Walk Right 3.png");
    public static GreenfootImage WalkU1= new GreenfootImage ("Walk Up 1.png");
    public static GreenfootImage WalkU2= new GreenfootImage ("Walk Up 2.png");
    public static GreenfootImage WalkD1= new GreenfootImage ("Walk Down 1.png");
    public static GreenfootImage WalkD2= new GreenfootImage ("Walk Down 2.png");
    public static boolean timestart=false;
    SimpleTimer tbombdelay= new SimpleTimer();
    SimpleTimer twalkdelay= new SimpleTimer();

    public Bomberman()
    {

        getImage().scale(50,50);
        tbombdelay.mark();
        twalkdelay.mark();
        timestart=false;
        tlifeloss.mark();
    }

    /**
     * Act - do whatever the Bomberman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(50,50);

        hitWall();
        hitBreakWall();
        spawnbomb();

        if (frame>3)//this is for if the frame goes above 3 which it sometimes did it will bring it back down so that way if the animation gets stuck because it went abouve 3 it will correct itself 
        {
            frame=1;

        }
        if(twalkdelay.millisElapsed()>250)//this makes it so there is a small pause between movement
        {

            if(Greenfoot.isKeyDown("left")) 
            {

                //if (SpeedUp.movefast ==false) thkis was used for my spped up power up 
                {
                    twalkdelay.mark();//it will reset the time restriction
                    blnGo=true;//this is what will alow the object to move 
                    xVal=-XMove;//it will set the movement to negative 5 
                    yVal=0;//doesn't effect the y value
                    stop=0;//this will be what makes the sprite look like it flows because he will move small bits(5 pixles) for a set abount of time alowing him to stay on the grid 

                    moveleftframe();//it will change frames that correspond with left movement

                }

            }
            if(Greenfoot.isKeyDown("right"))//same as left just driffrent directions
            {
                twalkdelay.mark();
                blnGo=true;
                xVal=+XMove;
                yVal=0;
                stop=0;
                moverightframe();
            }
            if(Greenfoot.isKeyDown("up")&& twalkdelay.millisElapsed()>150)
            {

                twalkdelay.mark();
                blnGo=true;
                yVal=-YMove;
                xVal=0;
                stop=0;
                moveupframe();
            }
            if(Greenfoot.isKeyDown("down")&& twalkdelay.millisElapsed()>150)
            {
                twalkdelay.mark();
                blnGo=true;
                yVal=+YMove;
                xVal=0;
                stop=0;
                movedownframe();
            }
        }
        if(getWorld() instanceof Level2)//if the player is in level 2 they are going to move twice the distance to simulate sliding on ice 
        {

            if(stop<10 && blnGo == true)//he will move 10 (5+5) pixles 10 times they will also move faster 
            {
                setLocation(getX() + (xVal+xVal), getY()+(yVal+yVal));//this sets the the movement but twice the normal amount to simulate the sliding 
                stop++;//this will make it so you can only move 10 times 
                timestart=true;
                if((hitWall()==true||(hitBreakWall()==true)))//if the player hits a wall or a brakable wall then they will move the exact opposite way so they can't go through it 
                {
                    setLocation(getX() - (xVal+xVal), getY()-(yVal+yVal));
                }
            }

        }
        else if (stop<10 && blnGo == true)//this will make it so you ccan move when thr boolean allows you and will only let you move 10 times
        {
            setLocation(getX() + xVal, getY()+yVal);//the player will move 10 times at 5 pixles
            stop++;//this will increase the until it hits 10
            timestart=true;
            if((hitWall()==true||(hitBreakWall()==true)))
            {
                setLocation(getX() - xVal, getY()-yVal);
            }
        }

        hitexplode();

        hithole();
        // else if (SpeedUp.movefast==true)
        // {
        // if (stop<2 && blnGo == true)
        // {
        // setLocation(getX() + xVal, getY()+yVal);
        // stop++;
        // timestart=true;
        // if((hitWall()==true||(hitBreakWall()==true)))
        // {
        // setLocation(getX() - xVal, getY()-yVal);
        // }
        // }

        // }

    }

    public void hitexplode()//if the player hits anexplosion and they will loose a life 
    {
        Actor explodehit =  getOneIntersectingObject(Explosion.class);
        if((explodehit != null)&&(tlifeloss.millisElapsed()>3000))//if it does hit a brick it will do the code below 
        {
            livesP1--;//you will looses a life 
            tlifeloss.mark();//this makes it so you can't loose lives in a shot time 

        }
    }

    public void moveleftframe()
    {

        if(frame == 1)//if the int frame is =1 it will change it to the second image
        {
            setImage(WalkL1);
            getImage().scale(50,50);//will alwyas set the size 
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

    public void moveupframe()//I only have 2 frames for the up and down movement 
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

        if((Greenfoot.isKeyDown("Space")  && (tbombdelay.millisElapsed() > 2090)))//when you hit the space key as well as it has been .5 seconds since the last time you hit space you will shoot a projectile (arrow) 
        {

            getWorld().addObject(new Bomb(),getX() , getY());//adds a new Bomb actor
            tbombdelay.mark();//reset the timer that impacts how many you can spawn in a given period of time 

        }

    }

    public boolean hitWall()//these are used for hit detection to adjust movement 
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

    public void hithole()//this is in level 2 were if you hit the hole you will be set back to the original spawn point 
    {
        Actor manhit =  getOneIntersectingObject(IceHole.class);
        if((manhit != null)&&stop>9)//if it does hit a brick it will do the code below 
        {

            setLocation(775,775);

        }
    }
}
