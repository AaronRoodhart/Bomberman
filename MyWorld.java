import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static GreenfootSound mainmusic;
    Brick[][] Walls= new Brick [7][7];//this creates the arrey for the middle of the level
    Brick[][] sideWalls= new Brick [2][15];
    Brick[][] updownWalls= new Brick [17][2];
    Bomberman bBomberman=new Bomberman();
    int[] nums = new int[] { 125, 75,175,225,275,325,375,425,475,525,575,625,675,725,775 }; // this is a one dimentional arrey that holds these spicific numbers this was done so when creating the locations of the breakable bricks they could only land on spicific spaces of the grid pattern 
    BreakBrick myBrick=new BreakBrick();
    

    public static Counter countDisplaytime =new Counter();//this is the counter that shows time 
    public static int iTimedisplay=300;//this is the int that is connected to the timer 
    public static Counter countShowScore =new Counter();
    public static Counter countShowP1lives =new Counter();//shows the lives of the player
    public static int iscore=0;//this is the score intiger
    public static SimpleTimer Time= new SimpleTimer();//this will be used to reduce the int iTimedisplay 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        super(1050, 850, 1);
        addObject(bBomberman,775, 775);//adds the player
        Label lTime = new Label(("Time"), 50);
        addObject(lTime, 950, 40);//this is the location of the lable 
        lTime.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lTime.setLineColor(Color.RED);//it will have a red outline 
        addObject(countDisplaytime,950,90);
        Label lScore = new Label(("Score"), 50);
        addObject(lScore, 950, 250);//this is the location of the lable 
        lScore.setFillColor(Color.YELLOW);//it will be yellow in the center 
        lScore.setLineColor(Color.RED);//it will have a red outline 
        addObject(countShowScore,950,290);
        countDisplaytime.setValue(300);
        iTimedisplay=300;
        iscore=0;//sets score to 0
        Bomberman.livesP1=4;//sets lives
        Label llife = new Label(("Lives"), 50);
        addObject(countShowP1lives,950,460);
        addObject(llife, 950, 410);//this is the location of the lable 
        llife.setFillColor(Color.YELLOW);//it will be yellow in the center 
        llife.setLineColor(Color.RED);//it will have a red outline 
        mainmusic=null;//thjs was the same method I used to fix the intro song as this errored too
        mainmusic= new GreenfootSound ("lvl1.mp3");//plays the main music 
        mainmusic.playLoop();

        for(int x=0; x < Walls.length;x++)//this will create the bricks in the middle of the world 
        {
            for (int y=0; y< Walls[x].length; y++)
            {

                {
                    Walls[x][y] = new Brick();
                    addObject(Walls[x][y],  125+100*x,125+100*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }
        for(int x=0; x < updownWalls.length;x++)//this is what makes the arrey of the bricks on the top and bottom 
        {
            for (int y=0; y< updownWalls[x].length; y++)
            {

                {
                    updownWalls[x][y] = new Brick();
                    addObject(updownWalls[x][y],  25+50*x,25+800*y);//this is what will determin the spacing of the bricks as they are made
                }

            }
        }

        for(int x=0; x < sideWalls.length;x++)//this is what makes the arrey of the bricks as long  
        {
            for (int y=0; y< sideWalls[x].length; y++)
            {
                sideWalls[x][y] = new Brick();

                addObject(sideWalls[x][y],  25+800*x,75+50*y);

            }

        }

        for (int add=0; add< 120; add++)
        {
            int choicex = nums[Greenfoot.getRandomNumber(nums.length)];//this is how I randomly generate my world b picking a random number out of the onedimentional arrey that allows the bricks to appere randomly but also makes it so their always in the grid
            int choicey = nums[Greenfoot.getRandomNumber(nums.length)];
            if((choicex!=775||choicey!=725)&&(choicex!=775||choicey!=775)&&(choicex!=725||choicey!=775)&&(choicex!=725||choicey!=675)&&(choicex!=775||choicey!=675))//this will make it so no matter the random location of the bricks they can not be placed near were the player spawns so that waythere will always be a way to get out with out taking damage

            {

                BreakBrick bb = new BreakBrick();
                addObject (bb,choicex,choicey);
                if (bb.hitBrick()||bb.hitBreakBrick())//if it adds one on top of the indestructable bricks or on top of another break brick it will remove the object so there isn't bricks ontop of one another, this also makes the # of bricks in the world random as well
                {
                    removeObject(bb);

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
                iTimedisplay--;
                Time.mark();
            }
        }
        countDisplaytime.setValue(iTimedisplay);
        countShowScore.setValue(iscore);
        countShowP1lives.setValue(Bomberman.livesP1);
        if((Bomberman.livesP1==0)||iTimedisplay==0)//if time runs out or the player dies then you have a game over 
        {
            Greenfoot.setWorld(new GameOver());
            MyWorld.mainmusic.stop();

        }

    }

}
