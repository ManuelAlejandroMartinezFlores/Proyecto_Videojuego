import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MecaWorld juego de mecanografía relajante
 * 
 * @author Manuel Alejandro Martinez Flores
 * @version 2
 */
public class MecaWorld extends World
{
    /**
     * Constructor for objects of class MecaWorld.
     * 
     */
    public MecaWorld()
    {    
        super(560, 560, 1);
        Instrucciones i = new Instrucciones();
        addObject(i, 0, 0);
        Greenfoot.playSound("purrple-cat-time-stands-still.wav");
    }
}
