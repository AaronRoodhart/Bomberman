import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    public static GreenfootSound mainmusic;
    Brick[][] Walls= new Brick [7][7];
    Brick[][] sideWalls= new Brick [2][15];
    Brick[][] updownWalls= new Brick [17][2];
    Bomberman bBomberman=new Bomberman();
    int[] nums = new int[] { 125, 75,175,225,275,325,375,425,475,525,575,625,675,725,775 };//this is a one dimentional arrey that will be used to spawn things like my breakbricks randomly but still on th grid pattern
    Counter countDisplaytime =new Counter();
    SimpleTimer Time= new SimpleTimer();
    public static int iTimedisplay=300;//this is the int that will be displayed on the counter 
    public static int total;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 850, 1);
        addObject(bBomberman,775, 775);//adds the main player
        mainmusic=null;//this was the same method I used to fix the intro song as this errored too
        mainmusic= new GreenfootSound ("lvl2.mp3");
        mainmusic.playLoop();

        Label lTime = new Label(("Time"), 50);
        addObject(lTime, 950, 40);//this is the location of the lable 
        lTime.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lTime.setLineColor(Color.RED);//it will have a red outline 
        addObject(countDisplaytime,950,90);
        Label lScore = new Label(("Score"), 50);
        addObject(lScore, 950, 250);//this is the location of the lable 
        lScore.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lScore.setLineColor(Color.RED);//it will have a red outline 
        addObject(MyWorld.countShowScore,950,290);
        countDisplaytime.setValue(300);
        iTimedisplay=300;
        MyWorld.Time.mark();

        Label llife = new Label(("Lives"), 50);
        addObject(MyWorld.countShowP1lives,950,460);
        addObject(llife, 950, 410);//this is the location of the lable 
        llife.setFillColor(Color.YELLOW);//it will be yellow in the center 
        llife.setLineColor(Color.RED);//it will have a red outline 
        total = ((MyWorld.iTimedisplay*20)+MyWorld.iscore);//this will make it so your score is equal to the points you got by destroying bricks and 20 points for every second remaining 

        for(int x=0; x < Walls.length;x++)//this is what makes the arrey of the bricks for the center of the level
        {
            for (int y=0; y< Walls[x].length; y++)
            {
                {
                    Walls[x][y] = new Brick();
                    addObject(Walls[x][y],  125+100*x,125+100*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }
        for(int x=0; x < updownWalls.length;x++)//this is what makes the arrey of the bricks for the top and bottom of the world 
        {
            for (int y=0; y< updownWalls[x].length; y++)
            {
                {
                    updownWalls[x][y] = new Brick();
                    addObject(updownWalls[x][y],  25+50*x,25+800*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }

        for(int x=0; x < sideWalls.length;x++)//this is what makes the arrey of the bricks along the side of the world
        {
            for (int y=0; y< sideWalls[x].length; y++)
            {
                sideWalls[x][y] = new Brick();

                addObject(sideWalls[x][y],  25+800*x,75+50*y);

            }

        }

        for (int add=0; add< 120; add++)
        {
            int choicex = nums[Greenfoot.getRandomNumber(nums.length)];//to get the x location it has to pick from the predefined arrey so that way the location can be random but also abide by the grid pattern
            int choicey = nums[Greenfoot.getRandomNumber(nums.length)];
            if((choicex!=775||choicey!=725)&&(choicex!=775||choicey!=775)&&(choicex!=725||choicey!=775)&&(choicex!=725||choicey!=675)&&(choicex!=775||choicey!=675))//this will make it so no matter the random location of the bricks they can not be placed near were the player spawns so that waythere will always be a way to get out with out taking damage

            {

                BreakBrick bb = new BreakBrick();
                addObject (bb,choicex,choicey);
                if (bb.hitBrick()||bb.hitBreakBrick())//if it hits a brick or a breakbrick it will be removed thus makeing it so they cant be overlaped but this also causes an inconsistant amount of bricks to be spawned
                {
                    removeObject(bb);

                }
            }
        }
        for (int add=0; add< 20; add++)//uses the same idea as the previous for loop when spawning breakbricks i this case just for ice holes 
        {
            int choicex = nums[Greenfoot.getRandomNumber(nums.length)];
            int choicey = nums[Greenfoot.getRandomNumber(nums.length)];
            if((choicex!=775||choicey!=725)&&(choicex!=775||choicey!=775)&&(choicex!=725||choicey!=775)&&(choicex!=725||choicey!=675)&&(choicex!=775||choicey!=675))//this will make it so no matter the random location of the bricks they can not be placed near were the player spawns so that waythere will always be a way to get out with out taking damage

            {

                IceHole Ih = new IceHole();
                addObject (Ih,choicex,choicey);
                if (Ih.hitBrick()||Ih.hitBreakBrick())//this makes it so no icehole can be placed ontop of another type of brick
                {
                    removeObject(Ih);

                }
            }
        }

    }

    public void act()
    {

        if (Bomberman.timestart==true)
        {
            if(Time.millisElapsed()>1000)//this is how the int timedisplay is connected to the time by decreasing the value every second that passes then reseting it so the timer will never go past 1 second
            {
                iTimedisplay--;//this is how the counter reduces the time by subtracting 1 from the displayed variable every second
                Time.mark();
            }
        }
        countDisplaytime.setValue(iTimedisplay);
        MyWorld.countShowScore.setValue(total);
        MyWorld.countShowP1lives.setValue(Bomberman.livesP1);
        if((Bomberman.livesP1==0)||iTimedisplay==0)//if the lives run out or the time is up you will go to the loose world
        {
            Greenfoot.setWorld(new GameOver());
            Level2.mainmusic.stop();

        }
    }
}
