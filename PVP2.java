import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PVP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PVP2 extends World
{
    public static GreenfootSound mainmusic;
    Brick[][] Walls= new Brick [7][7];
    Brick[][] sideWalls= new Brick [2][15];
    Brick[][] updownWalls= new Brick [17][2];
    Bomberman bBomberman=new Bomberman();
    BombermanP2 bBomberman2=new BombermanP2();
    int[] nums = new int[] { 125, 75,175,225,275,325,375,425,475,525,575,625,675,725,775 }; // 
    BreakBrick myBrick=new BreakBrick();
    public static int brickleft=10;
    Counter P2Lives =new Counter();
    public static int iTimedisplay=300;
    Counter P1Lives =new Counter();
    Counter counttime =new Counter();
    public static SimpleTimer Time= new SimpleTimer();

    /**
     * Constructor for objects of class PVP2.
     * 
     */
    public PVP2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 850, 1);
        addObject(bBomberman,775, 775);
        mainmusic=null;//thjs was the same method I used to fix the intro song as this errored too
        mainmusic= new GreenfootSound ("lvl2.mp3");
        mainmusic.playLoop();

        addObject(bBomberman2,75, 75);
        Bomberman.livesP1=4;
        BombermanP2.livesP2=4;
        Label lLifeP1 = new Label(("P1 Lives"), 50);
        addObject(lLifeP1, 950, 250);//this is the location of the lable 
        lLifeP1.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lLifeP1.setLineColor(Color.RED);//it will have a red outline 
        addObject(P1Lives,950,290);
        Label lLifeP2 = new Label(("P2 Lives"), 50);
        addObject(lLifeP2, 950, 350);//this is the location of the lable 
        lLifeP2.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lLifeP2.setLineColor(Color.RED);//it will have a red outline 
        addObject(P2Lives,950,390);

        Label lTime = new Label(("Time"), 50);
        addObject(lTime, 950, 40);//this is the location of the lable 
        lTime.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lTime.setLineColor(Color.RED);//it will have a red outline 
        addObject(counttime,950,90);
        iTimedisplay=300; 
        Time.mark();

        for(int x=0; x < Walls.length;x++)//this is what makes the arrey of the bricks as long as the 
        {
            for (int y=0; y< Walls[x].length; y++)
            {

                {
                    Walls[x][y] = new Brick();
                    addObject(Walls[x][y],  125+100*x,125+100*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }
        for(int x=0; x < updownWalls.length;x++)//this is what makes the arrey of the bricks as long as the 
        {
            for (int y=0; y< updownWalls[x].length; y++)
            {

                {
                    updownWalls[x][y] = new Brick();
                    addObject(updownWalls[x][y],  25+50*x,25+800*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }

        for(int x=0; x < sideWalls.length;x++)//this is what makes the arrey of the bricks as long as the 
        {
            for (int y=0; y< sideWalls[x].length; y++)
            {
                sideWalls[x][y] = new Brick();

                addObject(sideWalls[x][y],  25+800*x,75+50*y);

            }

        }

        for (int add=0; add< 120; add++)
        {
            int choicex = nums[Greenfoot.getRandomNumber(nums.length)];
            int choicey = nums[Greenfoot.getRandomNumber(nums.length)];
            if((choicex!=775||choicey!=725)&&(choicex!=775||choicey!=775)&&(choicex!=725||choicey!=775)&&(choicex!=725||choicey!=675)&&(choicex!=775||choicey!=675))//this will make it so no matter the random location of the bricks they can not be placed near were the player spawns so that waythere will always be a way to get out with out taking damage

            {
                if((choicex!=75||choicey!=75)&&(choicex!=125||choicey!=75)&&(choicex!=175||choicey!=75)&&(choicex!=75||choicey!=125)&&(choicex!=75||choicey!=175))
                {

                    BreakBrick bb = new BreakBrick();
                    addObject (bb,choicex,choicey);
                    if (bb.hitBrick()||bb.hitBreakBrick())
                    {
                        removeObject(bb);
                        brickleft--;

                    }
                }
            }
        }
    }

    public void act()
    {
        P1Lives.setValue(Bomberman.livesP1);
        P2Lives.setValue(BombermanP2.livesP2);
        counttime.setValue(iTimedisplay);

        if(Time.millisElapsed()>1000)//this is how the int timedisplay is connected to the time by decreasing the value every second that passes then reseting it so the timer will never go past 1 second
        {
            iTimedisplay--;
            Time.mark();
        }

    }
}

