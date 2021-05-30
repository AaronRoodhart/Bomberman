import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{

    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor Manhit =  getOneIntersectingObject(Bomberman.class);
        if(Manhit != null)//if it does hit a brick it will do the code below 
        {
            if(getWorld() instanceof Level2)//if your in level 2 it will bring you to the win screen
            {
                Greenfoot.setWorld(new WIn());
                Level2.mainmusic.stop();

            }
            else//you will be in level 1 so you will go to level 2
            {
                Greenfoot.setWorld(new Level2());
                MyWorld.mainmusic.stop();
            }

        }
    }   

    public Door()
    {
        getImage().scale(50,50);

    }
}
