
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    boolean exp=true;
    SimpleTimer texplode= new SimpleTimer();//creates a timer called texplode
    SimpleTimer tremove= new SimpleTimer();
    GreenfootImage gone= new GreenfootImage ("breakbrickgone.png");
    GreenfootImage Explode= new GreenfootImage ("explosion1.png");
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bomb()
    {
        getImage().scale(50,50);  
        texplode.mark();//itwill start the timer when created this is what determins the time it takes to explode when layed 

    }

    public void act() 
    {

        explode();

    } 

    public void explode()
    {
        if ((texplode.millisElapsed() > 2000) && (exp == true))//this makes it so when a bomb is added to the world it wont instantly explode
        {
            Explosion e = new Explosion();//it will add an explosion

            getWorld().addObject(e, getX(), getY());//it will spawn at the location of the character

            createExplosions();//this is a seperate mathod
            ExtraFire.extrafire=false;//this makes it so you only get one bomb with the extra range I did this because greenfoot would crash if you made it do to many explosions 
            exp = false;
            getWorld().removeObject(this);

        }
    }

    public void createExplosions()//this is the methoid that allows me to make the explosions in the t pose. and the way it works is by creating explosions 1 at a time and cheaking what their intersecting with to determin if they should spawn
    {
        if (exp==true)
        {
            Explosion e1 = new Explosion();//it will create the first explosion

            getWorld().addObject(e1, getX() - 50, getY());//it will be at the same location as the bomb but over -50 on the x
            if ((e1.didHit() ==false)&& (e1.didHitbreak()==false))//if the first explosion is not hitting the walls or breakable walls then the fallowing code will happen
            {

                Explosion e2 = new Explosion();
                getWorld().addObject(e2, getX() - 100, getY());

                if(ExtraFire.extrafire==true)//this is for the powerup ExtraFire and if it is true
                {
                    if((e2.didHit() ==false)&& (e2.didHitbreak()==false))//cheaks if the previosue explosion has hit anything
                    {
                        Explosion e9 = new Explosion();
                        getWorld().addObject(e9, getX() - 150, getY());//adds anotheer explosion

                        if((e9.didHit() ==false)&& (e9.didHitbreak()==false))
                        {
                            Explosion e10 = new Explosion();
                            getWorld().addObject(e10, getX() - 200, getY());//just makes the radious larger
                            if(e10.didHit()==true)
                            {
                                getWorld().removeObject(e10);//if e10 hits a brick or break brick it will be removed
                            }
                        }
                        if(e9.didHit()==true)
                        {
                            getWorld().removeObject(e9);//if the explosion hits a brick it will remove itself
                        }

                    }

                }
                if(e2.didHit()==true) 
                {
                    getWorld().removeObject(e2);
                }

            }
            else if(e1.didHit()==true) 
            {
                getWorld().removeObject(e1);//if e1 hits any type of brick itwill be removed
            }

            Explosion e3 = new Explosion();//the same prosess is repeted in all directions
            getWorld().addObject(e3, getX() + 50, getY());
            if ((e3.didHit() ==false)&& (e3.didHitbreak()==false))
            {
                Explosion e4 = new Explosion();

                getWorld().addObject(e4, getX() + 100, getY());
                if(ExtraFire.extrafire==true)//this is for the powerup ExtraFire
                {
                    if((e4.didHit() ==false)&& (e4.didHitbreak()==false))
                    {
                        Explosion e11 = new Explosion();
                        getWorld().addObject(e11, getX() + 150, getY());

                        if((e11.didHit() ==false)&& (e11.didHitbreak()==false))
                        {
                            Explosion e12 = new Explosion();
                            getWorld().addObject(e12, getX() + 200, getY());
                            if(e12.didHit()==true)
                            {
                                getWorld().removeObject(e12);
                            }
                        }
                        if(e11.didHit()==true)
                        {
                            getWorld().removeObject(e11);
                        }

                    }

                }
                if(e4.didHit()==true)
                {
                    getWorld().removeObject(e4);
                }

            }
            else if(e3.didHit()==true)
            {
                getWorld().removeObject(e3);
            }

            Explosion e5 = new Explosion();

            getWorld().addObject(e5, getX() , getY()- 50);
            if ((e5.didHit() ==false)&& (e5.didHitbreak()==false))
            {

                Explosion e6 = new Explosion();
                getWorld().addObject(e6, getX() , getY()- 100);

                if(ExtraFire.extrafire==true)//this is for the powerup ExtraFire
                {
                    if((e6.didHit() ==false)&& (e6.didHitbreak()==false))
                    {
                        Explosion e13 = new Explosion();
                        getWorld().addObject(e13, getX() , getY()- 150);

                        if((e13.didHit() ==false)&& (e13.didHitbreak()==false))
                        {
                            Explosion e14 = new Explosion();
                            getWorld().addObject(e14, getX() , getY()- 200);
                            if(e14.didHit()==true)
                            {
                                getWorld().removeObject(e14);
                            }
                        }
                        if(e13.didHit()==true)
                        {
                            getWorld().removeObject(e13);
                        }

                    }

                }
                if(e6.didHit()==true)
                {
                    getWorld().removeObject(e6);
                }

            }
            else if(e5.didHit()==true) 
            {
                getWorld().removeObject(e5);
            }

            Explosion e7 = new Explosion();
            getWorld().addObject(e7, getX() , getY()+ 50);
            if ((e7.didHit() ==false)&& (e7.didHitbreak()==false))
            {
                Explosion e8 = new Explosion();

                getWorld().addObject(e8, getX(), getY()+ 100);

                if(ExtraFire.extrafire==true)//this is for the powerup ExtraFire
                {
                    if((e8.didHit() ==false)&& (e8.didHitbreak()==false))
                    {
                        Explosion e15 = new Explosion();
                        getWorld().addObject(e15, getX() , getY()+ 150);

                        if((e15.didHit() ==false)&& (e15.didHitbreak()==false))
                        {
                            Explosion e16 = new Explosion();
                            getWorld().addObject(e16, getX() , getY()+ 200);
                            if(e16.didHit()==true)
                            {
                                getWorld().removeObject(e16);
                            }
                        }
                        if(e15.didHit()==true)
                        {
                            getWorld().removeObject(e15);
                        }

                    }

                }
                if(e8.didHit()==true)
                {
                    getWorld().removeObject(e8);
                }

            }
            else if (e7.didHit()==true)
            {
                getWorld().removeObject(e7);
            }

        }
        exp=false;
    }
}

