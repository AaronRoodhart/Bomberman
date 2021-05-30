import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BreakBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakBrick extends Actor
{

    SimpleTimer tchange= new SimpleTimer();
    GreenfootImage gone= new GreenfootImage ("breakbrickgone.png");
    GreenfootImage ice= new GreenfootImage ("icebreak.png");
    int spawnDoor;

    int transparency= 200;
    boolean stopscore=false;

    public BreakBrick()
    {
        getImage().scale(50,50);
        //isTouching();

    }


    /**
     * Act - do whatever the BreakBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hitexplosion();
        if((getWorld() instanceof Level2)||(getWorld() instanceof PVP2))//this changes how it looks at level 2
        {
            setImage(ice);
            getImage().scale(50,50);
        }

    }

    public boolean hitBrick()//these methods are used in the world code to detect if it has hit another brick
    {
        Actor removebrick = getOneIntersectingObject(Brick.class);
        if ( removebrick!= null)
        {

            return true;

        } 
        return false;

    }

    public boolean hitBreakBrick()
    {
        Actor removebrick = getOneIntersectingObject(BreakBrick.class);
        if ( removebrick!= null)
        {

            return true;

        } 
        return false;

    }

    public void hitexplosion()
    {
        Actor a = getOneIntersectingObject(Explosion.class);
        if (a != null)
        {

            // if (stopscore==false)
            // {
            // MyWorld.iscore++;
            // stopscore=true;
            if((getWorld() instanceof MyWorld)||getWorld()instanceof Level2)//this makes it so a door can't spawn on a pvp map
            {  
                int numbb = getWorld().getObjects(BreakBrick.class).size();//cheaks to see how many bricks are left in the world
                int numdoor = getWorld().getObjects(Door.class).size();//cheaks to see how many door there are 

                spawnDoor=Greenfoot.getRandomNumber(50);
                if(spawnDoor==1)//there is a one in 50 chance that a door will spawn when a brick is destroyed
                {
                    if (numdoor==0)//a door can only spawn if there are no doors already in the world
                    {
                        getWorld().addObject(new Door(),getX() , getY());
                    }
                }

                if((numbb==1)&& (numdoor==0))//if there is only one brick left in the world and there are no doors already spawned there will always be a door 
                {

                    getWorld().addObject(new Door(),getX() , getY());
                }
            }

            setImage(gone);

            getWorld().addObject(new breakBrickGone(),getX() , getY());//adds the yellow brick or transition brick

            getWorld().removeObject(this);//remove the brick

            // // }

        }
    }
}
