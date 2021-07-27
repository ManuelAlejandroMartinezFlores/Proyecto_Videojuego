import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LifeUp - si los presiona, gana una vida
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 2
 */
public class LifeUp extends Button
{
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        // Hereda fall y showLetter de clase Button
        fall();
        showLetter();
        evaluatePower();
    }
    /**
     * evaluatePower - si es presionada la letra, se gana una vida
     */
    public void evaluatePower(){
        if (Greenfoot.isKeyDown(letter)) {
            for (Manager m : getWorld().getObjects(Manager.class)){
                // añade una vida al usuario
                m.changeLife(true);
            }
            Greenfoot.playSound("typewriter-key-1.wav");
            disappear();
        }
    }
}
