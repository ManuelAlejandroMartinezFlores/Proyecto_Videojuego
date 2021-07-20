import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MecaWorld extends World
{
    public int score = 0;
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    
    public MecaWorld()
    {    
        super(560, 560, 1);
        showText("SCORE", 280, 530);
        Manager m = new Manager();
        addObject(m, 560, 560);
    }
}
