import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RegButton - si los presiona, gana puntos
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 2
 */
public class RegButton extends Button
{
    /**
     * Act - do whatever the RegButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        // Hereda estos métodos de la clase Button
        showLetter();
        fall();
        evaluate();
    }
}
